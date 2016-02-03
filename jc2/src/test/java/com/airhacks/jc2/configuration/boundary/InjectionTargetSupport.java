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

    @Inject
    private String notExistingString;

    @Inject
    private boolean notExistingBoolean;

    @Inject
    private long notExistingLong;

    @Inject
    private int notExistingInt;

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

    public boolean isNotExistingBoolean() {
        return notExistingBoolean;
    }

    public long getNotExistingLong() {
        return notExistingLong;
    }

    public int getNotExistingInt() {
        return notExistingInt;
    }

    public String getNotExistingString() {
        return notExistingString;
    }
}
