package org.zhenchao.algorithm.Learning;

/**
 * @author houchang123ok@163.com
 * @Date: 2019-08-24 10:17
 * @Description:
 */


/**
 * （1）LinkedHashMap继承自HashMap，具有HashMap的所有特性；
 *
 * （2）LinkedHashMap内部维护了一个双向链表存储所有的元素；
 *
 * （3）如果accessOrder为false，则可以按插入元素的顺序遍历元素；
 *
 * （4）如果accessOrder为true，则可以按访问元素的顺序遍历元素；
 *
 * （5）LinkedHashMap的实现非常精妙，很多方法都是在HashMap中留的钩子（Hook），直接实现这些Hook就可以实现对应的功能了，并不需要再重写put()等方法；
 *
 * （6）默认的LinkedHashMap并不会移除旧元素，如果需要移除旧元素，则需要重写removeEldestEntry()方法设定移除策略；
 *
 * （7）LinkedHashMap可以用来实现LRU缓存淘汰策略；
 *
 *  (8) accessOrder：控制访问元素的顺序，true会按照访问顺序访问，false会按照插入顺序访问
 */

/**
 * linkedHashMap可以实现LRU缓存算法
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LRU<Integer, Integer> lru = new LRU<>(5, 0.75f);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.put(4, 4);
        lru.put(5, 5);
        lru.put(6, 6);

        System.out.println(lru.get(4));

        System.out.println(lru.get(6));

        System.out.println(lru.get(2));

        System.out.println(lru.keySet());

    }


}
