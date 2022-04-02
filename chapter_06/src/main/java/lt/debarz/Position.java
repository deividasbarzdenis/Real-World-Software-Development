package lt.debarz;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

// Value object representing the position in the stream
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Position {
    /**
     * Position before any tweets have been seen
     */
    public static final Position INITIAL_POSITION = new Position(-1);

    private final int value;

    public Position next() {
        return new Position(value + 1);
    }
}
