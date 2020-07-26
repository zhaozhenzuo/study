package algo;

import java.util.HashMap;
import java.util.Map;

public class Majority {

    public static void main(String[] args) {

    }

    Map<Integer, Integer> numMap = new HashMap<>();

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int threshNum = nums.length >>1;
        for (int num : nums) {
            Integer v = numMap.get(num);
            if (v == null) {
                v = 1;
            } else {
                v++;
            }
            numMap.put(num, v);
            if (v > threshNum) {
                //找到这个数了
                return num;
            }
        }
        //没找到
        return 0;
    }
}
