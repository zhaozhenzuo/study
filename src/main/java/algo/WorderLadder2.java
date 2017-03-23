package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorderLadder2 {

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";

		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

		WorderLadder2 solution = new WorderLadder2();

		List<List<String>> resList = solution.findLadders(beginWord, endWord, wordList);
		if (resList != null) {
			for (List<String> res : resList) {
				System.out.println(res.toString());
			}
		}

	}

	private List<List<String>> returnMinList(List<List<String>> resList) {
		if (resList == null || resList.size() <= 1) {
			return resList;
		}

		Map<Integer, List<List<String>>> map = new HashMap<Integer, List<List<String>>>();

		Integer minSize = null;
		for (List<String> tempList : resList) {
			int tempSize = tempList.size();
			if (minSize == null || tempSize <= minSize) {
				minSize = tempSize;

				List<List<String>> oldList = map.get(tempSize);
				if (oldList == null) {
					oldList = new ArrayList<List<String>>();
					map.put(tempSize, oldList);
				}

				oldList.add(tempList);
			}
		}

		return map.get(minSize);
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		this.checkParam(beginWord, endWord, wordList);

		List<String> seqResList = new ArrayList<String>();
		seqResList.add(beginWord);

		List<List<String>> resList = this.findInner(beginWord, endWord, wordList, seqResList);
		
		if(resList == null){
			resList=new ArrayList<List<String>>();
		}

		return this.returnMinList(resList);
	}

	private void checkParam(String beginWord, String endWord, List<String> wordList) {
		if (beginWord == null || beginWord.length() <= 0 || endWord == null || endWord.length() <= 0 || wordList == null
				|| wordList.size() <= 0) {
			throw new IllegalArgumentException("非法参数");
		}

		if (beginWord.length() != endWord.length()) {
			throw new IllegalArgumentException("开始与结束单词长度不相等");
		}

	}

	public List<List<String>> findInner(String beginWord, String endWord, List<String> wordList,
			List<String> seqResList) {
		if (beginWord == null || beginWord.length() <= 0) {
			return null;
		}

		List<List<String>> resList = new ArrayList<List<String>>();
		if (beginWord.equals(endWord)) {
			/**
			 * 最终结果
			 */
			resList.add(seqResList);
			return resList;
		}

		/**
		 * 1.查找出当前beginWord在wordList但不在seqResList的单词集合
		 */
		List<String> transferProcessList = this.getWordList(beginWord, wordList, seqResList);
		if (transferProcessList == null || transferProcessList.size() <= 0) {
			/**
			 * 这个过渡队列无效
			 */
			return null;
		}

		/**
		 * 2.广度优先处理转变单词队列<br/>
		 * start:ab,end:tc<br/>
		 * collection:<br/>
		 * ac,bc,da,tb<br/>
		 * => ab,ac,tc<br/>
		 * => ab,tb,tc
		 * 
		 */
		for (String transferPrcessStr : transferProcessList) {
			List<String> tempParamResList = new ArrayList<String>();
			tempParamResList.addAll(seqResList);
			tempParamResList.add(transferPrcessStr);
			List<List<String>> tempResList = this.findInner(transferPrcessStr, endWord, wordList, tempParamResList);
			if (tempResList != null) {
				resList.addAll(tempResList);
			}
		}

		return resList;

	}

	public List<String> getWordList(String beginWord, List<String> wordList, List<String> seqResList) {
		if (wordList == null || wordList.size() <= 0 || beginWord == null || beginWord.length() <= 0) {
			return null;
		}

		List<String> tempList = new ArrayList<String>();
		for (String word : wordList) {
			if (this.wordEqAtleastOne(beginWord, word) && !this.wordIsInSeqResList(word, seqResList)) {
				tempList.add(word);
			}
		}

		return tempList;

	}

	private boolean wordIsInSeqResList(String beginWord, List<String> seqResList) {
		if (seqResList == null || seqResList.size() <= 0) {
			return false;
		}

		boolean eqFlag = false;
		for (String str : seqResList) {
			if (str.equals(beginWord)) {
				eqFlag = true;
				break;
			}
		}

		return eqFlag;
	}

	private boolean wordEqAtleastOne(String beginWord, String word) {
		if (beginWord.length() != word.length()) {
			throw new IllegalArgumentException("单词长度必须相等");
		}

		int length = beginWord.length();
		int eqCnt = 0;
		for (int i = 0; i < beginWord.length(); i++) {
			int charAtIndex = beginWord.charAt(i);
			if (word.charAt(i) == charAtIndex) {
				eqCnt++;
			}
		}

		if ((length - eqCnt) <= 1) {
			return true;
		}
		return false;
	}
}
