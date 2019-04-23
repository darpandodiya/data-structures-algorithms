package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Schedules {
    public static List<String> findSchedules(int workHours, int dayHours, String pattern) {

        List<String> answerList = new ArrayList<>();

        int[] pt_list = new int[pattern.length()];
        Arrays.fill(pt_list, -1);

        List<Integer> leftidx = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        int covered = 0;

        for(int i=0; i<pattern.length(); i++) {
            if(pattern.charAt(i) != '?') {
                pt_list[i] = Integer.parseInt(String.valueOf(pattern.charAt(i)));
                covered += Integer.parseInt(String.valueOf(pattern.charAt(i)));
            }
            else {
                leftidx.add(i);
            }
        }

        int total_left = leftidx.size();
        int left = workHours - covered;

        if(total_left * dayHours == left) {
            for(int i : leftidx) {
                pt_list[i] = dayHours;
            }

            StringBuilder str = new StringBuilder();
            for(int i : pt_list) {
                str.append(i);
            }

            answerList.add(str.toString());

            return answerList;
        }
        else {
            List<Integer> temp = new ArrayList<>();
            int count = leftidx.size();
            while(count > 0) {
                temp.add(-1);
                count--;
            }

            findSol(leftidx, temp, dayHours, left, answer, 0);

            //System.out.println(Arrays.toString(answer.toArray()));

            List<List<Integer>> remaining = new ArrayList<>();

            for(List<Integer> x : answer) {
                int totalSum = 0;
                for(int tempSum : x) {
                    totalSum += tempSum;
                }

                if(totalSum == left) {
                    remaining.add(x);
                }
            }

            for(List<Integer> x : remaining) {
                int[] copy = pt_list.clone();

                for(int ileftidx = 0; ileftidx<leftidx.size(); ileftidx++) {
                    copy[leftidx.get(ileftidx)] = x.get(ileftidx);
                }

                StringBuilder str = new StringBuilder();
                for(int i : copy) {
                    str.append(i);
                }
                answerList.add(str.toString());
            }

            Collections.sort(answerList);
        }
        return answerList;
    }

    public static void findSol(List<Integer> leftidx, List<Integer> mylist, int dayHours, int left, List<List<Integer>> answer, int index) {

        if(index >= leftidx.size()) {
            answer.add(new ArrayList<>(mylist));
            return;
        }

        for(int i = dayHours; i >= 0; i--) {
            if(left - i < 0) {
                continue;
            }
            mylist.set(index, i);

            findSol(leftidx, mylist, dayHours, left-i, answer, index+1);
        }
    }


    public static void main(String[] args) {
        List<String> answer = findSchedules(24, 4, "08??840");

        System.out.println(Arrays.toString(answer.toArray()));
    }
}
