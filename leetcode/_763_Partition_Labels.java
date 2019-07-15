package leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/partition-labels/

public class _763_Partition_Labels {
    public List<Integer> partitionLabels(String S) {
        int start = 0;
        int end = 0;
        int counter = 0;

        List<Integer> result = new ArrayList<>();

        for(char c : S.toCharArray()) {
            end = Math.max(end, S.lastIndexOf(c));
            counter++;

            if(counter > end) {
                result.add(end-start+1);
                start = counter;
            }
        }
        return result;
    }
}
