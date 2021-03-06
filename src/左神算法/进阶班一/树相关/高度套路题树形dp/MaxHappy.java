package 左神算法.进阶班一.树相关.高度套路题树形dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zbl
 * @version 1.0
 * @content:
 * @date 2020/1/6 12:51
 */
public class MaxHappy {

    public static class Node{
        public int huo;
        public List<Node> nexts;

        public Node(int huo) {
            this.huo = huo;
            this.nexts=new ArrayList<>();
        }
    }

    //构建成树形结构后，来的活跃度与不来的活跃度
    public static class ReturnType{
        public int lai_huo;
        public int bu_lai_huo;

        public ReturnType(int lai_huo, int bu_lai_huo) {
            this.lai_huo = lai_huo;
            this.bu_lai_huo = bu_lai_huo;
        }
    }
    
    public static int getMaxHappy(Node head){
        ReturnType returnData = process(head);
        return Math.max(returnData.bu_lai_huo,returnData.lai_huo);
    }

    public static ReturnType process(Node head){

        List<Node> list=head.nexts;
        int lai_huo=head.huo;
        int bu_lai_huo=0;
        for(int i=0;i<list.size();i++){
            ReturnType process = process(list.get(i));
            lai_huo+=process.bu_lai_huo;
            bu_lai_huo+=Math.max(process.bu_lai_huo,process.lai_huo);
        }
        return new ReturnType(lai_huo,bu_lai_huo);

    }

    //改为动态规划
    public static int maxHappy(int[][] matrix){
        int[][] dp=new int[matrix.length][2];  //dp[i][0]:表示i来的欢乐度，dp[i][1]代表i不来的欢乐度
        boolean [] visited=new boolean[matrix.length]; //visited[i]表示第i个人有没有已经计算过了
        int root=0;
        for(int i=0;i<matrix.length;i++){
            if(i==matrix[i][0])
                root=i;
        }
        process(matrix,dp,visited,root);

        return Math.max(dp[root][0],dp[root][1]);
    }

    private static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
        visited[root]=true;
        dp[root][0]=matrix[root][1];
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==root && !visited[i]){
                process(matrix,dp,visited,i);
                dp[root][0]+=dp[i][1];
                dp[root][1]+=Math.max(dp[i][0],dp[i][1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
        System.out.println(maxHappy(matrix));
    }

}
