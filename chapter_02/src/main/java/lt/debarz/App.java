package lt.debarz;

import lt.debarz.domain.BankTransaction;
import lt.debarz.service.BankStatementCSVParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * The different queries you have to implement no longer need to know
 * about internal parsing details, as you can now use
 * BankTransaction objects directly to extract the information required.
 */
public class App {

    private static final Path RESOURCES = (Paths.get(
            "./chapter_02/src/main/resources/bank-data-simple.csv")).toAbsolutePath();

    public static void main( String[] args ) throws IOException {
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        final List<String> lines = Files.readAllLines(RESOURCES);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
    }

    /*
    * to declare the methods calculateTotalAmount() and selectInMonth(), which are responsible for processing
    * the list of transactions and returning an appropriate result
    * */
    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for(final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }
    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for(final BankTransaction bankTransaction:
                bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }
}
