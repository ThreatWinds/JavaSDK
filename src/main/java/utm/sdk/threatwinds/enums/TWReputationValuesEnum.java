package utm.sdk.threatwinds.enums;

public enum TWReputationValuesEnum {
    // Param value list to create MultiValueMap<String, String> queryParams
    // For param PARAM_REPUTATION
    REPUTATION_VALUE_ANY("any"),
    REPUTATION_VALUE_GOOD("good"),
    REPUTATION_VALUE_BAD("bad");

    private String value;

    TWReputationValuesEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
