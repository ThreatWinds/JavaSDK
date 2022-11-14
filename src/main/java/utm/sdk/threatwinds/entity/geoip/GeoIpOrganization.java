package utm.sdk.threatwinds.entity.geoip;

public class GeoIpOrganization {
    Integer asn;
    String aso;
    String segment;

    public GeoIpOrganization(Integer asn, String aso, String segment) {
        this.asn = asn;
        this.aso = aso;
        this.segment = segment;
    }

    public GeoIpOrganization() {}

    public Integer getAsn() {
        return asn;
    }

    public void setAsn(Integer asn) {
        this.asn = asn;
    }

    public String getAso() {
        return aso;
    }

    public void setAso(String aso) {
        this.aso = aso;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    @Override
    public String toString() {
        return "GeoIpOrganization{" +
                "asn=" + asn +
                ", aso='" + aso + '\'' +
                ", segment='" + segment + '\'' +
                '}';
    }
}
