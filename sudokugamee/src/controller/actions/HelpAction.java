package controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;

import model.Game;

public class HelpAction extends AbstractAction {
	
	
	private static final long serialVersionUID = 1L;
	private Game game;

	public HelpAction(Game game){
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
		game.setHelp(((JCheckBox)e.getSource()).isSelected());
	}

}
