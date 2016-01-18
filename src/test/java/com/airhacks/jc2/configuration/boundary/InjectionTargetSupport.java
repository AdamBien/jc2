package com.airhacks.jc2.configuration.boundary;

import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class InjectionTargetSupport {

    @Inject
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

}
