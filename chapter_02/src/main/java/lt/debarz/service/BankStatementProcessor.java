package lt.debarz.service;

import lt.debarz.domain.BankTransaction;

import java.time.Month;
import java.util.List;

/**
 * As a result, your method signatures become simpler to reason about and the class
 * BankStatementProcessor is more cohesive. The code in Example 2-7 shows the end result.
 * The additional advantage is that the methods of BankStatementProcessor can be reused by
 * other parts of your application without depending on the whole BankStatementAnalyzer.
 * */

/*
* Grouping the calculation operations in the class BankStatementProcessor
* */
public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for(final BankTransaction bankTransaction:
                bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month)
            {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

}
