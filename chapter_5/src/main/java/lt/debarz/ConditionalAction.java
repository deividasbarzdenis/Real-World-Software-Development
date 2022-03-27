package lt.debarz;

/**
 * The current
 * Action interface is not sufficient because it doesn’t separate the code performed
 * versus the condition that triggers that code. At the moment there’s no way to
 * separate out the condition from the action code. To make up for this, we could
 * introduce an enhanced Action interface that has a built-in functionality for
 * evaluating the condition.
 * */
public interface ConditionalAction {
    boolean evaluate(Facts facts);
    void perform(Facts facts);
}
