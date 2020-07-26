package algo;

import java.util.*;

public class BinaryTree102 {

    public static void main(String[] args) {
        BinaryTree102 binaryTree102 = new BinaryTree102();
        TreeNode root = new TreeNode(4);

        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);

        root.left = left;
        root.right = right;

        List<List<Integer>> rList = binaryTree102.levelOrder(root);
        System.out.println(rList);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<QueueNode> queue = new LinkedList();
        List<List<Integer>> rList = new ArrayList<>();

        //根结点放入结果集
        queue.add(new QueueNode(root, 0));
        rList.add(0, Arrays.asList(root.val));

        //4,3,2
        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();
            if (queueNode == null || queueNode.node == null) {
                //打印错误
                continue;
            }

            //放入同层结点数据
            int levelOfNode = queueNode.level + 1;

            List<Integer> tList = null;
            if (levelOfNode <= rList.size() - 1) {
                tList = rList.get(levelOfNode);
            }
            if (tList == null) {
                tList = new ArrayList<>();
            }

            TreeNode treeNode = queueNode.node;
            if (treeNode.left != null) {
                tList.add(treeNode.left.val);
            }
            if (treeNode.right != null) {
                tList.add(treeNode.right.val);
            }

            if(!tList.isEmpty()){
                if(levelOfNode <= rList.size() - 1){
                    //之前已经有了
                    rList.set(levelOfNode, tList);
                }else{
                    //新元素
                    rList.add(levelOfNode, tList);
                }
            }

            //将同层结点放入queue，遍历下层结点
            if (treeNode.left != null) {
                queue.add(new QueueNode(treeNode.left, levelOfNode));
            }
            if (treeNode.right != null) {
                queue.add(new QueueNode(treeNode.right, levelOfNode));
            }
        }
        return rList;
    }

    static class QueueNode {

        /**
         * Node
         */
        private TreeNode node;

        /**
         * 所属level
         */
        private Integer level;

        public QueueNode(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

}
