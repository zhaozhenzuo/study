package algo;

import java.util.*;

public class BinaryTree102DFS {

    public static void main(String[] args) {
        BinaryTree102DFS binaryTree102 = new BinaryTree102DFS();
        TreeNode root = new TreeNode(3);

        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);

        root.left = left;
        root.right = right;

        TreeNode rightChildLeft = new TreeNode(15);
        TreeNode rightChildRight = new TreeNode(7);
        right.left = rightChildLeft;
        right.right = rightChildRight;

        List<List<Integer>> rList = binaryTree102.levelOrder(root);
        System.out.println(rList);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> rList = new ArrayList<>();
        queue.add(root);

        rList.add(Arrays.asList(root.val));

        //4,3,2
        while (!queue.isEmpty()) {
            List<Integer> tList = iterate(queue);
            if (tList != null && !tList.isEmpty()) {
                rList.add(tList);
            }
        }
        return rList;
    }

    private List<Integer> iterate(Queue<TreeNode> queue) {
        if (queue == null) {
            return null;
        }

        /**
         * 遍历queue中这层结点
         */
        List<Integer> rList = new ArrayList<>();

        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                rList.add(treeNode.left.val);
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                rList.add(treeNode.right.val);
                queue.offer(treeNode.right);
            }
        }
        return rList;
    }

}
