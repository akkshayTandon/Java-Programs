package tictactoe;

/**
 * Main :
 *      Main class (inheriting from Logic class ), program starts from here,
 *      Assumption - the game starts with player 1;
 */

public class Main extends Logic{

    //constructor of main class
    public Main(int player) {
        super(player);
    }

    //main method 
    public static void main(String[] args) {
        Main main =  new Main(1);
        main.menu();
    }
}
