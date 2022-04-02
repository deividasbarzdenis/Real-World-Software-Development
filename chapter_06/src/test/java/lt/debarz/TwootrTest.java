package lt.debarz;

import lt.debarz.in_memory.InMemoryTwootRepository;
import lt.debarz.in_memory.InMemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Optional;

import static lt.debarz.FollowStatus.ALREADY_FOLLOWING;
import static lt.debarz.FollowStatus.SUCCESS;
import static lt.debarz.TestData.TWOOT;
import static lt.debarz.TestData.twootAt;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TwootrTest {
    private static final Position POSITION_1 = new Position(0);

    @Mock
    private ReceiverEndPoint receiverEndPoint;
    private final TwootRepository twootRepository = spy(new InMemoryTwootRepository());
    private final UserRepository userRepository = new InMemoryUserRepository();
    private Twootr twootr;
    private SenderEndPoint endPoint;

    @BeforeEach
    public void setUp() {
        twootr = new Twootr(userRepository, twootRepository);
        assertEquals(RegistrationStatus.SUCCESS, twootr.onRegisterUser(TestData.USER_ID, TestData.PASSWORD));
        assertEquals(RegistrationStatus.SUCCESS, twootr.onRegisterUser(TestData.OTHER_USER_ID, TestData.PASSWORD));
    }
    @Test
     void shouldNotRegisterDuplicateUsers()
    {
        assertEquals(RegistrationStatus.DUPLICATE, twootr.onRegisterUser(TestData.USER_ID, TestData.PASSWORD));
    }

    /**
     * a good idea to start writing our project with a test class,
     * TwootrTest. So let’s start with a test that our user can log in:
     * shouldBeAbleToAuthenticateUser(). In this test a user
     * will log in and be correctly authenticated.
     */
    @Test
    void shouldBeAbleToAuthenticateUser() {
       logon();
    }

    @Test
     void shouldNotAuthenticateUserWithWrongPassword(){
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(
                TestData.USER_ID, "bad password", receiverEndPoint);

        assertFalse(endPoint.isPresent());
    }
    @Test
     void shouldNotAuthenticateUnknownUser() {
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(
                TestData.NOT_A_USER, TestData.PASSWORD, receiverEndPoint);

        assertFalse(endPoint.isPresent());
    }
    public void shouldFollowValidUser() {
        logon();

        final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);

        assertEquals(SUCCESS, followStatus);
    }
    @Test
     void shouldNotDuplicateFollowValidUser() {
        logon();

        endPoint.onFollow(TestData.OTHER_USER_ID);

        final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);
        assertEquals(ALREADY_FOLLOWING, followStatus);
    }
    @Test
     void shouldNotFollowInValidUser() {
        logon();

        final FollowStatus followStatus = endPoint.onFollow(TestData.NOT_A_USER);

        assertEquals(FollowStatus.INVALID_USER, followStatus);
    }

    @Test
     void shouldReceiveTwootsFromFollowedUser() {
        final String id = "1";

        logon();

        endPoint.onFollow(TestData.OTHER_USER_ID);

        final SenderEndPoint otherEndPoint = otherLogon();
        otherEndPoint.onSendTwoot(id, TWOOT);

        verify(twootRepository).add(id, TestData.OTHER_USER_ID, TWOOT);
        verify(receiverEndPoint).onTwoot(new Twoot(id, TestData.OTHER_USER_ID, TWOOT, new Position(0)));
    }

    @Test
     void shouldNotReceiveTwootsAfterLogoff() {
        final String id = "1";

        userFollowsOtherUser();

        final SenderEndPoint otherEndPoint = otherLogon();
        otherEndPoint.onSendTwoot(id, TWOOT);

        verify(receiverEndPoint, never()).onTwoot(new Twoot(id, TestData.OTHER_USER_ID, TWOOT, POSITION_1));
    }

    @Test
     void shouldReceiveReplayOfTwootsAfterLogoff() {
        final String id = "1";

        userFollowsOtherUser();

        final SenderEndPoint otherEndPoint = otherLogon();
        otherEndPoint.onSendTwoot(id, TWOOT);

        logon();

        verify(receiverEndPoint).onTwoot(twootAt(id, POSITION_1));
    }

    @Test
     void shouldDeleteTwoots() {
        final String id = "1";

        userFollowsOtherUser();

        final SenderEndPoint otherEndPoint = otherLogon();
        otherEndPoint.onSendTwoot(id, TWOOT);
        final DeleteStatus status = otherEndPoint.onDeleteTwoot(id);

        logon();

        assertEquals(DeleteStatus.SUCCESS, status);
        verify(receiverEndPoint, never()).onTwoot(twootAt(id, POSITION_1));
    }

    @Test
     void shouldNotDeleteFuturePositionTwoots() {
        logon();

        final DeleteStatus status = endPoint.onDeleteTwoot("DAS");

        assertEquals(DeleteStatus.UNKNOWN_TWOOT, status);
    }

    @Test
     void shouldNotOtherUsersTwoots() {
        final String id = "1";

        logon();

        final SenderEndPoint otherEndPoint = otherLogon();
        otherEndPoint.onSendTwoot(id, TWOOT);

        final DeleteStatus status = endPoint.onDeleteTwoot(id);

        assertNotNull(twootRepository.get(id));
        assertEquals(DeleteStatus.NOT_YOUR_TWOOT, status);
    }

    private SenderEndPoint otherLogon() {
        return logon(TestData.OTHER_USER_ID, mock(ReceiverEndPoint.class));
    }

    private void userFollowsOtherUser() {
        logon();

        endPoint.onFollow(TestData.OTHER_USER_ID);

        endPoint.onLogoff();
    }

    private void logon() {
        this.endPoint = logon(TestData.USER_ID, receiverEndPoint);
    }

    private SenderEndPoint logon(final String userId, final ReceiverEndPoint receiverEndPoint) {
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(userId, TestData.PASSWORD, receiverEndPoint);
        assertTrue(endPoint.isPresent(), () -> "Failed to logon");
        return endPoint.get();
    }
}
