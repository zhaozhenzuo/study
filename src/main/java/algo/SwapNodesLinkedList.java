package algo;

public class SwapNodesLinkedList {

    public static void main(String[] args) {
        SwapNodesLinkedList swapNodesLinkedList=new SwapNodesLinkedList();
//        SwapNodesLinkedList.ListNode l3=new SwapNodesLinkedList.ListNode(4,null);
//        SwapNodesLinkedList.ListNode l2=new SwapNodesLinkedList.ListNode(3,l3);
        SwapNodesLinkedList.ListNode l1=new SwapNodesLinkedList.ListNode(2,null);
        SwapNodesLinkedList.ListNode h1=new SwapNodesLinkedList.ListNode(1,l1);

        SwapNodesLinkedList.ListNode r=swapNodesLinkedList.swapPairs(h1);
        SwapNodesLinkedList.ListNode iterateNode=r;
        while(iterateNode!=null){
            System.out.println(iterateNode.val);
            iterateNode=iterateNode.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode blankNode=new ListNode();
        blankNode.next=head;
        ListNode cur=blankNode;
        //b,1,2,3,4
        while(cur.next!=null && cur.next.next!=null){
            ListNode n1=cur.next;
            ListNode n2=cur.next.next;
            cur.next=n2;
            n1.next=n2.next;
            n2.next=n1;
            cur=n1;
        }
        return blankNode.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        //1,2,3,4
        ListNode pre=head;
        ListNode cur=head.next;
        ListNode r=cur;
        pre.next=null;
        while(cur!=null){
            ListNode tempNext=cur.next;
            cur.next=pre;
            if(tempNext!=null){
                if(tempNext.next!=null){
                    pre.next=tempNext.next;
                }else{
                    pre.next=tempNext;
                }
            }
            cur=tempNext!=null?tempNext.next:null;
            pre=tempNext;
            if(pre!=null){
                pre.next=null;
            }
        }
        return r;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
