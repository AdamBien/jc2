package com.airhacks.jc2.configuration.boundary;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Produces;

/**
 *
 * @author airhacks.com
 */
public class TestPreloader {

    public final static String EXPECTED = "hey duke";

    @Produces
    public Map<String, String> getInitialConfiguration() {
        Map<String, String> initial = new HashMap<>();
        String className = InjectionTargetSupport.class.getName();
        String fieldName = "configured";
        initial.put(className + "." + fieldName, EXPECTED);
        return initial;
    }

}
