package algo;

import java.util.HashSet;
import java.util.Set;

public class EndPoint {

	/**
	 * 当前结点值,唯一值
	 */
	private String value;

	/**
	 * 当前结点能够连通的邻近结点
	 */
	private Set<String> adjSet;

	public EndPoint(String value) {
		this.value = value;
		adjSet = new HashSet<String>();

	}

	public Set<String> getAdj() {
		return adjSet;
	}

	/**
	 * 增加一个与当前结点能连通的结点<br/>
	 * 方法不抛错就算成功了
	 * 
	 * @param pointAdded
	 *            要增加的结点
	 * @return 如果之前不存在这个邻接结点则返回true，否则返回false
	 */
	public boolean addAdj(String pointAdded) {
		return adjSet.add(pointAdded);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
