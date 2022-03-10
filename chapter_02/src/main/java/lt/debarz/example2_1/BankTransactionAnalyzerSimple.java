package lt.debarz.example2_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*Example 2-1. Calculating the sum of all statements*/
public class BankTransactionAnalyzerSimple {
    private static final Path RESOURCES = (Paths.get("./chapter_02/src/main/resources/bank-data-simple.csv")).toAbsolutePath();

    public static void main(final String... args) throws IOException {
        Double sum = Files.readAllLines(RESOURCES).stream()
                .map(line -> line.split(","))
                .map(amount -> Double.parseDouble(amount[1]))
                .reduce(Double::sum)
                .orElse(0d);
        System.out.println("The total for all transactions is " + sum);
    }

}
