//首先模拟对象  找到基本存储结构与对应关系 这边cols[i]的i表示第几行 它的值表示第几列
//然后反复推演找临界点与定量等量关系来简化 判断条件if化 要有基准顺序

//中层思维 直接调用判断方法就行了 判断方法由底下的人实现 你只要考虑传入什么参数

//动态规划:动态规划适用于子问题不是独立的情况，也就是各子问题包含公共的子子问题
//分治法是将问题划分成一些独立的子问题，递归地求解各子问题
//动态规划算法对每个子问题只求解一次，将其结果保存起来，从而避免每次遇到各个子问题时重新计算答案。

//数组是引用类型 所以这里代替int 尽管只用到一个 但是他是双向改变的
/*
请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个nxn的棋盘上放置n个棋子，使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。

给定一个int n，请返回方法数，保证n小于等于15

测试样例：
1
返回：1
 */
public class diguihedongtaiguihua_nhuanghouwenti {
    public static int nQueens(int n) {
        int[] cols = new int[n];
        int[] num = { 0 };//计数器
        for (int i = 0; i < n; i++) {
            cols[0] = i;//第零行第i列
            getCount(cols, 1, num);
        }
        return num[0];
    }
    //除了第一行外，每行赋值皇后的位置，并判断位置是否合理，若能成功赋值最后一行
    // 位置,方法数+1；
    public static void getCount(int[] cols, int row, int[] num) {
        if (row == (cols.length)) {
            num[0]++;
            return;
        }//如果行列的个数相同 代表这条路已经通了
        for (int i = 0; i < cols.length; i++) {
            if (checkValid(cols, row, i)) {
                cols[row] = i;
                getCount(cols, row + 1, num);
            }//验证可行 确定这一行 继续下一行
        }
    }
    // 判断插入的皇后位置是否合理
    private static boolean checkValid(int[] cols, int row, int col) {
        for (int i = 0; i < row; i++) {
            int temp = cols[i];
            if (temp == col)
                return false;//同一列不行 同一行本来就不可能 因为就是以行为标的
            if (Math.abs(row - i) == Math.abs(temp - col))
                return false;//同一斜向也不行
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nQueens(10));
    }
}
