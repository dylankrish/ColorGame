import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameGUI implements ActionListener {

    public gameGUI() {
        int X = 5;
        int Y = 5;
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel(); //a new panel to hold all of the buttons on the game board.
        JButton[][] lightButtons;
        lightButtons = new JButton[X][Y]; //creates a new two dimensional array that will hold 25 buttons.
        buttonPanel.setLayout(new GridLayout(X,Y));
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new java.awt.GridLayout(X, Y));
        int randomRed = randomRGB();
        int randomGreen = randomRGB();
        int randomBlue = randomRGB();
        System.out.println(randomRed + " " + randomGreen + " " + randomBlue);
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                JButton btn = new JButton();
                lightButtons[i][j] = btn;
                btn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                btn.setBackground(new Color(randomRed, randomGreen, randomBlue));
                btn.setOpaque(true);
                btn.setBorderPainted(false);
                contentPane.add(btn);
            }
        }
        frame.add(contentPane);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(panel);

    }
    public int randomRGB() {
        return (int)(Math.random() * 255);
    }
    public int variationRGB(int color) {
        // choose a random number between 5 and 10
        int random = (int)(Math.random() * 5) + 5;
        // add or subtract that number from the color
        // choose a random number between 0 and 1
        int random2 = (int)(Math.random() * 2);
        if (random2 == 1) {
            return(color + random);
        } else {
            return(color - random);
        }
        // return (int)(Math.random() * color);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
    }
}
