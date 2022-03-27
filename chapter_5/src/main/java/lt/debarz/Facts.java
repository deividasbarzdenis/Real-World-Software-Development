package lt.debarz;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * We need to encapsulate the state that is available to actions
 * within the Business Rules Engine. Let’s model these requirements by introducing a
 * new class called Facts, which will represent the state available as part of the
 * Business Rules Engine, and an updated Action interface that can operate on facts.
 * An updated unit test is shown in Example 5-9. The unit test checks that when the
 * Business Rules Engine runs, the specified action is actually invoked with the Facts
 * object passed as an argument.
 * */
@Data
@Getter
@Setter
public class Facts {

    private final Map<String, String> facts = new HashMap<>();

    public void addFact(final String name, final String value) {
        this.facts.put(name, value);
    }

    public String getFact(String name) {
        return this.facts.get(name);
    }

    public void setFact(String name, String value) {
        this.facts.put(name, value);
    }
}
