package array;

public class SearchCenterIndex {


    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }



    public static void main(String[] args) {
        int[] array = {-1, -1, 0, 1, 1, 0};
        SearchCenterIndex searchCenterIndex = new SearchCenterIndex();
        int i = searchCenterIndex.pivotIndex(array);
        System.out.println(i);
    }

}
