import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] gameBoard = { 
            {' ', '|', ' ', '|', ' '},
            {'_',  '+', '_', '+', '_'},
            {' ', '|', ' ', '|', ' '},
            {'_',  '+', '_', '+', '_'},
            {' ', '|', ' ', '|', ' '}
        };       
       
        int playerTurns = 0;
        while (true){
            printGameBoard(gameBoard); /* Player 1 turn */
            System.out.println("Player 1, where will you place your X? (1 - 9)");           
            int boardSpace = Integer.valueOf(s.nextInt());                     
            placePiece(gameBoard, boardSpace, 'X');
            if (checkRow(gameBoard,'X') || checkColumn(gameBoard, 'X')|| checkDiag(gameBoard, 'X')){
                System.out.println("The Winner is Player 1!");
                printGameBoard(gameBoard);
                break;
            } 
            playerTurns++;
            if (playerTurns >= 9){
                System.out.println("The game is a draw!");
                printGameBoard(gameBoard);
                break;
            }
            printGameBoard(gameBoard); /* Player 2 turn */         
            System.out.println("Player 2, where will you place your O? (1 - 9)");
            boardSpace = Integer.valueOf(s.nextInt());
            placePiece(gameBoard, boardSpace, 'O');
            if (checkRow(gameBoard,'O') || checkColumn(gameBoard, 'O') || checkDiag(gameBoard, 'O')){
                System.out.println("The Winner is Player 2!");
                printGameBoard(gameBoard);
                break;
            }                   
            playerTurns++;
        }
        s.close();
    }
    
    public static void printGameBoard(char[][] gameBoard){   /* print Game Board to console */
        for (char[] iterable_element : gameBoard) {   
            System.out.println(iterable_element); 
        }
        System.out.println(); 
    }
    public static void placePiece(char[][] gameBoard, int boardSpace, char gamePiece){
            switch (boardSpace) {
            case 1:
                gameBoard[0][0] = gamePiece;
                break;
            case 2:
                gameBoard[0][2] = gamePiece;
                break;
            case 3:
                gameBoard[0][4] = gamePiece;
                break;
            case 4:
                gameBoard[2][0] = gamePiece;
                break;
            case 5:
                gameBoard[2][2] = gamePiece;
                break;
            case 6:
                gameBoard[2][4] = gamePiece;
                break;
            case 7:
                gameBoard[4][0] = gamePiece;
                break;
            case 8:
                gameBoard[4][2] = gamePiece;
                break;
            case 9:
                gameBoard[4][4] = gamePiece;
                break;                
            default:
                System.out.println("Invalid entry!");
                break;
            }       
    }

    public static boolean checkRow(char[][] TWODarray, char gamePiece){ /* boolean method to check if all elements of a row contain gamePiece */
        int gamePieceCount = 0;
        for (int j = 0; j < 5; j++) {        // for loop to iterate through rows
            gamePieceCount = 0;
            for (int i = 0; i < 5; i++) {    // for loop to iterate through elements of rows
                if (TWODarray[j][i] == gamePiece){
                    gamePieceCount++;
                    if (gamePieceCount == 3){
                        return true;        
                    }
                }
            }           
        } 
        return false;       
    }
    public static boolean checkColumn(char[][] TWODarray, char gamePiece){ /* boolean method to check if all elements of a column contain gamePiece */
        int gamePieceCount = 0;
        for (int j = 0; j < 5; j++) {        // for loop to iterate through columns
            gamePieceCount = 0;
            for (int i = 0; i < 5; i++) {    // for loop to iterate through elements of columns
                if (TWODarray[i][j] == gamePiece){
                    gamePieceCount++;
                    if (gamePieceCount == 3){
                        return true;        
                    }
                }
            }           
        } 
        return false;       
    }
    public static boolean checkDiag(char[][] TWODarray, char gamePiece){
        if (TWODarray[0][0] == gamePiece && TWODarray[2][2] == gamePiece && TWODarray[4][4] == gamePiece){
            return true;
        } else if (TWODarray[0][4] == gamePiece && TWODarray[2][2] == gamePiece && TWODarray[4][0] == gamePiece){
            return true;
        } 
        return false;
    }
}  