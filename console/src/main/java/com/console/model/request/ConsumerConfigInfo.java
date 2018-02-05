package com.console.model.request;

import org.apache.rocketmq.common.subscription.SubscriptionGroupConfig;

import java.util.List;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 */
public class ConsumerConfigInfo {
    //Consumer Group when Creating used
    private int selectedOrganization;

    private List<String> brokerNameList;
    private SubscriptionGroupConfig subscriptionGroupConfig;

    public ConsumerConfigInfo() {
    }

    public ConsumerConfigInfo(List<String> brokerNameList, SubscriptionGroupConfig subscriptionGroupConfig) {
        this.brokerNameList = brokerNameList;
        this.subscriptionGroupConfig = subscriptionGroupConfig;
    }

    public List<String> getBrokerNameList() {
        return brokerNameList;
    }

    public void setBrokerNameList(List<String> brokerNameList) {
        this.brokerNameList = brokerNameList;
    }

    public SubscriptionGroupConfig getSubscriptionGroupConfig() {
        return subscriptionGroupConfig;
    }

    public void setSubscriptionGroupConfig(SubscriptionGroupConfig subscriptionGroupConfig) {
        this.subscriptionGroupConfig = subscriptionGroupConfig;
    }

    public int getSelectedOrganization() {
        return selectedOrganization;
    }

    public void setSelectedOrganization(int selectedOrganization) {
        this.selectedOrganization = selectedOrganization;
    }
}
