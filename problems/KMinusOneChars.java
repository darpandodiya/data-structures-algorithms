package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KMinusOneChars {
    public static List<String> kMinus1UniqueCharSubstring(String input, int k) {
        Set<String> kMinus1Strings = new HashSet<>();

        

        for(int outer = 0; outer <= input.length(); outer++) {

            for(int inner = outer + 1; inner <= input.length(); inner++) {
                Set<Character> uniqueChars = new HashSet<>();
                String substring = input.substring(outer, inner);

                for(char c : substring.toCharArray()) {
                    uniqueChars.add(c);
                }

                if(uniqueChars.size() == (k-1) && substring.length() == k) {
                    System.out.println(substring);
                    kMinus1Strings.add(substring);
                }
            }
        }
        return new ArrayList<>(kMinus1Strings);
    }

    public static void main(String[] args) {
        System.out.println(kMinus1UniqueCharSubstring("aaaaaa", 4));
    }
}
