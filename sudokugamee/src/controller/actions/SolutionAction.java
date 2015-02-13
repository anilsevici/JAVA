package controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Game;

/**
 * Sudoku oyununundaki quickSolution butonuna basýp cozumu gösterir
 * @author ANIL
 *
 */
public class SolutionAction extends AbstractAction {
	
	
	private static final long serialVersionUID = 1L;
	private Game game;
	public SolutionAction(Game game){
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
		// TODO Auto-generated method stub
	    getGame().quickSolution();	
	}

}
