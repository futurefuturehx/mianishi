//以未知的但是更简单的为基础来进行运算就可以使用递归
//数学关联与坐标换算简化题目

/*链接：https://www.nowcoder.com/questionTerminal/11b018d042444d4d9ca4914c7b84a968
来源：牛客网

约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。

给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。

测试样例：
5 3
返回：4*/

/*我们注意到原问题仅仅是要求出最后的胜利者的序号，而不是要读者模拟整个过程。
因此如果要追求效率，就要打破常规，实施一点数学策略。

把n个人的编号改为0~n-1，然后对删除的过程进行分析

令f[i]表示i个人玩游戏报m退出最后胜利者的编号，最后的结果自然是f[n]
递推公式
f[1]=0;
f[i]=(f[i-1]+m)%i;  (i>1)*/

import java.util.*;
import java.util.Scanner;
public class lianbiao_yuesefuwenti {
    static int m;static int n;
    static int getResult(int m, int n){
        if(m<=0||n<=0){
            return -1;
        }
        int last=0;
        for(int i=2;i<n;i++){
            last=(last+m)/i;
        }
        return (last+1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        if(sc.hasNext()){
           m=sc.nextInt();
           n=sc.nextInt();}
           int result=getResult(m,n);
        System.out.println(result+1);
    }
}