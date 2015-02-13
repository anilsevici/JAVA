package controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Game;


/**
 * Paneldeki secilen rakam butonlar�ndan sudokudaki olabilecek yerleri g�sterir.Ayn� zamanda sudokuya girilmesi gereken rakam�da secer.
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
