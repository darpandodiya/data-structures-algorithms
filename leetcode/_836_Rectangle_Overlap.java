package leetcode;

//https://leetcode.com/problems/rectangle-overlap/
public class _836_Rectangle_Overlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec2[1] >= rec1[3] ||
                rec2[3] <= rec1[1] ||
                rec2[2] <= rec1[0] ||
                rec2[0] >= rec1[2]);
    }
}
