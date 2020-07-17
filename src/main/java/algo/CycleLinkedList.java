package algo;

public class CycleLinkedList {

    public static void main(String[] args) {
        CycleLinkedList reverseLinkedList = new CycleLinkedList();
        ListNode l2 = new ListNode(3, null);
        ListNode l1 = new ListNode(2, l2);
        ListNode h1 = new ListNode(1, l1);

        l1.next=h1;

        boolean r = reverseLinkedList.hasCycle(h1);
        System.out.println(r);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowNode = head;
        ListNode fastNode = head;
        //1,2,3,4
        while (fastNode.next != null && fastNode.next.next!=null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }

}
