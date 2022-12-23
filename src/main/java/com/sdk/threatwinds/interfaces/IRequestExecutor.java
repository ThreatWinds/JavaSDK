package com.sdk.threatwinds.interfaces;

import com.sdk.threatwinds.service.bridge.WebClientService;

public interface IRequestExecutor {
    Object executeRequest(String endPointMethod, Object paramsOrBody, WebClientService client) throws Exception;
}
