import org.springframework.util.MultiValueMap;
import utm.sdk.threatwinds.entity.in.GeoIpObject;
import utm.sdk.threatwinds.factory.TWJobFactory;
import utm.sdk.threatwinds.interfaces.IJobExecutor;
import utm.sdk.threatwinds.json.parser.GenericParser;
import utm.sdk.threatwinds.service.bridge.WebClientService;

public class Main {

    public static void main(String[] args) {
        try {
            WebClientService client = WebClientService.getAndConnectWebClient();
            String str = client.get("/api/v1/geoip/location/51.79.84.7", String.class );
            GenericParser parser = new GenericParser();
            GeoIpObject ip = parser.parseFrom(str, GeoIpObject.class,new GeoIpObject());
            System.out.println(ip.toString());
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
