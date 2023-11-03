import java.util.*;

public class NumberGuessingGame {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Random rand = new Random();
        System.out.println(
                "Game Instruction \n guess any number from 0 to 5 \n if your number match the generated randome number then you got score +4 other than your score less -1 \n if you give correct answer your limit increase +1 other than decrease -1 \n i give to you already maximum limit is 5.");
        int limit = 5;
        int score = 0;
        boolean answer = true;
        while (limit > 0) {
            int randnum = rand.nextInt(5);
            System.out.print("Enter the guess number :");
            int gnum = s.nextInt();
            if (gnum == randnum) {
                score += 4;
                limit++;
            } else {
                answer = false;
                limit--;
                if (score > 0) {
                    score--;
                }
            }
            System.out.println("your answer is " + answer);
            System.out.println("Your current score is :" + score);
            System.out.println("The correct answer is :" + randnum);
            System.out.println("number of attempt left is:" + limit);
            answer = true;
        }
        System.out.println("Your final Score is:" + score);
    }
}
