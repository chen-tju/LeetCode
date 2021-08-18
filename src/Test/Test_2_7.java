package Test;

public class Test_2_7 {
    public static void main(String[] args) {
        Solution solution = new Test_2_7().new Solution();
        String a = "cabaa";
        String b = "bcaaa";
        System.out.println(solution.largestMerge(a, b));
    }
    class Solution {
        public String largestMerge(String word1, String word2) {
            StringBuilder sb = new StringBuilder();
            int i = 0, j = 0;
            while(i < word1.length() && j < word2.length()){
                if(word1.charAt(i) > word2.charAt(j)){
                    sb.append(word1.charAt(i));
                    i++;
                }else if(word1.charAt(i) < word2.charAt(j)){
                    sb.append(word2.charAt(j));
                    j++;
                }else{
                    String tmp = helper(word1, word2, i, j);
                    if(word1.substring(i).equals(tmp)){
                        sb.append(word1.charAt(i));
                        i++;
                    }else{
                        sb.append(word2.charAt(j));
                        j++;
                    }
                }
            }
            return sb.toString();
        }
        private String helper(String a, String b, int i, int j){
            while(i < a.length() && j < b.length()){
                if(a.charAt(i) == b.charAt(j)){
                    i++;
                    j++;
                }
                break;
            }
            return a.charAt(i) >= b.charAt(j) ? a : b;
        }
    }
}
