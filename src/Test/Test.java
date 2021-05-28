package Test;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Test().new Solution();
        // TO TEST
        int [] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = solution.twoSum(nums, target);
        for(int num : res){
            System.out.println(num);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> mp = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(mp.containsKey(target - nums[i])){
                    return new int[]{i,mp.get(target-nums[i])};
                }
                mp.put(nums[i],i);
            }
            throw new IllegalArgumentException("No Two Sum Solution!");
        }
    }
    public static String get2DArrayPrint(boolean[][] matrix) {
        String output = new String();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                output = output + (matrix[i][j] + "\t");
            }
            output = output + "\n";
        }
        return output;
    }
}

