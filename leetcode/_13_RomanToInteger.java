package leetcode;

import java.util.HashMap;

public class _13_RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> symMap = new HashMap<>();

        symMap.put('I', 1);
        symMap.put('V', 5);
        symMap.put('X', 10);
        symMap.put('L', 50);
        symMap.put('C', 100);
        symMap.put('D', 500);
        symMap.put('M', 1000);

        int result = 0;

        for(int i=0; i<s.length(); i++) {
            int currentC = symMap.get(s.charAt(i));

            if(i+1 == s.length()) {
                result += currentC;
                break;
            }

            int nextC = symMap.get(s.charAt(i+1));

            if(nextC / currentC == 5 || nextC / currentC == 10) {
                result += nextC-currentC;
                i++;
            }
            else {
                result += currentC;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _13_RomanToInteger().romanToInt("MCMXCIV"));
    }
}
