package binary_search;

import java.util.Arrays;

public class FirstAndLastPositionElementSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int [] result = {-1, -1};
        int left = 0;
        int right = nums.length - 1;

        if(nums.length == 0) {
            return new int [] {-1, -1};
        }

        while(left < nums.length) {
            if (nums[left] == target) {
                result[0] = left;
                break;
            }
            left++;
        }
        while (right >= left) {
            if (nums[right] == target) {
                result[1] = right;
                break;
            }
            right--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints1 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8); // [3, 4]
        Arrays.stream(ints1).forEach(System.out::print);
        System.out.println();
        int[] ints2 = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6); // [-1, -1]
        Arrays.stream(ints2).forEach(System.out::print);
        System.out.println();
        int[] ints3 = searchRange(new int[]{}, 0); // [-1, -1]
        Arrays.stream(ints3).forEach(System.out::print);
        System.out.println();
        int[] ints4 = searchRange(new int[]{1}, 1); // [-1, -1]
        Arrays.stream(ints4).forEach(System.out::print);
    }
}
