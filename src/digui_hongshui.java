//	Throws  exception	Returns special value
//  Insert	add(e)	    offer(e)
//  Remove	remove()	poll()
//  Examine	element()	peek()
//创建基本类型结构 使用与结构体类似的类
//得到判断删除 判断成功则结束弹出 否则为空为止
//遍历队列 while空为止 总是以右下左上的顺序 总会遍历完
//压入结构体 判断结构体 准备更多结构体 一个一个判断推进
//初始化不赋值的话 所有二维数组元素的初始值是0
//另一层含义是如果不是0，说明走过了或者有障碍（是1）
//亦步亦标
import java.util.LinkedList;
import java.util.Queue;

/*链接：https://www.nowcoder.com/questionTerminal/365493766c514d0da0cd774d3d40fd49
来源：牛客网

在一个nxm矩阵形状的城市里爆发了洪水，洪水从(0,0)的格子流到这个城市，在这个矩阵中有的格子有一些建筑，洪水只能在没有建筑的格子流动。请返回洪水流到(n - 1,m - 1)的最早时间(洪水只能从一个格子流到其相邻的格子且洪水单位时间能从一个格子流到相邻格子)。

给定一个矩阵map表示城市，其中map[i][j]表示坐标为(i,j)的格子，值为1代表该格子有建筑，0代表没有建筑。同时给定矩阵的大小n和m(n和m均小于等于100)，请返回流到(n - 1,m - 1)的最早时间。保证洪水一定能流到终点。*/
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class digui_hongshui {
    public int floodFill(int[][] map, int n, int m) {
        // write code here
        if(m==0||map[0].length==0){
            return 0;
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        Point p;
        int x,y;
        while(!queue.isEmpty()){//QUEUE中存储的是一个点的邻接点
            p = queue.poll();
            x = p.x;
            y = p.y;

            if (x == n - 1 && y == m - 1){//如果得到结果，直接返回
                return map[x][y];
            }
            if (x + 1 < n&&map[x+1][y]==0){//右边的节点可以走，
                queue.add(new Point(x+1,y));//将右边节点加入队列
                map[x + 1][y] = map[x][y] + 1;//初始化右边节点。注意，我们这里判断的条件是map[x+1][y]==0，也就是说路是通的。另一层含义是如果不是0，说明走过了或者有障碍（是1）
            }


            if (y + 1 < m&&map[x][y+1]==0){//下面的节点，这里顺序不能变，因为最早时间，肯定是从右边或者下面走，只有走不通的时候才走左边和上面
                queue.add(new Point(x,y+1));
                map[x][y + 1] = map[x][y] + 1;
            }

            if (x - 1 >= 0&&map[x-1][y]==0){//同理左边节点
                queue.add(new Point(x - 1, y));
                map[x - 1][y] = map[x][y] + 1;
            }

            if (y - 1 >= 0&&map[x][y-1]==0){//上面的节点
                queue.add(new Point(x, y - 1));
                map[x][y - 1] = map[x][y] + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
    }
}
