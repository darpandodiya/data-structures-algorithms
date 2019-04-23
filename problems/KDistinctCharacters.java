package problems;

import java.util.HashSet;
import java.util.Set;


public class KDistinctCharacters {

    public static int kUniqueCharSubstring(String input, int k) {
        int result = 0;

        for(int outer = 0; outer <= input.length(); outer++) {

            for(int inner = outer + 1; inner <= input.length(); inner++) {
                Set<Character> uniqueChars = new HashSet<>();
                String substring = input.substring(outer, inner);

                for(char c : substring.toCharArray()) {
                    uniqueChars.add(c);
                }

                if(uniqueChars.size() == k) {
                    System.out.println(substring);
                    result++;
                }
            }


        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(kUniqueCharSubstring("abcbaa", 3));
    }
}
