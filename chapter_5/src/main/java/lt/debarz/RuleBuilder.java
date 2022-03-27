package lt.debarz;

public class RuleBuilder {
    private final Condition condition;
    private RuleBuilder(final Condition condition) {
        this.condition = condition;
    }
    public static RuleBuilder when(final Condition condition) {
        return new RuleBuilder(condition);
    }
    public Rule then(final Action action) {
        return new DefaultRule(condition, action);
    }
}
