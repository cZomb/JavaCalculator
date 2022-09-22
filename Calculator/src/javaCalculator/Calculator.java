/*
 * Main calculator class for initializing and running 
 * the custom calculator Swing application
 * 
 * @Author: Chris Skura
 * JavaSE-17
 */

package javaCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

//Calculator class handles creating the main windows and elements, and checks for user input
public class Calculator implements ActionListener {
	// main number used for storing calculations
	double num1;

	// string handles number input/output at bottom of screen
	String tNum = "";

	// button width and height
	int bWidth = 75;
	int bHeight = 75;

	// operation being used for calculations
	String operation;

	// output number after calculations are made
	double output;

	// window title
	String sTitle;

	// window width and height
	int sWidth;
	int sHeight;

	// runCalc is used to see if pressing an operation will run a calculation or
	// change the operator used
	boolean runCalc = false;

	// afterEquals checks to see if inputs are made directly after the equals button
	// is pressed
	boolean afterEquals = false;

	JFrame f; // main window
	JButton[] b = new JButton[20]; // array for calculator buttons
	JTextField l; // text field at bottom of window

	// string holds all button text
	String[] bLayout = { "C", "%", "/", "Del", "7", "8", "9", "X", "4", "5", "6", "-", "1", "2", "3", "+", "+/-", "0",
			".", "=" };

	// constructor to initialize all primary variables for window creation
	Calculator(int bWidth, int bHeight) {
		this.num1 = this.output = 0.00;
		this.operation = "+";

		this.bWidth = bWidth;
		this.bHeight = bHeight;

		this.sWidth = bWidth * 4;
		this.sHeight = bHeight * 6 + 39;
	}

	// creates the window, buttons, and textfield
	public void Create() {
		this.f = new JFrame(this.sTitle);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// sets the text field based on how large the buttons are
		this.l = new JTextField(16);
		this.l.setBounds(0, bHeight * 5, bWidth * 4, bHeight);
		this.l.setEditable(false);
		this.l.setHorizontalAlignment(SwingConstants.RIGHT);
		this.l.setFont(new Font("System", Font.BOLD, 42));

		// initialize each button based on string array bLayout
		for (int i = 0; i < 20; i++) {
			this.b[i] = new JButton(bLayout[i]);
			this.b[i].addActionListener(this);
		}

		// adjust sizing and position of each button based on bWidth/bHeight
		b[0].setBounds(0 * bWidth, 0, bWidth, bHeight);
		b[1].setBounds(1 * bWidth, 0, bWidth, bHeight);
		b[2].setBounds(2 * bWidth, 0, bWidth, bHeight);
		b[3].setBounds(3 * bWidth, 0, bWidth, bHeight);

		b[4].setBounds(0 * bWidth, bHeight, bWidth, bHeight);
		b[5].setBounds(1 * bWidth, bHeight, bWidth, bHeight);
		b[6].setBounds(2 * bWidth, bHeight, bWidth, bHeight);
		b[7].setBounds(3 * bWidth, bHeight, bWidth, bHeight);

		b[8].setBounds(0 * bWidth, 2 * bHeight, bWidth, bHeight);
		b[9].setBounds(1 * bWidth, 2 * bHeight, bWidth, bHeight);
		b[10].setBounds(2 * bWidth, 2 * bHeight, bWidth, bHeight);
		b[11].setBounds(3 * bWidth, 2 * bHeight, bWidth, bHeight);

		b[12].setBounds(0 * bWidth, 3 * bHeight, bWidth, bHeight);
		b[13].setBounds(1 * bWidth, 3 * bHeight, bWidth, bHeight);
		b[14].setBounds(2 * bWidth, 3 * bHeight, bWidth, bHeight);
		b[15].setBounds(3 * bWidth, 3 * bHeight, bWidth, bHeight);

		b[16].setBounds(0 * bWidth, 4 * bHeight, bWidth, bHeight);
		b[17].setBounds(1 * bWidth, 4 * bHeight, bWidth, bHeight);
		b[18].setBounds(2 * bWidth, 4 * bHeight, bWidth, bHeight);
		b[19].setBounds(3 * bWidth, 4 * bHeight, bWidth, bHeight);

		// add each button in the array to main window
		for (int i = 0; i < 20; i++) {
			f.add(b[i]);
		}

		// add text field to main window
		f.add(l);

		// initialize main window
		f.setSize(this.sWidth, this.sHeight);
		f.setLayout(null);
		f.setVisible(true);
	}

