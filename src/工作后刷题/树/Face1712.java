package 工作后刷题.树;

import 工作后刷题.TreeNode;

/**
 * @Author:zbl
 * @Date:2024/1/14 21:52
 * 二叉搜索树转链表(easy)
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，
 * 把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *
 * 返回转换后的单向链表的头节点。
 *
 * 注意：本题相对原题稍作改动
 *
 *
 *
 * 示例：
 *
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 *
 * 节点数量不会超过 100000。
 */
public class Face1712 {

    private TreeNode pre = null,head = null;
    public TreeNode convertBiNode(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.left);
            if(pre == null) {
                pre = root;
                head = root;
            } else {
                pre.right = root;
                pre = root;
            }
            root.left = null;
            inOrder(root.right);
        }
    }


}
