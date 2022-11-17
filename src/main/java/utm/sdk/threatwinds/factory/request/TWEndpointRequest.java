package utm.sdk.threatwinds.factory.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;
import utm.sdk.threatwinds.config.EnvironmentConfig;
import utm.sdk.threatwinds.entity.ein.Associations;
import utm.sdk.threatwinds.entity.ein.ThreatIntEntity;
import utm.sdk.threatwinds.entity.eout.EntityDefResponse;
import utm.sdk.threatwinds.entity.eout.EntityResponse;
import utm.sdk.threatwinds.entity.eout.EntityWithAssociationsResponse;
import utm.sdk.threatwinds.entity.geoip.GeoIpLocation;
import utm.sdk.threatwinds.entity.geoip.GeoIpOrganization;
import utm.sdk.threatwinds.enums.TWConstants;
import utm.sdk.threatwinds.enums.TWEndPointEnum;
import utm.sdk.threatwinds.enums.TWParamsEnum;
import utm.sdk.threatwinds.interfaces.IRequestExecutor;
import utm.sdk.threatwinds.json.parser.GenericParser;
import utm.sdk.threatwinds.service.UtilitiesService;
import utm.sdk.threatwinds.service.bridge.WebClientService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public Object executeRequest(String endPointMethod, Object paramsOrBody) throws Exception {
        WebClientService client = WebClientService.getAndConnectWebClient();
        GenericParser parser = new GenericParser();
        String method_uri = "";
        if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITIES_DEF.get()) == 0) {
            method_uri = TWEndPointEnum.GET_ENTITIES_DEF.getUri();
            String strEntityDef = client.get(method_uri, String.class, UtilitiesService.emptyQueryParams);
            return parser.parseFrom(strEntityDef, EntityDefResponse[].class, new EntityDefResponse[0]);

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITIES_BY_SEARCH.get()) == 0) {
            method_uri = TWEndPointEnum.GET_ENTITIES_BY_SEARCH.getUri();
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String strEntity = client.get(method_uri, String.class, queryParams);
            return parser.parseFrom(strEntity, EntityResponse[].class, new EntityResponse[0]);

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITIES_BY_TYPE.get()) == 0) {
            method_uri = TWEndPointEnum.GET_ENTITIES_BY_TYPE.getUri();
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String strEntity = client.get(method_uri, String.class, queryParams);
            return parser.parseFrom(strEntity, EntityResponse[].class, new EntityResponse[0]);

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITIES_BY_TYPE_DOWNLOAD.get()) == 0) {
            method_uri = TWEndPointEnum.GET_ENTITIES_BY_TYPE_DOWNLOAD.getUri();
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            return client.get(method_uri, String.class, queryParams);

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITY_BY_ID.get()) == 0) {
            method_uri = TWEndPointEnum.GET_ENTITY_BY_ID.getUri();
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String strEntity = client.get(method_uri, String.class, queryParams);
            return parser.parseFrom(strEntity, EntityWithAssociationsResponse.class, new EntityWithAssociationsResponse());

        } else if (endPointMethod.compareTo(TWEndPointEnum.GET_ENTITY_BY_VALUE.get()) == 0) {
            method_uri = TWEndPointEnum.GET_ENTITY_BY_VALUE.getUri();
            MultiValueMap<String, String> queryParams = (MultiValueMap<String, String>) paramsOrBody;
            String strEntity = client.get(method_uri, String.class, queryParams);
            return parser.parseFrom(strEntity, EntityWithAssociationsResponse.class, new EntityWithAssociationsResponse());

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
            return postBatchEntities(client,parser,method_uri,threatIntEntityList);

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
