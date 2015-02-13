package controller.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import model.Game;

/**
 * Yeni oyun baslatýr.
 * @author ANIL
 *
 */
public class NewGameAction  extends AbstractAction {
	
	
	private static final long serialVersionUID = 1L;
	private Game game;
	public NewGameAction(Game game){
		super("New");
		setGame(game);
		
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void actionPerformed(ActionEvent e){
        getGame().newGame();
	}
	

}
