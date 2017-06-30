package algo;

public class MergeTwoLinkedList {

	public static void main(String[] args) {

		MergeTwoLinkedList obj = new MergeTwoLinkedList();

		int[] n1 = { 1, 3, 9 };
		ListNode l1 = obj.compose(n1);

		int[] n2 = { 8 };
		ListNode l2 = obj.compose(n2);

		ListNode res = obj.mergeTwoLists(l1, l2);

		obj.show(res);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}

		if (l2 == null) {
			return l1;
		}

		ListNode resNode = null;
		ListNode resHead = null;

		ListNode n1 = l1;
		ListNode n2 = l2;

		/**
		 * 3,4<br/>
		 * 1,5,7
		 */
		while (true) {
			if (n1 == null || n2 == null) {
				break;
			}

			if (n1.val <= n2.val) {
				if (resNode != null) {
					resNode.next = n1;
					resNode = n1;
				} else {
					resHead = n1;
					resNode = n1;
				}
				n1 = n1.next;
			} else {
				if (resNode != null) {
					resNode.next = n2;
					resNode = n2;
				} else {
					resHead = n2;
					resNode = n2;
				}
				n2 = n2.next;
			}
		}

		/**
		 * 处理不为空队列，这个队列中的数值必定大于之前放入resList的元素
		 */
		if (n1 != null) {
			resNode.next = n1;
		} else if (n2 != null) {
			resNode.next = n2;
		}

		return resHead;
	}

	static class ListNode {
		int val;
		ListNode next;

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

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode compose(int[] nodes) {
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

	public static ListNode[] composeNodeArr(Integer[] nodes) {
		if (nodes == null || nodes.length <= 0) {
			return null;
		}

		ListNode[] nodesArr = new ListNode[nodes.length];

		for (int i = 0; i < nodes.length; i++) {
			ListNode node = new ListNode(nodes[i]);
			nodesArr[i] = node;
		}

		return nodesArr;
	}

	public static void show(ListNode node) {
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

}
