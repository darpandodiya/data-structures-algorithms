package leetcode;

public class _771_Jewels_And_Stones {
    public int numJewelsInStones(String J, String S) {
        int[] count = new int[256];

        for(char c : S.toCharArray()) {
            count[c]++;
        }

        int stones = 0;

        for(char c : J.toCharArray()) {
            stones += count[c];
        }

        return stones;
    }
}
