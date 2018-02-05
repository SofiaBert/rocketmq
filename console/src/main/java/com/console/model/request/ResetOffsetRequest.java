package com.console.model.request;

import java.util.List;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 */
public class ResetOffsetRequest {
    private List<String> consumerGroupList;
    private String topic;
    private long resetTime;
    private boolean force;

    public List<String> getConsumerGroupList() {
        return consumerGroupList;
    }

    public void setConsumerGroupList(List<String> consumerGroupList) {
        this.consumerGroupList = consumerGroupList;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }


    public long getResetTime() {
        return resetTime;
    }

    public void setResetTime(long resetTime) {
        this.resetTime = resetTime;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }
}
