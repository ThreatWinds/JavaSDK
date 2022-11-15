package utm.sdk.threatwinds.interfaces;

public interface IRequestExecutor {
    Object executeRequest(String endPointMethod, Object paramsOrBody) throws Exception;
}
