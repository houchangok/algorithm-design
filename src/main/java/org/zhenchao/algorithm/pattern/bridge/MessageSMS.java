package org.zhenchao.algorithm.pattern.bridge;

/**
 * @author houchang123ok@163.com
 * @Date: 2019-08-24 23:17
 * @Description:
 */
public class MessageSMS implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用系统内短消息的方法，发送消息'" + message + "'给" + toUser);

    }
}
