package lt.debarz;

import lombok.AllArgsConstructor;

import java.time.Month;
import java.util.List;

/**
 * Declaring a class that implements the BankTransactionFilter
 * */
@AllArgsConstructor
public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter{

    private final BankStatementProcessor bankStatementProcessor;

    /*
    * However, you’d need to create special classes every time you have a new requirement. This process can
    * add unnecessary boilerplate and can rapidly become cumbersome
    * */
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;
    }

    /*
    * Implementing BankTransactionFilter using a lambda expression
    * */
    final List<BankTransaction> transactions = bankStatementProcessor.findTransactions(bankTransaction
            -> bankTransaction.getDate().getMonth() == Month.FEBRUARY
                    && bankTransaction.getAmount() >= 1_000);
}
