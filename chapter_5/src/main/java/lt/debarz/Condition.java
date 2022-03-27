package lt.debarz;

@FunctionalInterface
public interface Condition {
    boolean evaluate(Facts facts);
}
