package problems;

public class NoOfSteps {
    public int solution(String s) {
        int decimalValue = Integer.parseInt(s, 2);
        int noOfSteps = 0;

        while(decimalValue != 0) {
            //even
            if(decimalValue % 2 == 0) {
                decimalValue = decimalValue/2;
            }
            //odd
            else {
                decimalValue--;
            }
            noOfSteps++;
        }


        return noOfSteps;
    }

    public static void main(String[] args) {
        System.out.println(new NoOfSteps().solution("011100"));
    }
}
