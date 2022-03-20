package lt.debarz;

import lt.debarz.service.BankStatementCSVParser;
import lt.debarz.service.BankStatementParser;

import java.io.IOException;

/*
* bring all the different parts together and create your main application
* */
public class MainApplication {

    public static void main(String[] args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }
}

/*
* Generally, when writing code you will aim for low coupling. This means that different components in your code
* are not relying on internal/implementation details. The opposite of low coupling is called high coupling,
* which is what you definitely want to avoid!
* */
