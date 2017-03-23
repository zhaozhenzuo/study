package algo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Graph {

	private Lock lock = new ReentrantLock();

	private Map<String, EndPoint> endPointMap;

	private int pointCnt;

	private int edgeCnt;

	private static final String EDGE_SPLIT_FOR_DATA = ";";

	private static final String POINT_SPLIT_FOR_DATA = ",";

	public static void main(String[] args) {
		Graph graph = new Graph();

		String data = "3,1;3,2;1,2;";
		graph.initGraph(data);

		graph.show();
		
//		DepthFirstSearch depthFirstSearch=new DepthFirstSearch(graph);
//		boolean canConnectFlag=depthFirstSearch.pointCanConnectedFromStart("2", "3");
//		System.out.println(canConnectFlag);
		
		Cycle cycle=new Cycle(graph);
		cycle.dpProcess();
		
		System.out.println(cycle.isCycle());

	}
	
	public Collection<EndPoint> getEndPoints(){
		return endPointMap.values();
	}
	
	public EndPoint getEndpointByValue(String value){
		return endPointMap.get(value);
	}
	
	private void show() {
		for (Entry<String, EndPoint> entry : endPointMap.entrySet()) {
			String key = entry.getKey();
			EndPoint endPoint = entry.getValue();
			System.out.println("结点:" + key + ",能够连通结点[" + endPoint.getAdj().toString() + "]");
		}
	}

	private void initGraph(String data) {
		List<String[]> dataRes = this.parseGraphData(data);

		for (String[] edge : dataRes) {
			this.addEdge(edge[0], edge[1]);
		}
	}

	private List<String[]> parseGraphData(String data) {
		if (data == null || data == "") {
			return null;
		}

		List<String[]> resList = new ArrayList<String[]>();

		String[] edgeArr = data.split("\\" + EDGE_SPLIT_FOR_DATA);
		for (String edge : edgeArr) {
			String[] pointArr = edge.split("\\" + POINT_SPLIT_FOR_DATA);
			resList.add(pointArr);
		}

		return resList;
	}

	public Graph() {
		endPointMap = new HashMap<String, EndPoint>();
		pointCnt = 0;
		edgeCnt = 0;
	}

	public void addEdge(String p1, String p2) {
		lock.lock();

		try {
			/**
			 * 1.维护结点1关系
			 */
			boolean hasNotExist1 = this.addAdjPoint(p1, p2);
			if (hasNotExist1) {
				pointCnt = pointCnt + 1;
				edgeCnt = edgeCnt + 1;
			}

			/**
			 * 2.维护结点2关系
			 */
			boolean hasNotExist2 = this.addAdjPoint(p2, p1);
			if (hasNotExist2) {
				pointCnt = pointCnt + 1;
				edgeCnt = edgeCnt + 1;
			}
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 加入一个能连通的结点给当前targetPointValue结点<br/>
	 * 方法不抛错就算成功了
	 * 
	 * @param targetPointValue
	 * @param adjPointAdded
	 * @return 如果之前没有这个要加入的连通结点则返回true，否则返回flase
	 */
	private boolean addAdjPoint(String targetPointValue, String adjPointAdded) {
		EndPoint endPoint = endPointMap.get(targetPointValue);
		if (endPoint == null) {
			endPoint = new EndPoint(targetPointValue);
			endPointMap.put(targetPointValue, endPoint);
		}
		return endPoint.addAdj(adjPointAdded);
	}

	public int getPointCnt() {
		return pointCnt;
	}

	public void setPointCnt(int pointCnt) {
		this.pointCnt = pointCnt;
	}

	public int getEdgeCnt() {
		return edgeCnt;
	}

	public void setEdgeCnt(int edgeCnt) {
		this.edgeCnt = edgeCnt;
	}

}