	// check for user input
	public void actionPerformed(ActionEvent e) {
		// C key
		if (e.getSource() == b[0]) {
			this.tNum = "";
			this.num1 = 0;
			this.operation = "+";
		}

		// check if a number button is pressed directly after pressing equals button
		if (this.afterEquals) {
			if (e.getSource() == b[4] || e.getSource() == b[5] || e.getSource() == b[6] || e.getSource() == b[8]
					|| e.getSource() == b[9] || e.getSource() == b[10] || e.getSource() == b[12]
					|| e.getSource() == b[13] || e.getSource() == b[14] || e.getSource() == b[17]
					|| e.getSource() == b[18]) {

				this.tNum = "";
				this.num1 = 0;
				this.operation = "+";
				this.afterEquals = false;
			}
		}

		// decimal
		if (e.getSource() == b[18]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += ".";
			this.runCalc = true;
		}
		// Number button inputs
		if (e.getSource() == b[4]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += "7";
			this.runCalc = true;
		}
		if (e.getSource() == b[5]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += "8";
			this.runCalc = true;
		}
		if (e.getSource() == b[6]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += "9";
			this.runCalc = true;
		}
		if (e.getSource() == b[8]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += "4";
			this.runCalc = true;
		}
		if (e.getSource() == b[9]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += "5";
			this.runCalc = true;
		}
		if (e.getSource() == b[10]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += "6";
			this.runCalc = true;
		}
		if (e.getSource() == b[12]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += "1";
			this.runCalc = true;
		}
		if (e.getSource() == b[13]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += "2";
			this.runCalc = true;
		}
		if (e.getSource() == b[14]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += "3";
			this.runCalc = true;
		}
		if (e.getSource() == b[17]) {
			if (!this.runCalc)
				this.tNum = "";
			this.tNum += "0";
			this.runCalc = true;
		}

		// DEL key
		if (e.getSource() == b[3]) {
			if (this.tNum.length() > 0)
				this.tNum = this.tNum.substring(0, this.tNum.length() - 1);
		}

		// update text in main text field
		this.l.setText(this.tNum);

		// equals
		if (e.getSource() == b[19]) {
			if (this.runCalc) {
				calculate();
				this.runCalc = false;
				this.num1 = Double.parseDouble(this.tNum);
			}

			this.afterEquals = true;
			this.runCalc = false;
		}
		// modulus
		if (e.getSource() == b[1]) {
			if (this.runCalc) {
				calculate();
				this.runCalc = false;
			}
			this.operation = "%";
			if (!this.afterEquals)
				this.tNum = "";
			if (this.afterEquals)
				this.afterEquals = false;
		}
		// divide
		if (e.getSource() == b[2]) {
			if (this.runCalc) {
				calculate();
				this.runCalc = false;
			}
			this.operation = "/";
			if (!this.afterEquals)
				this.tNum = "";
			if (this.afterEquals)
				this.afterEquals = false;
		}
		// multiple
		if (e.getSource() == b[7]) {
			if (this.runCalc) {
				calculate();
				this.runCalc = false;
			}
			this.operation = "*";
			if (!this.afterEquals)
				this.tNum = "";
			if (this.afterEquals)
				this.afterEquals = false;
		}
		// subtract
		if (e.getSource() == b[11]) {
			if (this.runCalc) {
				calculate();
				this.runCalc = false;
			}
			this.operation = "-";
			if (!this.afterEquals)
				this.tNum = "";
			if (this.afterEquals)
				this.afterEquals = false;
		}
		// addition
		if (e.getSource() == b[15]) {
			if (this.runCalc) {
				calculate();
				this.runCalc = false;
			}
			this.operation = "+";
			if (!this.afterEquals)
				this.tNum = "";
			if (this.afterEquals)
				this.afterEquals = false;
		}
	}

	// run the main calculation method
	public void calculate() {
		// if text field is blank, assume 0
		if (tNum == "")
			tNum += "0";

		// tempNum stores parsed String information based on text field
		double tempNum = Double.parseDouble(tNum);

		// run each calculation based on operation value
		if (this.operation == "+") {
			this.num1 += tempNum;
		}
		if (this.operation == "-") {
			this.num1 -= tempNum;
		}
		if (this.operation == "/") {
			this.num1 /= tempNum;
		}
		if (this.operation == "*") {
			this.num1 *= tempNum;
		}
		if (this.operation == "%") {
			this.num1 %= tempNum;
		}

		// clear tNum
		this.tNum = "";
		// apply new output number to tNum
		this.tNum += this.num1;
		// print to screen
		this.l.setText(this.tNum);
	}

	@Override
	public String toString() {
		return "Num1 = " + this.num1 + " Operation = " + this.operation + " Output = " + this.output;
	}
}
