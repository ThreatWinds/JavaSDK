package com.sdk.threatwinds.exceptions;

public class WebClientConnectionException extends Exception{
    public WebClientConnectionException () {
        super("com.sdk.threatwinds.service.bridge.WebClientService: (DOWN) Error trying to create and connect WebClient, please check that you defined the environment variables " +
                "or the permission parameters needed to connect");
    }
}
