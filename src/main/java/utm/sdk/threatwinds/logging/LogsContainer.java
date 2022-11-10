package utm.sdk.threatwinds.logging;

public class LogsContainer {

    static LogsCollector logsCollector = new LogsCollector();

    public static LogsCollector getCollector() {
        return logsCollector;
    }
}
