package utm.sdk.threatwinds.interfaces;

import utm.sdk.threatwinds.service.bridge.WebClientService;

public interface IRequestExecutor {
    Object executeRequest(String endPointMethod, Object paramsOrBody, WebClientService client) throws Exception;
}
