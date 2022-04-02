package lt.debarz;

import lombok.*;

@AllArgsConstructor
@NonNull
@Getter
@ToString
@EqualsAndHashCode
public class Twoot {
    private final String id;
    private final String senderId;
    private final String content;
    private final Position position;

    public boolean isAfter(final Position otherPosition) {
        return position.getValue() > otherPosition.getValue();
    }
}
