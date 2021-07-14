import java.util.Scanner;

public class TicTacToe {
    static Scanner scanner;
    static Model model;
    public static void main(String[] args) {

        scanner=new Scanner(System.in);
        System.out.println("Welcome to the game, please enter the size of the board");
        int dimension = 3;
        model = new Model(dimension);
        Board board = new Board(dimension,model);

        while(model.orContinue()){
            TicTacToe.printBoard();
            makeAMove();
            if(model.isWon()){
                System.out.println("Victory");
            }
        }
        System.out.println("End of the game");
    }

    public static void makeAMove() {
        System.out.println(model.getCurrentSymbol() + " your turn");
        System.out.println("Enter the index of the row");
        int row = scanner.nextInt();
        System.out.println("Enter the index of the column");
        int column = scanner.nextInt();
        boolean correctMove = model.makeAMove(row,column);
        if(!correctMove) {
            System.out.println("Incorrect move");
        }
    }

    public static void printBoard() {
        int dimension = model.getDimension();
        // column headers
        System.out.print("\t");
        // loop that prints the column headers
        for (int i = 0; i < dimension; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        // rows printing
        for (int row = 0; row < dimension; row++) {
            System.out.print(row + ":\t");
            for (int column = 0; column < dimension; column++) {
                System.out.print(model.getField(row,column) +"\t");
            }
            System.out.println();
        }
    }
}
