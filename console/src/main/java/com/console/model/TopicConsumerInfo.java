package com.console.model;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 * One Topic
 */
public class TopicConsumerInfo {
    private String topic;
    private long diffTotal;
    private long lastTimestamp;
    private List<QueueStatInfo> queueStatInfoList = Lists.newArrayList();

    public TopicConsumerInfo(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public long getDiffTotal() {
        return diffTotal;
    }

    public void setDiffTotal(long diffTotal) {
        this.diffTotal = diffTotal;
    }

    public List<QueueStatInfo> getQueueStatInfoList() {
        return queueStatInfoList;
    }

    public long getLastTimestamp() {
        return lastTimestamp;
    }

    public void appendQueueStatInfo(QueueStatInfo queueStatInfo) {
        queueStatInfoList.add(queueStatInfo);
        diffTotal += (queueStatInfo.getBrokerOffset() - queueStatInfo.getConsumerOffset());
        lastTimestamp = Math.max(lastTimestamp, queueStatInfo.getLastTimestamp());
    }
}
