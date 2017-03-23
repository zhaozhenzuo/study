package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DepthFirstSearch {

	private Graph graph;

	private Map<String, Boolean> markedMap;

	int count;

	public DepthFirstSearch(Graph graph) {
		this.graph = graph;
		markedMap = new HashMap<String, Boolean>();
		count = 0;
	}

	public boolean pointCanConnectedFromStart(String targetPointValue, String startPointValue) {
		this.initMarkedFromStartByDepthSearch(startPointValue);

		Boolean flag = markedMap.get(targetPointValue);
		return flag == null ? false : true;
	}

	private void initMarkedFromStartByDepthSearch(String startPointValue) {
		Boolean markedFlag = markedMap.get(startPointValue);
		if (markedFlag == null) {
			markedMap.put(startPointValue, true);
		}

		EndPoint endPoint = graph.getEndpointByValue(startPointValue);
		if (endPoint == null) {
			throw new IllegalArgumentException("cannot found point for value[" + startPointValue + "]");
		}

		Set<String> adjPointSet = endPoint.getAdj();
		if (adjPointSet == null) {
			return;
		}

		for (String pointValue : adjPointSet) {
			Boolean pointMarkedFlag = markedMap.get(pointValue);
			if (pointMarkedFlag == null) {
				/**
				 * 没有对应marked标记，代表还没有处理过该结点
				 */
				initMarkedFromStartByDepthSearch(pointValue);
			}
		}

	}

}
