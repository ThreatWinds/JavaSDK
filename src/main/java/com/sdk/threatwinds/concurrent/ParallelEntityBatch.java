package com.sdk.threatwinds.concurrent;

import com.sdk.threatwinds.service.UtilitiesService;
import com.sdk.threatwinds.service.bridge.WebClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ParallelEntityBatch implements Runnable{
    private static final Logger log = LoggerFactory.getLogger(UtilitiesService.class);
    private static final String CLASSNAME = "ParallelEntityBatch";

    WebClientService client;
    String method_uri;
    String bodyData;
    private String batchResult = "";

    public ParallelEntityBatch(WebClientService client, String method_uri, String bodyData) {
        this.client = client;
        this.method_uri = method_uri;
        this.bodyData = bodyData;
    }

    @Override
    public void run() {
        try {
            this.batchResult = this.client.post(this.method_uri, String.class, this.bodyData);
            this.batchResult = "Entity batch executed, result: " + batchResult + "\n";
            log.info(batchResult);
        } catch (Exception ex) {
            log.error(CLASSNAME + "" + ex.getLocalizedMessage());
        }
    }
}
