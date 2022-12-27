package com.sdk.threatwinds.factory;

import com.sdk.threatwinds.factory.request.TWEndpointRequest;
import com.sdk.threatwinds.interfaces.IRequestExecutor;
import com.sdk.threatwinds.service.UtilitiesService;

import java.util.concurrent.ThreadPoolExecutor;

/*
 * Main class of the SDK, dedicated to define the request to
 * be executed, if you don't provide a ThreadPoolExecutor defaults to
 * 10 concurrent threads
 * */
public class RequestFactory {
    int batchSize;
    ThreadPoolExecutor executor;

    public RequestFactory(int batchSize) {
        this.batchSize = batchSize;
    }

    public IRequestExecutor getExecutor() {
        if (this.executor == null) {
            this.executor = UtilitiesService.defaultThreadPoolExecutor;
        }
        return new TWEndpointRequest(this.batchSize, this.executor);
    }

    public RequestFactory withThreadPoolExecutor(ThreadPoolExecutor executor) {
        this.executor = executor;
        return this;
    }
}
