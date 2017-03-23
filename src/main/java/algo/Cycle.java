package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cycle {

	private Graph graph;

	private Map<String, Boolean> markedMap = new HashMap<String, Boolean>();

	private boolean cycleFlag;

	public Cycle(Graph graph) {
		this.graph = graph;
		cycleFlag = false;
	}

	public void dpProcess() {
		for (EndPoint endPoint : graph.getEndPoints()) {
			boolean markedFlag=markedMap.get(endPoint.getValue()) == null?false:true;
			if(!markedFlag){
				this.cycleProcess(endPoint, endPoint);
			}
			
		}
	}

	private void cycleProcess(EndPoint endPoint, EndPoint preEndPoint) {
		markedMap.put(endPoint.getValue(), true);

		Set<String> adjList = endPoint.getAdj();
		for (String ajdStr : adjList) {
			Boolean markedFlag = markedMap.get(ajdStr);
			if (markedFlag == null || !markedFlag) {
				/**
				 * 该结点还没访问过，继续深度优先处理
				 */
				EndPoint endPointAdj = graph.getEndpointByValue(ajdStr);
				this.cycleProcess(endPointAdj, endPoint);
			} else if (markedFlag != null && markedFlag && !ajdStr.equals(preEndPoint.getValue())) {
				/**
				 * 已经访问过，并且上个结点来源与访问过的结点不是同一个，说明出现了环
				 */
				cycleFlag = true;
			}
		}

	}

	public boolean isCycle() {
		return cycleFlag;
	}

}
