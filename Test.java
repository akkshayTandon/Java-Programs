import java.util.Random;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        /*for result generator */
        // Root r = new Root();
        // r.input();

        /*for rock-paper-scissor */
        Rcs r = new Rcs();
        // r.game();
        r.menu();
    }
}
    /*Result generator */
// class Root{
//     int numOfSubjects;
//     String nameOfSubject;
//     void input(){
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number of subjects : "); numOfSubjects = sc.nextInt();
//         sc.nextLine();
//         String[] subjects = new String[numOfSubjects];
//         for(int i = 0; i < numOfSubjects; i++){
//             System.out.println("Enter the name of subject : ");
//             nameOfSubject = sc.nextLine();
//             subjects[i] = nameOfSubject;
//         }
//         sc.close();
//     }
// }

    /* ROCK - PAPER - SCISSOR */
class Rcs{
    void game(){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("\nEnter 1 for rock, 2 for paper and 3 for for scissor");
        int userInput = sc.nextInt();
        int computerInput = random.nextInt(3) + 1;
        // computerInput += 1;
        System.out.println("user : " + userInput + " and computer : " + computerInput );
        String result = checkwin(userInput, computerInput);
        // System.out.println(result);
        if(result == "User") System.out.println("You chose " + getInput(userInput) + " and computer chose " + getInput(computerInput) + " Result : " + result + " wins.");
        if(result == "Computer") System.out.println("You chose " + getInput(userInput) + " and computer chose " + getInput(computerInput) + " Result : " + result + " wins.");
        if(result == "Draw") System.out.println("Game Draw.");
        System.out.println("\n\tPress 'e'/'E' to return to the main menu");
        char c = sc.next().charAt(0);
        if(c == 'e' || c == 'E') menu();
        sc.close();
    }
    
    String checkwin(int uInput, int cInput){
        if ( uInput == cInput ) return "Draw";
        else if( (uInput == 1 && cInput == 2) ) return "Computer";
        else if( (uInput == 1 && cInput == 3) ) return "User";
        else if( (uInput == 2 && cInput == 1) ) return "User";
        else if( (uInput == 2 && cInput == 3) ) return "Computer";
        else if( (uInput == 3 && cInput == 1) ) return "Computer";
        else if( (uInput == 3 && cInput == 2) ) return "User";
        else return "invalid";
    }

    String getInput(int choice) {
        if( choice == 1 ) return "ROCK";
        else if ( choice == 2 ) return "PAPER";
        else if(  choice == 3 ) return "SCISSOR";
        else return "invalid";
    }

    void menu(){
        Scanner sc = new Scanner(System.in);
        char ch;
        do {
            System.out.println("\n\tROCk-PAPER-SCISSOR");
            System.out.println("-----------------------");
            System.out.println(" 1.Play");
            System.out.println(" 2.Exit");
            System.out.print("\n\tEnter your choice : "); ch = sc.next().charAt(0);

            switch (ch) {
                case '1':
                    game();
                    break;
                case '2':
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n\tINVALID CHOICE!!");
                    break;
            }
        } while (ch != '2');
        sc.close();
    }
}
