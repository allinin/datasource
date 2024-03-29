package 左神算法.基础班.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的序列化与反序列化
 */
public class SerializeAndReconstructTree {

     public static class Node {
         public int value;
         public Node right;
         public Node left;

         public Node(int value) {
             this.value = value;
         }
     }
     //==============================================后序遍历的方式序列化与反序列化====================
     public static String serialByPost(Node head){
         StringBuilder sb = new StringBuilder();
         if(head == null){
             sb.append("#_");
         }else{
             sb.append(serialByPost(head.left));
             sb.append(serialByPost(head.right));
             sb.append(head.value + "_");
         }
         return sb.toString();
     }
    public Node deserialize(String data) {
        String[] strs = data.split("_");
        LinkedList<String> queue = new LinkedList<>();
        for(String str : strs){
            queue.add(str);
        }
        return postDeserial(queue);
    }

    private Node postDeserial(LinkedList<String> queue){
        if(queue.isEmpty()){
            return null;
        }
        //弹出最后一个节点
        String str = queue.pollLast();
        if(str.equals("#")){
            return null;
        }
        Node root = new Node(Integer.valueOf(str));
        //先右子节点，再左子节点
        root.right = postDeserial(queue);
        root.left = postDeserial(queue);
        return root;
    }
    //==============================================后序遍历的方式序列化与反序列化====================
     //以!来表示某个节点值的结尾，以#表示某个节点的孩子不存在
     public static String serialByPre(Node head)
     {
         if(head==null)
             return "#!";
         String res=head.value+"!";
         res+=serialByPre(head.left);
         res+=serialByPre(head.right);
         return res;
     }

     public static Node reconPreOrder(Queue<String> queue)
     {
         //前序遍历弹出最前端的节点值
         String value=queue.poll();
         if(value.equals("#"))
             return null;
         Node head=new Node(Integer.valueOf(value));
         //先左孩子再右孩子
         head.left=reconPreOrder(queue);
         head.right=reconPreOrder(queue);
         return head;
     }

     public static Node reconByPreString(String str)
     {
         String[] values = str.split("!");
         Queue<String> queue = new LinkedList<String>();
         for (int i = 0; i != values.length; i++) {
             queue.offer(values[i]);
         }
         return reconPreOrder(queue);
     }
     //按层遍历的方式来序列化
     public static String serialByLevel(Node head)
     {
          if(head==null)
              return "#!";
          String res=head.value+"!";
          Queue<Node>queue=new LinkedList<>();
          queue.offer(head);
          while(!queue.isEmpty()){
              head=queue.poll();
              if(head.left!=null)
              {
                  res+=head.left.value+"!";
                  queue.offer(head.left);
              }else{
                  res+="#!";
              }
              if(head.right!=null)
              {
                  res+=head.right.value+"!";
                  queue.offer(head.right);
              }else {
                  res+="#!";
              }
          }
          return res;
     }

     public static Node reconByLevelString(String str){
         String[] values=str.split("!");
         int index=0;
         Node head=generateNodeByString(values[index++]);
         Queue<Node>queue =new LinkedList<>();
         if(head!=null)
         {
             queue.offer(head);
         }
         Node node=null;
         while(!queue.isEmpty())
         {
             node=queue.poll();
             node.left=generateNodeByString(values[index++]);
             node.right=generateNodeByString(values[index++]);
             if(node.left!=null)
             {
                 queue.offer(node.left);
             }
             if(node.right!=null)
             {
                 queue.offer(node.right);
             }
         }
         return head;

     }

     public static Node generateNodeByString(String str)
     {
         if(str.equals("#"))
             return null;
         return new Node(Integer.parseInt(str));
     }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = null;
        printTree(head);

        String pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serialByPre(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = reconByPreString(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serialByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = reconByLevelString(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

    }

}
