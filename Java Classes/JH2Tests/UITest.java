package JH2Tests;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UITest extends JFrame implements ActionListener
{	
	private static final long serialVersionUID = 1L;
	/* */
	
	String [] choices = {"rock", "paper", "scissors", "random"};
	void myLayout()
	{
		setSize(600, 600);
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(0,1));
		topPanel.add(new JLabel("Dean"));
		add(topPanel, BorderLayout.NORTH);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(0, 4));
		
		ButtonGroup choicelist = new ButtonGroup();		
		JButton [] choiceArr = new JButton[4];
		
		for (int i = 0; i < choices.length; i++)
		{
			JButton bt = new JButton(choices[i]);
			choiceArr[i] = bt;
			choicelist.add(bt);
			bt.addActionListener(this);
			bottomPanel.add(bt);
		}
		add(bottomPanel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		
		switch(action)
		{
		case "rock":
			
		case "paper":
			
		case "scissors":
			
		case "random":
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UITest uit = new UITest();
		uit.myLayout();

	}



}
