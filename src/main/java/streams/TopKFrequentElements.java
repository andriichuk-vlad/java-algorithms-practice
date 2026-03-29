package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, HashMap::new , Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static int[] topKFrequentOptimized(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int[] result = new int[k];
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        for (int i = buckets.length -1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (int j = 0; j < buckets[i].size(); j++) {
                result[index] = buckets[i].get(j);
                index++;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = topKFrequentOptimized(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [1, 2]
    }
}