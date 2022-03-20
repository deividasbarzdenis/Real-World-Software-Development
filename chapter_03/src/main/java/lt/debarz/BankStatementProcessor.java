package lt.debarz;

import lombok.AllArgsConstructor;

import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@AllArgsConstructor
public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public SummaryStatistics  summarizeTransactions(){
        final DoubleSummaryStatistics doubleSummaryStatistics = bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .summaryStatistics();

        return new SummaryStatistics(doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getAverage());
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((acc, bankTransaction) -> bankTransaction.getDate().getMonth() == month
                        ? acc + bankTransaction.getAmount() : acc);
    }

    /*
    * Flexible findTransactions() method using Open/Closed Principle
    * */
    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction:
                bankTransactions) {
            if(bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return bankTransactions;
    }
    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }
}
