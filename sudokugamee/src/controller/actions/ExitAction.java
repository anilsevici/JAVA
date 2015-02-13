package controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Game;


/**Oyundan c�kar.AbstractAction s�n�f�ndan kal�t�l�p Javadaki Action interfaceini implemente eder.
 * @author ANIL
 *
 */
public class ExitAction extends AbstractAction {
     
	private static final long serialVersionUID = 1L;
	private Game game;
     public ExitAction(Game game){
    	 super("Exit");
    	 setGame(game);
     }
     
     public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void actionPerformed(ActionEvent e){
    	 System.exit(0);
     }
     
}
