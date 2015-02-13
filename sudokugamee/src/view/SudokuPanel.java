package view;



import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.exception.NotFinishGameException;
import model.Game;
import model.UpdateAction;



/**
 * Bu class Sudoku oyun tahtasýnýn yaratýldýgý kýsýmdýr.Gamedeki degisikleri update eden classlardan biridir.
 * @author ANIL
 *
 */
public class SudokuPanel extends JPanel implements Observer {
    
	private static final long serialVersionUID = 1L;
    private Field[][] fields;       
    private JPanel[][] panels;     

   
    public SudokuPanel() {
        super(new GridLayout(3, 3));

        panels = new JPanel[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                panels[y][x] = new JPanel(new GridLayout(3, 3));
                if(x+y==1 || x+y==3)
                	panels[y][x].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                else
                panels[y][x].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)); 
                
                add(panels[y][x]);
            }
        }

        fields = new Field[9][9];
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x] = new Field(x, y);
                panels[y / 3][x / 3].add(fields[y][x]); 
            }
        }
    }

    public Field[][] getFields() {
		return fields;
	}

	public JPanel[][] getPanels() {
		return panels;
	}

	
    public void update(Observable o, Object arg) {
        switch ((UpdateAction)arg) {
            case NEW_GAME:
                setGame((Game)o);
                break;
            case CHECK:
				setGameCheck((Game)o);
	            break;
            case SOLUTION:
            	setSolution((Game)o);
            	break;
            case FINISH:
			try {
				setFinish((Game)o);
			} catch (NotFinishGameException e) {
				JOptionPane.showMessageDialog(JOptionPane.getRootFrame() ,e.getMessage() ,"WARNING" , JOptionPane.WARNING_MESSAGE);
			}
            	 break;
            case SELECTED_NUMBER:
            case HELP:
                setCandidates((Game)o);
                break;
        }
    }
    
    private void setSolution(Game solution){
    	 for (int y = 0; y < 9; y++) {
             for (int x = 0; x < 9; x++) {
                 fields[y][x].setBackground(Color.WHITE);
                 if(!fields[y][x].getForeground().equals(Color.BLACK) || fields[y][x].getText().equals("")){
                 fields[y][x].setNumber(solution.getSolution(x, y), true);
                 fields[y][x].setForeground(Color.RED);
                 }
             }
         }
    }
    private void setFinish(Game game) throws NotFinishGameException{
    	 for (int y = 0; y < 9; y++) {
             for (int x = 0; x < 9; x++) {
                 
                 if (!game.isCheckValid(x, y))
                	 throw new NotFinishGameException();   
             }
         }
    	 JOptionPane.showMessageDialog(JOptionPane.getRootFrame() ,"CONGRATULATIONS YOU FINISHED GAME" ,"FINISH" , JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    private void setGame(Game game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.WHITE);
                fields[y][x].setNumber(game.getNumber(x, y), false);
            }
        }
    }

   
    private void setGameCheck(Game game){
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.WHITE);
                if (fields[y][x].getForeground().equals(Color.BLUE))
                    fields[y][x].setBackground(game.isCheckValid(x, y) ? Color.GREEN : Color.RED);
            }
        }
    }

   
    private void setCandidates(Game game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.WHITE);
                if (game.isHelp() && game.isSelectedNumberCandidate(x, y))
                    fields[y][x].setBackground(Color.CYAN);
            }
        }
    }
    
}