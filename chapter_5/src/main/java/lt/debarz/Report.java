package lt.debarz;

import lombok.Data;

@Data
public class Report {

    private final Facts facts;
    private final ConditionalAction conditionalAction;
    private final boolean isPositive;
}

/**
 * To provide a solution that meets the Interface Segregation Principle, we are
 * encouraged to separate out concepts in smaller interface that can evolve separately.
 * This idea essentially promotes higher cohesion. Separating out interfaces also
 * provides an opportunity for introducing names that are closer to the domain at hand,
 * such as Condition and Action, which we explore in the next section
 * */


