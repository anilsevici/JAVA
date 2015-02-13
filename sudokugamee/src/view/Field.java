package view;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;


/**
 * Bu class Sudokuki celleri temsil eder.Her hücre Jlabelden olusmustur.
 * @author ANIL
 *
 */
public class Field extends JLabel {
    
	private static final long serialVersionUID = 1L;           
	
	private int x;      
    private int y;      

    
    public Field(int x, int y) {
        super("", CENTER);
        this.x = x;
        this.y = y;
                                                                                 
        setPreferredSize(new Dimension(60,60));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        setOpaque(true);
    }

  
    public void setNumber(int number, boolean userInput) {
        setForeground(userInput ? Color.BLUE : Color.BLACK);
        setText(number > 0 ? number + "" : "");
    }

   
    public int getFieldX() {
        return x;
    }

 
    public int getFieldY() {
        return y;
    }


}
