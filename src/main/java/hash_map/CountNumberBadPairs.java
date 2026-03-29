package hash_map;

import java.util.HashMap;
import java.util.Map;

public class CountNumberBadPairs {

    public static long countBadPairs(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        long count = 0;
        int length = nums.length;
        long totalPairs = (long) length * (length - 1) / 2;
        for(int i = 0; i < nums.length; i++) {
            int key = nums[i] - i; // Calculate the key for Map based on the value and index
            if (frequencyMap.containsKey(key)) { // If the key already exists, it means we have found a good pair
                count += frequencyMap.get(key); // Add the count of existing pairs with the same key to the total count of good pairs
                frequencyMap.put(key, frequencyMap.get(key) + 1); // Increment the count of the current key in the Map
            } else { // If the key does not exist, add it to the Map with a count of 1
                frequencyMap.put(key, 1);
            }
        }
        return totalPairs - count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 3};
        System.out.println(countBadPairs(nums)); // Output: 5

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(countBadPairs(nums)); // Output: 0
    }


    public static long countBadPairsRefactored(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        long count = 0;
        int length = nums.length;
        long totalPairs = (long) length * (length - 1) / 2;
        for(int i = 0; i < nums.length; i++) {
            int key = nums[i] - i; // Calculate the key for Map based on the value and index
            int frequency = frequencyMap.getOrDefault(key, 0); // Get the current frequency of the key, or default to 0 if it does not exist
            count += frequency; // Add the count of existing pairs with the same key to the total count of good pairs
            frequencyMap.put(key, frequency + 1); // Increment the count of the current key in the Map
        }
        return totalPairs - count;
    }
}
