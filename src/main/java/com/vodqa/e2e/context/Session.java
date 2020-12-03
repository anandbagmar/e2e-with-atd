package com.vodqa.e2e.context;

import com.appium.capabilities.CapabilityManager;
import com.applitools.eyes.BatchInfo;
import com.context.SessionContext;
import com.google.gson.Gson;
import com.vodqa.e2e.entities.Platform;
import com.vodqa.e2e.exceptions.InvalidTestDataException;
import com.vodqa.e2e.tools.Driver;
import com.vodqa.e2e.tools.Visual;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Session extends SessionContext {

    public static final Platform platform;
    public static final Map<String, String> environmentConfiguration;
    public static final BatchInfo batchName;
    public static final boolean isVisualTestingEnabled;
    private static final List<String> envs = Arrays.asList("temp", "dev", "qa");

    static {
        System.out.println("Initialising Session in unified-automation-framework");
        new Session();
        platform = Platform.valueOf(System.getenv("Platform"));
        String env = getEnvironmentNameFromBinary();
        isVisualTestingEnabled = Boolean.parseBoolean(System.getenv("Visual"));
        System.out.println("IsVisualTestingEnabled: " + isVisualTestingEnabled);
        batchName = new BatchInfo("VodQA-" + platform.name() + "-" + env);
        environmentConfiguration = getEnvironmentConfiguration(env);
        System.out.println("Initialised Session in unified-automation-framework");
    }

    public static Driver fetchDriver (long threadId) {
        Driver driver = (Driver) getTestExecutionContext(threadId).getTestState("driver");
        System.out.println("is driver null? " + (null == driver));
        return driver;
    }

    public static Visual fetchEyes (long threadId) {
        return (Visual) getTestExecutionContext(threadId).getTestState("eyes");
    }

    private static String getEnvironmentNameFromBinary () {
        CapabilityManager instance = CapabilityManager.getInstance();
        JSONObject platformCapabilities = instance.getCapabilityObjectFromKey(Session.platform.name());
        JSONObject app = (JSONObject) platformCapabilities.get("app");
        String appPath = app.getString("local").toLowerCase();
        System.out.println("appPath is: " + appPath);

        String env = determineEnv(appPath);
        System.out.printf("Running test against '%s' environment%n", env);
        return env;
    }

    @NotNull
    private static String determineEnv (String appPath) {
        for (String env : envs) {
            if (appPath.contains(env)) return env;
        }
        throw new InvalidTestDataException("Unable to determine environment name from platform and binary");
    }

    private static Map<String, String> getEnvironmentConfiguration (String environment) {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("./src/test/resources/environments.json"));

            Map<String, Map> map = gson.fromJson(reader, Map.class);
            Map<String, String> envMap = map.get(environment);
            System.out.println("envMap: " + envMap);
            reader.close();
            return envMap;
        } catch (IOException e) {
            throw new InvalidTestDataException(String.format("Invalid environment: '%s' provided", environment), e);
        }
    }
}
