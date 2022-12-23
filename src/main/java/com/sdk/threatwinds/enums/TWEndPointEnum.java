package com.sdk.threatwinds.enums;

import com.sdk.threatwinds.config.EnvironmentConfig;

public enum TWEndPointEnum {
    GET_ENTITIES_DEF("GET_ENTITIES_DEF", "/entities/definitions"),
    GET_ENTITIES_BY_TYPE("GET_ENTITIES_BY_TYPE", "/entities/type"),
    GET_ENTITIES_BY_TYPE_DOWNLOAD("GET_ENTITIES_BY_TYPE_DOWNLOAD", "/entities/type"),
    GET_ENTITY_BY_VALUE("GET_ENTITY_BY_VALUE", "/entity/value"),
    GET_ENTITY_ASSOC("GET_ENTITY_ASSOC", "/entity/associations"),
    GET_ENTITY_ATTR("GET_ENTITY_ATTR", "/entity/attributes"),

    POST_ENTITIES("POST_ENTITIES", "/entities"),
    POST_ENTITIES_ASSOC("POST_ENTITIES_ASSOC", "/entities/associations"),

    GET_GEOIP_LOCATION_BY_IP("GET_GEOIP_LOCATION_BY_IP", "/geoip/location/"),
    GET_GEOIP_ORGANIZATION_BY_IP("GET_GEOIP_ORGANIZATION_BY_IP", "/geoip/organization/"),

    POST_GEOIP_LOCATION("POST_GEOIP_LOCATION", "/geoip/location"),
    POST_GEOIP_ORGANIZATION("POST_GEOIP_ORGANIZATION", "/geoip/organization");

    private String method_refference;
    private String method_uri;

    TWEndPointEnum(String method_refference, String method_uri) {
        this.method_refference = method_refference;
        this.method_uri = method_uri;
    }

    public String get() {
        return method_refference;
    }

    public String getUri() {
        return "/" + TWConstants.API_PREFIX.get() + "/" + EnvironmentConfig.TW_API_VERSION + method_uri;
    }
}
