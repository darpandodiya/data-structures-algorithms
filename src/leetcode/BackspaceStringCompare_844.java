package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BackspaceStringCompare_844 {

    //Suggested by the solution
    public boolean backspaceCompare(String S, String T) {
        return buildString(S).equals(buildString(T));
    }

    private String buildString(String inS) {
        Stack<Character> type = new Stack<>();

        for(char c : inS.toCharArray()) {
            if(c == '#') {
                if(!type.isEmpty()) {
                    type.pop();
                }
                else {
                    type.push(c);
                }
            }
        }

        return String.valueOf(type);
    }


    //S = "ac##", T = "#a#c"
    public boolean backspaceCompareBackwards(String S, String T) {
        int sPointer = S.length()-1;
        int tPointer = T.length()-1;
        int skipS = 0;
        int skipT = 0;

        while (sPointer >= 0 || tPointer >= 0) {

            while (sPointer >= 0) {
                if(S.charAt(sPointer) == '#') {
                    skipS++;
                    sPointer--;
                }
                else if(skipS > 0) {
                    skipS--;
                    sPointer--;
                }
                else {
                    break;
                }
            }

            while (tPointer >= 0) {
                if(T.charAt(tPointer) == '#') {
                    skipT++;
                    tPointer--;
                }
                else if(skipT > 0) {
                    skipT--;
                    tPointer--;
                }
                else {
                    break;
                }
            }

            if(sPointer >= 0 && tPointer >= 0 && (S.charAt(sPointer) != T.charAt(tPointer))) {
                return false;
            }

            if((sPointer >= 0 && tPointer < 0) || (sPointer<0 && tPointer>=0)) {
                return false;
            }

            sPointer--;
            tPointer--;
        }
        return true;
    }


    //First attempt, not optimized
    public boolean backspaceCompare0(String S, String T) {

        List<String> sList = new ArrayList<>();
        List<String> tList = new ArrayList<>();

        for(char currentC : S.toCharArray()) {
            if(currentC == '#') {
                if(sList.size() > 0) {
                    sList.remove(sList.size() - 1);
                }
            }
            else {
                sList.add(String.valueOf(currentC));
            }

        }

        for(char currentC : T.toCharArray()) {
            if(currentC == '#') {
                if(tList.size() > 0) {
                    tList.remove(tList.size() - 1);
                }
            }
            else {
                tList.add(String.valueOf(currentC));
            }
        }

        String newS = String.join("", sList);
        String newT = String.join("", tList);

        return newS.equalsIgnoreCase(newT);
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare_844().backspaceCompareBackwards("a##c#", "b#"));
    }
}
