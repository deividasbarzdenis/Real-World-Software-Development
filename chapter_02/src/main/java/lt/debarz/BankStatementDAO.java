package lt.debarz;

import lt.debarz.domain.BankTransaction;

import java.time.LocalDate;

/*
* An example of informational cohesion
* */
public class BankStatementDAO {
    public BankTransaction create(final LocalDate date, final double amount, final String description) {
        // ...
        throw new UnsupportedOperationException();
    }

    public BankTransaction read(final long id) {
        // ...
        throw new UnsupportedOperationException();
    }

    public BankTransaction update(final long id) {
        // ...
        throw new UnsupportedOperationException();
    }

    public void delete(final BankTransaction bankTransaction) {
        // ...
        throw new UnsupportedOperationException();
    }
}
