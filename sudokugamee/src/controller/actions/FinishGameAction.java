package controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Game;



/**
 * Bu class Finish Buttonuna týklandýgýnda olusan eventi temsil eder.Javadaki Action interfaceini implemente eder.
 * @author ANIL
 *
 */
public class FinishGameAction extends AbstractAction {
	
	
	
	private static final long serialVersionUID = 1L;
	private Game game;
	public FinishGameAction(Game game){
		setGame(game);
	}
	
	
	
	public Game getGame() {
		return game;
	}



	public void setGame(Game game) {
		this.game = game;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		  getGame().setFinishGame();
		
	}

}
