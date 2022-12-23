package com.sdk.threatwinds.service.bridge;

import com.sdk.threatwinds.exceptions.WebClientConnectionException;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import com.sdk.threatwinds.config.EnvironmentConfig;
import com.sdk.threatwinds.entity.eout.WebClientObjectResponse;
import com.sdk.threatwinds.enums.TWParamsEnum;
import com.sdk.threatwinds.service.UtilitiesService;

import java.util.List;

/**
 * @author Leonardo Mora Lopez, modified by Freddy R. Laffita Almaguer
 */

public class WebClientService {

    private static final Logger log = LoggerFactory.getLogger(WebClientService.class);
    private static final String CLASSNAME = "WebClientService";

    private static WebClient wc;
    private static WebClientService webClientService = null;
    private HttpHeaders headers = new HttpHeaders();

    private WebClientService() {
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            if (EnvironmentConfig.TW_AUTHENTICATION != null && EnvironmentConfig.TW_AUTHENTICATION.compareTo("") != 0) {
                headers.add("Authorization", "Bearer " + EnvironmentConfig.TW_AUTHENTICATION);
            } else {
                headers.add("api-key", EnvironmentConfig.TW_API_KEY);
                headers.add("api-secret", EnvironmentConfig.TW_API_SECRET);
            }

        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies
                .builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();

        HttpClient httpClient = HttpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 720000)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(720));
                    connection.addHandlerLast(new WriteTimeoutHandler(720));
                });

        wc =
                WebClient
                        .builder()
                        .baseUrl(EnvironmentConfig.TW_API_URL)
                        .defaultHeaders(headers -> headers.addAll(this.headers))
                        .clientConnector(new ReactorClientHttpConnector(httpClient))
                        .exchangeStrategies(strategies)
                        .build();
        log.info("WebClient status -> CREATED");
    }
    private WebClientService(String TW_API_URL, String TW_AUTHENTICATION, String TW_API_KEY, String TW_API_SECRET) {
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        if (TW_AUTHENTICATION != null && TW_AUTHENTICATION.compareTo("") != 0) {
            headers.add("Authorization", "Bearer " + TW_AUTHENTICATION);
        } else {
            headers.add("api-key", TW_API_KEY);
            headers.add("api-secret", TW_API_SECRET);
        }

        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies
                .builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();

        HttpClient httpClient = HttpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 720000)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(720));
                    connection.addHandlerLast(new WriteTimeoutHandler(720));
                });

        wc =
                WebClient
                        .builder()
                        .baseUrl(TW_API_URL)
                        .defaultHeaders(headers -> headers.addAll(this.headers))
                        .clientConnector(new ReactorClientHttpConnector(httpClient))
                        .exchangeStrategies(strategies)
                        .build();
        log.info("WebClient status -> CREATED");
    }

    // Singleton implementation to get the WebCient instance with custom permission keys
    // Order is TW_API_URL, TW_AUTHENTICATION, TW_API_KEY, TW_API_SECRET
    // If you don't provide those variables, it looks in the environment, if not present in the environment launch an error
    // You can pass combination of (TW_API_URL, TW_AUTHENTICATION) or (TW_API_URL, TW_API_KEY, TW_API_SECRET)
    public static WebClientService getAndConnectWebClient(String... accessVariables) throws WebClientConnectionException {
        if (accessVariables!=null && accessVariables.length > 1) {
            if (webClientService == null) {
                if (accessVariables.length == 2) {
                    // Assume (TW_API_URL, TW_AUTHENTICATION) variant
                    if (accessVariables[0].compareTo("")!=0) {
                        return webClientService = new WebClientService(accessVariables[0],
                                accessVariables[1], "", "");
                    } else {
                        throw new WebClientConnectionException();
                    }
                } else if (accessVariables.length == 3) {
                    // Assume (TW_API_URL, TW_API_KEY, TW_API_SECRET) variant
                    if (accessVariables[0].compareTo("")!=0) {
                        return webClientService = new WebClientService(accessVariables[0],
                                "",accessVariables[1],accessVariables[2]);
                    } else {
                        throw new WebClientConnectionException();
                    }
                } else {
                    throw new WebClientConnectionException();
                }
            } else return webClientService;
        } else {
            if (webClientService == null) {
                if (UtilitiesService.isEnvironmentOk()) {
                    return webClientService = new WebClientService();
                } else {
                    throw new WebClientConnectionException();
                }
            } else return webClientService;
        }
    }

    /**
     * Execute a GET request
     *
     * @param uri         Uri of the request
     * @param type        Type to map the response
     * @param queryParams A map with the query parameters
     * @param <T>         Generic representation of the response
     * @return A generic object of type T
     */
    public <T> T get(String uri, Class<T> type, MultiValueMap<String, String> queryParams) {
        final String ctx = CLASSNAME + ".get";
        return wc
                .get()
                .uri(uriBuilder -> uriBuilder.path(uri).queryParams(queryParams).build())
                .retrieve()
                .onStatus(
                        HttpStatus::isError,
                        response -> response.bodyToMono(String.class).handle((error, sink) -> sink.error(new RuntimeException(ctx + ": " + error)))
                )
                .bodyToMono(type)
                .block();
    }

    /**
     * Execute a GET request
     *
     * @param uri         Uri of the request
     * @param queryParams A map with the query parameters
     * @param nextCursor  cursor header of the request
     * @return WebClientObjectResponse -> cursor header, response body
     */
    public WebClientObjectResponse getWCursor(String uri, MultiValueMap<String, String> queryParams, String nextCursor) {
        final String ctx = CLASSNAME + ".getWC";
        WebClientObjectResponse headerAndBody = new WebClientObjectResponse();

        ResponseEntity responseEntity = null;
        if (nextCursor != null && nextCursor.compareTo("") != 0) {
            responseEntity = wc.mutate().defaultHeader(TWParamsEnum.PARAM_CURSOR.get(), nextCursor).build().get()
                    .uri(uriBuilder -> uriBuilder.path(uri).queryParams(queryParams).build())
                    .retrieve()
                    .onStatus(
                            HttpStatus::isError,
                            response -> response.bodyToMono(String.class).handle((error, sink) -> sink.error(new RuntimeException(ctx + ": " + error)))
                    )
                    .toEntity(String.class)
                    .block();
        } else {
            responseEntity = wc.mutate().defaultHeaders(headers -> headers.addAll(this.headers)).build()
                    .get()
                    .uri(uriBuilder -> uriBuilder.path(uri).queryParams(queryParams).build())
                    .retrieve()
                    .onStatus(
                            HttpStatus::isError,
                            response -> response.bodyToMono(String.class).handle((error, sink) -> sink.error(new RuntimeException(ctx + ": " + error)))
                    )
                    .toEntity(String.class)
                    .block();
        }

        HttpHeaders responseHeaders = responseEntity.getHeaders();
        List<String> headerValue = responseHeaders.get(TWParamsEnum.PARAM_NEXT_CURSOR.get());

        if (headerValue != null && headerValue.size() > 0) {
            headerAndBody.setNextCursor(headerValue.get(0));
        } else {
            headerAndBody.setNextCursor("");
        }
        headerAndBody.setResponseBody(responseEntity.getBody().toString());
        return headerAndBody;
    }

    /**
     * Execute a POST request
     *
     * @param uri  Uri of the request
     * @param body Body of the request
     */
    public <T> T post(String uri, Class<T> type, Object body) {
        final String ctx = CLASSNAME + ".post";
        return wc
                .post()
                .uri(uri)
                .bodyValue(body)
                .retrieve()
                .onStatus(
                        HttpStatus::isError,
                        response -> response.bodyToMono(String.class).handle((error, sink) -> sink.error(new RuntimeException(ctx + ": " + error)))
                )
                .bodyToMono(type)
                .block();
    }

    /**
     * Execute a PATCH request
     *
     * @param uri  Uri of the request
     * @param body Body of the request
     */
    public <T> T patch(String uri, Class<T> type, Object body) {
        final String ctx = CLASSNAME + ".patch";
        return wc
                .patch()
                .uri(uri)
                .bodyValue(body)
                .retrieve()
                .onStatus(
                        HttpStatus::isError,
                        response -> response.bodyToMono(String.class).handle((error, sink) -> sink.error(new RuntimeException(ctx + ": " + error)))
                )
                .bodyToMono(type)
                .block();
    }

    /**
     * Add new default header
     *
     * @param headerName  Header name
     * @param headerValue Header value
     */
    public void addHeader(String headerName, String headerValue) {
        wc = wc.mutate().defaultHeader(headerName, headerValue).build();
    }
}
