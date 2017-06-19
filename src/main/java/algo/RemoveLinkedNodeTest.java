package algo;

public class RemoveLinkedNodeTest {

	public static void main(String[] args) {
		RemoveLinkedNodeTest obj = new RemoveLinkedNodeTest();

		int[] nodes = { 1, 2, 3, 4, 5 };
		ListNode head = obj.compose(nodes);
		
		obj.show(head);

		ListNode res = obj.removeNthFromEnd(head, 5);
		obj.show(res);
		
	}

	public ListNode compose(int[] nodes) {
		if (nodes == null || nodes.length <= 0) {
			return null;
		}

		ListNode head = new ListNode(nodes[0]);

		ListNode tempNode = head;
		for (int i = 1; i < nodes.length; i++) {
			ListNode node = new ListNode(nodes[i]);
			tempNode.setNext(node);
			tempNode = node;
		}

		return head;
	}

	public void show(ListNode node) {
		if (node == null) {
			System.out.println("empty");
			return;
		}

		ListNode temp = node;
		StringBuilder buffer = new StringBuilder();
		while (temp != null) {
			buffer.append(temp.getVal() + ">");
			temp = temp.next;
		}

		System.out.println("res=" + buffer.toString());
	}

	/**
	 * 1->2->3->4->5
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}

		if (n <= 0) {
			return head;
		}

		/**
		 * cal length of list
		 */
		ListNode dataNode = head;
		int cnt = 0;
		while (dataNode != null) {
			cnt++;
			dataNode = dataNode.next;
		}

		int targetIndex = cnt - n;
		if (targetIndex < 0) {
			return head;
		}

		int i = 0;
		ListNode headRes = head;
		ListNode preNode = null;
		dataNode = head;
		while (dataNode != null) {
			if (i == targetIndex) {
				/**
				 * 删除结点
				 */
				if (preNode == null) {
					/**
					 * 当前结点就是head结点
					 */
					headRes = dataNode.next;
				} else {
					/**
					 * 当前结点不是head结点
					 */
					preNode.next = dataNode.next;
				}

				break;
			}

			preNode = dataNode;
			dataNode = dataNode.next;
			i++;
		}

		return headRes;
	}

	static class ListNode {
		int val;

		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}
	}

}
