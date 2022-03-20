package lt.debarz;

import lt.debarz.domain.BankTransaction;
import lt.debarz.service.BankStatementCSVParser;
import lt.debarz.service.BankStatementParser;
import lt.debarz.service.BankStatementProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

/*
 * Processing lists of bank transactions using the BankStatementProcessor class
 * */
public class BankStatementAnalyzer {

    private static final String RESOURCES = "./chapter_02/src/main/resources/bank-data-simple.csv";

    /*
    * Decoupling the Bank Statements Analyzer from the parser
    * */
    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = (Paths.get(RESOURCES + fileName)).toAbsolutePath();
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }


}
