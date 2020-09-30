package second_shape_drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DrawingProg2 extends JFrame implements
ActionListener{

	//
	private static final long serialVersionUID = 1L;
	//
	JPanel drawSelect = new JPanel();
	JPanel colorSelect = new JPanel();
	DrawingPanel drawingPanel = new DrawingPanel();
	JCheckBox filled = new JCheckBox("filled");
	
	DrawingProg2()
	{
		super("My Drawing Program");

		String[] colors = {"red", "green", "blue", "magenta"};
		String[] shapes1 = {"rectangle","oval","line","scribble"};
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		layout(shapes1, colors);
		setVisible(true);
	}

	private void layout(String[] shapes, String[] colors)
	{
		// set defaults
		drawingPanel.drawing.setColor(Color.red);
		drawingPanel.drawing.setDrawType(DrawType.rectangle);
		setLayout(new BorderLayout());

		drawSelect.setLayout(new FlowLayout());
		filled.addActionListener(this);
		drawSelect.add(filled);
		ButtonGroup drawlist = new ButtonGroup();
		JRadioButton [] shapeArr = new JRadioButton[4];

		for (int i = 0;i < shapes.length; i++)
		{
			if (shapes[i] == "rectangle")
			{
				JRadioButton rb = new JRadioButton(shapes[i], true);
				shapeArr[i] = rb;
				drawlist.add(rb);
				rb.addActionListener(this);
				drawingPanel.drawing.setDrawType(DrawType.rectangle);
				drawSelect.add(rb);	
			}
			else {
				JRadioButton rb = new JRadioButton(shapes[i], false);
				shapeArr[i] = rb;
				drawlist.add(rb);
				rb.addActionListener(this);
				drawSelect.add(rb);	
			}

		}

		add(drawSelect, BorderLayout.NORTH);

		colorSelect.setLayout(new GridLayout(0,1));
		ButtonGroup colorlist = new ButtonGroup();
		JRadioButton [] colorArr = new JRadioButton[4];

		for (int i = 0;i < colors.length;i++)
		{
			if (colors[i] == "red")
			{
				JRadioButton rb = new JRadioButton(colors[i], true);
				colorArr[i] = rb;
				colorlist.add(rb);
				rb.addActionListener(this);
				drawingPanel.drawing.setColor(Color.red);
				colorSelect.add(rb);
			}
			else {
				JRadioButton rb = new JRadioButton(colors[i], false);
				colorArr[i] = rb;
				colorlist.add(rb);
				rb.addActionListener(this);
				colorSelect.add(rb);				
			}
		}


		add(colorSelect, BorderLayout.WEST);

		add(drawingPanel, BorderLayout.CENTER);

		/*
 drawingPanel goes in the CENTER
 Create a JPanel with a FlowLayout for the NORTH.
 This JPanel will get the filled JCheckBox and all
of the necessary radio buttons
 Create a JPanel with a GridLayout(0,1) or
GridLayout(3,1) for the WEST.
 This JPanel will get the radio buttons for the
colors.
 All RadioButtons and the CheckBox will have
ActionListeners associated with them.
		 */

	}


	public static void main(String[] args) {
		DrawingProg2 dp = new DrawingProg2();

	}
	@Override
	public void actionPerformed(ActionEvent actionEvent)
	{
		String action = actionEvent.getActionCommand();
		System.out.println(action);

		switch(action)
		{
		case "red":
			drawingPanel.drawing.setColor(Color.red);
			break;
		case "green":
			drawingPanel.drawing.setColor(Color.green);
			break;
		case "blue":
			drawingPanel.drawing.setColor(Color.blue);
			break;
		case "magenta":
			drawingPanel.drawing.setColor(Color.magenta);
			break;
		case "rectangle":
			drawingPanel.drawing.setDrawType(DrawType.rectangle);
			filled.setVisible(true);
			break;
		case "oval":
			drawingPanel.drawing.setDrawType(DrawType.oval);
			filled.setVisible(true);
			break;
		case "line":
			drawingPanel.drawing.setDrawType(DrawType.line);
			filled.setVisible(false);
			break;
		case "scribble":
			drawingPanel.drawing.setDrawType(DrawType.scribble);
			filled.setVisible(false);
			break;
		case "filled":
			if (filled.isSelected())
			{
				drawingPanel.drawing.setFilled(true);
			}
			else {
				drawingPanel.drawing.setFilled(false);
			}
			break;
		default:
			break;
			/*
 Handle all of the other actions, and make sure you set
the visibility of
 the filled CheckBox appropriately.
 The other methods to be called are:
 drawingPanel.drawing.setDrawType(....);
 drawingPanel.drawing.setFilled(.....);
			 */

		}


	}
}