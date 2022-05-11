package finalExamCode;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class newGameOfLight implements ActionListener {
	public newGameOfLight() {
		final int X = 5;
		final int Y = 5;
		JFrame frame = new JFrame();
		JPanel buttonPanel = new JPanel();//a new panel to hold all of the //buttons on the game board.
		JButton[][] lightButtons;
		lightButtons = new JButton[X][Y]; //creates a new two dimensional //ray that will hold 25 buttons.
		buttonPanel.setLayout(new GridLayout(X,Y));
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new java.awt.GridLayout(X, Y));

		for (int i = 0; i < X; i++){
			for(int j = 0; j < Y; j++) {
				JButton btn = new JButton();
				lightButtons[i][j] = btn;
				btn.addActionListener(
						new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String eventName = e.getActionCommand();
							}
						});
			    //btn.setBorder(BorderFactory.createLineBorder(Color.blue)); // sets border color
				//btn.setBackground(Color.pink); // sets background color
				contentPane.add(btn);
				
			}
		}
		frame.add(contentPane);
		frame.setSize(400,400);
		frame.setVisible(true);
	}

	/**
	 * Create and show the GUI.
	 */
	private static void runGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);

		newGameOfLight playLife = new newGameOfLight();
	}
	public static void main(String[] args) {
		/* Methods that create and show a GUI should be
       run from an event-dispatching thread */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
