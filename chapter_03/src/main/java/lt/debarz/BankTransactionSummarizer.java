package lt.debarz;

/*
* Key operations for the BankTransactionProcessor class
* */
@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
