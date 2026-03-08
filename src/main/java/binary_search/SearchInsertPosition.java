package binary_search;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int middle = (int) Math.floor((double) (left + right) / 2);
            if(nums[middle] >= target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(searchInsert(nums, target)); // Output: 2

        target = 2;
        System.out.println(searchInsert(nums, target)); // Output: 1

        target = 7;
        System.out.println(searchInsert(nums, target)); // Output: 4

        target = 0;
        System.out.println(searchInsert(nums, target)); // Output: 0
    }
}
