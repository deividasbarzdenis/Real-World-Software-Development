package lt.debarz;

/**
 * An interface that only contains a single abstract method is called a functional
 * interface since Java 8. You can annotate it using the
 * @FunctionalInterface annotation to make the intent of the interface clearer.
 *
 * Java 8 introduced a generic java.util.function.Predicate<T>
 * inferface, which would be a great fit for the problem at hand. However, this
 * chapter introduces a new named interface to avoid introducing too much
 * complexity early on in the book
 * */
@FunctionalInterface
public interface BankTransactionFilter {

    /**
     *  a way to decouple the iteration logic from the
     * business logic through this interface. Your method no longer depends
     * on one specific implementation of a filter. You can introduce new
     * implementations by passing them as an argument without modifying
     * the body of this method. Hence, it is now open for extension and
     * closed for modification
     * */
    boolean test(BankTransaction bankTransaction);
}
