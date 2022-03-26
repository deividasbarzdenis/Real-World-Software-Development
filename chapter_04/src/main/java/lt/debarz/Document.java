package lt.debarz;

import java.util.Map;

/**
 * In short, domain classes allow us to name a concept and restrict the
 * possible behaviors and values of this concept in order to improve
 * discoverability and reduce the scope for bugs.
 * */
public class Document {

    private final Map<String, String> attributes;

    Document(final Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(final String attributeName) {
        return attributes.get(attributeName);
    }
}
