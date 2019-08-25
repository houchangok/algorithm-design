package org.zhenchao.algorithm.pattern.bridge;

/**
 * @author houchang123ok@163.com
 * @Date: 2019-08-24 23:13
 * @Description:
 */
public class CommonMessage extends AbstractMessage {


    public CommonMessage(MessageImplementor impl) {
        super(impl);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}
