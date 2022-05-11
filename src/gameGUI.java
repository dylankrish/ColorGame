import javax.swing.*;

public class gameGUI {
    private JFrame frame;
    private JPanel panel;

    public gameGUI() {
        frame = new JFrame();
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(panel);

    }
}
