package leetcode;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class MaximumDepthBT {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        else {
            int leftH = maxDepth(root.left);
            int rightH = maxDepth(root.right);

            return Math.max(leftH, rightH) + 1;
        }
    }


    int currentD = 1;
    int maxD = 0;

    //My approach that sucked
    public int maxDepthMyApproach(TreeNode root) {

        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            if(currentD > maxD) {
                maxD = currentD;
            }
            currentD--;
            return maxD;
        }

        if(root.left != null) {
            currentD++;
            maxDepth(root.left);
        }

        if(root.right != null) {
            currentD++;
            maxDepth(root.right);
        }

        return maxD;
    }

    public static void main(String[] args) {

    }
}
