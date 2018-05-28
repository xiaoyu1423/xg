package com.xg.mall.order.jms;

public enum SendTaskEnum {

    // CREATE_ORDER("任务类型", "交换机名称", "队列匹配条件")
    CREATE_ORDER("topic", "create_order", "create_order"),
    PAY_ORDER("topic", "pay_order", "pay_order");

    private String taskType;

    private String exchangeName;

    private String routingKey;

    SendTaskEnum(String taskType, String exchangeName, String routingKey) {
        this.taskType = taskType;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
    }

    public static SendTaskBean getExchangeConfig(String taskType) {
        for (SendTaskEnum sendTaskEnum : SendTaskEnum.values()) {
            if (sendTaskEnum.getTaskType() == taskType) {
                SendTaskBean sendTaskBean = new SendTaskBean();
                sendTaskBean.setExchangeName(sendTaskEnum.getExchangeName());
                sendTaskBean.setRoutingKey(sendTaskEnum.getRoutingKey());
                return sendTaskBean;
            }
        }
        return null;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
