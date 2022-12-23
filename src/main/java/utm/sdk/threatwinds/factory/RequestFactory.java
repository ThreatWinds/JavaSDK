package utm.sdk.threatwinds.factory;

import utm.sdk.threatwinds.factory.request.TWEndpointRequest;
import utm.sdk.threatwinds.interfaces.IRequestExecutor;
import utm.sdk.threatwinds.service.UtilitiesService;

/*
* Main class of the SDK, dedicated to define the request to
* be executed
* */
public class RequestFactory {
    int batchSize;
    public RequestFactory(int batchSize) {
        this.batchSize = batchSize;
    }

    public IRequestExecutor getExecutor (){
            return new TWEndpointRequest(this.batchSize);
        }
}
