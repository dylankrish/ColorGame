

package finalExam;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class gameGUI implements ActionListener {
	public gameGUI() {
		
//		// Message JFrame
//		String LABEL_TEXT = "GAME RULES!!!!!!!!!!!!!!! READ THIS ISH!!!!!!! ";
//		// When it clicks X game shuts down to so fix that; maybe do in main class
//		
//		JFrame frameMessage = new JFrame();
//		JPanel panelMessage = new JPanel();
//		JPanel contentPanelMessage;
//		JLabel label;
//		JLabel label2;
//		JButton button;
//		frameMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	
//		/* Create and set up the frame */
//		frameMessage = new JFrame("Message");
//		frameMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		contentPanelMessage = new JPanel();
//		contentPanelMessage.setLayout(new GridLayout(2,2,10,5));
//		contentPanelMessage.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
//		
//		label = new JLabel(LABEL_TEXT);
//		label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
//		label.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
//		contentPanelMessage.add(label);
//		frameMessage.setContentPane(contentPanelMessage);
//		
//		button = new JButton("Click when finished reading instructions");
//		button.setAlignmentX(JButton.CENTER_ALIGNMENT);
//		button.setActionCommand("Answer");
//		button.addActionListener(this);
//		contentPanelMessage.add(button);
//
//		/* Size and then display the frame. */
//		frameMessage.pack();
//		frameMessage.setVisible(true);
//	
//		frameMessage.add(contentPanelMessage);
//		frameMessage.setSize(500, 500);
//		//frameMessage.setVisible(true);
//		frameMessage.add(contentPanelMessage);
//		
		// Creates button array
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
		int randomRed = randomRGB();
		int randomGreen = randomRGB();
		int randomBlue = randomRGB();

		JButton btnColor = new JButton();

		System.out.println(randomRed + " " + randomGreen + " " + randomBlue);
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				JButton btn = new JButton();

				lightButtons[i][j] = btn; // tells the position of the buttons ? 
				// btn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
				btn.setBorder(BorderFactory.createLineBorder(Color.white));
				btn.setBackground(new Color(randomRed, randomGreen, randomBlue));
				// btn.setOpaque(true);
				// btn.setBorderPainted(false);
				contentPane.add(btn);
				int IPos = 0;
				int JPos = 0;

				int newPosJ = JPos;
				int newPosI = IPos;

				int newRed = randomRed + 40;
				int newGreen = randomGreen + 40;
				int newBlue = randomBlue + 40;
				
				// needs to be + 40 cause math
				// make it more or less depending one level
				// if user goes to each level (like 10) decrease the variation
				
				// this is the variation statement
				if (newRed >= 250) {
					newRed = newRed - 40;
				}
				
				if (newGreen >= 250) {
					newGreen = newGreen - 40;
				}
				
				if (newBlue >= 250) {
					newBlue = newBlue - 40;
				}
				
				System.out.print( i + "," + j + " ");
				if (lightButtons[i][j] == lightButtons[3][3]) {
					btn.setBackground(new Color(newRed, newGreen, newBlue));	
				}
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


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
	}
}
