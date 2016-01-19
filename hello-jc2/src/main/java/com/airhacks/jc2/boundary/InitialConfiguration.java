package com.airhacks.jc2.boundary;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Produces;

/**
 *
 * @author airhacks.com
 */
public class InitialConfiguration {

    @Produces
    public Map<String, String> get() {
        Map<String, String> cache = new HashMap<>();
        cache.put("com.airhacks.jc2.boundary.HelloResource.greeting", "hey duke");
        return cache;
    }

}
