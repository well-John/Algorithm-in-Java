package utils;

public class CommonUtils {

    /**
     * sort  0：向前移位  1：向后移位
     *
     * @param a
     * @param src
     * @param desc
     * @param sort
     */
    public static void backward(int[] a, int src, int desc, int sort) {
        if (sort == 0) {
            while (src < desc) {
                a[src] = a[++src];
            }
        } else if (sort == 1) {
            while (desc > src) {
                a[desc] = a[--desc];
            }
        }
    }


    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
