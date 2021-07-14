import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {
    int x;
    int y;
    int stan;
    Model model;
    Board board;

    public Button(int x, int y, Model model, Board board) {
        super();
        this.x = x;
        this.y = y;
        this.model=model;
        this.board=board;
        stan=0;
        addActionListener(this);

        //this.setText("o");
        this.setFont(new Font("Arial", Font.PLAIN, 150));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        runButton();
        board.userFinishMove();
    }
    public void runButton(){
        char currentSymbol=model.getCurrentSymbol();
        System.out.println("currentSymbol="+currentSymbol);
        model.makeAMove(y,x);
        if(currentSymbol=='X'){
            //stan=1;
            //System.out.println("ustawiam stan "+ stan);
            this.setText("x");
            this.setEnabled(false);
        }
        else{
            this.setText("o");
            this.setEnabled(false);
            //stan=2;
            //System.out.println("ustawiam stan "+ stan);
        }
        //  repaint();
        // printShape();
    }



   /* @Override
    public void paint(Graphics g) {
        super.paint(g);

        printShape();
    }
    private void printShape(){

        if(stan == 1)
        {
            Graphics graphics = this.getGraphics();
            graphics.drawLine(0, 0, 180, 180);
            graphics.drawLine(180, 0, 0, 180);
        }
        else if(stan==2)
        {
            Graphics graphics = this.getGraphics();
            graphics.drawOval(10, 10, 160, 160);
        }


    }*/

}
