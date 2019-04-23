package problems;

/**
 * Given array of integers, give maximum sub of an sub array.
 *
 * [1, -4, 7, 2] - return 9 (comes from [7, 2]
 *
 */
public class SubarraySum {

    //Try ever subarray and compare their sum. This will be n^2 Main.
    private static int bruteForce(int[] input) {
        int maxSoFar = Integer.MIN_VALUE;

        for(int inner=0; inner<input.length; inner++) {
            int currentSum = 0;

            for(int outer=inner; outer<input.length; outer++) {
                currentSum += input[outer];

                maxSoFar = Math.max(maxSoFar, currentSum);
            }
        }

        return maxSoFar;
    }

    private static int kadaneAlgo(int[] input) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for(int index=0; index<input.length; index++) {
            maxEndingHere += input[index];

            if(maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }

            if(maxEndingHere < 0) {
                maxEndingHere = 0;
            }

        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] testData1 = new int[]{1, -4, 7, 2};
        int[] testData2 = new int[]{-1, 2, -1};
        int[] testData3 = new int[]{-1, 2, 3, 3, -2, 4, 5, -1};

        System.out.println(bruteForce(testData3));
        System.out.println(kadaneAlgo(testData3));
    }
}
