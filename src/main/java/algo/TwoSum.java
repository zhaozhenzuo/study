package algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] res = sum.twoSum(nums, target);
        System.out.println(res[0] + "," + res[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        int[] res = new int[2];
        Map<Integer,Integer> dataMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            Integer index=dataMap.get(temp);
            if (index!=null) {
                res[0]=index;
                res[1]=i;
                break;
            }else{
                dataMap.put(nums[i],i);
            }
        }
        return res;
    }

}
