package Test;

public class Test_9_6_1 {
    public static void main(String[] args) {
        Solution solution = new Test_9_6_1().new Solution();
        //System.out.println(solution.modifyString("?mds"));
        System.out.println(solution.modifyString("??yw?ipkj?"));
    }
    class Solution {
        public String modifyString(String s) {
            String res = "";
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != '?'){
                    res += s.charAt(i);
                }else{
                    for(int j = 0; j <= 26; j++){
                        char tmp = (char)('a' + j);
                        if(i - 1 >= 0 && s.charAt(i-1) == tmp){
                            continue;
                        }else if(i + 1 <= s.length() - 1 && s.charAt(i+1) == tmp){
                            continue;
                        }else{
                            s = s.substring(0,i) + tmp + s.substring(i + 1, s.length());
                            res += tmp;
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }
}
