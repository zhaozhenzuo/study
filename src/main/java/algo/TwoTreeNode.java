package algo;

/**
 * 二叉树结点
 * 
 * @author zhaozhenzuo
 *
 */
public class TwoTreeNode {

	private TwoTreeNode leftNode;

	private TwoTreeNode rightNode;

	private Object data;

	public TwoTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TwoTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public TwoTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(TwoTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
