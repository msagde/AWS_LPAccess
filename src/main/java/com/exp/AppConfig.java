package com.exp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigUtil;
import com.typesafe.config.ConfigValue;
import com.typesafe.config.ConfigValueFactory;

public class AppConfig {

    private AppConfig() {}

    /*
     * Since this code will be part of some application and app should have a config file, following
     * call will load config file from its default path.
     */
    public static Config INSTANCE = ConfigFactory.load();

    private static final Logger Logger = LoggerFactory.getLogger(AppConfig.class);

    /*
     * Need to call this method in case there is a special need to override the config in file with
     * env vars. Though a config item can be overridden in file iteslf using ${?EVN_VAR} as value in
     * the file, this method eliminates the need to mark config item to be overridden by env variable
     * in file
     */
    public static void mergeEnvVars() {

        Map<String, String> envVars = System.getenv();

        for (String envName : envVars.keySet()) {
            // Env var is considered to match with config var if it is converted to lower case
            // and _ are replaced by .
            // If they match, config item is overridden by env var.
            // EX: Config Item app.test.val is considered to match APP_TEST_VAL

            // Assuming we stick to convention of defining env vars, following split should work
            String[] str = envName.toLowerCase().split("_");

            if (str.length == 0) {
                // Not sure why this should happen, but lets avoid crash in case the split yields empty
                // array
                Logger.warn("msg='Wrong formatted env var, dropping. EnvVar {}:{}'", envName,
                        envVars.get(envName));
                break;
            }
            // Convert String arry to 'dot notation' config path.
            String key = ConfigUtil.joinPath(str);


            if (INSTANCE.hasPath(key)) {
                // This will override env vars already in the Config, but will add if they are not mentioned
                // in the file
                // Read more on how typesafe config works at
                // http://typesafehub.github.io/config/latest/api/overview-summary.html
                INSTANCE = INSTANCE.withValue(key, ConfigValueFactory.fromAnyRef(envVars.get(envName)));
            }
        }

    }

    static {
        if (INSTANCE.hasPath("app.dump.conf")) {
            for (Map.Entry<String, ConfigValue> entry : INSTANCE.entrySet()) {
                Logger.info("msg='" + entry.getKey() + " = " + entry.getValue() + "'");
            }
        }
        // dump log level
        // Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        // Logger.info("msg='App log-level: {}'", log.);
    }

    // Given a string which is in a specific format used in marathon ENV section
    // like this APP_MY_CONFIG_X (all upper with _ in btw)
    // this method converts it to format thats used in applicaiton.conf file (all lower with . in btw)
    protected static String convertKeyFormat(String key) {
        String[] str = key.toLowerCase().split("_");

        if (str.length == 0) {
            // Not sure why this should happen, but lets avoid crash in case the split yields
            // empty array
            Logger.warn("msg='Wrong formatted env var, dropping. EnvVar {}'", key);
            return "";
        }
        // Convert String arry to 'dot notation' config path.
        Logger.debug("Converted key {}:{}", key, ConfigUtil.joinPath(str));
        return ConfigUtil.joinPath(str);
    }

    /***
     * This is for flink services where arguments cannot be passed using environment variable. This
     * will take existing path of arguments that is mapped to env variable and update that value e.g.
     * app.flink.exec.env.job_name = ${JOB_NAME}
     *
     * @param params Arguments map coming from command line
     * @param existingParams map of config path to env variable.
     */
    public static void mergeArgsToConf(Map<String, String> params) {

        if (null == params || params.size() == 0) {
            Logger.warn("No arguments to merge !");
            return;
        }

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String k = convertKeyFormat(entry.getKey());

            if (INSTANCE.hasPath(k)) {
                INSTANCE =
                        INSTANCE.withValue(k,
                                ConfigValueFactory.fromAnyRef(entry.getValue()));
            }
        }
    }

}