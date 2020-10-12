import java.util.HashMap;
import java.util.Map;

public class test {
    public static void main(String[] args) {
        Solution solution = new test().new Solution();
        // TO TEST
        int [] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(solution.twoSum(nums,target));
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
}

