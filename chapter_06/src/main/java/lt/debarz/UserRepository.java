package lt.debarz;

import java.util.Optional;

public interface UserRepository {
    boolean add(User user);

    Optional<User> get(String userId);

    void update(User user);

    void clear();

    FollowStatus follow(User follower, User userToFollow);
}
