package com.airhacks.jc2.configuration.boundary;

import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class InjectionTargetSupport {

    @Inject
    @Configurable("JAVA_HOME")
    private String javaHome;

    public String getJavaHome() {
        return javaHome;
    }

}
