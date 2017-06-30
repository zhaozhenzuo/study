package algo;

import java.util.ArrayList;
import java.util.List;

import algo.MergeTwoLinkedList.ListNode;

public class ReverseKnode {

	public static void main(String[] args) {
		ReverseKnode obj = new ReverseKnode();

		int[] nodes = { 1 };
		ListNode head = MergeTwoLinkedList.compose(nodes);
		ListNode res = obj.reverseKGroup(head, 3);

		MergeTwoLinkedList.show(res);

	}

	/**
	 * 1,2,3,4; k=3
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {

		if (k <= 1 || head == null || head.next == null) {
			return head;
		}

		int i = 1;
		ListNode curNode = head;
		List<ListNode> list = new ArrayList<ListNode>();

		ListNode headRes = head;

		while (curNode != null) {

			list.add(curNode);

			if (i % k != 0) {
				/**
				 * 当前不需要进行转换
				 */
				curNode = curNode.next;
			} else {
				/**
				 * 需要转换
				 */
				// 1,2,3,4; k=3
				// 代表k-1之后的结点
				ListNode curNodeNext = curNode.next;

				// 该分组最一个结点
				ListNode firstNodeOfGroup = list.get(i - k);

				int preGroupLastNodeIndex = i - 2 * k;
				ListNode preGroupLastNode = null;
				if (preGroupLastNodeIndex >= 0) {
					preGroupLastNode = list.get(preGroupLastNodeIndex);
				}

				/**
				 * 从k-1数组位置向前，依次将指针next指向变为：3->2->1->4
				 */
				ListNode preNode = null;
				for (int j = i - 1; j >= (i - k); j--) {
					ListNode tempNode = list.get(j);
					if (preNode != null) {
						preNode.next = tempNode;
					}

					preNode = tempNode;
				}

				// 最后转换后的1指向4
				firstNodeOfGroup.next = curNodeNext;

				// 设置首结点
				if (i == k) {
					headRes = curNode;
				}

				if (preGroupLastNode != null) {
					// 大于两个分组，将第一分组最后一个元素指向当前元素
					preGroupLastNode.next = curNode;
				}

				// 设置下个处理结点为k-1的后结点
				curNode = curNodeNext;
			}

			i++;

		}

		return headRes;

	}

}
