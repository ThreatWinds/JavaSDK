package utm.sdk.threatwinds.enums;

/*Enum to define all environment variables used in the ETL process*/
public enum EnvironmentsEnum {

    TW_API_KEY("TW_API_KEY"),
    TW_API_SECRET("TW_API_SECRET"),
    TW_API_URL("TW_API_URL"),
    TW_API_VERSION("TW_API_VERSION"),
    TW_AUTHENTICATION("TW_AUTHENTICATION");

    private String varName;

    EnvironmentsEnum(String varName) {
        this.varName = varName;
    }

    public String getVarName() {
        return varName;
    }
}
