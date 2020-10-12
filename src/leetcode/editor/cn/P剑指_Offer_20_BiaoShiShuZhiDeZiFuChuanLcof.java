//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 45 👎 0


package leetcode.editor.cn;

//表示数值的字符串

import java.util.Map;

public class P剑指_Offer_20_BiaoShiShuZhiDeZiFuChuanLcof{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P剑指_Offer_20_BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
        System.out.println(solution.isNumber("0"));
    }
    
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        boolean isNum = false, isDot = false, isE = false;
        char[] str = s.trim().toCharArray();
        for(int i = 0; i < str.length; i++){
            if(str[i] >= '0' && str[i] <= '9'){
                isNum = true;
            }else if(str[i] == '.'){
                if(isDot || isE){
                    return false;
                }
                isDot = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                if(!isNum || isE){
                    return false;
                }
                isE = true;
                isNum = false;
            }else if(str[i] == '+' || str[i] == '-'){
                if(i != 0 && str[i-1] == 'e' && str[i] == 'E'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return isNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}