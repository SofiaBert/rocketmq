package com.console.service.impl;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.ProducerConnection;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.tools.admin.MQAdminExt;
import com.console.service.ProducerService;
import com.google.common.base.Throwables;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by frintasse
 * 2018/02/05
 * jarvisbert@foxmail.com
 */
@Service
public class ProducerServiceImpl implements ProducerService {
    @Resource
    private MQAdminExt mqAdminExt;

    @Override
    public ProducerConnection getProducerConnection(String producerGroup, String topic) {
        try {
            return mqAdminExt.examineProducerConnectionInfo(producerGroup, topic);
        } catch (RemotingException | MQClientException | MQBrokerException | InterruptedException e) {
            throw Throwables.propagate(e);
        }
    }
}
