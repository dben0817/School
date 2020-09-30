package chess_program;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;

public class ChessProgram extends JFrame {
	
	ChessProgram()
	{
		super("Chess ... a great game");
		 ChessPiece.readInImages();
		 setSize(800, 600);
		 setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	 public void paint(Graphics g)
	    {      
	       super.paint(g);
	       Insets insets = getInsets();
	       int top = insets.top;
	       int bottom = insets.bottom;
	       int left = insets.left;
	       int right = insets.right;
	       
	       int height = getHeight();
	       int width = getWidth();
	       
	       int cell_h = (height-top-bottom)/8;
	       int cell_w = (width-left-right)/8;
	      
	       BoardDimensions bd = new BoardDimensions(left, top, cell_w, cell_h);
	       
	       int x,y;
	       
	       for (int row=0; row < 8; row++)
	       {
	           y = top + row*cell_h;
	           for (int col=0; col < 8; col++)
	           {
	               x = left + col*cell_w;
	               boolean greenColor = (row+col) %2 == 1;
	               if (greenColor)
	               {
	                   g.setColor(Color.green);
	               }
	               else
	               {
	                   g.setColor(Color.white);
	               }
	               g.fillRect(x, y, cell_w, cell_h);
	           }
	       }
	       
	       for (int col = 0;col < 8;col++)
	       {
	    	   Piece p = new Piece(PieceType.Pawn, ColorType.black, col, 1);
	    	   p.drawInPosition(g, bd);
	    	   
	    	   Piece p2 = new Piece(PieceType.Pawn, ColorType.white, col, 6);
	    	   p2.drawInPosition(g, bd);
	    	 if (col == 0||col == 7) { 
	    	   Piece br = new Piece(PieceType.Rook, ColorType.black, col, 0);
	    	   Piece wr = new Piece(PieceType.Rook, ColorType.white, col, 7);
	    	   br.drawInPosition(g, bd);
	    	   wr.drawInPosition(g, bd);}
	    	   
	    	 else if (col == 1||col ==6) {
		       Piece bk = new Piece(PieceType.Knight, ColorType.black, col, 0);
		       Piece wk = new Piece(PieceType.Knight, ColorType.white, col, 7);
		       bk.drawInPosition(g, bd);
		   	   wk.drawInPosition(g, bd);}
	    	 else if (col == 2||col == 5) {
		       Piece bb = new Piece(PieceType.Bishop, ColorType.black, col, 0);
		       Piece wb = new Piece(PieceType.Bishop, ColorType.white, col, 7);
		       bb.drawInPosition(g, bd);
		       wb.drawInPosition(g, bd);}
	    	 else if (col == 3) {
	    	   Piece bq = new Piece(PieceType.Queen, ColorType.black, col, 0);
		       Piece wq = new Piece(PieceType.Queen, ColorType.white, col, 7);
		       bq.drawInPosition(g, bd);
		       wq.drawInPosition(g, bd);}
	    	 else if (col == 4){
	    	   Piece bk = new Piece(PieceType.King, ColorType.black, col, 0);
		       Piece wk = new Piece(PieceType.King, ColorType.white, col, 7);
		       bk.drawInPosition(g, bd);
		       wk.drawInPosition(g, bd);}
	    	 
	    	 }
	       }
	    
	public static void main(String[] args) {
        ChessProgram cp = new ChessProgram();

	}

}
