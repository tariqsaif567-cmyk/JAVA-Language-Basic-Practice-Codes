package Snake;
import  javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class GamePanel extends JPanel{

    public GamePanel(){
        this.setBackground(Color.black);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(50, 50, 25, 25);
    }
    
}
