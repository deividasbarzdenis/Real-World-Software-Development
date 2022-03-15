package lt.debarz.example2_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*Example 2-1. Calculating the sum of all statements*/
public class BankTransactionAnalyzerSimple {
    private static final Path RESOURCES = (Paths.get(
            "./chapter_02/src/main/resources/bank-data-simple.csv")).toAbsolutePath();

    public static void main(final String... args) throws IOException {
        Double sum = Files.readAllLines(RESOURCES).stream()
                .map(line -> line.split(","))
                .map(amount -> Double.parseDouble(amount[1]))
                .reduce(Double::sum)
                .orElse(0d);
        System.out.println("The total for all transactions is: " + sum);
        calculatingSum();
    }

    /*
     * How many bank transactions are there in a particular month
     * Example 2-2. Calculating the sum of January statements:
     * */
    public static void calculatingSum() throws IOException {
        final List<String> lines = Files.readAllLines(RESOURCES);
        double total = 0d;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0],
                    DATE_PATTERN);
            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }
        System.out.println("The total for all transactions in January is" + total);
    }

}
