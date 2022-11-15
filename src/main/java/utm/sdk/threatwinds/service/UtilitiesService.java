package utm.sdk.threatwinds.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import utm.sdk.threatwinds.config.EnvironmentConfig;
import utm.sdk.threatwinds.enums.EnvironmentsEnum;

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
            EnvironmentConfig.TW_API_VERSION == null ||
            EnvironmentConfig.TW_API_VERSION.compareTo("") == 0 ||
            EnvironmentConfig.TW_API_KEY == null ||
            EnvironmentConfig.TW_API_KEY.compareTo("") == 0 ||
            EnvironmentConfig.TW_API_SECRET == null ||
            EnvironmentConfig.TW_API_SECRET.compareTo("") == 0
        ) {
            log.error(
                "\n *********** Check your environment configuration, some variables are not configured correctly ***********" +
                "\n * " +
                EnvironmentsEnum.TW_API_URL +
                " is required, has to be defined and can't be empty" +
                "\n * " +
                EnvironmentsEnum.TW_API_VERSION +
                " is required, has to be defined and can't be empty" +
                "\n * " +
                EnvironmentsEnum.TW_API_KEY +
                " is required, has to be defined and can't be empty" +
                "\n * " +
                EnvironmentsEnum.TW_API_SECRET +
                " is required, has to be defined and can't be empty" +
                "\n *********************************************************************************************************"
            );
            return false;
        }
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
        return true;
    }
}
