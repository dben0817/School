package rock_paper_scissors;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gameNet.GameNet_UserInterface;
import gameNet.GamePlayer;







public class MyUserInterface extends JFrame 
          implements GameNet_UserInterface, ActionListener
{	private static final long serialVersionUID = 1L;
    /* */
	private GamePlayer myGamePlayer;
	private MyGameInput myGameInput;
	private JTextArea resultsTextArea = new JTextArea(20, 70);
	private String [] choices = {"rock", "paper", "scissors", "random"};
	public MyUserInterface()
	{
		super();
	}

	public void startUserInterface (GamePlayer player)
	{
		myGamePlayer = player;
		myGameInput = new MyGameInput();
		myGameInput.setName(myGamePlayer.getPlayerName());

		
		myLayout();
		
		myGameInput.setPick(MyGameInput.CONNECTING);
		myGamePlayer.sendMessage(myGameInput);
	}
	
	public void receivedMessage(Object ob)
	{
		MyGameOutput mg = (MyGameOutput)ob;
		String playerName = myGamePlayer.getPlayerName();
		String status = mg.gameStatus.publish_status(playerName);

		resultsTextArea.setText(status);
	}

	char randomSelect()
	{
		Random r = new Random();
		int num = r.nextInt(choices.length);
		
		if (num == 0)
			return MyGameInput.ROCK;
		else if (num == 1)
			return MyGameInput.PAPER;
		else 
			return MyGameInput.SCISSORS;
	}

	public void actionPerformed(ActionEvent e) 
	{
		String action = e.getActionCommand();
		char pick = MyGameInput.NO_PICK;
		
		switch(action)
		{
		case "rock":
			pick = MyGameInput.ROCK;
			break;
		case "paper":
			pick = MyGameInput.PAPER;
			break;
		case "scissors":
			pick = MyGameInput.SCISSORS;
			break;
		case "random":
			pick = randomSelect();
			break;
		}
		myGameInput.setPick(pick);
		if (pick != MyGameInput.NO_PICK)
			myGamePlayer.sendMessage(myGameInput);
	}

	private void exitProgram()
	{
		myGameInput.setPick(MyGameInput.EXITING);
		myGamePlayer.sendMessage(myGameInput);
		myGamePlayer.doneWithGame();
		System.exit(0);
	}
	class Termination extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			exitProgram();
		}
	}
	

	void myLayout()
	{
		setSize(600, 400);
		setLayout(new BorderLayout());
		Font font = new Font("SERIF", Font.BOLD, 24);
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(0,1));
		topPanel.add(new JLabel(myGamePlayer.getPlayerName()));
		add(topPanel, BorderLayout.NORTH);

		resultsTextArea.setBackground(Color.lightGray);
		resultsTextArea.setEditable(false);
		resultsTextArea.setFont(font);
		JScrollPane scrolledText = new JScrollPane(resultsTextArea);
		scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		
		add(scrolledText, BorderLayout.CENTER);
		addWindowListener (new Termination());
		
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
}
