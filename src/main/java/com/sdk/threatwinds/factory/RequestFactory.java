package com.sdk.threatwinds.factory;

import com.sdk.threatwinds.factory.request.TWEndpointRequest;
import com.sdk.threatwinds.interfaces.IRequestExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/*
* Main class of the SDK, dedicated to define the request to
* be executed
* */
public class RequestFactory {
    int batchSize;
    ThreadPoolExecutor executor;
    public RequestFactory(int batchSize, ThreadPoolExecutor executor) {
        this.batchSize = batchSize;
        this.executor = executor;
    }

    public IRequestExecutor getExecutor (){
            return new TWEndpointRequest(this.batchSize, this.executor);
        }
}
