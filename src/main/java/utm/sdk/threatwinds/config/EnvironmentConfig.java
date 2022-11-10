package utm.sdk.threatwinds.config;

import utm.sdk.threatwinds.enums.EnvironmentsEnum;

public class EnvironmentConfig {

    // Represents the access key to the threat intelligence endpoints URL (TW_API_URL)
    public static final String TW_API_KEY = System.getenv(EnvironmentsEnum.TW_API_KEY.getVarName());
    // Represents the access secret for threat intelligence endpoints URL (TW_API_URL)
    public static final String TW_API_SECRET = System.getenv(EnvironmentsEnum.TW_API_SECRET.getVarName());
    // Represents the threat intelligence endpoints URL
    public static final String TW_API_URL = System.getenv(EnvironmentsEnum.TW_API_URL.getVarName());
    // Represents the threat winds API version
    private static String twApiVersion = System.getenv(EnvironmentsEnum.TW_API_VERSION.getVarName());
    public static final String TW_API_VERSION = twApiVersion != null && twApiVersion.compareTo("") != 0 ? twApiVersion : "v1";
}
