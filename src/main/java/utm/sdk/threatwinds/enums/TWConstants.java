package utm.sdk.threatwinds.enums;

public enum TWConstants {
    GEO_IP_ADDR("GEO_IP_ADDR"),
    API_PREFIX("api");

    private String constant;

    TWConstants(String constant) {
        this.constant = constant;
    }

    public String get() {
        return constant;
    }
}
