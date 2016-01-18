package com.airhacks.jc2.configuration.boundary;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author airhacks.com
 */
@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class Configurator {

    Cache<String, String> store;
    CachingProvider cachingProvider;
    CacheManager cacheManager;

    public final static String CONFIGURATION = "configuration";

    @PostConstruct
    public void initCache() {
        this.cachingProvider = Caching.getCachingProvider();
        this.cacheManager = cachingProvider.getCacheManager();
        Configuration<String, String> configuration = getConfiguration();
        this.store = this.cacheManager.createCache(CONFIGURATION, configuration);
    }

    @Produces
    public String expose(InjectionPoint ip) {
        String className = ip.getMember().getDeclaringClass().getName();
        String fieldName = ip.getMember().getName();
        String key = className + "." + fieldName;
        return store.get(key);
    }

    public Configuration<String, String> getConfiguration() {
        MutableConfiguration<String, String> configuration = new MutableConfiguration<>();
        configuration.setStoreByValue(false).
                setTypes(String.class, String.class).
                setManagementEnabled(true).
                setStatisticsEnabled(true);
        return configuration;
    }

    @PreDestroy
    public void shutdown() {
        this.cachingProvider.close();
    }

}
