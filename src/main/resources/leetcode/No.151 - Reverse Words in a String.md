### Reverse Words in a String

> No.151, medium

Given an input string, reverse the string word by word.

For example,  
Given s = `"the sky is blue"`, return `"blue is sky the"`.

#### 分析


#### 实现

```java
public String reverseWords(String s) {
    if (null == s || s.length() == 0) return s;
    char[] cs = s.toCharArray();
    // 先整体逆置
    this.reverse(cs, 0, s.length() - 1);
    int start = 0, end = 0;
    // 遍历，以空字符分隔进行局部逆置
    for (int i = 0; i < cs.length; i++) {
        if (' ' != cs[i]) {
            end++;
        } else {
            if (end > start) {
                this.reverse(cs, start, end - 1);
                start = end;
            }
            start++;
            end++;
        }
    }
    this.reverse(cs, start, end - 1);
    return String.valueOf(cs).trim().replaceAll("\\s+", " ");
}

// 对字符数组进行逆置操作
private void reverse(char[] cs, int start, int end) {
    while (start < end) {
        char t = cs[start];
        cs[start] = cs[end];
        cs[end] = t;
        start++;
        end--;
    }
}
```