package codechef.decemberchallenge;

import java.util.Scanner;

public class CHFINTRO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int r = scanner.nextInt();

        while (N-- > 0) {
            if(scanner.nextInt() < r) {
                System.out.println("Bad boi");
            }
            else {
                System.out.println("Good boi");
            }
        }
    }
}
