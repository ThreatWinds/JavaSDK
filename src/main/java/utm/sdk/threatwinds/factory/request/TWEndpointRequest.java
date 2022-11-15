package utm.sdk.threatwinds.factory.request;

import org.springframework.util.MultiValueMap;
import utm.sdk.threatwinds.config.EnvironmentConfig;
import utm.sdk.threatwinds.entity.eout.EntityDefResponse;
import utm.sdk.threatwinds.entity.eout.EntityResponse;
import utm.sdk.threatwinds.entity.eout.EntityWithAssociationsResponse;
import utm.sdk.threatwinds.entity.geoip.GeoIpLocation;
import utm.sdk.threatwinds.entity.geoip.GeoIpOrganization;
import utm.sdk.threatwinds.enums.TWConstants;
import utm.sdk.threatwinds.enums.TWEndPointEnum;
import utm.sdk.threatwinds.interfaces.IRequestExecutor;
import utm.sdk.threatwinds.json.parser.GenericParser;
import utm.sdk.threatwinds.service.UtilitiesService;
import utm.sdk.threatwinds.service.bridge.WebClientService;

public class TWEndpointRequest implements IRequestExecutor {
    @Override
    public Object executeRequest(String endPointMethod, Object paramsOrBody) throws Exception {
        WebClientService client = WebClientService.getAndConnectWebClient();
        GenericParser parser = new GenericParser();
        String method_uri = "";
        if(endPointMethod.compareTo(TWEndPointEnum.GET_ENTITIES_DEF.get())==0){
          method_uri = TWEndPointEnum.GET_ENTITIES_DEF.getUri();
          String strEntityDef = client.get(method_uri, String.class, UtilitiesService.emptyQueryParams);
          EntityDefResponse[] entityDefResponseList = parser.parseFrom(strEntityDef, EntityDefResponse[].class,new EntityDefResponse[0]);
          return entityDefResponseList;
        } else if(endPointMethod.compareTo(TWEndPointEnum.GET_ENTITIES_BY_SEARCH.get())==0){
            method_uri = TWEndPointEnum.GET_ENTITIES_BY_SEARCH.getUri();
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>)paramsOrBody;
            String strEntity = client.get(method_uri, String.class, queryParams);
            EntityResponse[] entityResponseList = parser.parseFrom(strEntity, EntityResponse[].class,new EntityResponse[0]);
            return entityResponseList;
        } else if(endPointMethod.compareTo(TWEndPointEnum.GET_ENTITIES_BY_TYPE.get())==0){
            method_uri = TWEndPointEnum.GET_ENTITIES_BY_TYPE.getUri();
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>)paramsOrBody;
            String strEntity = client.get(method_uri, String.class, queryParams);
            EntityResponse[] entityResponseList = parser.parseFrom(strEntity, EntityResponse[].class,new EntityResponse[0]);
            return entityResponseList;
        } else if(endPointMethod.compareTo(TWEndPointEnum.GET_ENTITY_BY_ID.get())==0){
            method_uri = TWEndPointEnum.GET_ENTITY_BY_ID.getUri();
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>)paramsOrBody;
            String strEntity = client.get(method_uri, String.class, queryParams);
            EntityWithAssociationsResponse entityAssocResponse = parser.parseFrom(strEntity, EntityWithAssociationsResponse.class,new EntityWithAssociationsResponse());
            return entityAssocResponse;
        } else if(endPointMethod.compareTo(TWEndPointEnum.GET_ENTITY_BY_VALUE.get())==0){
            method_uri = TWEndPointEnum.GET_ENTITY_BY_VALUE.getUri();
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>)paramsOrBody;
            String strEntity = client.get(method_uri, String.class, queryParams);
            EntityWithAssociationsResponse entityAssocResponse = parser.parseFrom(strEntity, EntityWithAssociationsResponse.class,new EntityWithAssociationsResponse());
            return entityAssocResponse;
        } else if(endPointMethod.compareTo(TWEndPointEnum.GET_GEOIP_LOCATION_BY_IP.get())==0){
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>)paramsOrBody;
            String GEO_IP_ADDR = queryParams.containsKey(TWConstants.GEO_IP_ADDR.get())?queryParams.getFirst(TWConstants.GEO_IP_ADDR.get()):"";
            method_uri = TWEndPointEnum.GET_GEOIP_LOCATION_BY_IP.getUri()+GEO_IP_ADDR;
            String strEntity = client.get(method_uri, String.class, UtilitiesService.emptyQueryParams);
            GeoIpLocation geoIpLocation = parser.parseFrom(strEntity, GeoIpLocation.class,new GeoIpLocation());
            return geoIpLocation;
        } else if(endPointMethod.compareTo(TWEndPointEnum.GET_GEOIP_ORGANIZATION_BY_IP.get())==0){
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>)paramsOrBody;
            String GEO_IP_ADDR = queryParams.containsKey(TWConstants.GEO_IP_ADDR.get())?queryParams.getFirst(TWConstants.GEO_IP_ADDR.get()):"";
            method_uri = TWEndPointEnum.GET_GEOIP_ORGANIZATION_BY_IP.getUri()+GEO_IP_ADDR;
            String strEntity = client.get(method_uri, String.class, UtilitiesService.emptyQueryParams);
            GeoIpOrganization geoIpOrganization = parser.parseFrom(strEntity, GeoIpOrganization.class,new GeoIpOrganization());
            return geoIpOrganization;
        }
        return null;
    }
}
