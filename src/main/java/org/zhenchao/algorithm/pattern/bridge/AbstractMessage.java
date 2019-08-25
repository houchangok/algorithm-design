package org.zhenchao.algorithm.pattern.bridge;

/**
 * @author houchang123ok@163.com
 * @Date: 2019-08-24 22:47
 * @Description:
 */

/**
 * 继承关系是强关联，而聚合关系是弱关联
 * 将两个角色之间的继承关系改为聚合关系，就是将它们之间的强关联改换成为弱关联。
 * 因此，桥梁模式中的所谓脱耦，就是指在一个软件系统的抽象化和实现化之间使用聚合关系而不是继承关系，从而使两者可以相对独立地变化。这就是桥梁模式的用意。
 */
public abstract class AbstractMessage {

    //持有一个实现部分的对象
    MessageImplementor impl;

    /**
     * 构造方法，传入实现部分的对象
     *
     * @param impl 实现部分的对象
     */
    public AbstractMessage(MessageImplementor impl) {
        this.impl = impl;
    }

    /**
     * 发送消息，委派给实现部分的方法
     *
     * @param message 要发送消息的内容
     * @param toUser  消息的接受者
     */
    public void sendMessage(String message, String toUser) {
        this.impl.send(message, toUser);
    }


}
