package leetcode;

public class _26_RemoveDupsSortedArray {

    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int pointer = 1;
        int lastseen = nums[0];

        for (int i=1; i<nums.length; i++) {
            //If new number
            if(nums[i] != lastseen) {
                lastseen = nums[i];
                nums[pointer] = lastseen;
                pointer++;
            }
        }

        return pointer;
    }

    public static void main(String[] args) {
        System.out.println(new _26_RemoveDupsSortedArray().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
