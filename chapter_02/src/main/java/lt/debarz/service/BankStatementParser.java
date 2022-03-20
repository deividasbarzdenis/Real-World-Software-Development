package lt.debarz.service;

import lt.debarz.domain.BankTransaction;

import java.util.List;

/**
 * An interface for parsing bank statements
 * You can decouple different components by using an interface, which is the tool of choice for providing
 * flexibility for changing requirements.
 * */
public interface BankStatementParser {

    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
