package com.sdk.threatwinds.entity.eout;

public class WebClientObjectResponse {
    Object nextCursor = "";
    Object responseBody = "";

    public WebClientObjectResponse(Object nextCursor, Object responseBody) {
        this.nextCursor = nextCursor;
        this.responseBody = responseBody;
    }
    public WebClientObjectResponse(){}

    public Object getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(Object nextCursor) {
        this.nextCursor = nextCursor;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }
}
