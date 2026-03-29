package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedFromArray {

    //Given an array nums of n integers where nums[i] is in the range [1, n],
    //return an array of all the integers in the range [1, n] that do not appear in nums.

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                result.add(j + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1})); // 5, 6
        System.out.println(findDisappearedNumbers(new int[] {1, 1})); // 2
    }
}
