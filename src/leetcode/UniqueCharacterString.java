package leetcode;

//https://leetcode.com/problems/first-unique-character-in-a-string/

import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharacterString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charMap = new LinkedHashMap<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for(int i=0; i<s.length(); i++) {
            if(charMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueCharacterString().firstUniqChar("dddccdbba"));
    }
}
