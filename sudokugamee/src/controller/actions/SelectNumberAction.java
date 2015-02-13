package controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Game;


/**
 * Paneldeki secilen rakam butonlarýndan sudokudaki olabilecek yerleri gösterir.Ayný zamanda sudokuya girilmesi gereken rakamýda secer.
 * @author ANIL
 *
 */
public class SelectNumberAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	private Game game;
	public SelectNumberAction(Game game){
		setGame(game);
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void actionPerformed(ActionEvent e){
		getGame().setSelectedNumber(Integer.parseInt(e.getActionCommand())); 
	}

}
