package com.sdk.threatwinds.enums;

public enum TWLSACustomValuesEnum {
    // Param value list to create MultiValueMap<String, String> queryParams
    // For param PARAM_LSA
    LSA_VALUE_NOW_MINUS_15M("now-15m"),
    LSA_VALUE_NOW_MINUS_30M("now-30m"),
    LSA_VALUE_NOW_MINUS_1H("now-1h"),
    LSA_VALUE_NOW_MINUS_8H("now-8h"),
    LSA_VALUE_NOW_MINUS_24H("now-24h"),
    LSA_VALUE_NOW_MINUS_7D("now-7d"),
    LSA_VALUE_NOW_MINUS_30D("now-30d"),
    LSA_VALUE_NOW_MINUS_90D("now-90d"),
    LSA_VALUE_NOW_MINUS_120D("now-120d");

    private String value;

    TWLSACustomValuesEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
