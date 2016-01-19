package com.airhacks.jc2.configuration.boundary;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Specializes;

/**
 *
 * @author airhacks.com
 */
@Specializes
public class TestPreloader extends Preloader {

    public final static String EXPECTED = "hey duke";

    @Override
    public Map<String, String> getInitialConfiguration() {
        Map<String, String> initial = new HashMap<>();
        String className = InjectionTargetSupport.class.getName();
        String fieldName = "configured";
        initial.put(className + "." + fieldName, EXPECTED);
        return initial;
    }

}
