package lt.debarz.service;

import lt.debarz.domain.BankTransaction;

/*
 * An example of logical cohesion
 * Say you needed to provide implementations for parsing from CSV, JSON, and XML. You may be tempted to group the methods
 * responsible for parsing the different format inside one class
 * */
public class BankTransactionParser {

    public BankTransaction parseFromCSV(final String line) {
// ...
        throw new UnsupportedOperationException();
    }

    public BankTransaction parseFromJSON(final String line) {
        // ...
        throw new UnsupportedOperationException();
    }

    public BankTransaction parseFromXML(final String line) {
// ...
        throw new UnsupportedOperationException();
    }
}
