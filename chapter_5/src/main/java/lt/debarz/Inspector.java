package lt.debarz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Inspector class that takes a list of
 * ConditionalAction objects and evaluates them based on some facts
 * */
public class Inspector {
    private final List<ConditionalAction> conditionalActionList;

    public Inspector(final ConditionalAction...conditionalActions) {
        this.conditionalActionList = Arrays.asList(conditionalActions);
    }

    public List<Report> inspect(final Facts facts){
        final List<Report> reportList = new ArrayList<>();
        for(ConditionalAction conditionalAction : conditionalActionList){
            final  boolean conditionResult = conditionalAction.evaluate(facts);
            reportList.add(new Report(facts, conditionalAction, conditionResult));
        }
        return reportList;
    }
}

/**
 * This general idea is the foundation of the Interface Segregation Principle. It makes
 * the case that no class should be forced to depend on methods it does not use because
 * this introduces unnecessary coupling. In Chapter 2, you learned about another
 * principle, the Single Responsibility Principle (SRP), which promotes high cohesion.
 * The SRP is a general design guideline that a class has responsibility over a single
 * functionality and there should be only one reason for it to change. Although the ISP
 * may sound like the same idea, it takes a different view. The ISP focuses on the user
 * of an interface rather than its design. In other words, if an interface ends up very
 * large, it may be that the user of that interface sees some behaviors it doesn’t care for,
 * which causes unnecessary coupling.
 * */
