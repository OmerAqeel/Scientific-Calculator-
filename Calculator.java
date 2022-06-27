import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;



import java.awt.event.*;
import java.beans.Expression;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator extends JFrame implements ActionListener{
	
	
	/*
	 * FIELDS
	 */
	
	JPanel myPanel;
				
	//Normal Arithmatic Operations
	JButton buttonPlus;
	JButton buttonMinus;
	JButton buttonMultiply;
	JButton buttonDivide;
	
	//Advance Arithmatic Operations
	JButton buttonDecimal;
	JButton buttonOpenBracket;
	JButton buttonCloseBracket;
	JButton buttonSin;
	JButton buttonCos;
	JButton buttonTan;
	JButton buttonSquareRoot;
	JButton buttonCubeRoot;
	JButton buttonLog;
	JButton buttonSquare;
	JButton buttonPow;
	JButton buttonFactorial;
	JButton buttonPercent;
	JButton buttonPi;
	
	//Equal					Equal will call the method from the calculate class to evaluate any expression in the textfield
	JButton buttonEqual;
	//Clear
	JButton buttonClear;
	
	//Numbers			Buttons that will pressed to choose the number
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	
	//Save Buttons
	JButton btnM1;
	JButton btnM2;
	JButton btnM3;
	JButton btnM4;
	
	//Read Buttons
	JButton getM1;
	JButton getM2;
	JButton getM3;
	JButton getM4;
	
	//TextField
	JTextField result;				
	JTextField result2;				//This is where the the answer for the equations will be displayed
	
	//Entries
	Boolean firstEntry = true; 		//if any number is the first entry then the firstEntry will be turned to false

	//calculate object 
	private static calculate calc = new calculate(); 	//Creating an instance from calculate class to be used in the whole calculator class
		
	/*
	 * CONSTRUCTOR
	 */
	public Calculator() {
		myPanel = new JPanel();
		
		myPanel.setLayout(null);		//No Layout
		
		
		//Creating JButton objects and setting their bounds
		buttonPlus = new JButton("+");
		buttonPlus.setBounds(570, 330, 100, 50);	//xSize, ySize, width, height
		buttonMinus = new JButton("-");
		buttonMinus.setBounds(460, 330, 100, 50);
		buttonMultiply = new JButton("*");
		buttonMultiply.setBounds(790,260, 100, 55 );
		buttonDivide = new JButton("/");
		buttonDivide.setBounds(790, 190, 100, 55);
		
		buttonDecimal = new JButton(".");
		buttonDecimal.setBounds(125, 330, 100, 50);
		buttonOpenBracket = new JButton("(");
		buttonOpenBracket.setBounds(460, 120, 100, 55);
		buttonCloseBracket = new JButton(")");
		buttonCloseBracket.setBounds(570, 120, 100, 55);
		buttonSin = new JButton("Sin");
		buttonSin.setBounds(350, 190, 100, 55);
		buttonCos = new JButton("Cos");
		buttonCos.setBounds(460, 190, 100, 55);
		buttonTan = new JButton("Tan");
		buttonTan.setBounds(570, 190, 100, 55);
		buttonSquareRoot = new JButton("√");
		buttonSquareRoot.setBounds(350, 120, 100, 55);
		buttonCubeRoot = new JButton("3√");
		buttonCubeRoot.setBounds(680, 120, 100, 55);
		buttonLog = new JButton("log");
		buttonLog.setBounds(350, 260, 100, 55);
		buttonSquare = new JButton("x^2");
		buttonSquare.setBounds(460, 260, 100, 55);
		buttonPow = new JButton("x^y");
		buttonPow.setBounds(570, 260, 100, 55);
	    buttonFactorial = new JButton("n!");
	    buttonFactorial.setBounds(680, 190, 100, 55);
	    buttonPercent = new JButton("%");
	    buttonPercent.setBounds(680, 260, 100, 55);
	    buttonPi = new JButton("π");
	    buttonPi.setBounds(790, 120, 100, 55);
	    
	    buttonEqual = new JButton("=");
	    buttonEqual.setBounds(228, 330, 220, 50);
	    buttonClear = new JButton("CLEAR");
	    buttonClear.setBounds(680,330, 210, 50);
	   
	    
	    button0 = new JButton("0");
	    button0.setBounds(15, 330, 100, 50);
	    button1 = new JButton("1");
	    button1.setBounds(15, 260, 100, 50);
	    button2 = new JButton("2");
	    button2.setBounds(125, 260, 100, 50);
	    button3 = new JButton("3");
	    button3.setBounds(235, 260, 100, 50);
	    button4 = new JButton("4");
	    button4.setBounds(15, 190, 100, 50);
	    button5 = new JButton("5");
	    button5.setBounds(125, 190, 100, 50);
	    button6 = new JButton("6");
	    button6.setBounds(235, 190, 100, 50);
	    button7 = new JButton("7");
	    button7.setBounds(15, 120, 100, 50);
	    button8 = new JButton("8");
	    button8.setBounds(125, 120, 100, 50);
	    button9 = new JButton("9");
	    button9.setBounds(235, 120, 100, 50);
	    
	    btnM1 = new JButton("M1");
	    btnM1.setBounds(540, 5, 100, 25);
	    getM1 = new JButton("M1+");
	    getM1.setBounds(540, 35, 100, 25);   
	    btnM2 = new JButton("M2");
	    btnM2.setBounds(640, 5, 100, 25);
	    getM2 = new JButton("M2+");
	    getM2.setBounds(640, 35, 100, 25);
	    btnM3 = new JButton("M3");
	    btnM3.setBounds(540, 65, 100, 25);
	    getM3 = new JButton("M3+");
	    getM3.setBounds(540, 95, 100, 25);
	    btnM4 = new JButton("M4");
	    btnM4.setBounds(640, 65, 100, 25);
	    getM4 = new JButton("M4+");
	    getM4.setBounds(640, 95, 100, 25);
	   
	    result = new JTextField(20);
	    result.setText("0.0");
	    result.setEditable(false);
	    result.setBounds(15, 5, 500, 50);		//xSize, ySize, width, height
	    result2 = new JTextField(50);
	    result2.setText("0.0");
	    result2.setEditable(false);
	    result2.setBounds(15, 60, 500, 25);
	    
	    
	    //Adding the panel
	    add(myPanel);
	    
	    //Adding buttons to the panel
	    myPanel.add(buttonPlus);
	    myPanel.add(buttonMinus);
	    myPanel.add(buttonMultiply);
	    myPanel.add(buttonDivide);
	    myPanel.add(buttonDecimal);
	    myPanel.add(buttonOpenBracket);
	    myPanel.add(buttonCloseBracket);
	    myPanel.add(buttonSin);
	    myPanel.add(buttonCos);
	    myPanel.add(buttonTan);
	    myPanel.add(buttonSquareRoot);
	    myPanel.add(buttonCubeRoot);
	    myPanel.add(buttonLog);
	    myPanel.add(buttonSquare);
	    myPanel.add(buttonPow);
	    myPanel.add(buttonFactorial);
	    myPanel.add(buttonPercent);
	    myPanel.add(buttonPi);
	    myPanel.add(buttonEqual);
	    myPanel.add(buttonClear);
	    myPanel.add(button0);
	    myPanel.add(button1);
	    myPanel.add(button2);
	    myPanel.add(button3);
	    myPanel.add(button4);
	    myPanel.add(button5);
	    myPanel.add(button6);
	    myPanel.add(button7);
	    myPanel.add(button8);
	    myPanel.add(button9);
	    myPanel.add(btnM1);
	    myPanel.add(btnM2);
	    myPanel.add(btnM3);
	    myPanel.add(btnM4);
	    myPanel.add(getM1);
	    myPanel.add(getM2);
	    myPanel.add(getM3);
	    myPanel.add(getM4);
	    myPanel.add(result);
	    myPanel.add(result2);
	    
	    //Adding ActionListener to all the buttons
	    buttonPlus.addActionListener(this); 		
	    buttonMinus.addActionListener(this);
	    buttonMultiply.addActionListener(this);
	    buttonDivide.addActionListener(this);
	    buttonOpenBracket.addActionListener(this);
	    buttonCloseBracket.addActionListener(this);
	    buttonDecimal.addActionListener(this);
	    buttonSin.addActionListener(this);
	    buttonCos.addActionListener(this);
	    buttonTan.addActionListener(this);
	    buttonSquareRoot.addActionListener(this);
	    buttonCubeRoot.addActionListener(this);
	    buttonLog.addActionListener(this);
	    buttonSquare.addActionListener(this);
	    buttonPow.addActionListener(this);
	    buttonFactorial.addActionListener(this);
	    buttonPercent.addActionListener(this);
	    buttonPi.addActionListener(this);
	    buttonEqual.addActionListener(this);
	    buttonClear.addActionListener(this);
	    button0.addActionListener(this);
	    button1.addActionListener(this);
	    button2.addActionListener(this);
	    button3.addActionListener(this);
	    button4.addActionListener(this);
	    button5.addActionListener(this);
	    button6.addActionListener(this);
	    button7.addActionListener(this);
	    button8.addActionListener(this);
	    button9.addActionListener(this);
	    btnM1.addActionListener(this);
	    btnM2.addActionListener(this);
	    btnM3.addActionListener(this);
	    btnM4.addActionListener(this);
	    getM1.addActionListener(this);
	    getM2.addActionListener(this);
	    getM3.addActionListener(this);
	    getM4.addActionListener(this);
	  			
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator myFrame = new Calculator();
		myFrame.setVisible(true);
		myFrame.setSize(900, 470);
		myFrame.setResizable(false);				//not enabling to allow the user to resize the frame, it will affect the design of the gui
		myFrame.setTitle("Scientific Calculator");
		myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		calc = new calculate();			//Creating an instance/object using the calculate class
		
	}
	
		
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/*
		 * WHEN THE NUMBER BUTTONS ARE PRESSED, THE firstEntry WILL BE CHANGED TO FALSE AFTER ANY BUTTON IS PRESSED
		 * PROGRAM IS GOING TO CHECK THAT WHETHER THE BUTTON PRESSED IS FIRST ENTRY OR NOT, IF IT IS THEN THE PROGRAM WILL
		 * DISPLAY THE NUMBER ON THE TEXTFIELD(result) ELSE IT WILL BE GET THE NUMBER THAT IS ALREADY IN THE TEXTFIELD(result)
		 * AND CONCATENATE THAT NUMBER PRESSED TO IT.
		 */
		if(e.getSource() == button0) {
			if(firstEntry == true) {
				result.setText("0");
				firstEntry = false;				//First entry will be turned to false because when the next button of number will be pressed then that will not be the first entry
			}
			else {
				result.setText(result.getText() + "0");		//if the First entry was another number then that number will be concatenated with the the number pressed
			}
			
		}
		if(e.getSource() == button1) {
			if(firstEntry == true) {
				result.setText("1");
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + "1");
			}
			
		}
		if(e.getSource() == button2) {
			if(firstEntry == true) {
				result.setText("2");
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + "2");
			}
			
		}
		if(e.getSource() == button3) {
			if(firstEntry == true) {
				result.setText("3");
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + "3");
			}
			
		}
		if(e.getSource() == button4) {
			if(firstEntry == true) {
				result.setText("4");
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + "4");
			}
			
		}
		if(e.getSource() == button5) {
			if(firstEntry == true) {
				result.setText("5");
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + "5");
			}
			
		}
		if(e.getSource() == button6) {
			if(firstEntry == true) {
				result.setText("6");
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + "6");
			}
			
		}
		if(e.getSource() == button7) {
			if(firstEntry == true) {
				result.setText("7");
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + "7");
			}
			
		}
		if(e.getSource() == button8) {
			if(firstEntry == true) {
				result.setText("8");
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + "8");
			}
			
		}
		if(e.getSource() == button9) {
			if(firstEntry == true) {
				result.setText("9");
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + "9");
			}
			
		}
		if(e.getSource() == buttonDecimal)
		{
			if(firstEntry == true)
			{
				result.setText(".");
				firstEntry = false;
			}
			else
			{
				result.setText(result.getText() + ".");
			}
		}
		
		/*
		 * WHEN THE USER PRESSES THE CLEAR BUTTON THEN EVERYTHING WILL BE SET BACK TO THE STARTING POINT.
		 */
		if(e.getSource() == buttonClear) {
			result.setText("0.0");				//the text of the JTextField(result) will be converted back to 0.0
			firstEntry = true;			//So that when the player presses any number after clearing, that button will be consider the first entry
			result2.setText("0.0");
		}
		
		/*
		 *ALLOWING THE PLAYER TO ENTER THE BRACKETS INTO THE TEXTFIELD 
		 */
		
		if(e.getSource() == buttonOpenBracket) {
			if(firstEntry == true) {				//If it is the bracket is going to be the first entry into the text field then 0.0 will be removed else it will show up as 0.0(
				result.setText("(");			
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + "(");		//if its not then the the bracket will be attached to the last button pressed outcome.
			}
		}
		
		if(e.getSource() == buttonCloseBracket) {
			if(firstEntry == true) {				//If it is the bracket is going to be the first entry into the text field then 0.0 will be removed else it will show up as 0.0(
				result.setText(")");			
				firstEntry = false;
			}
			else {
				result.setText(result.getText() + ")");		//if its not then the the bracket will be attached to the last button pressed outcome.
			}
		}
	
		/*
		 * ARITHMETIC OPERATIONS
		 */
		
		if(e.getSource() == buttonPlus) 
		{
			result.setText(result.getText() + "+");
			
		}
		
		if(e.getSource() == buttonMinus) 
		{
			result.setText(result.getText() + "-");

		}
		
		if(e.getSource() == buttonDivide)
		{
			result.setText(result.getText() + "/");
		}
		if(e.getSource() == buttonMultiply)
		{
			result.setText(result.getText() + "*");
		}
		if(e.getSource() == buttonSquare)
		{
			result.setText(result.getText() + "^2");
		}
		if(e.getSource() == buttonPow) 
		{
			result.setText(result.getText() + "^");
		}
		if(e.getSource() == buttonSquareRoot)
		{
			result.setText(result.getText() + "^(1/2)");
		}
		if(e.getSource() == buttonCubeRoot)
		{
			result.setText(result.getText() + "^(1/3)");
		}
		if(e.getSource() == buttonPercent)
		{
			result.setText(result.getText() + "%");
		}
		if(e.getSource() == buttonPi)
		{
			result.setText(result.getText() + "22/7");
		}
		if(e.getSource() == buttonFactorial)
		{
			result.setText(result.getText() + "!");
		}
		if(e.getSource() == buttonSin)
		{
			if(firstEntry == true)
			{
				result.setText("sin(");
				firstEntry = false;
			}
			else {
			result.setText(result.getText() + "sin(");
			}
		}
		if(e.getSource() == buttonCos)
		{
			if(firstEntry == true) {
				result.setText("cos(");
				firstEntry = false;
			}
			else{
				result.setText(result.getText() + "cos(");
				}
			
		}
		if(e.getSource() == buttonTan)
		{
			if(firstEntry == true)
			{
				result.setText("tan(");
				firstEntry = false;
			}
			else 
			{
				result.setText(result.getText() + "tan(");
			}
		}
		if(e.getSource() == buttonLog)
		{
			if(firstEntry == true)
			{
				result.setText("log(");
				firstEntry = false;
			}
			else 
			{
				result.setText(result.getText() + "log(");
			}
		}
		if(e.getSource() == buttonEqual) 
		{
			try {
				result2.setText(String.valueOf(calc.evaluate(result.getText())));			
				result.setText("");	
			}catch(Exception e2)					//if any invalid entry is made 
			{
				result.setText("Invalid entry");
			}
		}
		
		//MEMORY BUTTONS
		/*
		 * FOUR FILES HAVE BEEN CREATED TO SAVE EACH MEMORY IN ITS ALLOCATED FILE
		 */
		if(e.getSource() == btnM1)
		{
			try {
				File file = new File("history1.txt");				//File object created to 				
				
				FileWriter writeHandle = new FileWriter(file);		
				BufferedWriter bw = new BufferedWriter(writeHandle);
				
				String memory1 = result2.getText();
				

				bw.write(memory1);
				
				bw.close();							//Closing the bufferedWriter
				writeHandle.close();				//Closing the writeHandle
				
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			
			
		}
		if(e.getSource() == btnM2)
		{	
			try {
				
				File file = new File("history2.txt");
				
				FileWriter writeHandle = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(writeHandle);
				
				String save = result2.getText();
				bw.write(save);				
				bw.close();
				writeHandle.close();
				
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
		}
		
		if(e.getSource() == btnM3)
		{
		
			try {
				File file = new File("history3.txt");					
				
				FileWriter writeHandle = new FileWriter(file);	
				BufferedWriter bw = new BufferedWriter(writeHandle);
				
				String save = result2.getText();
				bw.write(save);
				bw.close();
				writeHandle.close();
				
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
           
			
		}
		if(e.getSource() == btnM4)
		{
			try {
				File file = new File("history4.txt");					
				
				FileWriter writeHandle = new FileWriter(file);	
				BufferedWriter bw = new BufferedWriter(writeHandle);
				
				String memory1 = result2.getText();
				

				bw.write(memory1);
				
				bw.close();
				writeHandle.close();
				
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				

           
		}
		
		if(e.getSource() == getM1)
		{
			try {
			File file = new File("history1.txt");
			
			Scanner scan = new Scanner(file);
			
			Long m1 = Math.round(Double.parseDouble(scan.next()));		//Returning a rounded value of the 
			
			if(firstEntry == true)
			{
				result.setText(m1.toString());
				firstEntry = false;
			}else
			{
			result.setText(result.getText() + m1.toString());
			}
			scan.close();
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource() == getM2)
		{
			try {
				File file = new File("history2.txt");
				
				Scanner scan = new Scanner(file);
				
				Long m1 = Math.round(Double.parseDouble(scan.next()));		//Returning a rounded value of the 
				
				if(firstEntry == true)
				{
					result.setText(m1.toString());
					firstEntry = false;
				}else
				{
				result.setText(result.getText() + m1.toString());
				}
				scan.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
		}
		if(e.getSource() == getM3)
		{
			try {
				File file = new File("history3.txt");
				
				Scanner scan = new Scanner(file);
				
				Long m1 = Math.round(Double.parseDouble(scan.next()));		//Returning a rounded value of the 
				
				if(firstEntry == true)
				{
					result.setText(m1.toString());
					firstEntry = false;
				}else
				{
				result.setText(result.getText() + m1.toString());
				}
				scan.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
		}
		if(e.getSource() == getM4)
		{
			try {
				File file = new File("history4.txt");
				
				Scanner scan = new Scanner(file);
				
				Long m1 = Math.round(Double.parseDouble(scan.next()));		//Returning a rounded value of the 
				
				if(firstEntry == true)
				{
					result.setText(m1.toString());
					firstEntry = false;
				}else
				{
				result.setText(result.getText() + m1.toString());
				}
				scan.close();
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
		}
		
		
	}




}
