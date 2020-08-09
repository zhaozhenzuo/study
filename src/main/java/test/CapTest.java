package test;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CapTest {

	private static final Logger logger = LoggerFactory.getLogger(CapTest.class);

	public static void main(String[] args) {
		int maxQps=200;
		String[] rtList={"1","1","1","10","10"}; //600+ 400
		int requestNum=5000;
		int threadNum=10;
		
		long costTime=doneTime(maxQps, rtList, requestNum, threadNum);
		System.out.println(costTime);
	}

	/**
	 * 1.得出每台服务器的连接数<br/>
	 * 一个线程不断发往特定服务器一秒能够到达请求数=1000毫秒/当前服务器rt时间 <br/>
	 * 当前服务器能够允许最多连接数=maxQps/[一个线程不断发往特定服务器一秒能够到达请求数]<br/>
	 * 2.合计出所有服务器一秒能够处理的请求数<br/>
	 * 所有服务器一秒能够处理请求数=<br/>
	 * [一个线程不断发往特定服务器一秒能够到达请求数]*[当前服务器能够允许最多连接数]<br/>
	 * 耗时=[请求数]/[所有服务器一秒能够处理请求数]
	 * 
	 * @param maxQps
	 * @param rtList
	 * @param requestNum
	 * @param threadNum
	 * @return 耗时毫秒数
	 */
	static long doneTime(int maxQps, String[] rtList, int requestNum, int threadNum) {

		/**
		 * 1.验证参数
		 */
		if (maxQps <= 0) {
			logger.warn(">maxQps must be larger than 0,maxQps[" + maxQps + "]");
			throw new IllegalArgumentException("服务器maxQps必须大于0");
		}

		if (rtList == null || rtList.length <= 0) {
			throw new IllegalArgumentException("服务器rt时间必须传");
		}

		if (requestNum <= 0) {
			logger.warn(">requestNum is less than 0,requestNum[" + requestNum + "]");
			return 0;
		}

		if (threadNum <= 0) {
			throw new IllegalArgumentException("threadNum必须大于0");
		}

		/**
		 * 2.计算出每台服务的连接数
		 */
		/**
		 * 2.1.排序rt时间
		 */
		List<Long> rtResList = strArrToLongList(rtList);
//		Collections.sort(rtResList);

		/**
		 * 2.2.循环计算出每个服务器最大连接数<br/>
		 * 默认从rt最小的开始计算，尽量将这台的连接数达到极限值
		 */
		long threadNumsRemain = threadNum;
		long reqNumsProcessOneSecondAllServer = 0;

		/**
		 * test<br/>
		 * rtList=10ms,20ms,100ms<br/>
		 * threadNum=3<br/>
		 * maxQps=200<br/>
		 * requestNums=1000<br/>
		 */
		for (Long rt : rtResList) {
			if (threadNumsRemain <= 0) {
				break;
			}

			long maxReqNumsSendByOneThread = 1000L / rt; // 一个线程不断发送请求，一秒能够发送的请求数
			long maxConnection = maxQps / maxReqNumsSendByOneThread; // 最大连接数
			if(maxConnection<=0){
				maxConnection=1;
			}

			// 计算出分配这台服务器连接数
			long curConnectionNums = 0;

			if (threadNumsRemain <= maxConnection) {
				// 可分配线程数小于当前服务器最大连接数,则所有连接都分配给它
				curConnectionNums = threadNumsRemain;
				threadNumsRemain = 0;
			} else {
				/**
				 * 可分配线程数大于服务器最大连接数，则分配当前服务器能够接受的最大连接数
				 */
				curConnectionNums = maxConnection;
				threadNumsRemain = threadNumsRemain - curConnectionNums;
			}

			/**
			 * 计算出当前这台服务器一秒能够处理掉的请求数
			 */
			long canProcessReqNumsOneSecondsCurServer = curConnectionNums * maxReqNumsSendByOneThread;
			reqNumsProcessOneSecondAllServer += canProcessReqNumsOneSecondsCurServer;
		}

//		if (threadNumsRemain > 0) {
//			logger.error(">线程数分配不完，会压跨服务器,threadNum[" + threadNum + "]");
//			throw new IllegalArgumentException("线程数分配不完，会压跨服务器");
//		}

		double requestNumDouble = requestNum;
		double reqNumsProcessOneSecondAllServerDouble = reqNumsProcessOneSecondAllServer;

		double costTime = requestNumDouble / reqNumsProcessOneSecondAllServerDouble;

		long res = (long) (costTime * 1000);

		return res;
	}

	private static List<Long> strArrToLongList(String[] rtArr) {
		if (rtArr == null || rtArr.length <= 0) {
			return null;
		}

		List<Long> resList = new ArrayList<Long>(rtArr.length);

		for (String rt : rtArr) {
			resList.add(Long.valueOf(rt));
		}

		return resList;
	}

}
