package com.sdk.threatwinds.factory.request;

import com.sdk.threatwinds.entity.eout.*;
import com.sdk.threatwinds.interfaces.IRequestExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;
import com.sdk.threatwinds.entity.ein.Associations;
import com.sdk.threatwinds.entity.ein.ThreatIntEntity;
import com.sdk.threatwinds.entity.geoip.GeoIpLocation;
import com.sdk.threatwinds.entity.geoip.GeoIpOrganization;
import com.sdk.threatwinds.enums.TWEndPointEnum;
import com.sdk.threatwinds.enums.TWParamsEnum;
import com.sdk.threatwinds.json.parser.GenericParser;
import com.sdk.threatwinds.service.UtilitiesService;
import com.sdk.threatwinds.service.bridge.WebClientService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class to execute requests based on endpoint enum, builds the response objects and return it as result
 * Note: if the endpoint use cursor header, keep in mind delete "cursor" in the map of params if you don't need any more
 * or set the value to "" for the next execution. This will avoid wrong results.
 * */
public class TWEndpointRequest implements IRequestExecutor {
    int batchSize = 1000;
    private static final Logger log = LoggerFactory.getLogger(TWEndpointRequest.class);
    private static final String CLASSNAME = "TWEndpointRequest";

    public TWEndpointRequest(int batchSize) {
        if (batchSize <= 0 || batchSize > this.batchSize) {
            log.warn("Invalid batch size creating TWEndPointRequest, setting to default: " + this.batchSize);
        } else {
            this.batchSize = batchSize;
            log.info("Creating TWEndPointRequest instance with batch size: " + this.batchSize);
        }
    }

