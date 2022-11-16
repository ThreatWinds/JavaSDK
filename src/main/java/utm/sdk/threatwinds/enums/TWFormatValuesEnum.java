package utm.sdk.threatwinds.enums;

public enum TWFormatValuesEnum {
    // Param value list to create MultiValueMap<String, String> queryParams
    // For param PARAM_FORMAT
    FORMAT_VALUE_LIST("list"),
    FORMAT_VALUE_CSV("csv"),
    FORMAT_VALUE_JSON("json"),
    FORMAT_VALUE_XML("xml"),
    FORMAT_VALUE_YAML("yaml"),
    FORMAT_VALUE_TOML("toml");

    private String value;

    TWFormatValuesEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
