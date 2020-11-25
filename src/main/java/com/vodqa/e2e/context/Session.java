package com.vodqa.e2e.context;

import com.appium.capabilities.CapabilityManager;
import com.context.SessionContext;
import com.google.gson.Gson;
import com.vodqa.e2e.entities.Platform;
import com.vodqa.e2e.exceptions.InvalidTestDataException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Session extends SessionContext {

    public static final Platform platform;
    public static final Map<String, String> environmentConfiguration;

    static {
        System.out.println("Session default constructor");
        new Session();
        platform = Platform.valueOf(System.getenv("Platform"));
        String env = getEnvironmentNameFromBinary(platform);
        environmentConfiguration = getEnvironmentConfiguration(env);

        System.out.println("Initialized SessionContext");
    }

    private static String getEnvironmentNameFromBinary(Platform platform) {
        CapabilityManager instance = CapabilityManager.getInstance();
        JSONObject platformCapabilities = instance.getCapabilityObjectFromKey(platform.name());
        String env = "eat";
        JSONObject app = (JSONObject) platformCapabilities.get("app");
        String appPath = app.getString("local").toLowerCase();
        System.out.println("appPath is: " + appPath);
        if (appPath.contains("master")) {
            env = "prod";
        } else if (appPath.contains("dev")) {
            env = "dev";
        } else if (appPath.contains("qa")) {
            env = "qa";
        } else {
            throw new InvalidTestDataException(
                    "Unable to determine environment name from platform and binary");
        }

        System.out.printf("Running test against '%s' environment\n", env);
        return env;
    }

    private static Map<String, String> getEnvironmentConfiguration(String environment) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("./src/test/resources/environments.json"));

            Map<String, Map> map = gson.fromJson(reader, Map.class);
            System.out.println("map: " + map);

            Map<String, String> envMap = map.get(environment);
            System.out.println("envMap: " + envMap);
            reader.close();
            return envMap;
        } catch (IOException e) {
            throw new InvalidTestDataException(
                    String.format("Invalid environment: '%s' provided", environment), e);
        }
    }
}
