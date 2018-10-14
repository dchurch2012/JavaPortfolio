import javax.swing.*;  
import java.awt.event.*;  
import java.lang.*;

public class CalculatorGUI implements ActionListener{  
    JLabel lblResult;  
    JTextArea tbox1 = null;
	JTextArea tbox2 = null;
	
	final int X_COORD = 20;
	final int Y_COORD = 10;
	final int HEIGHT = 20;
	final int WIDTH = 70;
	
	final int SEPERATOR = 10;
	
	final int FRAME_WIDTH = 350;
	final int FRAME_HEIGHT = 400;
	
	final int BUTTON_WIDTH = 200;
	final int BUTTON_HEIGHT = 50;
	
	final int LABEL_X = X_COORD + WIDTH + 20;
	final int LABEL_Y = Y_COORD;
	
	JButton btnAdd;
	JButton btnSubtract;
	JButton btnMultiply;
	JButton btnDivide;
	

    CalculatorGUI() {  
        JFrame frame = new JFrame();  

		//Terminate application when user closes main window (JFrame)
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		//x, y, width, height
		
        lblResult = new JLabel();  
        lblResult.setBounds(LABEL_X,LABEL_Y,200,30);  

        tbox1 = new JTextArea();  
        tbox1.setBounds(X_COORD,Y_COORD,WIDTH,HEIGHT);  

		tbox2 = new JTextArea();  
		tbox2.setBounds(X_COORD,Y_COORD+HEIGHT+SEPERATOR,WIDTH,HEIGHT);  

		// Create Add Button
        btnAdd = new JButton("ADD");  
        btnAdd.setBounds(X_COORD,Y_COORD+2*HEIGHT+2*SEPERATOR,BUTTON_WIDTH,BUTTON_HEIGHT);  
        btnAdd.addActionListener(this);  

		// Create Subtract Button
		btnSubtract = new JButton("SUBTRACT");  
		btnSubtract.setBounds(X_COORD,Y_COORD+4*HEIGHT+3*SEPERATOR,BUTTON_WIDTH,BUTTON_HEIGHT);  
		btnSubtract.addActionListener(this);  

		// Create Multiply Button
		btnMultiply = new JButton("MULTIPLY");  
		btnMultiply.setBounds(X_COORD,Y_COORD+6*HEIGHT+4*SEPERATOR,BUTTON_WIDTH,BUTTON_HEIGHT);  
		btnMultiply.addActionListener(this);  

		// Create Divide Button
		btnDivide = new JButton("DIVIDE");  
		btnDivide.setBounds(X_COORD,Y_COORD+8*HEIGHT+5*SEPERATOR,BUTTON_WIDTH,BUTTON_HEIGHT);  
		btnDivide.addActionListener(this);  

        frame.add(lblResult);
		
		frame.add(tbox1);
		frame.add(tbox2);
		
		frame.add(btnAdd);  
		frame.add(btnSubtract);  
		frame.add(btnMultiply);  
		frame.add(btnDivide);  
		
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);  
        frame.setLayout(null);  
        frame.setVisible(true);  

    }  

    public void actionPerformed(ActionEvent event){  
		double num1 =  0;
		double num2 =  0;
	
		Object source = event.getSource();

		num1 =  Double.parseDouble(tbox1.getText());
		num2 =  Double.parseDouble(tbox2.getText());
		
		//check that the source is really a button
		if( (source instanceof JButton)) { 
		
		
			String buttonText = ((JButton) source).getText();  
			performAction(buttonText,num1,num2);
		
		}
		
    }  
	
	public void performAction(String action, double num1, double num2) {
		if(action.equals("ADD")) {
				lblResult.setText(num1 + " + " + num2 + " = " + (num1+num2));  
		}
		else
		if(action.equals("SUBTRACT")) {
			lblResult.setText(num1 + " - " + num2 + " = " + (num1-num2));  
		}
		else
		if(action.equals("MULTIPLY")) {
			lblResult.setText(num1 + " * " + num2 + " = " + (num1*num2));  
		}
		else
		if(action.equals("DIVIDE")) {
			lblResult.setText(num1 + " / " + num2 + " = " + (num1 / num2));  
		}
	}
	
	
    public static void main(String[] args) {  
        new CalculatorGUI();  
    }  
}
  