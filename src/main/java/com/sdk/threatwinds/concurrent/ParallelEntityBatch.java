package com.sdk.threatwinds.concurrent;

import com.sdk.threatwinds.entity.ein.ThreatIntEntity;
import com.sdk.threatwinds.factory.request.TWEndpointRequest;
import com.sdk.threatwinds.service.UtilitiesService;
import com.sdk.threatwinds.service.bridge.WebClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class ParallelEntityBatch implements Runnable{
    private static final Logger log = LoggerFactory.getLogger(UtilitiesService.class);
    private static final String CLASSNAME = "ParallelEntityBatch";

    WebClientService client;
    String method_uri;
    String bodyData;
    private String batchResult = "";
    private List<ThreatIntEntity> batchList;

    public ParallelEntityBatch(WebClientService client, String method_uri, String bodyData, List<ThreatIntEntity> batchList) {
        this.client = client;
        this.method_uri = method_uri;
        this.bodyData = bodyData;
        this.batchList = batchList;
    }

    @Override
    public void run() {
        try {
            this.batchResult = this.client.post(this.method_uri, String.class, this.bodyData);
            this.batchResult = "Entity batch executed, result: " + batchResult;
            log.info(this.batchResult);
        } catch (Exception ex) {
            // In case of errors the batch list is added to the errors list,
            // this can be used from outside the sdk to perform error actions
            TWEndpointRequest.postResultList.addAll(this.batchList);
            log.error(CLASSNAME + "" + ex.getLocalizedMessage());
        }
    }
}
