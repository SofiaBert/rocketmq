package com.console.service;

import java.util.Map;
import java.util.Properties;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 */
public interface ClusterService {
    Map<String,Object> list();

    Properties getBrokerConfig(String brokerAddr);
}
