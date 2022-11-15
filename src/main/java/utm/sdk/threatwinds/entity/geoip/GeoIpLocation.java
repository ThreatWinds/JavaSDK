package utm.sdk.threatwinds.entity.geoip;

public class GeoIpLocation {
    String segment;
    String country;
    String countryCode;
    String city;
    Double latitude;
    Double longitude;
    Integer accuracyRadius;

    public GeoIpLocation(String segment, String country, String countryCode, String city, Double latitude, Double longitude, Integer accuracyRadius) {
        this.segment = segment;
        this.country = country;
        this.countryCode = countryCode;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.accuracyRadius = accuracyRadius;
    }
    public GeoIpLocation(){}

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getAccuracyRadius() {
        return accuracyRadius;
    }

    public void setAccuracyRadius(Integer accuracyRadius) {
        this.accuracyRadius = accuracyRadius;
    }

    @Override
    public String toString() {
        return "GeoIpLocation{" +
                "segment='" + segment + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", city='" + city + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", accuracyRadius=" + accuracyRadius +
                '}';
    }
}
