package com.xg.mall.order.jms;

import com.rabbitmq.client.*;
import com.xg.rabbitmq.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class ReceiveTask implements ApplicationRunner {

    @Autowired
    private OrderServiceImpl orderService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        receive("create_order");
    }

    public void receive(String quequName) throws IOException, TimeoutException {

        // 创建链接
        Connection connection = Factory.getConnectionFactory();
        final Channel channel = connection.createChannel();

        channel.queueDeclare(quequName, true, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicQos(1);

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                boolean ack = true;
                try {
                    orderService.createOrder(message);
                } catch (Exception ex) {
                    ack = false;
                    ex.printStackTrace();

                } finally {
                    channel.basicAck(envelope.getDeliveryTag(), ack);
                }
            }
        };

        boolean autoAck = false;
        channel.basicConsume(quequName, autoAck, consumer);
    }


}
