### Candy

> No.135, hard

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

- Each child must have at least one candy.
- Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

#### 分析

#### 实现

```java
/**
 * 思想上与 Trapping Rain Water 相同
 *
 * @param ratings
 * @return
 */
public int candy(int[] ratings) {
    if (null == ratings || ratings.length == 0) return 0;

    int[] left = new int[ratings.length];
    left[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
        left[i] = ratings[i] > ratings[i - 1] ? left[i - 1] + 1 : 1;
    }

    int[] right = new int[ratings.length];
    right[ratings.length - 1] = 1;
    for (int i = ratings.length - 2; i >= 0; i--) {
        right[i] = ratings[i] > ratings[i + 1] ? right[i + 1] + 1 : 1;
    }

    int total = 0;
    for (int i = 0; i < ratings.length; i++) {
        total += Math.max(left[i], right[i]);
    }
    return total;
}
```
