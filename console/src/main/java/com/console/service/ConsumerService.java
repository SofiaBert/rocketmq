package com.console.service;

import org.apache.rocketmq.common.protocol.body.ConsumerConnection;
import org.apache.rocketmq.common.protocol.body.ConsumerRunningInfo;
import com.console.model.ConsumerGroupRollBackStat;
import com.console.model.GroupConsumeInfo;
import com.console.model.TopicConsumerInfo;
import com.console.model.request.ConsumerConfigInfo;
import com.console.model.request.DeleteSubGroupRequest;
import com.console.model.request.ResetOffsetRequest;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 */
public interface ConsumerService {
    /**
     * Query All ConsumeGroup Message
     * @return
     */
    List<GroupConsumeInfo> queryGroupList();

    List<TopicConsumerInfo> queryConsumeStatsListByGroupName(String groupName);

    List<TopicConsumerInfo> queryConsumeStatsList(String topic, String groupName);

    Map<String,TopicConsumerInfo> queryConsumeStatsListByTopicName(String topic);


    Map<String /*consumerGroup*/ ,ConsumerGroupRollBackStat> resetOffset(ResetOffsetRequest resetOffsetRequest);


    List<ConsumerConfigInfo> examineSubscriptionGroupConfig(String group);

    boolean deleteSubGroup(DeleteSubGroupRequest deleteSubGroupRequest);

    boolean createAndUpdateSubscriptionGroupConfig(ConsumerConfigInfo consumerConfigInfo);

    Set<String> fetchBrokerNameSetBySubscriptionGroup(String group);

    ConsumerConnection getConsumerConnection(String consumerGroup);

    ConsumerRunningInfo getConsumerRunningInfo(String consumerGroup, String clientId, boolean jstack);
}
