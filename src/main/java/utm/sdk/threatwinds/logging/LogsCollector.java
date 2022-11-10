package utm.sdk.threatwinds.logging;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Freddy
 */
public class LogsCollector {

    ArrayList<LogDef> logsList;

    public LogsCollector() {
        if (this.logsList == null) {
            this.logsList = new ArrayList<LogDef>();
        }
    }

    public ArrayList<LogDef> getLogsList() {
        return logsList;
    }

    public void collectLogs() {
        if (logsList.size() > 0) {
            //System.out.println("Errors detected...");
            for (Iterator it = logsList.iterator(); it.hasNext();) {
                LogDef errors = (LogDef) it.next();
                System.out.println(errors.logDefToString());
            }
        } else {
            System.out.println("No errors detected...");
        }
    }

    //Return all logs for a given type, allowed values: See LogTypeEnum
    public ArrayList<LogDef> collectLogsByType(String TYPE) {
        ArrayList<LogDef> byType = new ArrayList<LogDef>();
        if (logsList.size() > 0) {
            //System.out.println("Errors detected...");
            for (Iterator it = logsList.iterator(); it.hasNext();) {
                LogDef errors = (LogDef) it.next();
                if (errors.getLOG_TYPE().compareTo(TYPE) == 0) {
                    byType.add(errors);
                }
            }
        }
        return byType;
    }

    //Return all logs except a given type, allowed values: See LogTypeEnum
    public ArrayList<LogDef> collectLogsExceptType(String TYPE) {
        ArrayList<LogDef> byType = new ArrayList<LogDef>();
        if (logsList.size() > 0) {
            //System.out.println("Errors detected...");
            for (Iterator it = logsList.iterator(); it.hasNext();) {
                LogDef errors = (LogDef) it.next();
                if (errors.getLOG_TYPE().compareTo(TYPE) != 0) {
                    byType.add(errors);
                }
            }
        }
        return byType;
    }
}
