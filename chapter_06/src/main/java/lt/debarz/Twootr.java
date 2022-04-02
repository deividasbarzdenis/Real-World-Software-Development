package lt.debarz;

import java.util.Optional;

public class Twootr {

    /**
     * Using Optional as a return type makes it
     * explicit what happens when the method fails to return its value—it
     * returns the empty Optional
     * */
    Optional<SenderEndPoint> onLogon(String userId, ReceiverEndPoint receiver) {
        return Optional.of(new SenderEndPoint());
    }

}
