package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * s: "barfoothefoobarman" <br/>
 * words: ["foo", "bar"]
 * 
 * @author zhaozhenzuo
 *
 */
public class SubStringWithConcatenation {

	public static void main(String[] args) {

		SubStringWithConcatenation obj = new SubStringWithConcatenation();

		String s = "barthefoobarman";
		String[] words = { "foo", "bar" };

		List<Integer> resList = obj.findSubstring(s, words);

		System.out.println(resList.toString());

	}

	public List<Integer> findSubstring(String s, String[] words) {

		/**
		 * 1.验证参数
		 */
		List<Integer> resList = new ArrayList<Integer>();

		if (s == null || s == "") {
			return resList;
		}

		if (words == null || words.length <= 0) {
			return resList;
		}

		int totalSize = words[0].length() * words.length;
		if (totalSize > s.length()) {
			/**
			 * word数组长度和已经大于s
			 */
			return resList;
		}

		/**
		 * 2.为words每个值构建map元素
		 */
		int wordNums = words.length;
		Map<String/* 单词 */, List<String>> wordMap = new HashMap<String, List<String>>();

		Map<Integer/* 首字符 */, List<String>> firstCharMap = new HashMap<Integer, List<String>>();

		for (String word : words) {
			List<String> tempList = wordMap.get(word);
			if (tempList == null) {
				tempList = new ArrayList<String>();
				wordMap.put(word, tempList);
			}

			tempList.add(word);

			int firstChar = word.charAt(0);
			List<String> firstList = firstCharMap.get(firstChar);
			if (firstList == null) {
				firstList = new ArrayList<String>();
				firstCharMap.put(firstChar, firstList);
			}

			firstList.add(word);
		}

		/**
		 * 3.开始循环字符串
		 */
		Map<String/* 单词 */, Integer/* 已匹配次数 */> matchedMap = new HashMap<String, Integer>();

		int wordSize = words[0].length();
		List<Integer> resIndexList = new ArrayList<Integer>();

		/**
		 * s: "barfooa" <br/>
		 * words: ["foo", "bar"]
		 */
		int lastIndex = s.length() - totalSize;
		char[] charArr = s.toCharArray();
		for (int i = 0; i <= lastIndex; i++) {
			matchedMap.clear();

			/**
			 * 看当前首字母是否存在对应words的词
			 */
			int c = charArr[i];
			List<String> strListInFirstMap = firstCharMap.get(c);
			if (strListInFirstMap == null || strListInFirstMap.size() <= 0) {
				continue;
			}

			int matchWordNums = 0;
			int startIndex = i;
			while (true) {
				if ((startIndex + wordSize - 1) >= s.length()) {
					break;
				}

				String subStr = s.substring(startIndex, startIndex + wordSize);
				boolean isSubStr = this.isSubString(subStr, matchedMap, wordMap);
				if (isSubStr) {
					matchWordNums++;
				} else {
					break;
				}

				if (matchWordNums == wordNums) {
					resIndexList.add(i);
					break;
				}

				startIndex = startIndex + wordSize;
			}

		}

		return resIndexList;

	}

	/**
	 * 子串是否匹配word数组
	 * 
	 * @param subStr
	 * @param matchedMap
	 * @param wordMap
	 * @return
	 */
	private boolean isSubString(String subStr, Map<String/* 单词 */, Integer/* 已匹配次数 */> matchedMap,
			Map<String/* 单词 */, List<String>/* 对应单词列表 */> wordMap) {

		/**
		 * 查找对应单词的单词列表
		 */
		List<String> strList = wordMap.get(subStr);
		if (strList == null || strList.size() <= 0) {
			return false;
		}

		Integer matchedNum = matchedMap.get(subStr);
		if (matchedNum == null) {
			matchedNum = 0;
		}
		matchedNum = matchedNum + 1;

		if (matchedNum > strList.size()) {
			return false;
		}

		matchedMap.put(subStr, matchedNum);

		return true;
	}

}
