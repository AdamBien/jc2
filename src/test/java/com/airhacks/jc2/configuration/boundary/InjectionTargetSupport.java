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

    public String getGreeting() {
        return greeting;
    }

    public String getConfigured() {
        return configured.get();
    }

}
