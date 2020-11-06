/**Programmer: Christina Song
 * Date: September
 * Program Name: TicTacEvent.java
 * Program Description: This program runs the GUI for Tic Tac Toe
*/
 

//use the classes that will b required for the program

import javax.swing.*; 

import java.awt.event.*; 
import java.awt.*; 
	
//create a class that responds to mouse & keyboard input by "listening"
public class TicTacEvent implements ItemListener, ActionListener, Runnable
{
	public ImageIcon back2 = new ImageIcon("cardback.jpg ");
	
	//associate the game board with the event
	TicTac gui;
	
	//declare threads
	Thread playing;
	Thread resetting;
	
	ImageIcon a = new ImageIcon("x.jpg");
	ImageIcon b = new ImageIcon("o.jpg");
	int clicks = 0;
	int win = 0;
	int[][] check = new int[3][3];

	//associate the 2 files to b used together
	public TicTacEvent (TicTac in)
	{
	        
		gui = in;
	        
	    //initiates winner check array
	    for (int row=0; row<=2; row++)
	    {
	    	for (int col=0; col<=2; col++)
	        {
	    		check[row][col]=0;
	        }
	       
	     }
	}
	//tell program what to do when button clicked
	public void actionPerformed (ActionEvent event) 
	{
		//take button name as input from button that is clicked
		String command = event.getActionCommand();
		
		//check command variable and call appropiate method
	    if (command.equals("Play")) 
	    {
	    	System.out.print("play has been clicked");
	    	startPlaying();
	    }
	    if (command.equals("1")) 
	    {
	        b1();
	    }
	    if (command.equals("2")) 
	    {
	        b2();
	    }
	    if (command.equals("3")) 
	    {
	        b3();
	    }
	    if (command.equals("4")) 
	    {
	    	b4();
	    }
	    if (command.equals("5")) 
	    {
	        b5();
	    }
	    if (command.equals("6")) 
	    {
	        b6();
	    }
	    if (command.equals("7")) 
	    {
	        b7();
	    }
	    if (command.equals("8")) 
	    {
	        b8();
	    }
	    if (command.equals("9")) 
	    {
	        b9();
	    }
	    if (command.equals("Reset"))
	    {
	    	startResetting();
	    }
	}
	
	void b1() 
	{
        //keep track of # of boxes chosen 
		clicks = clicks + 1;
        
		//put X on board and declare that square to b taken
		if ((clicks%2)==1)
        {
            gui.boxes[0][0].setIcon(a);
            check[0][0] = 1;
        } 
        //put O on board and declare that square to b taken
		else 
        {
            gui.boxes[0][0].setIcon(b);
            check[0][0] = 2;
        }
		//check for winner
		winner();
	}
	
	void b2() 
	{
        clicks = clicks + 1;
        if ((clicks%2)==1)
        {
            gui.boxes[0][1].setIcon(a);
            check[0][1] = 1;
        } 
        else 
        {
            gui.boxes[0][1].setIcon(b);
            check[0][1] = 2;
        }
        //check for winner
      	winner();
	}
	
	void b3() 
	{
        clicks = clicks + 1;
        if ((clicks%2)==1)
        {
            gui.boxes[0][2].setIcon(a);
            check[0][2] = 1;
        } 
        else 
        {
            gui.boxes[0][2].setIcon(b);
            check[0][2] = 2;
        }
      //check for winner
      	winner();
	}
	
	void b4() 
	{
        clicks = clicks + 1;
        if ((clicks%2)==1)
        {
            gui.boxes[1][0].setIcon(a);
            check[1][0] = 1;
        } 
        else 
        {
            gui.boxes[1][0].setIcon(b);
            check[1][0] = 2;
        }
      //check for winner
      	winner();
	}
	
	void b5() 
	{
        clicks = clicks + 1;
        if ((clicks%2)==1)
        {
            gui.boxes[1][1].setIcon(a);
            check[1][1] = 1;
        } 
        else 
        {
            gui.boxes[1][1].setIcon(b);
            check[1][1] = 2;
        }
      //check for winner
      	winner();
	}
	
