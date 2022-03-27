package lt.debarz;

import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {

    private List<Rule> rules;
    private Facts facts;

    public BusinessRuleEngine() {
    }

    public BusinessRuleEngine(Facts facts) {
        this.facts = facts;
        this.rules = new ArrayList<>();
    }

    public Integer count() {
        return this.rules.size();
    }

    public void addRule(final Rule rule) {
        this.rules.add(rule);
    }

    public void run() {
        this.rules.forEach(rule -> rule.perform(facts));
    }
}
