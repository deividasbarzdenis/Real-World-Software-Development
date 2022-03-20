package lt.debarz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class BankTransaction {

    private final LocalDate date;
    private final double amount;
    private final String description;

}
