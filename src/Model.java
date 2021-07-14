import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    char currentSymbol;
    char[][] board;
    int moveCounter;
    int maxNumberOfMove;
    int dimension;
    boolean win;
    Random random = new Random();

    public Model(int dimension) {
        this.dimension=dimension;
        this.currentSymbol = 'X';
        this.board = new char[dimension][dimension];
        this.moveCounter = 0;
        this.maxNumberOfMove=dimension*dimension;
        this.win=false;
        for( int row = 0; row < dimension; row++) {

            for( int column = 0; column < dimension; column++) {
                board[row][column]=' ';
            }

        }
    }
    private boolean checkSlant1 (char[][] board, char symbol){
        int dimension = board.length;
        for( int i = 0; i < dimension; i++) {
            if ( board[i][i] != symbol ) {
                return false;
            }
        }
        return true;
    }
    private boolean checkColumns (char[][] board, char symbol){
        int dimension = board.length;
        for( int column = 0; column < dimension; column++) {
            boolean win = true;
            for( int row = 0; row < dimension; row++) {
                if ( board[row][column] != symbol ) {
                    win = false;
                    break;
                }
            }
            if ( win ) { return true;}
        }

        return false;
    }
    private boolean checkRows (char[][] board, char symbol){
        int dimension = board.length;
        for( int row = 0; row < dimension; row++) {
            boolean win = true;
            for( int column = 0; column < dimension; column++) {
                if ( board[row][column] != symbol ) {
                    win = false;
                    break;
                }
            }
            if ( win ) { return true;}
        }

        return false;
    }
    public boolean makeAMove(int row,int column) {

        boolean correctMove = board[row][column] == ' ';
        if (correctMove) {
            board[row][column] = currentSymbol;
            moveCounter++;
            win=isWin();
            switchPlayer();
            return true;
        } else {
            return false;
        }
    }
    private void switchPlayer(){
        if(currentSymbol == 'X' ){
            currentSymbol='O';
        }
        else{
            currentSymbol='X';
        }
    }
    public Point computerMove(){
        List<Point> points = new ArrayList<>();
        for( int row = 0; row < dimension; row++) {

            for( int column = 0; column < dimension; column++) {
                if ( board[row][column] == ' ' ) {
                    Point p = new Point(column,row);
                    points.add(p);
                }
            }

        }
        return points.get(random.nextInt(points.size()));
    }

    public char getCurrentSymbol() {
        return currentSymbol;
    }
    private boolean isWin(){
        boolean rowsWon = checkRows(board,currentSymbol);
        boolean columnsWon = checkColumns(board,currentSymbol);
        boolean slant1Won = checkSlant1(board,currentSymbol);
        return columnsWon || rowsWon || slant1Won;
    }
    public boolean orContinue(){
        return moveCounter<maxNumberOfMove&&!isWin();
    }
    public char getField(int row,int column){
        return board[row][column];
    }

    public int getDimension() {
        return dimension;
    }

    public boolean isWon() {
        return win;
    }
}
