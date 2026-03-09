package Snake;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() {
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(600, 600);
        this.add(new GamePanel());
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
