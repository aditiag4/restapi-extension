package com.vmware.gemfire.restapi;

import org.apache.geode.cache.Cache;
import org.apache.geode.internal.cache.CacheService;
import org.apache.geode.internal.cache.InternalCache;
import org.apache.geode.management.internal.beans.CacheServiceMBeanBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RestApiApplicationImpl implements CacheService {

//    private static final Logger logger = LogService.getLogger();

    private InternalCache cache;
    private ApplicationContext context;

    public RestApiApplicationImpl() {}


    @Override
    public boolean init(Cache cache) {
        if (cache == null) {
            throw new IllegalStateException("cache is null");
        }

        this.cache = (InternalCache) cache;

        if (this.cache.isClient() || this.cache.isServer()) {
            return false;
        }

        try{
            System.out.println(this.cache.getMembers());
            registerGmcJar();
        }catch (Exception e){

        }

//        logger.debug("Initialized service for GemFire Management Console");

        return true;
    }

    private void registerGmcJar() throws Exception {
//        logger.debug("Deploying jars");
//        ExtensionApplication.main(null);
        context = new AnnotationConfigApplicationContext(ExtensionApplication.class);
    }

    @Override
    public Class<? extends CacheService> getInterface() {
        return RestApiApplicationImpl.class;
    }

    @Override
    public CacheServiceMBeanBase getMBean() {
        return null;
    }
}
