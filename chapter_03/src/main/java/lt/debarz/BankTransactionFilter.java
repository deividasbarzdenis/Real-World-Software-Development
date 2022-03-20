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
    boolean test(BankTransaction bankTransaction);
}
