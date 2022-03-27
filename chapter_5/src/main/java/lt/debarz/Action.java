package lt.debarz;

@FunctionalInterface
public interface Action {

    void perform(Facts facts);

}
