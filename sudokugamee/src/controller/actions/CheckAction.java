package controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Game;

/**
 * Kullan�c�n�n girdigi degerlerin oyun icindeki dogrulugunu yanl�sl�g�n� kontrol eder.Eger dogruysa yesil yanl�ssa k�rm�z� yan�p yol g�sterir.
 * Javadaki Action interfaceini implemente eder AbstractAction s�n�f�ndan kal�t�l�r.
 * @author ANIL
 *
 */
public class CheckAction extends AbstractAction {
	  
	  private static final long serialVersionUID = 1L;
	  private Game game;
	
      public CheckAction(Game game){
    	  super("Check");
    	  setGame(game);
      }
      
      public void actionPerformed(ActionEvent e){
    	  getGame().checkGame();
      }
      
      public Game getGame() {
  		return game;
  	 }

  	 public void setGame(Game game) {
  		this.game = game;
  	 }
}
