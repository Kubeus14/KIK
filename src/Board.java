import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    int size;
    Button buttons [][];
    Model model;
    public Board(int size, Model model) {
        this.size=size;
        this.buttons=new Button[3][3];
        this.model=model;
        this.setTitle("Game");

        this.setSize(size*200,size*200);
        GridLayout layout = new GridLayout(3,3);
        this.setLayout(layout);
        this.addButton(0,0,model);
        this.addButton(1,0,model);
        this.addButton(2,0,model);
        this.addButton(0,1,model);
        this.addButton(1,1,model);
        this.addButton(2,1,model);
        this.addButton(0,2,model);
        this.addButton(1,2,model);
        this.addButton(2,2,model);
        //layout.addLayoutComponent("b1",new JButton("x"));
        //layout.addLayoutComponent("b2",new JButton("x"));
        //layout.addLayoutComponent("b3",new JButton("x"));
        //layout.addLayoutComponent("b4",new JButton("x"));
        //layout.addLayoutComponent("b5",new JButton("x"));
        setVisible(true);
    }
    private void addButton(int x, int y, Model model){
        Button button = new Button(x,y,model,this);
        this.add(button);
        buttons[y][x]=button;
    }
    public void userFinishMove(){
        if(model.isWon()){
            JOptionPane.showMessageDialog(this, "Krzyżyk wygrał");
        }
        else if(!model.orContinue()){
            JOptionPane.showMessageDialog(this, "Remis");
        }
        else{
            Point p = model.computerMove();
            System.out.println("ruch komputera: x="+p.x+" y="+p.y);

            buttons[p.y][p.x].runButton();
            if(model.isWon()){
                JOptionPane.showMessageDialog(this, "Kółko wygrało");
            }
            else if(!model.orContinue()){
                JOptionPane.showMessageDialog(this, "Remis");
            }
        }
    }


}
