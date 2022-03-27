package lt.debarz;

public class DefaultRule extends Rule {
    public DefaultRule(Condition condition, Action action) {
        super(condition, action);
    }
/**
 * However, even though the code uses names that are close to our domain
 * (Condition, Action, Rule), this code is fairly manual. The user has to
 * instantiate separate objects and assemble things together. Let’s introduce what’s
 * called the Builder pattern to improve the process of creating a Rule object with the
 * appropriate condition and action. The purpose of this pattern is to allow the creation
 * of an object in a simpler manner. The Builder pattern essentially deconstructs the
 * parameters of a constructor and instead provides methods to supply each of the
 * parameters. The benefit of this approach is that it allows you to declare methods with
 * names that are suitable to the domain at hand. For example, in our case we’d like to
 * use the vocabulary when and then. The code in Example 5-29 shows how to set up
 * the Builder pattern to build a DefaultRule object. We’ve introduced a method
 * when(), which supplies the condition. The method when() returns this (i.e., the
 * current instance), which will allow us to chain up further methods. We’ve also
 * introduced a method then(), which will supply the action. The method then()
 * also returns this, which allows us to further chain a method. Finally, the method
 * createRule() is responsible for the creation of the DefaultRule object.
 * */
final Rule ruleSendEmailToSalesWhenCEO = RuleBuilder
        .when(facts -> "CEO".equals(facts.getFact("jobTitle")))
        .then(facts -> {
            var name = facts.getFact("name");
            Mailer.sendEmail("sales@company.com", "Relevant customer!!!: "
                    + name);
        });

    private static class Mailer {

        public static void sendEmail(String name1, String name){
            System.out.println(name + name1);
        }

    }
}
