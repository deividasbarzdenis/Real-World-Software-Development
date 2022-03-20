package lt.debarz;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SummaryStatistics {

    private final double sum;
    private final double max;
    private final double min;
    private final double average;

}
