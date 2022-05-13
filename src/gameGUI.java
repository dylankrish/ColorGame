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
        JPanel buttonPanel = new JPanel();//a new panel to hold all of the //buttons on the game board.
        JButton[][] lightButtons;
        lightButtons = new JButton[X][Y]; //creates a new two dimensional //ray that will hold 25 buttons.
        buttonPanel.setLayout(new GridLayout(X,Y));
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new java.awt.GridLayout(X, Y));

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                JButton btn = new JButton();
                lightButtons[i][j] = btn;
                btn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                btn.setBackground(new Color(0, 255, 168));
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
