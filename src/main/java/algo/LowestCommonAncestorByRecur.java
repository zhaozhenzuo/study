package algo;

import java.util.*;

public class LowestCommonAncestorByRecur {

    public static void main(String[] args) {
        LowestCommonAncestorByRecur lowestCommonAncestor = new LowestCommonAncestorByRecur();

        TreeNode root = new TreeNode(1);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(3);

        root.left = p;
        root.right = q;

        TreeNode r = lowestCommonAncestor.lowestCommonAncestor(root, p, q);
        System.out.println(r);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null
                || p.val == root.val || q.val == root.val) {
            return root;
        }

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return root;
        }
    }

}
