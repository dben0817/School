package graphing_problem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

class GBar
{
    String text;
    int value;
    GBar(String t, int v)
    {
        text=t;
        value =v;
    }
}

public class Graph extends JFrame{

    ArrayList<GBar> gbarArr = new ArrayList<GBar>();
    static String title;

    Graph(ArrayList<GBar> garr)
    {
        super(title);

        gbarArr = garr;
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Find the maximum width of the strings in pixels
    int getMaxTextWidth(ArrayList<GBar> garr, FontMetrics fm)
    {
        int maxValue=0;
        for (int i=0; i < garr.size(); i++)
        {
            int width = fm.stringWidth(garr.get(i).text);
            if (width > maxValue)
                maxValue = width;
        }
        return maxValue;            
    }

    // Find the maximum value in the ArrayList
    int getMaxBarWidth(ArrayList<GBar> garr)
    {
        int maxValue=0;
        for (int i=0; i < garr.size(); i++)
        {
            int value = garr.get(i).value;
            if (value > maxValue)
                maxValue = value;
        }
        return maxValue;            
    }
	void border (Graphics g, int x, int y, int w, int h,int thickness)
	{
	    for (int i = 0;i < thickness; i++)
	    {
	    	g.drawRect(x + i, y + i, w - 2 * i, h - 2 * i);
	    }
	}
	
    public void paint(Graphics g)
    {
        super.paint(g);
        Dimension dimen = getSize();
        
        Insets insets = getInsets();
        int btop = insets.top;
        int bleft = insets.left;
        int bright = insets.right;
        int bbottom = insets.bottom;
        
    	//int b_height = getHeight() - (getHeight()/50);
    	//int b_width = getWidth() - (getWidth()/50);
    	int b_thick = Math.min((getHeight()/600) + (btop + bbottom), (getWidth()/600) + (bleft + bright));
    	
    	g.setColor(Color.red);
    	border(g, 0 + bleft, 0 + btop, getWidth() - (bleft + bright), getHeight() - (btop + bbottom), b_thick);
    	
    	int top = insets.top + (b_thick);
        int left = insets.left + (b_thick + 5);
        int right = insets.right + (b_thick);
        int bottom = insets.bottom + (b_thick);
    	

 

        
        g.setColor(Color.green);
        Font font = g.getFont();
        FontMetrics fm = getFontMetrics(font);
        int fontHeight = fm.getHeight();
        int maxAscent = fm.getMaxAscent();

        int strMaxWidth = left + getMaxTextWidth( gbarArr, fm);
        int x_bar_start =  strMaxWidth +1/* a little white space pad*/; 
        
        int barMaxValue = getMaxBarWidth(gbarArr);
        double scale = (dimen.width -x_bar_start - right) / (double) barMaxValue;
        
        int y_start = top;
        
        int bar_height = fontHeight;
        
        for (int i=0; i < gbarArr.size(); i++)
        {
            String text = gbarArr.get(i).text;
            int strWidth = fm.stringWidth(text);
            int value =gbarArr.get(i).value;
            int scaledValue = (int)(value * scale); 
            g.setColor(Color.black);
            g.drawString(text, strMaxWidth - strWidth, y_start + maxAscent);
            g.setColor(Color.green);
            g.fillRect(x_bar_start, y_start, scaledValue, bar_height);
            
            y_start += fontHeight + 10/*  a little space between rows */;
        }
        g.drawLine(strMaxWidth, top, strMaxWidth, dimen.height - (b_thick + 8));
    }

    public static void main(String[] args) {
        ArrayList<GBar> garr = new ArrayList<GBar>();
        try {
			Scanner scan = new Scanner(Paths.get("graphing.txt"));
			scan.useDelimiter("[\n]");
			
			title = scan.next();
			while (scan.hasNextLine())
			{
				String[] barPiece = null;
				String nl = scan.next();

                barPiece = nl.split("; ");

				garr.add(new GBar(barPiece[0], Integer.parseInt(barPiece[1].trim())));
			}
			scan.close();
		} catch (IOException e1) {
            System.out.println("File does Not Exist!");
		}
        finally
        {
            Graph gb= new Graph(garr); 	
        }


    }

}