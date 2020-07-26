package algo;

public class MaxDepthTree104 {

    Integer max = 0;

    //3,9,20
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int level = 1;
        max = 1;
        recur(root, level);
        return max;
    }

    private void recur(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && level > max) {
            max = level;
        }
        recur(node.left, level + 1);
        recur(node.right, level + 1);
    }

}
