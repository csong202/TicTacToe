//make the drawing classes ready to use
import java.awt.*;
import javax.swing.*;

public class TicTac extends JFrame
{
	//joins the two programs to work with each other
	TicTacEvent tictac = new TicTacEvent(this); 
	
	//create outline box
	JPanel row1 = new JPanel();
	JPanel row2 = new JPanel();
	
	//create nine buttons in a 2D array that is 3 x 3
    JButton[ ] [ ] boxes = new JButton [3][3];
    
    //create buttons and text fields
    JButton play = new JButton ("Play");
    JButton reset = new JButton ("Reset");
    JTextField blank1 = new JTextField();
    JTextField blank2 = new JTextField();
    JOptionPane win = new JOptionPane("Winner");
    public ImageIcon back = new ImageIcon("cardback.jpg ");
	
    //create method to draw game board
    public TicTac() 
    {
    	//create outer frame with the title
        super ("Tic Tac Toe");
        
        //set size of outer frame
        setSize (500,600);
        
        //sets the program to quit running when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //arrange components from left to right, center components horizontally with a 5 pixel gap between them
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        int name = 0;
        String newname;
        
        //arrange components in a rectangular grid, cells are equal size
        GridLayout layout1 = new GridLayout(4, 3, 10, 10);
        row1.setLayout(layout1);
        row2.setLayout(layout1);
        
        //create & add the buttons to the GridLayouts first 3 rows
        for (int x=0; x<=2; x++)
        {
            for (int y=0; y<=2; y++)
            {
                name = name + 1;
                newname = Integer.toString(name);
                boxes[x][y] = new JButton(newname);
                boxes[x][y].setIcon(back);
                row1.add(boxes[x][y]);
                row2.add(boxes[x][y]);
            }
        }
        
        //add remaining components to the GridLayout
        row1.add(blank1);       
        row1.add(blank2);
        row2.add(play);
        row2.add(reset);
        
        //add the GridLayout to the FlowLayout
        add (row1);
        add (row2);
        
        //make the program ready to handle mouse clicks
        play.addActionListener(tictac);
        for (int x=0; x<=2; x++)
        {
            for (int y=0; y<=2; y++)
            {
                boxes[x][y].addActionListener(tictac);
            }
        }
        
        reset.addActionListener(tictac);
        
        
        //show FlowLayout on the screen
        setVisible(true);
    }
    public static void main(String[] args) 
    {
		// TODO Auto-generated method stub
    	//run the screen layout class
    	TicTac frame = new TicTac();
	}

}


