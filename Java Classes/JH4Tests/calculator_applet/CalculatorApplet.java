package calculator_applet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class CalculatorApplet extends JApplet{
	//Serial Number to avoid compiler
	private static final long serialVersionUID = 1L;
	JPanel output = new JPanel();
	JPanel buttons = new JPanel();
	JTextField textField = new JTextField("", 23);
	int currOperand = 0;
	String toutput = "", mathtotal, operand1, operand2, operator;

	class MyActions implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {

			String tinput = e.getActionCommand();			
			switch (tinput)
			{
			case "0": case "1": case "2": case "3": case "4": case "5":
			case "6":  case "7": case "8": case "9":

				if (currOperand == 0 || currOperand == 1) {
					mathtotal = null;
					if (operand1 != null)
					{
						operand1 = operand1 + tinput;
						toutput = operand1;
					}
					else {
						operand1 = tinput;
						toutput = operand1;
					}
				}
				else if (currOperand == 2){
					if (operand2 != null)
					{
						operand2 = operand2 + tinput;
						toutput = operand2;
					}
					else {
						operand2 = tinput;
						toutput = operand2;
					}
				}

				break;
			case "+":  case "-": case "*": case "/":
				if (mathtotal != null)
				{
					operand1 = mathtotal;
					toutput = operand1;
					mathtotal = null;

				}
				operator = tinput;
				currOperand =2;
				toutput = operator;
				break;
			case "=":
				mathtotal = myMath(operator);
				toutput = mathtotal;
				operand1 = null;
				operand2= null;
				operator = null;
				currOperand = 0;
				break;
			default:
				operand1 = null;
				operand2= null;
				operator = null;
				mathtotal = null;
				currOperand = 0;
				toutput = "";
				break;

			}

			textField.setText(toutput);

		}

		String myMath (String s)
		{
			String temptotal;
			switch (s)
			{
			case "+":  
				temptotal = Integer.toString(Integer.parseInt(operand1) + Integer.parseInt(operand2));
				break;
			case "-": 
				temptotal = Integer.toString(Integer.parseInt(operand1) - Integer.parseInt(operand2));
				break;
			case "*": 
				temptotal = Integer.toString(Integer.parseInt(operand1) * Integer.parseInt(operand2));
				break;
			case "/":
				temptotal = Integer.toString(Integer.parseInt(operand1) / Integer.parseInt(operand2)); 
				//Need to figure out how to make display as 12 instead of 12.0 when an even number, then convert all to Doubles
				break;
			default:
				temptotal = "Error!!";
				break;
			}
			return temptotal;
		}

	}

	public void init() {
		Font font = new Font("SERIF", Font.BOLD, 32);
		setLayout(new BorderLayout());

		output.setLayout(new FlowLayout());
		output.getPreferredSize();
		output.setBackground(Color.YELLOW);

		MyActions ma = new MyActions();

		textField.setEditable(false);
		textField.setFont(font);
		textField.setBackground(Color.YELLOW);

		output.add(textField);

		add(output, BorderLayout.NORTH);

		buttons.setLayout(new GridLayout(4,4,4,4));

		JButton [] calcButtons = new JButton[16];

		String calcInput [] = {"0", "1", "2", "3", "4", "5", "6", 
				"7", "8", "9", "+", "-", "*", "/", "=", "clear"};

		for (int i = 0;i < calcInput.length; i++)
		{

			if (i > 9) {	
				JButton jb = new JButton(calcInput[i]);
				calcButtons[i] = jb;
				calcButtons[i].setFont(font);
				calcButtons[i].setBackground(Color.RED);
				calcButtons[i].addActionListener(ma);
				buttons.add(jb);
			}
			else {
				JButton jb = new JButton(calcInput[i]);
				calcButtons[i] = jb;
				calcButtons[i].setFont(font);
				calcButtons[i].setBackground(Color.cyan);
				calcButtons[i].addActionListener(ma);
				buttons.add(jb);
			}
		}
		add(buttons, BorderLayout.CENTER);
	}
	
	public static void main(String [] args) {
		CalculatorApplet applet = new CalculatorApplet();
		JFrame frame = new JFrame("Calculator");
		frame.add(applet);
		frame.setSize(650, 700);

		applet.init();	 
		
		frame.setVisible(true);
	}


}
