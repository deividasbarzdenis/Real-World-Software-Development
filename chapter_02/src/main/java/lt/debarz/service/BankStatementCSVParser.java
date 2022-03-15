package lt.debarz.service;

import lt.debarz.domain.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
* The first natural step is to extract the CSV parsing logic into aseparate class so you can reuse it for different
* processing queries.Let’s call it BankStatementCSVParser so it is immediately clear what it does (Example 2-3).
* the class BankStatementCSVParser declares two methods, parseFromCSV() and parseLinesFromCSV(),
* that generate BankTransaction objects, which is a domain class  that models a bank statement
* */
public class BankStatementCSVParser {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private BankTransaction parseFromCSV(final String line) {
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        return new BankTransaction(date, amount, description);
    }
    public List<BankTransaction> parseLinesFromCSV(final List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final String line: lines) {
            bankTransactions.add(parseFromCSV(line));
        }
        return bankTransactions;
    }
}

/*
* The key benefit with this refactoring is that your main application is
no longer responsible for the implementation of the parsing logic. It
is now delegating that responsibility to a separate class and methods
that can be maintained and updated independently. As new
requirements come in for different queries, you can reuse the
functionality encapsulated by the BankStatementCSVParser
class.
* */
