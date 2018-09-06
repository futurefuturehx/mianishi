//遇到删除较多 首先想到链表
//每次从新的链首开始 removeLast再addFirst获得新的链表开始
//遇到循环往复 首先想到模 round为步长 curr来定位

import java.util.LinkedList;

/*链接：https://www.nowcoder.com/questionTerminal/ff063da83b1a4d91913dd1b1e8b01466
来源：牛客网

约瑟夫问题是一个著名的趣题。这里我们稍稍修改一下规则。有n个人站成一列。并从头到尾给他们编号，第一个人编号为1。然后从头开始报数，第一轮依次报1，2，1，2...然后报到2的人出局。接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。以此类推直到剩下以后一个人。现在需要求的即是这个人的编号。

给定一个int n，代表游戏的人数。请返回最后一个人的编号

测试样例：
5
返回：5*/

/*链接：https://www.nowcoder.com/questionTerminal/ff063da83b1a4d91913dd1b1e8b01466
来源：牛客网
解题思路：
1. 由于涉及到频繁的删除操作，故数据结构应该选择链表，这里选择LinkedList，其底层实现是循环双链表。
2. 每一轮报数完毕之后，将链表尾部节点移动到链表首部，开始新一轮的报数。
3. 链表中仅剩一个节点，程序结束。
4. 举个例子：假设n = 24，第一个人编号为1。
（1）第一轮：依次报1，2，1，2...然后报到2的人出局，则第一轮过后未出局的编号为1、3、5、7、9、11、13、15、17、19、21、23；
（2）第二轮：从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...报到2，3的人出局。我这里做的处理是，先将上一轮最后一个报数的编号移动到最前面，即23、1、3、5、7、9、11、13、15、17、19、21；然后开始第二轮报数，未出局的编号为23、5、11、17；
（3）第三轮：从上一轮最后一个报数的人开始依次报1，2，3，4，1，2，3，4...报到2，3，4的人出局。同样，我这里做的处理是，先将上一轮最后一个报数的编号移动到最前面，即17、23、5、11；然后开始第三轮报数，未出局的编号为17，此时链表中仅剩一个节点，故程序结束。*/
public class yuesefuwenti2 {
    public static int getResult(int n) {
        if (n < 1)
            return -1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        int round = 2, i, curr = 0;
        for (i = 1; i <= n; i++) {
            list.add(i);
        }
        while (list.size() > 1) {
            i = 0;
            while (list.size() > 1 && i < list.size()) {
                curr = (curr + 1) % round;
                if (curr != 1) {
                    list.remove(i);
                } else {
                    i++;
                }
            }
            round++;// 下一轮的最大报数
            curr = 0;// 表示还未开始报数
            if (list.size() > 1) {// 将最后报数的元素移动到链表首部，即确保每次报数从链表首部开始。
                int last = list.removeLast();
                list.addFirst(last);
            }
        }
        return list.pop();// 返回最后一个元素
    }

    public static void main(String[] args) {
        int result = getResult(3);
        System.out.println(result);
    }
}
