package algo;

import java.util.List;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList=new ReverseLinkedList();
        ListNode l2=new ListNode(3,null);
        ListNode l1=new ListNode(2,l2);
        ListNode h1=new ListNode(1,l1);

        ListNode r=reverseLinkedList.reverseList(h1);
        ListNode iterateNode=r;
        while(iterateNode!=null){
            System.out.println(iterateNode.val);
            iterateNode=iterateNode.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        //1->2->3->null
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null){
            ListNode tempNext=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tempNext;
        }
        return pre;

//        ListNode iterateNode=head.next;
//        ListNode preNode=head;
//        preNode.next=null;
//        ListNode rHead=head;
//        while(iterateNode!=null){
//            if(iterateNode.next == null){
//                //正向链表的最后一个结点就是头结点
//                rHead=iterateNode;
//            }
//            ListNode temp=iterateNode.next;
//            iterateNode.next=preNode;
//            preNode=iterateNode;
//            iterateNode=temp;
//        }
//        return rHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
