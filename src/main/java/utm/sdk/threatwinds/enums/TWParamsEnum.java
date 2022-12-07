package utm.sdk.threatwinds.enums;

public enum TWParamsEnum {
    // Param Keys list to create MultiValueMap<String, String> queryParams
    PARAM_TYPE("type"),
    PARAM_VALUE("value"),
    PARAM_LIMIT("limit"),
    PARAM_CURSOR("cursor"),
    PARAM_NEXT_CURSOR("next-cursor"),
    PARAM_OFFSET("offset"),
    PARAM_REPUTATION("reputation"),
    PARAM_ACCURACY("accuracy"),
    PARAM_LSA("lsa"),
    PARAM_FORMAT("format"),

    // Path keys constants
    // Special param used to set the path value for GeoIp posts
    GEO_IP_ADDR("GEO_IP_ADDR");

    private String param;

    TWParamsEnum(String param) {
        this.param = param;
    }

    public String get() {
        return param;
    }
}
