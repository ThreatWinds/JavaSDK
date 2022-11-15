import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import utm.sdk.threatwinds.entity.eout.EntityDefResponse;
import utm.sdk.threatwinds.entity.eout.EntityResponse;
import utm.sdk.threatwinds.entity.eout.EntityWithAssociationsResponse;
import utm.sdk.threatwinds.entity.geoip.GeoIpLocation;
import utm.sdk.threatwinds.enums.TWConstants;
import utm.sdk.threatwinds.enums.TWEndPointEnum;
import utm.sdk.threatwinds.factory.RequestFactory;
import utm.sdk.threatwinds.interfaces.IRequestExecutor;
import utm.sdk.threatwinds.json.parser.GenericParser;
import utm.sdk.threatwinds.service.bridge.WebClientService;

public class Main {

    public static void main(String[] args) {
        try {
            WebClientService client = WebClientService.getAndConnectWebClient();
            MultiValueMap<String, String> emptyQueryParams = new LinkedMultiValueMap<>();
            //queryParams.set("value","threat");

            //GenericParser parser = new GenericParser();

            //String strGeoIpLoc = client.get("/api/v1/geoip/location/51.79.84.7", String.class, emptyQueryParams);
            //GeoIpLocation geoIpLoc = parser.parseFrom(str, GeoIpLocation.class,new GeoIpLocation());

            //String strGeoIpOrg = client.get("/api/v1/geoip/organization/51.79.84.7", String.class, emptyQueryParams);
            //GeoIpOrganization geoIpOrg = parser.parseFrom(strGeoIpOrg, GeoIpOrganization.class,new GeoIpOrganization());

            //String strEntityDef = client.get("/api/v1/entities/definitions", String.class, emptyQueryParams);
            //EntityDefResponse[] entityDefResponseList = parser.parseFrom(strEntityDef, EntityDefResponse[].class,new EntityDefResponse[0]);

            //MultiValueMap<String, String> searchQueryParams = new LinkedMultiValueMap<>();
            //searchQueryParams.set("value","threat");

            //String strEntitySearch = client.get("/api/v1/entities/search", String.class, searchQueryParams);
            //EntityResponse[] entityResponseList = parser.parseFrom(strEntitySearch, EntityResponse[].class,new EntityResponse[0]);

            //MultiValueMap<String, String> searchQueryParams = new LinkedMultiValueMap<>();
            //searchQueryParams.set("value","threat");

            //String strEntityWithAssoc = client.get("/api/v1/entity/id", String.class, searchQueryParams);
            //EntityWithAssociationsResponse entityWithAssociationsResponse = parser.parseFrom(strEntityWithAssoc, EntityWithAssociationsResponse.class,new EntityWithAssociationsResponse());

            //System.out.println(entityWithAssociationsResponse.toString());
            IRequestExecutor mainJob = new RequestFactory().getExecutor();
            if (mainJob != null) {
                /*EntityDefResponse[] entityDefResponseList = (EntityDefResponse[]) mainJob.executeRequest(TWEndPointEnum.GET_ENTITIES_DEF.get(), emptyQueryParams);
                System.out.println(entityDefResponseList[0].toString());*/

                /*MultiValueMap<String, String> searchQueryParams = new LinkedMultiValueMap<>();
                searchQueryParams.set("value","threat");
                searchQueryParams.set("limit","10");
                searchQueryParams.set("offset","0");
                EntityResponse[] entityResponseList = (EntityResponse[]) mainJob.executeRequest(TWEndPointEnum.GET_ENTITIES_BY_SEARCH.get(), searchQueryParams);
                System.out.println(entityResponseList[0].toString());*/

                /*MultiValueMap<String, String> typeQueryParams = new LinkedMultiValueMap<>();
                typeQueryParams.set("value","threat");
                typeQueryParams.set("limit","10");
                typeQueryParams.set("offset","0");
                typeQueryParams.set("reputation","any");
                typeQueryParams.set("accuracy","0");
                typeQueryParams.set("lsa","now-90d");
                EntityResponse[] entityResponseList = (EntityResponse[]) mainJob.executeRequest(TWEndPointEnum.GET_ENTITIES_BY_TYPE.get(), typeQueryParams);
                System.out.println(entityResponseList[0].toString());*/

                /*MultiValueMap<String, String> entIdQueryParams = new LinkedMultiValueMap<>();
                entIdQueryParams.set("value","1eb11c1d-2ccc-473f-ad3c-dc78f2df013d");
                entIdQueryParams.set("limit","10");
                entIdQueryParams.set("offset","0");
                EntityWithAssociationsResponse entityAssocResponse = (EntityWithAssociationsResponse) mainJob.executeRequest(TWEndPointEnum.GET_ENTITY_BY_ID.get(), entIdQueryParams);
                System.out.println(entityAssocResponse.toString());*/

                /*MultiValueMap<String, String> entValueQueryParams = new LinkedMultiValueMap<>();
                entValueQueryParams.set("value","OSINT - Keep Calm and (Donâ€™t) Enable Macros: A New Threat Actor Targets UAE Dissidents");
                entValueQueryParams.set("limit","10");
                entValueQueryParams.set("offset","0");
                EntityWithAssociationsResponse entityAssocResponse = (EntityWithAssociationsResponse) mainJob.executeRequest(TWEndPointEnum.GET_ENTITY_BY_VALUE.get(), entValueQueryParams);
                System.out.println(entityAssocResponse.toString());*/

                MultiValueMap<String, String> geoIpLocQueryParams = new LinkedMultiValueMap<>();
                geoIpLocQueryParams.set(TWConstants.GEO_IP_ADDR.get(), "51.79.84.7");
                GeoIpLocation geoIpLocation = (GeoIpLocation) mainJob.executeRequest(TWEndPointEnum.GET_GEOIP_LOCATION_BY_IP.get(), geoIpLocQueryParams);
                System.out.println(geoIpLocation.toString());


            } else {
                System.out.println("Testing");
            }
        } catch (Exception jne) {
            System.out.println(jne.getMessage());
        }
    }
}
