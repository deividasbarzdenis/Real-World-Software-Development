package lt.debarz;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * In the spirit of TDD, let’s start by writing our first tests to verify that addActions
 * and count behave correctly, as shown in Example 5-3
 * */
class BusinessRuleEngineTest {
    final BusinessRuleEngine businessRule = new BusinessRuleEngine();

    @Test
    void shouldHaveNoRulesInitially(){
        assertEquals(0, businessRule.count());
    }

    @Test
    void shouldAddTwoActions(){
        businessRule.addAction(() -> {});
        businessRule.addAction(() -> {});

        assertEquals(2, businessRule.count());
    }

    /*
    The static method mock() allows you to create a mock object which you can then verify that
    certain behaviors happen. The method verify() allows you to set up assertions
    that a particular method is invoked
    */
    /**
    * The unit test creates a mock object for Action. This is done by passing the class as
     * argument to the mock method. Next, you have the when part of your test where you
     * invoke behaviors. Here we are adding the action and executing the method run().
     * Finally, you have the then part of the unit tests, which sets up assertions. In this case,
     * we verify that the method perform() on the Action object was invoked.
    * */
    /**
     * Re-run the tests and you will now see the test passing. Mockito was able to verify
     * that when the Business Rules Engine is running, the method perform() on the
     * Action object should be invoked. Mockito allows you to specify sophisticated
     * verification logic such as how many times a method should be invoked, with certain
     * arguments, etc.
     * */
    @Test
    void shouldExecuteOneAction(){
        // given
        final Action mockAction = mock(Action.class);
        // when
        businessRule.addAction(mockAction);
        businessRule.run();
        // then
        verify(mockAction).perform();
    }
}
