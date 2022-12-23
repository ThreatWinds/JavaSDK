package com.sdk.threatwinds.factory;

import com.sdk.threatwinds.factory.request.TWEndpointRequest;
import com.sdk.threatwinds.interfaces.IRequestExecutor;

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
