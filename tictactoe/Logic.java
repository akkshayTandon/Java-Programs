package tictactoe;

import java.util.Scanner;

/**
 * Logic :
 *      class Logic is implementing interface Menu
 *      methods containing the working of game
 */
public class Logic implements Menu{
   private int player; // player variable to store palyer number (i.e 1 or 2)
   
   //constructor of logic class
    public Logic(int p) {
        this.setPlayer(p);
    }

    //getter method to get player number
    public int getPlayer() {
        return player;
    }

    //setter method to get player number
    public void setPlayer(int player) {
        this.player = player;
    }

    //fucntion to print tic-tac-toe
    @Override
    public void tictactoe() {
        System.out.printf("    ==== ==== ====    ====   //\\\\     ====    ====  ====  ====\n");
        System.out.printf("     ||   ||  |        ||   ||   ||   |        ||   |  |  |\n");
        System.out.printf("     ||   ||  |   ---  ||   ||===||   |   ---  ||   |  |  |===\n");
        System.out.printf("     ||   ||  |        ||   ||   ||   |        ||   |  |  |\n");
        System.out.printf("     ||  ==== ====     ||   ||   ||   ====     ||   ====  |====\n");
        System.out.printf("=====================================================================\n"); 
    }

    //menu method to print main menu
    @Override
    public void  menu() {
        char choice; 
        Scanner sc = new Scanner(System.in);

        do {

            tictactoe();
            
            System.out.println("1. PLAY");
            System.out.println("2. EXIT");
            System.out.println("    ENTER YOUR CHOICE : "); choice = sc.next().charAt(0);

            switch(choice) {
                case '1' : 
                        game(this);
                        break;
                case '2' : 
                        System.exit(0);
                        break;
                default: System.out.println("\n\nINVALID CHOICE!!");
            }
        }while( choice != '2' );
        sc.close();
    }

    //method to print and update board with the mark of player( 'X' or 'O' )
    @Override
    public void board(char[] board) {

        System.out.printf("    |    |    \n");
        System.out.printf("   %c|   %c|  %c\n",board[0],board[1],board[2]);
        System.out.printf("--------------\n");
        System.out.printf("    |    |    \n");
        System.out.printf("   %c|   %c|  %c\n",board[3],board[4],board[5]);
        System.out.printf("--------------\n");
        System.out.printf("    |    |    \n");
        System.out.printf("   %c|   %c|  %c\n",board[6],board[7],board[8]);

    }

    //function to check the winner after each update on board
    public int checkwin(char[] square) {
        if( square[0]==square[1] && square[1]==square[2])
       return 1;
    else if( square[3]==square[4] && square[4]==square[5])
       return 1;
    else if( square[6]==square[7] && square[7]==square[8])
       return 1;
    else if( square[0]==square[3] && square[3]==square[6])
       return 1;
    else if( square[1]==square[4] && square[4]==square[7])
       return 1;
    else if( square[2]==square[5] && square[5]==square[8])
       return 1;
    else if( square[0]==square[4] && square[4]==square[8])
       return 1;
    else if( square[2]==square[4] && square[4]==square[6])
       return 1;
    else if ( square[0]!='1' && square[1]!='2' && square[2]!='3' && square[3]!='4' && square[4]!='5' &&
              square[5]!='6' && square[6]!='7' && square[7]!='8' && square[8]!='9')
       return -1;
    else
       return 0;
    }

    //function for logic of game (game starts here)
    public void game(Logic logic) {
        char[] sq = {'1','2','3','4','5','6','7','8','9'};

        setPlayer(1); int choice, ch; char mark;
        Scanner sc = new Scanner(System.in);


        do{
            setPlayer((( getPlayer() %2 ) == 1) ? 1 : 2);
            mark = (getPlayer() == 1) ? 'X' : 'O';


            clearScreen();
            board(sq);
            System.out.print("\nPlayer " + getPlayer() + " ("+ mark + ") "+"enter box number : ");
            choice = sc.nextInt();

            if( (getPlayer()==1) && ( choice==1 || choice==2 || choice==3 || choice==4 || choice==5 ||
                                 choice==6 || choice==7 || choice==8 || choice==9 ) )
                    sq[choice-1] = mark;
            if( (getPlayer()==2) && ( choice==1 || choice==2 || choice==3 || choice==4 || choice==5 ||
                                 choice==6 || choice==7 || choice==8 || choice==9 ) )
                    sq[choice-1] = mark;
            
            
            ch = checkwin(sq);
            setPlayer(getPlayer() + 1);

            if(ch == -1) break;

        } while(ch == 0);

        if( ch == 1 ) {
            System.out.println("\n      Congratulations player " + (getPlayer()-1) + " . You Win!!");
            System.out.println("\n\n PRESS 'E/e' and enter TO RETURN TO MAIN MENU !! ");
            if( sc.next().charAt(0) == 'e' || sc.next().charAt(0) == 'E' ) {
                clearScreen();
                logic.menu();
            }
        }

        if( ch == -1 ) {
            System.out.println("\n Game Draw!! " );
            System.out.println("\n\n PRESS 'E/e' and enter TO RETURN TO MAIN MENU !! ");
            if( sc.next().charAt(0) == 'e' || sc.next().charAt(0) == 'E' ){
                clearScreen();
                logic.menu();
            }
        }
        sc.close(); 
    }

    //function to clear screen
    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
}
