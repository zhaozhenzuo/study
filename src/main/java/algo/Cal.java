//private ExecutorService threadPool = new ThreadPoolExecutor(
//			10,
//			10,
//			10L,
//			TimeUnit.SECONDS,
//			new LinkedBlockingDeque<Runnable>());
//
//	private CompletionService<String> pool = new ExecutorCompletionService<String>(threadPool);
//
//	List<Share> resList = null;
//	while(true) {
//		shareList = shareService.selectGtIdLimitRows(loopBeginId, DEFALUT_ROWS);
//		// 如果遍历结束,break跳出
//		if(CollectionUtils.isEmpty(tbShareList)) break;
//
//		for (Share tbShare : shareList) {
//			// 1.提交执行任务
//			pool.submit(new CutDayByShareIdTask(share,
//					cutDayDate, tenThousandIncome,repairFlag));
//
//			// 2.统计执行任务数
//			execNum++;
//		}
//
//		// 3.下一次循环起始地址
//		loopBeginId = shareList.get(tbShareList.size() - 1).getId();
//	}
//
//	/*********************5.获取执行结果*******************************/
//	final long finalExecNum = execNum;
//	for(int i = 0; i < finalExecNum; i++){
//	   String result = pool.take().get();
//	   if(Constants.OPERATION_EXEC_RESULT.SUCCESS.equals(result)) {
//		   execSuccNum++;
//	   }
//	}
//