package org.zhenchao.algorithm.pattern.bridge;

/**
 * @author houchang123ok@163.com
 * @Date: 2019-08-24 23:18
 * @Description:
 */
public class MessageEmail implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用邮件短消息的方法，发送消息'" + message + "'给" + toUser);

    }
}
