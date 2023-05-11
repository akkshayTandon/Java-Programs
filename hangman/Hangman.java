package hangman;

import java.util.Random;
import java.util.Scanner;

/**
 * Hangman : 
 *          program starts here, contains the main method
 *          ASSUMPTION : number of guesses given to the user is equal to the length of the word generated
 */
public class Hangman {
    public static void main(String[] args) {
        Logic l = new Logic();
        l.menu();
    }
}

/**
 * Logic
 */
class Logic {
 static final String[] COLOURS_ARRAY = {
    "Amber","Apricot","Aqua","Azure","Black","Blue","Bronze","Brown","Cobalt","Cream","Crimson","Cyan","Denim","Ecru","Gold","Grey","Ivory","Jade","Lemon","Mauve","Mustard","Olive","Orange","Peach","Puce","Pink","Red","Rose","Ruby","Silver","Scarlet","Tan","Violet","White"
};

//function that generates a random colour from COLOURS_ARRAY, takes the guess of letter guessed by user and at last compares the generated word with the word guessed by user, if both words match user wins else HANGED!
public void generator() {
    Random r = new Random();
    String generatedWord = COLOURS_ARRAY[r.nextInt(COLOURS_ARRAY.length)].toLowerCase();
    final int MAX_ATTEMPTS = generatedWord.length(); 
   
    String secretString = "";
    for (int i = 0; i < generatedWord.length(); i++) {
        secretString += "*";
    }

    Scanner sc = new Scanner(System.in);
    int letterPosition;
    char userGuess;
    String updateSecretString;
    int attempts = MAX_ATTEMPTS;

    clearScreen();
    do{
        clearScreen();
        // System.out.println("\n\tGenerated Word : " + generatedWord);
        System.out.println("\n\tColour : " + secretString);
        System.out.println("\n\tATTEMPTS LEFT : " + attempts);
        System.out.print("\n\tYour guess : "); userGuess = sc.next().charAt(0);

        letterPosition = generatedWord.indexOf(userGuess);
        updateSecretString = updateString(secretString,userGuess,letterPosition);

        secretString = new String(updateSecretString);
        attempts = attempts - 1;
    }while(attempts > 0);
    
    clearScreen();
    System.out.println("\n\tColour : " + secretString);
    System.out.println("\n\tYour guess : " + userGuess);
    
    if( secretString.equals(generatedWord) ) {
        System.out.println("\n\tCONGRATULATIONS!! YOU GUESSED IT RIGHT.");
        System.out.println("\n\n PRESS 'E/e' and enter TO RETURN TO MAIN MENU !! ");
            if( sc.next().charAt(0) == 'e' || sc.next().charAt(0) == 'E' ) {
                clearScreen();
                menu();
            }
    } else {
        System.out.println("\n\tSorry!! You lose, you are hanged!");
        System.out.println("\n\tThe correct word was : " + generatedWord);
        hanged();
        System.out.println("\n\n PRESS 'E/e' and enter TO RETURN TO MAIN MENU !! ");
            if( sc.next().charAt(0) == 'e' || sc.next().charAt(0) == 'E' ) {
                clearScreen();
                menu();
            }
    }
    sc.close();
}

//function to replace a character at a specified index in the string
String updateString(String str, char charToReplace, int index) {
    char[] arr = str.toCharArray();
    for (int i = 0; i < arr.length; i++) {
        if(i == index) arr[i] = charToReplace;
    }
    return new String(arr);
}

//function to clear screen
public void clearScreen() {
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}

//printing the hanged man on losing game
void hanged() {
    System.out.println(" _______");
    System.out.println("|      |");
    System.out.println("|      O");
    System.out.println("|     \\|/");
    System.out.println("|      |");
    System.out.println("|     / \\");
    System.out.println("|_______");
}

//prints HANGMAN
void hangman() {
    System.out.println("||   ||  //\\\\  ||\\    || ||-----   ||\\    /||  //\\\\  ||\\    ||");
    System.out.println("||   || ||  || || \\   || ||        || \\  / || ||  || || \\   ||");
    System.out.println("||===|| ||==|| ||  \\  || ||        ||  \\/  || ||==|| ||  \\  ||");
    System.out.println("||   || ||  || ||   \\ || ||  ---|| ||      || ||  || ||   \\ ||");
    System.out.println("||   || ||  || ||    \\|| ||_____|| ||      || ||  || ||    \\||");
    System.out.println("=================================================================");
}

//function for main menu
public void menu() {
        char choice; 
        Scanner sc = new Scanner(System.in);

        do {

            hangman();
            
            System.out.println("1. PLAY");
            System.out.println("2. EXIT");
            System.out.println("    ENTER YOUR CHOICE : "); choice = sc.next().charAt(0);

            switch(choice) {
                case '1' : 
                        generator();
                        break;
                case '2' : 
                        System.exit(0);
                        break;
                default: System.out.println("\n\nINVALID CHOICE!!");
            }
        }while( choice != '2' );
        sc.close();
    }
}
