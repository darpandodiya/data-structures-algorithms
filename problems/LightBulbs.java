package problems;

public class LightBulbs {
    public int solution(int A[]) {
        int i = 100000;

        long ilong = (long) i;
        long sum = (ilong * ilong-1)/2;

        System.out.println(sum);

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LightBulbs().solution(new int[] {2, 3, 4, 1, 5}));
    }
}
