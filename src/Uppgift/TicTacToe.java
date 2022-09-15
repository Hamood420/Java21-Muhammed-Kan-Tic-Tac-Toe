package Uppgift ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	
    static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
    printGameBoard(gameBoard);

    while(true) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your placement (1-9):");
        int playerPos = scan.nextInt();
        int playerPos2 = scan.nextInt();
        while(player1Positions.contains(playerPos) || player2Positions.contains(playerPos2)) {
            System.out.println("Position taken! Enter a correct Position");
            playerPos = scan.nextInt();
            playerPos2 = scan.nextInt();
        }

        placePiece(gameBoard, playerPos, "player1");
        String result = checkWinner();
        if (result.length() > 0) {
            System.out.println(result);
            break;
        }
        
       
        placePiece(gameBoard, playerPos2, "player2");
        printGameBoard(gameBoard);
        result = checkWinner();
        if (result.length() > 0) {
            System.out.println(result);
            break;
        }
        
    }

    }

    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row : gameBoard) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';

        if(user.equals("player1")) {
            symbol = 'X';
            player1Positions.add(pos);
        } else if (user.equals("player2")) {
            symbol = 'O';
            player2Positions.add(pos);
        }

        switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    public static String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8,9);
        List leftCol = Arrays.asList(1, 2, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        List<List> winConditions = new ArrayList<List>();
        winConditions.add(topRow);
        winConditions.add(midRow);
        winConditions.add(botRow);
        winConditions.add(leftCol);
        winConditions.add(midCol);
        winConditions.add(rightCol);
        winConditions.add(cross1);
        winConditions.add(cross2);

        for(List l : winConditions){
            if(player1Positions.containsAll(l)) {
                return "Congratulations Player1 won!";
            } else if (player1Positions.containsAll(l)) {
                return "Congratulations Player2 won";
            } else if (player2Positions.size() + player1Positions.size() == 9) {
                return "DRAW";
            }
        }
 
        return "";   
    }
}