    @Override
    public Object executeRequest(String endPointMethod, Object paramsOrBody, WebClientService client) throws Exception {
        GenericParser parser = new GenericParser();
        String method_uri = "";
        if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITIES_DEF.get()) == 0) {
            String strEntityDef = client.get(TWEndPointEnum.GET_ENTITIES_DEF.getUri(), String.class,
                    UtilitiesService.emptyQueryParams);
            return parser.parseFrom(strEntityDef, EntityDefResponse[].class, new EntityDefResponse[0]);

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITIES_BY_TYPE.get()) == 0) {
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String nextCursor = queryParams.containsKey(TWParamsEnum.PARAM_CURSOR.get()) ? queryParams.getFirst(TWParamsEnum.PARAM_CURSOR.get()) : "";
            WebClientObjectResponse wcoResponse = client.getWCursor(TWEndPointEnum.GET_ENTITIES_BY_TYPE.getUri(), queryParams,nextCursor);
            wcoResponse.setResponseBody(parser.parseFrom(wcoResponse.getResponseBody().toString(), EntityResponse[].class, new EntityResponse[0]));
            return wcoResponse;

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITIES_BY_TYPE_DOWNLOAD.get()) == 0) {
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String nextCursor = queryParams.containsKey(TWParamsEnum.PARAM_CURSOR.get()) ? queryParams.getFirst(TWParamsEnum.PARAM_CURSOR.get()) : "";
            WebClientObjectResponse wcoResponse = client.getWCursor(TWEndPointEnum.GET_ENTITIES_BY_TYPE_DOWNLOAD.getUri(), queryParams,nextCursor);
            return wcoResponse;

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITY_BY_VALUE.get()) == 0) {
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String nextCursor = queryParams.containsKey(TWParamsEnum.PARAM_CURSOR.get()) ? queryParams.getFirst(TWParamsEnum.PARAM_CURSOR.get()) : "";
            WebClientObjectResponse wcoResponse = client.getWCursor(TWEndPointEnum.GET_ENTITY_BY_VALUE.getUri(), queryParams,nextCursor);
            wcoResponse.setResponseBody(parser.parseFrom(wcoResponse.getResponseBody().toString(), EntityResponse.class, new EntityResponse()));
            return wcoResponse;

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITY_ATTR.get()) == 0) {
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String nextCursor = queryParams.containsKey(TWParamsEnum.PARAM_CURSOR.get()) ? queryParams.getFirst(TWParamsEnum.PARAM_CURSOR.get()) : "";
            WebClientObjectResponse wcoResponse = client.getWCursor(TWEndPointEnum.GET_ENTITY_ATTR.getUri(), queryParams,nextCursor);
            wcoResponse.setResponseBody(parser.parseFrom(wcoResponse.getResponseBody().toString(), AttributeResponse[].class, new AttributeResponse[0]));
            return wcoResponse;

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITY_ASSOC.get()) == 0) {
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String nextCursor = queryParams.containsKey(TWParamsEnum.PARAM_CURSOR.get()) ? queryParams.getFirst(TWParamsEnum.PARAM_CURSOR.get()) : "";
            WebClientObjectResponse wcoResponse = client.getWCursor(TWEndPointEnum.GET_ENTITY_ASSOC.getUri(), queryParams,nextCursor);
            wcoResponse.setResponseBody(parser.parseFrom(wcoResponse.getResponseBody().toString(), AssociationResponse[].class, new AssociationResponse[0]));
            return wcoResponse;

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_GEOIP_LOCATION_BY_IP.get()) == 0) {
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String GEO_IP_ADDR = queryParams.containsKey(TWParamsEnum.GEO_IP_ADDR.get()) ? queryParams.getFirst(TWParamsEnum.GEO_IP_ADDR.get()) : "";
            method_uri = TWEndPointEnum.GET_GEOIP_LOCATION_BY_IP.getUri() + GEO_IP_ADDR;
            String strEntity = client.get(method_uri, String.class, UtilitiesService.emptyQueryParams);
            return parser.parseFrom(strEntity, GeoIpLocation.class, new GeoIpLocation());

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_GEOIP_ORGANIZATION_BY_IP.get()) == 0) {
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String GEO_IP_ADDR = queryParams.containsKey(TWParamsEnum.GEO_IP_ADDR.get()) ? queryParams.getFirst(TWParamsEnum.GEO_IP_ADDR.get()) : "";
            method_uri = TWEndPointEnum.GET_GEOIP_ORGANIZATION_BY_IP.getUri() + GEO_IP_ADDR;
            String strEntity = client.get(method_uri, String.class, UtilitiesService.emptyQueryParams);
            return parser.parseFrom(strEntity, GeoIpOrganization.class, new GeoIpOrganization());

        } else if (endPointMethod.compareTo(TWEndPointEnum.POST_ENTITIES.get()) == 0) {
            method_uri = TWEndPointEnum.POST_ENTITIES.getUri();
            List<ThreatIntEntity> threatIntEntityList = (List<ThreatIntEntity>) paramsOrBody;
            return postBatchEntities(client, parser, method_uri, threatIntEntityList);

        } else if (endPointMethod.compareTo(TWEndPointEnum.POST_GEOIP_LOCATION.get()) == 0) {
            method_uri = TWEndPointEnum.POST_GEOIP_LOCATION.getUri();
            GeoIpLocation geoIpLocation = (GeoIpLocation) paramsOrBody;
            String bodyData = parser.parseTo(geoIpLocation);
            return client.post(method_uri, String.class, bodyData);

        } else if (endPointMethod.compareTo(TWEndPointEnum.POST_GEOIP_ORGANIZATION.get()) == 0) {
            method_uri = TWEndPointEnum.POST_GEOIP_ORGANIZATION.getUri();
            GeoIpOrganization geoIpOrganization = (GeoIpOrganization) paramsOrBody;
            String bodyData = parser.parseTo(geoIpOrganization);
            return client.post(method_uri, String.class, bodyData);

        } else if (endPointMethod.compareTo(TWEndPointEnum.POST_ENTITIES_ASSOC.get()) == 0) {
            method_uri = TWEndPointEnum.POST_ENTITIES_ASSOC.getUri();
            Associations associations = (Associations) paramsOrBody;
            String bodyData = parser.parseTo(associations);
            return client.post(method_uri, String.class, bodyData);
        }
        return null;
    }

    public String postBatchEntities(WebClientService client, GenericParser parser, String method_uri, List<ThreatIntEntity> threatIntEntityList) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("* Batch execution:\n");
        List<ThreatIntEntity> batchEntityList = new ArrayList<>();
        Iterator<ThreatIntEntity> it;
        for (it = threatIntEntityList.iterator(); it.hasNext(); ) {
            if (batchEntityList.size() < this.batchSize) {
                batchEntityList.add(it.next());
            } else {
                try {
                    String bodyData = parser.parseTo(batchEntityList);
                    String batchResult = client.post(method_uri, String.class, bodyData);
                    stringBuffer.append("- Entity batch executed, result: " + batchResult + "\n");
                    batchEntityList = new ArrayList<>();
                    batchEntityList.add(it.next());
                } catch (Exception ex) {
                    stringBuffer.append(CLASSNAME + "" + ex.getLocalizedMessage());
                }
            }

        }
        // Executing POST with remaining Entities
        if (batchEntityList.size() > 0) {
            try {
                String bodyData = parser.parseTo(batchEntityList);
                String batchResult = client.post(method_uri, String.class, bodyData);
                stringBuffer.append("- Entity batch executed, result: " + batchResult + "\n");
            } catch (Exception ex) {
                stringBuffer.append(CLASSNAME + "" + ex.getLocalizedMessage());
            }
        }

        return stringBuffer.toString();
    }
}
