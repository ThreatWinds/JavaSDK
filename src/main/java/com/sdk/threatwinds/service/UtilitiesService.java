package com.sdk.threatwinds.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import com.sdk.threatwinds.config.EnvironmentConfig;
import com.sdk.threatwinds.enums.EnvironmentsEnum;

public class UtilitiesService {

    private static final Logger log = LoggerFactory.getLogger(UtilitiesService.class);
    private static final String CLASSNAME = "UtilitiesService";

    // Object to set default query params when calling some threat winds endpoints
    public static final MultiValueMap<String, String> emptyQueryParams = new LinkedMultiValueMap<>();

    // Method to check if the Environment variables are well-defined
    public static boolean isEnvironmentOk() {
        if (
            EnvironmentConfig.TW_API_URL == null ||
            EnvironmentConfig.TW_API_URL.compareTo("") == 0 ||
            ((EnvironmentConfig.TW_AUTHENTICATION==null ||
             EnvironmentConfig.TW_AUTHENTICATION.compareTo("") == 0) &&
            (EnvironmentConfig.TW_API_KEY == null ||
            EnvironmentConfig.TW_API_KEY.compareTo("") == 0 ||
            EnvironmentConfig.TW_API_SECRET == null ||
            EnvironmentConfig.TW_API_SECRET.compareTo("") == 0) )
        ) {
            log.error(
                "\n *********** Check your environment configuration, some variables are not configured correctly ***********" +
                "\n * " +
                EnvironmentsEnum.TW_API_URL +
                " is required, has to be defined and can't be empty" +
                "\n * " +
                EnvironmentsEnum.TW_API_VERSION +
                " is optional, but used to build the final URL to endpoints access (TW_API_URL/api/TW_API_VERSION/Methods_URI), if you don't define a valid value, defaults to v1, that can cause undesired behaviours in some cases" +
                "\n * " +
                EnvironmentsEnum.TW_AUTHENTICATION +
                " is required if you don't define " + EnvironmentsEnum.TW_API_KEY + " and "+ EnvironmentsEnum.TW_API_SECRET +
                "\n * " +
                EnvironmentsEnum.TW_API_KEY +
                " is required if you don't define " + EnvironmentsEnum.TW_AUTHENTICATION +
                "\n * " +
                EnvironmentsEnum.TW_API_SECRET +
                " is required if you don't define " + EnvironmentsEnum.TW_AUTHENTICATION +
                "\n *********************************************************************************************************"
            );
            return false;
        }
        return true;
    }
    // Method to print environment configuration variables
    public static void printEnvironment() {
        log.info(
                "\n ********************************************** ENVIRONMENT **********************************************" +
                        "\n * " +
                        EnvironmentsEnum.TW_API_URL +
                        " = " +
                        EnvironmentConfig.TW_API_URL +
                        "\n * " +
                        EnvironmentsEnum.TW_API_VERSION +
                        " = " +
                        EnvironmentConfig.TW_API_VERSION +
                        "\n * " +
                        EnvironmentsEnum.TW_AUTHENTICATION +
                        " = " +
                        EnvironmentConfig.TW_AUTHENTICATION +
                        "\n * " +
                        EnvironmentsEnum.TW_API_KEY +
                        " = " +
                        EnvironmentConfig.TW_API_KEY +
                        "\n * " +
                        EnvironmentsEnum.TW_API_SECRET +
                        " = " +
                        EnvironmentConfig.TW_API_SECRET +
                        "\n * " +
                        "\n *********************************************************************************************************"
        );
    }
}
