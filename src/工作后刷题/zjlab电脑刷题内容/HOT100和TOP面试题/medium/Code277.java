package 工作后刷题.zjlab电脑刷题内容.HOT100和TOP面试题.medium;

/**
 * @Author: ZBL
 * @Date: 2024-01-02  14:44
 * <p>
 * 搜寻名人
 * <p>
 * 假设你是一个专业的狗仔，参加了一个 n 人派对，其中每个人被从 0 到 n - 1 标号。在这个派对人群当中可能存在一位 “名人”。所谓 “名人” 的定义是：其他所有 n - 1 个人都认识他/她，而他/她并不认识其他任何人。
 * <p>
 * 现在你想要确认这个 “名人” 是谁，或者确定这里没有 “名人”。而你唯一能做的就是问诸如 “A 你好呀，请问你认不认识 B呀？” 的问题，以确定 A 是否认识 B。你需要在（渐近意义上）尽可能少的问题内来确定这位 “名人” 是谁（或者确定这里没有 “名人”）。
 * <p>
 * 在本题中，你可以使用辅助函数 bool knows(a, b) 获取到 A 是否认识 B。请你来实现一个函数 int findCelebrity(n)。
 * <p>
 * 派对最多只会有一个 “名人” 参加。若 “名人” 存在，请返回他/她的编号；若 “名人” 不存在，请返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: graph = [
 * [1,1,0],
 * [0,1,0],
 * [1,1,1]
 * ]
 * 输出: 1
 * 解析: 有编号分别为 0、1 和 2 的三个人。graph[i][j] = 1 代表编号为 i 的人认识编号为 j 的人，而 graph[i][j] = 0 则代表编号为 i 的人不认识编号为 j 的人。“名人” 是编号 1 的人，因为 0 和 2 均认识他/她，但 1 不认识任何人。
 * 示例 2:
 * <p>
 * 输入: graph = [
 * [1,0,1],
 * [1,1,0],
 * [0,1,1]
 * ]
 * 输出: -1
 * 解析: 没有 “名人”
 * <p>
 * <p>
 * 注意:
 * <p>
 * 该有向图是以邻接矩阵的形式给出的，是一个 n × n 的矩阵， a[i][j] = 1 代表 i 与 j 认识，a[i][j] = 0 则代表 i 与 j 不认识。
 * 请记住，您是无法直接访问邻接矩阵的。
 * ————————————————
 * 版权声明：本文为CSDN博主「暴躁老哥在线刷题」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_32424059/article/details/100550793
 */
public class Code277 {

    //贪心
    public int findCelebrity(int n) {
        int celebrity = 0;//先假设0号是名人
        for (int i = 1; i < n; i++) {
            //如果celebrity认识i,则celebrity一定不是名人，i可能是名人
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }
        //验证当前假设的名人是否符合所有人都认识他，并且他不认识所有其他人
        for (int i = 0; i < n; i++) {
            if (celebrity != i) {
                if (knows(celebrity, i) || !knows(i, celebrity)) {
                    return -1;
                }
            }
        }
        return celebrity;
    }

    //题目中给出的已知函数
    private boolean knows(int a, int b) {
        return true;
    }
}
