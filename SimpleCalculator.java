package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator implements ActionListener { 
	
	// Declare all necessary variables as global variables
	JFrame frame;
	JTextField textfield;
	JButton[] nbuttons = new JButton[10]; //buttons for the numbers: 0,1,2,...,9
	JButton[] fbuttons = new JButton[9]; //buttons for the functions: ".", "*", "/" ,...
	JButton addButton, subButton, mulButton, divButton, decButton, negButton, equButton, delButton, clrButton;
	JPanel panel;
	
	Font myFont = new Font("Ink.free",Font.TRUETYPE_FONT,29);
	
	double number1 = 0, number2 = 0, result = 0;   // variables to hold the numbers and result of the calculation
	char operator;     // variable to hold the operator
	
	SimpleCalculator() {
		
		frame = new JFrame("calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550,700); 
		frame.getContentPane().setBackground(new Color(191,185,191));
		frame.setLayout(null);
		frame.setResizable(false);
		
		//result box
		textfield = new JTextField();
		textfield.setBounds(50,10,300,70);
		textfield.setFont(myFont);
		textfield.setBackground(new Color(237,233,237));
		textfield.setEditable(false);
		
		
		// Create buttons for the functions and numbers
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		negButton = new JButton("(-)");
		equButton = new JButton("=");
		delButton = new JButton("DEL");
		clrButton = new JButton("CLEAR");
		
		
		// Add function buttons to array and set properties
		fbuttons[0] = addButton;
		fbuttons[1] = subButton;
		fbuttons[2] = mulButton;
		fbuttons[3] = divButton;
		fbuttons[4] = decButton;
		fbuttons[5] = negButton;
		fbuttons[6] = equButton;
		fbuttons[7] = delButton;
		fbuttons[8] = clrButton;
		
		
		for(int i = 0;i < 9;i++) {
			fbuttons[i].addActionListener(this);  // add an ActionListener to the button
			fbuttons[i].setFont(myFont);
			fbuttons[i].setBackground(new Color(237,233,237));
			fbuttons[i].setFocusable(false);
		}
		
		for(int i = 0;i <= 9;i++) {
			nbuttons[i] = new JButton(String.valueOf(i));   // create a button for each number and set its text
			nbuttons[i].addActionListener(this);     // add an ActionListener to the button
			nbuttons[i].setFont(myFont);
			nbuttons[i].setBackground(new Color(237,233,237));  
			nbuttons[i].setFocusable(false);
		}
		
		
		// Set the bounds for the function buttons
		negButton.setBounds(255,560,195,70); 
		delButton.setBounds(20,30,50,50);
		clrButton.setBounds(50,560,195,70);
		decButton.setBounds(355,10,95,70);
		
		
		panel = new JPanel();
		panel.setBounds(50, 100, 400, 450);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		panel.setBackground(new Color(191,185,191));
		panel.setForeground(new Color(98,61,98));
		
		
		// Add the buttons to the panel in the correct order
		panel.add(nbuttons[7]);
		panel.add(nbuttons[8]);
		panel.add(nbuttons[9]);
		panel.add(fbuttons[2]);  // *
		panel.add(nbuttons[4]);
		panel.add(nbuttons[5]);
		panel.add(nbuttons[6]);
		panel.add(fbuttons[1]);   // -
		panel.add(nbuttons[1]);
		panel.add(nbuttons[2]);
		panel.add(nbuttons[3]);
		panel.add(fbuttons[0]);  // +
		panel.add(fbuttons[5]);  // (-)
		panel.add(nbuttons[0]);
		panel.add(fbuttons[4]);   // .
		panel.add(fbuttons[6]);   //  =
		panel.add(fbuttons[3]);   //  /
		panel.add(fbuttons[7]);
		panel.add(fbuttons[8]);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(clrButton);
		frame.add(decButton);
		frame.add(textfield);
		frame.setVisible(true);
		
	}

	
	public static void main(String[] args) {
		
		SimpleCalculator calculator = new SimpleCalculator();
	
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0;i <= 9;i++) {
			if(e.getSource() == nbuttons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		for(int i = 0;i < 8;i++) {
			if(e.getSource() == addButton) {
				number1 = Double.parseDouble(textfield.getText());
				operator = '+';
				textfield.setText("");
			}
		}
		
		
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
		if(e.getSource() == subButton) {
			number1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if(e.getSource() == mulButton) {
			number1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		
		if(e.getSource() == divButton) {
			number1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		if(e.getSource() == equButton) {
			number2 = Double.parseDouble(textfield.getText());
			switch(operator) {
			     case '+' :
			    	 result = number1 + number2;
			    	 break;
			     case '-' :
			    	 result = number1 - number2;
			    	 break;
			     case '*' :
			    	 result = number1 * number2;
			    	 break;
			     case '/' :
			    	 result = number1 / number2;
			    	 break;
			}
			textfield.setText(String.valueOf(result));
			number1 = result;
		}
		
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp *= -1;
			textfield.setText(String.valueOf(temp));
		}
		
		if(e.getSource() == clrButton) {
			textfield.setText("");
			}
		
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0;i < string.length() - 1;i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		
		
	}
		

}


