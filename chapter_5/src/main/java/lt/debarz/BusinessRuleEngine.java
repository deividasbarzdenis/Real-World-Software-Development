package lt.debarz;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {

    private List<Action> actions;
    private Facts facts;

    public BusinessRuleEngine() {
    }

    public BusinessRuleEngine(Facts facts) {
        this.facts = facts;
        this.actions = new ArrayList<>();
    }

    public Integer count() {
        return this.actions.size();
    }

    public void addAction(final Action action) {
        this.actions.add(action);
    }

    public void run() {
        this.actions.forEach(action -> action.perform(facts));
    }
}
