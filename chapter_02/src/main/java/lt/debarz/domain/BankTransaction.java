package lt.debarz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/*
* The BankTransaction class is useful so that different parts of our application share the same common understanding
* of what a bank statement is.
* */
@AllArgsConstructor
@Data
public class BankTransaction {

    private final LocalDate date;
    private final double amount;
    private final String description;

}
