import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class wordleGame {
    public static void guess (String word){
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Wordle!");
        System.out.println("Not in the word: blank\tWrong place: ^\tCorrect place: *");
        List<List<String>> wordList = new ArrayList<>();
        for (int i=0; i<6; i++){
            wordList.add(new ArrayList<>());
        }
        int underscores_row_num = 6;
        int row_tracker = 1;

        // underlines score
        while (true){
            // underlines
            for (int i = 0; i < underscores_row_num; i++){
                for (int j=0; j<5; j++){
                    System.out.print("_ ");
                }
                System.out.println();
            }
            // guessing word
            System.out.print("Enter Word: ");
            String user_input = s.nextLine();
            if (user_input.length() < 5 || user_input.length() > 5){
                System.out.println("You word should be 5 letters, try again.");
            }
            else {
                underscores_row_num--;
                for (int i=0; i<row_tracker; i++) {
                    List<String> row = wordList.get(i);
                    for (int j = 0; j < user_input.length(); j++){
                        String letter = user_input.substring(j, j+1);
                        row.add(letter);
                    }
                    for (int x = 0; x < 5; x ++){
                        if (row.get(x).equals(word.substring(x, x+1))){
                            System.out.print(row.get(x)+"* ");
                        }
                        else if (word.contains(row.get(x))){
                            System.out.print(row.get(x)+"^ ");
                        }
                        else {
                            System.out.print(row.get(x)+" ");
                        }
                    }
                    System.out.println();
                }
                row_tracker++;
                if (user_input.equals(word)){
                    System.out.println("You got it! The word is "+word);
                    break;
                }
                else if (row_tracker == 7){
                    System.out.println("You lose, the word is "+ word);
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        guess("teens");
    }
}
