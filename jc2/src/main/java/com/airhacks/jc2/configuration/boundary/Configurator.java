package com.airhacks.jc2.configuration.boundary;

import java.util.Map;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@ApplicationScoped
public class Configurator {

    Cache<String, String> store;
    CachingProvider cachingProvider;
    CacheManager cacheManager;

    public final static String CONFIGURATION = "configuration";

    /**
     * Initial set of key-values can be exposed with @Produces and merged at
     * startup with the cache. The existing entries in the cache are going to be
     * overridden.
     */
    @Inject
    Instance<Map<String, String>> initialValues;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object doesntMatter) {
        this.cachingProvider = Caching.getCachingProvider();
        this.cacheManager = cachingProvider.getCacheManager();
        Configuration<String, String> configuration = getConfiguration();
        this.store = this.cacheManager.getCache(CONFIGURATION, String.class, String.class);
        if (this.store == null) {
            this.store = this.cacheManager.createCache(CONFIGURATION, configuration);
        }
        for (Map<String, String> initial : initialValues) {
            this.store.putAll(initial);
        }
    }

    /**
     *
     * @param ip represents the field where the configuration is injected
     * @return resolved value. The name of the class is concatenated with the
     * field name and used as a key.
     */
    @Produces
    public String getString(InjectionPoint ip) {
        String className = ip.getMember().getDeclaringClass().getName();
        String key = className + "." + ip.getMember().getName();
        String fieldName = computeKeyName(ip.getAnnotated(), key);
        return this.store.get(fieldName);
    }

    String computeKeyName(Annotated annotated, String key) {
        Configurable annotation = annotated.getAnnotation(Configurable.class);
        return annotation == null ? key : annotation.value();

    }

    public Configuration<String, String> getConfiguration() {
        MutableConfiguration<String, String> configuration = new MutableConfiguration<>();
        configuration.setStoreByValue(false).
                setTypes(String.class, String.class).
                setManagementEnabled(true).
                setStatisticsEnabled(true);
        return configuration;
    }

    public void shutdown(@Observes @Destroyed(ApplicationScoped.class) Object doesntMatter) {
        this.cacheManager.destroyCache(CONFIGURATION);
        this.cachingProvider.close();
    }

}
