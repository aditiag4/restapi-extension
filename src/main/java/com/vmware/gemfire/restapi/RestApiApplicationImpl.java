package com.vmware.gemfire.restapi;

import org.apache.geode.cache.Cache;
import org.apache.geode.distributed.internal.ClusterDistributionManager;
import org.apache.geode.internal.cache.CacheService;
import org.apache.geode.internal.cache.InternalCache;
import org.apache.geode.management.internal.beans.CacheServiceMBeanBase;
import org.springframework.boot.SpringApplication;
import java.util.logging.Logger;
import java.util.logging.Level;

public class RestApiApplicationImpl implements CacheService {

//    private static final Logger logger = LogService.getLogger();

    private static final Logger logger = Logger.getLogger(RestApiApplicationImpl.class.getName());


    private InternalCache cache;
//    private ApplicationContext context;

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
//            int vmKind = ((InternalCache) cache).getInternalDistributedSystem()
//                    .getDistributedMember().getVmKind();
//
//            if(vmKind == ClusterDistributionManager.LOCATOR_DM_TYPE) {
//                logger.log(Level.INFO, "Initialized service for GemFire Management Console");
//                SpringApplication.run(ExtensionApplication.class);
//                return true;
//            }
            logger.log(Level.INFO, "Initialized service for GemFire Management Console");
            SpringApplication.run(ExtensionApplication.class);
            return true;

        }catch (Exception e){
            logger.log(Level.SEVERE, e.getMessage());
        }

        return false;


//        logger.debug("Initialized service for GemFire Management Console");
    }

    private void registerGmcJar() throws Exception {
//        logger.debug("Deploying jars");
//        ExtensionApplication.main(null);
//        context = new AnnotationConfigApplicationContext(ExtensionApplication.class);
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
