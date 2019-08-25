package org.zhenchao.algorithm.pattern.bridge;

/**
 * @author houchang123ok@163.com
 * @Date: 2019-08-24 23:10
 * @Description:
 */
public interface MessageImplementor {

    /**
     * 发送消息
     *
     * @param message 要发送消息的内容
     * @param toUser  消息的接受者
     */
    public void send(String message, String toUser);

}
