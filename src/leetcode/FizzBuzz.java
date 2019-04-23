package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        int i = 1;
        List<String> answer = new ArrayList<>();

        while (i <= n) {
            if(i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            }
            else if(i % 3 == 0) {
                answer.add("Fizz");
            }
            else if(i % 5 == 0) {
                answer.add("Buzz");
            }
            else {
                answer.add(Integer.toString(i));
            }
            i++;
        }
        return answer;
    }

    public List<String> fizzBuzzConcat(int n) {
        int i = 1;
        List<String> answer = new ArrayList<>();

        while (i <= n) {
            String s = "";
            if(i % 3 == 0) {
                s = s + "Fizz";
            }
            if(i % 5 == 0) {
                s = s + "Buzz";
            }
            if(s.length() == 0) {
                s = Integer.toString(i);
            }
            answer.add(s);
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
