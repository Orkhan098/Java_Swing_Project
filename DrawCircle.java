package ex8;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class DrawCircle extends JFrame{
	// cw = circle width, ch = circle height, lw = line width,lh = line height
	public static final int cw = 90,ch=90,lw=50,lh=50;
	public boolean isActive = true;
	public void paint(Graphics g) {
		while(isActive) {
			// x and y - beginning coordinates of shapes,x2 and y2 - are the second coordinates of line  rx and ry - rectangle x and y coordinates
			int x=10,y=185,x2=0,y2=0,rx=x+cw+10,ry=y+(ch/2);
			// we use loop 
			for(int i=0;i<5;i++) {
				// DRAWING OVAL
				g.setColor(Color.BLACK);g.drawOval(x, y, cw, ch);
				g.setColor(Color.CYAN);g.fillOval(x, y, cw, ch);
				
				// SETTING UP THE FONT
				if(i==0) {
					g.setFont(new Font("Monaco", Font.PLAIN, 20));
					g.setColor(Color.BLACK);g.drawString("ST", (2*x+cw)/2-cw/6,(2*y+ch)/2+ch/15);
				}
				else if(i==4){
					g.setFont( new Font("Monaco", Font.PLAIN, 20));				
					g.setColor(Color.BLACK);g.drawString("WT", (2*x+cw)/2-cw/6,(2*y+ch)/2+ch/15);				
					break;
				}
				else {
					g.setFont(new Font("Monaco", Font.PLAIN, 20));
					g.setColor(Color.BLACK);g.drawString("IT"+i, (2*x+cw)/2-cw/6,(2*y+ch)/2+ch/15);
				}
				
				// DRAWING LINE 
				x+=cw;y+=ch;x2=x+lw;y2=y+lh;
				g.setColor(Color.BLACK);g.drawLine(x, y, x2, y2);
				
				// DRAWING POLYGON 
				int xValues1[] = {x2+5,x2+10,x2-5};
				int yValues1[] = {y2-5,y2+10,y2+5};
				g.drawPolygon(xValues1, yValues1, 3);
				g.fillPolygon(xValues1, yValues1, 3);
				
				// DRAWING SECOND OVAL
				x+=lw+15;y+=lh;
				g.setColor(Color.BLACK);g.drawOval(x, y, cw, ch);			
				g.setColor(Color.ORANGE);g.fillOval(x, y, cw, ch);
			    	g.setFont(new Font("Monaco", Font.PLAIN, 20));			
				g.setColor(Color.BLACK);g.drawString("B"+(i+1), (2*x+cw)/2-cw/6,(2*y+ch)/2+ch/15);
				
				// AND THE SECOND LINE WITH POLYGON
				x+=cw;x2=x+lw;y2=y-lh;
				g.setColor(Color.BLACK);
				g.drawLine(x, y,x2, y2);
				int xValues2[] = {x2+5,x2+10,x2-5};
				int yValues2[] = {y2+5,y2-10,y2-5};
				g.drawPolygon(xValues2, yValues2, 3);
				g.fillPolygon(xValues2, yValues2, 3);
				g.setColor(Color.CYAN);
				x+=lw;y=y-lh-ch; 
				
				// DRAWING SMALL RECTANGLES WITH POLYGON
				g.setColor(Color.BLACK);
				for(int j=0;j<8;j++) {
					g.fillRect(rx, ry, 5, 5);
					rx+=20;
				}
				int yValues[] = {ry+10,ry-10,ry};
				int xValues[] = {rx,rx,rx+18};
				g.fillPolygon(xValues, yValues, 3);
				rx+=cw+45;	
			}
			
			//TO SLEEP FOR 1.5 SECONDS
			try {Thread.sleep(1500);}
			catch(Exception e) {}
	
			//REPAINTING PART
			x=10;y=185;x2=0;y2=0;rx=x+cw+10;ry=y+(ch/2);
			for(int i=0;i<5;i++) {
				
				// USING RANDOM VALUE FOR SLEEPING
				Random rand = new Random();
				int value = rand.nextInt(2000); 		
				
				// SLEEPING FOR THE OVAL REPAINTING
				try {
					Thread.sleep(value);
					g.setColor(Color.GREEN);g.drawOval(x, y, cw, ch);
					g.setColor(Color.GREEN);g.fillOval(x, y, cw, ch);
				}
				catch(Exception e) {
					e.printStackTrace();
				}			
				
				if(i==0) {
					g.setFont(new Font("Monaco", Font.PLAIN, 20));
					g.setColor(Color.BLACK);g.drawString("ST", (2*x+cw)/2-cw/6,(2*y+ch)/2+ch/15);
				}
				else if(i==4){
					g.setFont( new Font("Monaco", Font.PLAIN, 20));				
					g.setColor(Color.BLACK);g.drawString("WT", (2*x+cw)/2-cw/6,(2*y+ch)/2+ch/15);				
					System.out.println("Thread WT"+" got the message.");			
					break;
				}
				else {
				    g.setFont(new Font("Monaco", Font.PLAIN, 20));
					g.setColor(Color.BLACK);g.drawString("IT"+i, (2*x+cw)/2-cw/6,(2*y+ch)/2+ch/15);
					System.out.println("Thread IT"+i+" got the message.");			
				}
				
				x+=cw;y+=ch;x2=x+lw;y2=y+lh;
				// SLEEPING FOR THE LINE REPAINTING WITH POLYGON
				try {
					Thread.sleep(value);
					g.setColor(Color.GREEN);g.drawLine(x, y, x2, y2);
					int xValues1[] = {x2+5,x2+10,x2-5};
					int yValues1[] = {y2-5,y2+10,y2+5};
					g.drawPolygon(xValues1, yValues1, 3);
					g.fillPolygon(xValues1, yValues1, 3);
				}
				catch(Exception e) {
					e.printStackTrace();
				}			
	
				x+=lw+15;y+=lh;
				// REPAINTING THE SECOND OVAL
				try {
					Thread.sleep(value);
					g.setColor(Color.GREEN);g.drawOval(x, y, cw, ch);			
					g.setColor(Color.GREEN);g.fillOval(x, y, cw, ch);
				}
				catch(Exception e) {
					e.printStackTrace();
				}			
			    g.setFont(new Font("Monaco", Font.PLAIN, 20));			
				g.setColor(Color.BLACK);g.drawString("B"+(i+1), (2*x+cw)/2-cw/6,(2*y+ch)/2+ch/15);
				
				x+=cw;x2=x+lw;y2=y-lh;
				//REPAINTING THE SECOND LINE WITH POLYGON
				try {
					Thread.sleep(value);
					g.setColor(Color.GREEN);
					g.drawLine(x, y,x2, y2);
					int xValues2[] = {x2+5,x2+10,x2-5};
					int yValues2[] = {y2+5,y2-10,y2-5};
					g.drawPolygon(xValues2, yValues2, 3);
					g.fillPolygon(xValues2, yValues2, 3);
				}
				catch(Exception e) {
					e.printStackTrace();
				}			
				
				x+=lw;y=y-lh-ch; 
				g.setColor(Color.BLACK);
				for(int j=0;j<8;j++) {
					g.fillRect(rx, ry, 5, 5);
					rx+=20;
				}
				int yValues[] = {ry+10,ry-10,ry};
				int xValues[] = {rx,rx,rx+18};
				g.fillPolygon(xValues, yValues, 3);
				rx+=cw+45;	
			}
			isActive = false;
		}
	}
	
	public DrawCircle() {
		setTitle("AFRASIYAB&ORKHAN"); // set title 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to give a function when the window closes
		setSize(1400,600); // setting size of window
		setBackground(Color.WHITE);	
	}
	
	public static void main(String[] args) {
		DrawCircle f = new DrawCircle(); // to create a JFrame
		f.setVisible(true); // to display the window
	}
	
	
}
