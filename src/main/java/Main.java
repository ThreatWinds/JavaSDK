import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import utm.sdk.threatwinds.entity.eout.EntityDefResponse;
import utm.sdk.threatwinds.entity.eout.EntityResponse;
import utm.sdk.threatwinds.entity.geoip.GeoIpLocation;
import utm.sdk.threatwinds.entity.geoip.GeoIpOrganization;
import utm.sdk.threatwinds.factory.TWJobFactory;
import utm.sdk.threatwinds.interfaces.IJobExecutor;
import utm.sdk.threatwinds.json.parser.GenericParser;
import utm.sdk.threatwinds.service.bridge.WebClientService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            WebClientService client = WebClientService.getAndConnectWebClient();
            MultiValueMap<String, String> emptyQueryParams = new LinkedMultiValueMap<>();
            //queryParams.set("value","threat");

            GenericParser parser = new GenericParser();

            //String strGeoIpLoc = client.get("/api/v1/geoip/location/51.79.84.7", String.class, emptyQueryParams);
            //GeoIpLocation geoIpLoc = parser.parseFrom(str, GeoIpLocation.class,new GeoIpLocation());

            //String strGeoIpOrg = client.get("/api/v1/geoip/organization/51.79.84.7", String.class, emptyQueryParams);
            //GeoIpOrganization geoIpOrg = parser.parseFrom(strGeoIpOrg, GeoIpOrganization.class,new GeoIpOrganization());

            //String strEntityDef = client.get("/api/v1/entities/definitions", String.class, emptyQueryParams);
            //EntityDefResponse[] entityDefResponseList = parser.parseFrom(strEntityDef, EntityDefResponse[].class,new EntityDefResponse[0]);

            MultiValueMap<String, String> searchQueryParams = new LinkedMultiValueMap<>();
            searchQueryParams.set("value","threat");

            String strEntitySearch = client.get("/api/v1/entities/search", String.class, searchQueryParams);
            EntityResponse[] entityResponseList = parser.parseFrom(strEntitySearch, EntityResponse[].class,new EntityResponse[0]);

            System.out.println(entityResponseList[0].toString());
            IJobExecutor mainJob = new TWJobFactory().getJob();
            if (mainJob!=null) {
                mainJob.executeFlow();
            } else {
                System.out.println("Testing");
            }
        } catch (Exception jne){
            System.out.println(jne.getMessage());
        }
    }
}
