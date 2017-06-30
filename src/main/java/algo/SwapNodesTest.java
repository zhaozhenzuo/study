package algo;

import algo.MergeTwoLinkedList.ListNode;

public class SwapNodesTest {

	public static void main(String[] args) {

		SwapNodesTest obj = new SwapNodesTest();

		int[] nodes = {  };
		ListNode l1 = MergeTwoLinkedList.compose(nodes);
		
		ListNode res=obj.swapPairs(l1);
		
		MergeTwoLinkedList.show(res);

	}

	/**
	 * 1->2->3->4
	 * 
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return head;
		}

		int cnt = 1;

		ListNode headRes = head;
		ListNode preNode = null;
		ListNode curNode = head;
		ListNode preTwoNode = null;

		while (curNode != null) {
			ListNode curNext = curNode.next;
			
			if (cnt % 2 == 0) {
				// 需要交换结点
				curNode.next = preNode;
				preNode.next = curNext;

				if (preTwoNode != null) {
					preTwoNode.next = curNode;
				}

				if (cnt == 2) {
					/**
					 * 首结点要变成这个结点<br/>
					 * eg:<br/>
					 * a->b->c => b->a->c<br/>
					 * 这里的cnt等于2时需要将b结点设置为head结点
					 */
					headRes = curNode;
				}

			} else {
				preTwoNode = preNode;
				preNode = curNode;
			}

			curNode = curNext;
			cnt++;
		}

		return headRes;
	}

}
