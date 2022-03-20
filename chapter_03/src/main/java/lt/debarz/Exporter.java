package lt.debarz;

public interface Exporter {

    /*
    * With this in mind, you come up with an alternative API that returns a String, as shown in Example 3-14.
    * It is now clear that the Exporter will return text and it’s then up to a separate part of the program
    * to decide whether to print it, save it to a file, or even send it electronically. Text strings are also
    * very useful for testing as you can directly compare them with assertions.
    * */
    String export(SummaryStatistics summaryStatistics);

}
