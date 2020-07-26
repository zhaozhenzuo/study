package algo;

import java.util.LinkedList;
import java.util.Queue;

public class ValidTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return valid(root, null, null);
    }

    private boolean valid(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        if (node.left != null && !valid(node.left, min, node.val)) {
            return false;
        }
        if (node.right != null && !valid(node.right, node.val, max)) {
            return false;
        }
        return true;
    }

}
