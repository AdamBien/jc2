package com.airhacks.jc2.configuration.boundary;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class InjectionTargetSupport {

    @Inject
    private String greeting;

    @Inject
    Instance<String> configured;

    @Inject
    @Configurable("msg")
    private String message;

    @Inject
    private int intValue;

    @Inject
    private long longValue;

    @Inject
    private boolean booleanValue;

    public String getGreeting() {
        return greeting;
    }

    public String getConfigured() {
        return configured.get();
    }

    public String getWithCustomKey() {
        return message;
    }

    public String getMessage() {
        return message;
    }

    public int getIntValue() {
        return intValue;
    }

    public long getLongValue() {
        return longValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

}
