package lt.debarz;

/*
* Now that you have defined an API to export information, you can
implement various kinds of exporters that respect the contract of the
Exporter interface. You can see an example of implementing a
basic HTML exporter
* */
public class HtmlExporter implements Exporter{

    @Override
    public String export(final SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: " + summaryStatistics.getSum() + "</li>";
        result += "<li><strong>The average is</strong>: " + summaryStatistics.getAverage() + "</li>";
        result += "<li><strong>The max is</strong>: " + summaryStatistics.getMax() + "</li>";
        result += "<li><strong>The min is</strong>: " + summaryStatistics.getMin() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
