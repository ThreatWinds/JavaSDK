package utm.sdk.threatwinds.factory;

import utm.sdk.threatwinds.factory.request.TWEndpointRequest;
import utm.sdk.threatwinds.interfaces.IRequestExecutor;
import utm.sdk.threatwinds.service.UtilitiesService;

/*
* Main class of the API, dedicated to define the feed to
* be executed
* */
public class RequestFactory {
    public RequestFactory() {
    }

    public IRequestExecutor getExecutor (){
        if (UtilitiesService.isEnvironmentOk()) {
            return new TWEndpointRequest();
        }
        return null;
    }
}