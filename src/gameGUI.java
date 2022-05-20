


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class gameGUI implements ActionListener {
	public gameGUI() {
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

		//JButton btnColor = new JButton();

		System.out.println(randomRed + " " + randomGreen + " " + randomBlue);
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				JButton btn = new JButton();

				lightButtons[i][j] = btn; // tells the position of the buttons ? 
				// btn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
				btn.setBorder(BorderFactory.createLineBorder(Color.white));
				btn.setBackground(new Color(randomRed, randomGreen, randomBlue));


                String os = System.getProperty("os.name");
                if (os.equals("Mac OS X")) {
                    btn.setOpaque(true);
				    btn.setBorderPainted(false);
                }
				
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
				
				int newPosX = (int)(Math.random() * 3);
				int newPosY = (int)(Math.random() * 3);
				
				
				System.out.print( i + "," + j + " ");
				if (lightButtons[i][j] == lightButtons[2][3]) {
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
