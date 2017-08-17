import java.util.Scanner;

/**
 * Created by buyss025 on 10/3/2016.
 */
public class BattleshipBoard {
    private static int width;
    private static int height;
    private static String[][] board;
    private int turns; //needed to count turns
    private boolean debug; //needed to use debug mode

    public BattleshipBoard(int m, int n) {
        //Sets up board and makes turns = 0
        width = m;
        height = n;
        turns = 0;
    }

    public int BoardSetUp() {
        int x = 0;
        //Check to see if the width and height are within bound
        if (width <= 10 && height <= 10 && width >= 2 && height >= 2) {
            board = new String[width][height];
            x = 1;

        } else {
            //Lets you know if you have incorrect dimensions
            System.out.println("Error. Incorrect Board Dimensions.");
            System.out.println("Board can be 2*2 up to 10*10");
            x = -1;
        }
        return x;
    }

    public void ships() {
        int[] shipArray = new int[1];

        /*The next 5 if statments are used to keep track of how many ships are
        needed and what types of ships are needed*/

        if (width == 2 || height == 2) {
            shipArray = new int[1];
            shipArray[0] = 2;
        }
        if (width > 2 || height > 2) {
            if (width <= 4 || height <= 4) {
                shipArray = new int[2];
                shipArray[0] = 2;
                int x1 = (int) Math.floor(Math.random());
                int y1 = (int) Math.floor(Math.random());
                board[x1][y1] = "s";

                shipArray[1] = 3;
            }
        }
        if (width > 4 || height > 4) {
            if (width <= 6 || height <= 6) {
                shipArray = new int[3];
                shipArray[0] = 2;
                shipArray[1] = 3;
                shipArray[2] = 3;
            }
        }
        if (width > 6 || height > 6) {
            if (width <= 8 || height <= 8) {
                shipArray = new int[4];
                shipArray[0] = 2;
                shipArray[1] = 3;
                shipArray[2] = 3;
                shipArray[3] = 4;
            }
        }
        if (width > 8 || height > 8) {
            if (width <= 10 || height <= 10) {
                shipArray = new int[5];
                shipArray[0] = 2;
                shipArray[1] = 3;
                shipArray[2] = 3;
                shipArray[3] = 4;
                shipArray[4] = 5;
            }
        }
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                board[i][j] = "m";
            }
        }
        for (int i = 0; i < shipArray.length; i++) {
            //Next 4 if statements set the ships on the board
            if (shipArray[i] == 2) {
                int x1 = (int) Math.floor(Math.random()) % board.length;
                int y1 = (int) Math.floor(Math.random()) % board[0].length;
                while(board[x1][y1].equals("s")){ //Checks to make sure the first point does not already have a ship
                    x1 = (int) Math.floor(Math.random()) % board.length;
                    y1 = (int) Math.floor(Math.random()) % board[0].length;
                    if(board[x1][y1] != "s"){
                        break;
                    }
                }
                //Checks to make sure the next points are also not occupied by a ship
                while(board[x1+1][y1].equals("s") || board[x1][y1+1].equals("s")){
                    x1 = (int) Math.floor(Math.random()) % board.length;
                    y1 = (int) Math.floor(Math.random()) % board[0].length;
                    if(board[x1+1][y1] != "s" || board[x1][y1+1] != "s"){
                        break;
                    }
                }
                int r = (int) Math.ceil(Math.random());
                int x2 = 0;
                int y2 = 0;
                //Uses r to get next point without going diagonal
                if (r == 0) {
                    x2 = x1;
                    y2 = y1 + 1;
                } else {
                    x2 = x1 + 1;
                    y2 = y1;
                }
                board[x1][y1] = "s";
                board[x2][y2] = "s";
            }
            if (shipArray[i] == 3) {
                int x1 = (int) Math.floor((board.length - 1) * Math.random());
                int y1 = (int) Math.floor((board[0].length - 1) * Math.random());
                //Checks to make sure there is not already a ship there
                while(board[x1][y1].equals("s")){
                    x1 = (int) Math.floor((board.length - 1) * Math.random());
                    y1 = (int) Math.floor((board[0].length - 1) * Math.random());
                }
                int r = (int) Math.floor(Math.random());
                int x2 = 0;
                int x3 = 0;
                int y2 = 0;
                int y3 = 0;
                if (r == 0) {
                    x2 = x1;
                    x3 = x1;
                    y2 = y1 + 1;
                    y3 = y2 + 1;
                    //Makes sure to check points so that it does not overlap
                    if(board[x2][y2].equals("s") || board[x3][y3].equals("s")){
                        x2 = x1 + 1;
                        x3 = x2 + 1;
                        y2 = y1;
                        y3 = y1;
                    }
                } else {
                    x2 = x1 + 1;
                    x3 = x2 + 1;
                    y2 = y1;
                    y3 = y1;
                    //Makes sure it doesn't overlap
                    if(board[x2][y2].equals("s") || board[x3][y3].equals("s")){
                        x2 = x1;
                        x3 = x1;
                        y2 = y1 + 1;
                        y3 = y2 + 1;
                    }
                }
                //Plots ship
                board[x1][y1] = "s";
                board[x2][y2] = "s";
                board[x3][y3] = "s";
            }
            //Same as shipArray[i] == 3 but adds the points x4 and y4
            if (shipArray[i] == 4) {
                int x1 = (int) Math.floor((board.length - 1) * Math.random());
                int y1 = (int) Math.floor((board[0].length - 1) * Math.random());
                while(board[x1][y1].equals("s")){
                    x1 = (int) Math.floor((board.length - 1) * Math.random());
                    y1 = (int) Math.floor((board[0].length - 1) * Math.random());
                }
                int r = (int) Math.floor(Math.random());
                int x2 = 0;
                int x3 = 0;
                int x4 = 0;
                int y2 = 0;
                int y3 = 0;
                int y4 = 0;
                if (r == 0) {
                    x2 = x1;
                    x3 = x1;
                    x4 = x1;
                    y2 = y1 + 1;
                    y3 = y2 + 1;
                    y4 = y3 + 1;
                    if(board[x2][y2].equals("s") || board[x3][y3].equals("s") || board[x4][y4].equals("s")){
                        x2 = x1 - 1;
                        x3 = x2 - 1;
                        x4 = x3 - 1;
                        y2 = y1;
                        y3 = y1;
                        y4 = y1;
                    }
                } else {
                    x2 = x1 + 1;
                    x3 = x2 + 1;
                    x4 = x3 + 1;
                    y2 = y1;
                    y3 = y1;
                    y4 = y1;
                    if(board[x2][y2].equals("s") || board[x3][y3].equals("s") || board[x4][y4].equals("s")){
                        x2 = x1;
                        x3 = x1;
                        x4 = x1;
                        y2 = y1 + 1;
                        y3 = y2 + 1;
                        y4 = y3 + 1;
                    }
                }
                board[x1][y1] = "s";
                board[x2][y2] = "s";
                board[x3][y3] = "s";
                board[x4][y4] = "s";
            }
            //Same as above if statements
            if(shipArray[i] == 5){
                int x1 = (int) Math.floor((board.length - 1) * Math.random());
                int y1 = (int) Math.floor((board[0].length - 1) * Math.random());
                while(board[x1][y1].equals("s")){
                    x1 = (int) Math.floor((board.length - 1) * Math.random());
                    y1 = (int) Math.floor((board[0].length - 1) * Math.random());
                }
                int r = (int) Math.floor(Math.random());
                int x2 = 0;
                int x3 = 0;
                int x4 = 0;
                int x5 = 0;
                int y2 = 0;
                int y3 = 0;
                int y4 = 0;
                int y5 = 0;
                if (r == 0) {
                    x2 = x1;
                    x3 = x1;
                    x4 = x1;
                    x5 = x1;
                    y2 = y1 + 1;
                    y3 = y2 + 1;
                    y4 = y3 + 1;
                    y5 = y4 + 1;
                    if(board[x2][y2].equals("s") || board[x3][y3].equals("s") || board[x4][y4].equals("s") || board[x5][y5].equals("s")){
                        x2 = x1 + 1;
                        x3 = x2 + 1;
                        x4 = x3 + 1;
                        x5 = x4 + 1;
                        y2 = y1;
                        y3 = y1;
                        y4 = y1;
                        y5 = y1;
                    }
                } else {
                    x2 = x1 + 1;
                    x3 = x2 + 1;
                    x4 = x3 + 1;
                    x5 = x4 + 1;
                    y2 = y1;
                    y3 = y1;
                    y4 = y1;
                    y5 = y1;
                    if(board[x2][y2].equals("s") || board[x3][y3].equals("s") || board[x4][y4].equals("s") || board[x5][y5].equals("s")){
                        x2 = x1;
                        x3 = x1;
                        x4 = x1;
                        x5 = x1;
                        y2 = y1 + 1;
                        y3 = y2 + 1;
                        y4 = y3 + 1;
                        y5 = y4 +1;
                    }
                }
                board[x1][y1] = "s";
                board[x2][y2] = "s";
                board[x3][y3] = "s";
                board[x4][y4] = "s";
                board[x5][y5] = "s";
            }
        }
        //If debug mode is on, it will print out the board after it has been made
        if(debug){
            for(int i = 0; i<board.length; i++){
                for(int j = 0; j<board[i].length; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public boolean turn(){
        boolean tf = true; //Used to see if there is a next turn
        System.out.print("Enter coordinate to check : ");
        Scanner s1 = new Scanner(System.in); //takes in coordinates like "2 2"
        int x = s1.nextInt() - 1;//board starts at (0,0) but game player will input points (1,1) and higher
        int y = s1.nextInt() - 1; //Subtract one to keep it on board
        if(board[x][y].equals("h") || x>width || y>height){
            System.out.println("Penalty");
            turns += 1;
        }
        if(board[x][y].equals("s")){
            System.out.println("Hit");
            board[x][y] = "h"; //if hit it will replace the ship with a hit
        }
        if(board[x][y].equals("m")){
            System.out.println("Miss");
        }
        //Checks to see if there are any ships left
        int z = 0;
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j].equals("s")){
                    z = -1;
                    j = board[i].length;
                    i = board.length;
                    break;
                }
                else{
                    z = 1;
                }
            }
        }
        if(z == 1){
            System.out.println("All of the ships have been sunk!");
            System.out.println("Number of turns: " + turns);
            tf = false; //Returns false to stop game
        }
        else{
            turns++;
        }
        //Prints board every turn if debug mode is on
        if(debug){
            for(int i = 0; i<board.length; i++){
                for(int j = 0; j<board[i].length; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
        return tf;

    }
    public void debugMode(){
        debug = true;
    } //Turns on debug mode if called

    public static void main(String[] args){
        System.out.print("Enter in board dimensions: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Scanner s = new Scanner(input);
        int m = s.nextInt();
        int n = s.nextInt();
        BattleshipBoard b = new BattleshipBoard(m,n);
        //Checks to see if board can be set up with given dimensions
        while(b.BoardSetUp() == -1){
            System.out.print("Enter in board dimensions: ");
            Scanner s1 = new Scanner(System.in);
            String i1 = s1.nextLine();
            Scanner s2 = new Scanner(input);
            int m2 = s2.nextInt();
            int n2 = s2.nextInt();
            b = new BattleshipBoard(m2,n2);
            //Will continue to check until board dimensions are in bounds
        }
        System.out.print("Would you like to play in Debug Mode? (y/n): ");
        scanner = new Scanner(System.in);
        input = scanner.nextLine();
        //turns on debug mode if wanted
        if(input.equals("y")){
            b.debugMode();
        }
        b.ships(); //places ships
        /*While there are still more turns to be had, the player will
        * be asked for more coordinates */
        while(b.turn()){
            b.turn();
            if(b.turn() == false){
                break;
            }
        }
    }


}
