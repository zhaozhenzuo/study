package algo;

import java.util.*;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor=new LowestCommonAncestor();

        TreeNode root=new TreeNode(1);

        TreeNode p=new TreeNode(2);
        TreeNode q=new TreeNode(3);

        root.left=p;
        root.right=q;

        TreeNode r=lowestCommonAncestor.lowestCommonAncestor(root,p,q);
        System.out.println(r);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        //定义数据结构
        Stack<TreeNode> stackForP = new Stack();
        Stack<TreeNode> stackForQ = new Stack();
        Set<Integer> setForP = new HashSet<>();
        Set<Integer> setForQ = new HashSet<>();

        //查询p
        findAndInsertNodes(root, p.val, stackForP, setForP);

        //查询q
        findAndInsertNodes(root, q.val, stackForQ, setForQ);

        //判空
        if (stackForP.isEmpty() || setForQ.isEmpty()) {
            return null;
        }

        //看哪个结点深度更深，从深度更深的结点开始
        if (stackForP.size()>=stackForQ.size()) {
            return findLowestAncestor(stackForP,setForQ);
        }else{
            return findLowestAncestor(stackForQ,setForP);
        }
    }

    private TreeNode findLowestAncestor(Stack<TreeNode> stack, Set<Integer> otherNodeSet) {
        if (stack == null || otherNodeSet == null) {
            return null;
        }
        while(!stack.isEmpty()){
            TreeNode treeNode=stack.pop();
            if(otherNodeSet.contains(treeNode.val)){
                return treeNode;
            }
        }
        return null;
    }

    private void findAndInsertNodes(TreeNode root, Integer findValue, Stack<TreeNode> stack, Set<Integer> sets) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue=new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curNode=queue.poll();
            if(curNode == null){
                return;
            }
            stack.add(curNode);
            sets.add(curNode.val);
            if (curNode.val == findValue) {
                //找到结点了
                return;
            }
            queue.add(curNode.left);
            queue.add(curNode.right);
        }

        //没找到这个结点，则清空结果集
        stack.clear();
        sets.clear();
    }

}