	void b6() 
	{
        clicks = clicks + 1;
        if ((clicks%2)==1)
        {
            gui.boxes[1][2].setIcon(a);
            check[1][2] = 1;
        } 
        else 
        {
            gui.boxes[1][2].setIcon(b);
            check[1][2] = 2;
        }
      //check for winner
      	winner();
	}
	
	void b7() 
	{
        clicks = clicks + 1;
        if ((clicks%2)==1)
        {
            gui.boxes[2][0].setIcon(a);
            check[2][0] = 1;
        } 
        else 
        {
            gui.boxes[2][0].setIcon(b);
            check[2][0] = 2;
        }
      //check for winner
      	winner();
	}
	
	void b8() 
	{
        clicks = clicks + 1;
        if ((clicks%2)==1)
        {
            gui.boxes[2][1].setIcon(a);
            check[2][1] = 1;
        } 
        else 
        {
            gui.boxes[2][1].setIcon(b);
            check[2][1] = 2;
        }
      //check for winner
      	winner();
	}
	
	void b9() 
	{
        clicks = clicks + 1;
        if ((clicks%2)==1)
        {
            gui.boxes[2][2].setIcon(a);
            check[2][2] = 1;
        } 
        else 
        {
            gui.boxes[2][2].setIcon(b);
            check[2][2] = 2;
        }
      //check for winner
      	winner();
	}
	void startPlaying() 
	{
        
		//Thread = the execution of the program
		//this = within an instance method or constructor, this is a reference to the current object
		playing = new Thread(this);
        
		//start game
		playing.start();
		
		//disables the play button
        gui.play.setEnabled(false);
    }
	void startResetting()
	{
		
		resetting = new Thread(this);
		
		//reset game
		resetting.start();
		
		//for loop to go through all boxes and make them blank
		for (int x = 0; x<=2; x++)
		{
			for (int y = 0; y<=2; y++)
			{
				gui.boxes[x][y].setIcon(back2);
			}
		}
		
		//reset boxes
		for (int x=0; x<=2; x++)
		{
			for (int y=0; y<=2;y++)
			{
				check[x][y]=0;
			}
		}
		
		
	}
	
	void winner() 
	{
		//checks each row for winner
		for (int x=0; x<=2; x++)
		{
		    //checks to see if all entries are all X or all O        
			if ((check[x][0]==check[x][1])&&(check[x][0]==check[x][2])) 	            
			{
		         if (check[x][0]==1) 
		         {
		             JOptionPane.showMessageDialog(null, "X is the winner");
		             win = 1;
		         } 
		         else if (check[x][0]==2)
		         {
		             //create a pop up box to declare winner  
		        	 JOptionPane.showMessageDialog(null, "Y is the winner");
		             win = 1;
		         }
		            
		    }
		}
		//checks each row
		for (int x=0; x<=2; x++)
		{
            if ((check[0][x]==check[1][x])&&(check[0][x]==check[2][x])) 
            {
                if (check[0][x]==1) 
                {
                    JOptionPane.showMessageDialog(null, "X is the winner");
                    win = 1;
                } 
                else if (check[0][x]==2) 
                {
                    JOptionPane.showMessageDialog(null, "Y is the winner");
                    win = 1;
                }
            }
        }
		//check for diagonal matches
		if (((check[0][0]==check[1][1])&&(check[0][0]==check[2][2]))||
                ((check[2][0]==check[1][1])&&(check[1][1]==check[0][2])))
		{
            //checks for X or O winner
			if (check[1][1]==1) 
            {
                JOptionPane.showMessageDialog(null, "X is the winner");
                win = 1;
            } 
            else if (check[1][1]==2) 
            {
                JOptionPane.showMessageDialog(null, "Y is the winner");
                win = 1;
            }
        }
		if ((clicks==9) && (win==0)) //game is tired
		{
            JOptionPane.showMessageDialog(null, "The game is a tie");
        }
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
	public void itemStateChanged(ItemEvent e) 
	{         
		throw new UnsupportedOperationException("Not supported yet.");     
	} 
	 
    public void run() 
    {        
    	throw new UnsupportedOperationException("Not supported yet.");     
    } 
 
 

}
