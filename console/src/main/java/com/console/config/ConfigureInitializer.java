package com.console.config;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 */
public class ConfigureInitializer {
    private Logger logger = LoggerFactory.getLogger(ConfigureInitializer.class);
    
    private String nameSrvAddr;

    public String getNameSrvAddr() {
        return nameSrvAddr;
    }

    public void setNameSrvAddr(String nameSrvAddr) {
        this.nameSrvAddr = nameSrvAddr;
    }

    public void init() {
        if(StringUtils.isNotBlank(nameSrvAddr)){
            System.setProperty( "rocketmq.namesrv.addr", nameSrvAddr);
            logger.info("setNameSrvAddrByProperty nameSrvAddr={}", nameSrvAddr);
        }
    }
}
