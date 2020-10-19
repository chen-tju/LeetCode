package leetcode.editor.cn;

public class Test_guibing {
    public static void main(String[] args) {
        int[] nums = {6,8,1,3,4,7,0};
        MergeSort(nums, 0, nums.length - 1);
        for(int num : nums) {
            System.out.println(num);
        }
    }

    private static void MergeSort(int[] a, int start, int end) {
        if(start>=end){
            return;
        }
        int mid = (start+end)/2;
        MergeSort(a, start, mid);
        MergeSort(a, mid+1, end);
        Mergea(a, start, mid, end);
    }
    private static void Mergea(int[] a, int start, int mid, int end) {

        int left_len = mid-start+1;
        int right_len = end-mid;
        int[] L = new int[left_len];
        int[] R = new int[right_len];
        int i, j, k;
        for(i=0, k=start; i<left_len; i++,k++){
            L[i]=a[k];
        }
        for (j = 0, k = mid + 1; j < right_len; j++,k++) {
            R[j]=a[k];
        }
        for (i = 0, j = 0, k = start; i <left_len && j<right_len; k++) {
            if(L[i]<R[j]){
                a[k] = L[i++];
            }else{
                a[k] = R[j++];
            }
        }
        if (j<right_len) {
            for(;j<right_len;k++){
                a[k] = R[j++];
            }
        }
        if (i<left_len) {
            for(;i<left_len;k++){
                a[k] = L[i++];
            }
        }
    }
}
