package streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FirstUniqueStringCharacter {

    public static int firstUniqueChar(String s) {
        Optional<String> first = s.chars()
                .mapToObj(Character::toString)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        return first.map(s::indexOf)
                .orElse(-1);
    }

    public static int firstUniqueCharOptimized(String s) {
        int [] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("leetcode")); //0 - index of 'l'
    }
}
