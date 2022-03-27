package lt.debarz;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InspectorTest {

    /**
     * This test highlights a fundamental issue
     * with our current design. In fact, the ConditionalAction interface breaks the
     * Interface Segregation Principle (ISP)
     * */
    @Test
    void inspectOneConditionEvaluatesTrue(){
        final Facts facts = new Facts();
        facts.setFact("jobTitle", "CEO");
        final ConditionalAction conditionalAction = new JobTitleCondition();
        final Inspector inspector = new Inspector(conditionalAction);
        final List<Report> reportList = inspector.inspect(facts);
        assertEquals(1, reportList.size());
        assertTrue(reportList.get(0).isPositive());
    }
    private static class JobTitleCondition implements ConditionalAction {
        @Override
        public void perform(Facts facts) {
            throw new UnsupportedOperationException();
        }
        @Override
        public boolean evaluate(Facts facts) {
            return "CEO".equals(facts.getFact("jobTitle"));
        }
    }

}
