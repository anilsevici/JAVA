package controller.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Game;

/**
 * Kullanýcýnýn girdigi degerlerin oyun icindeki dogrulugunu yanlýslýgýný kontrol eder.Eger dogruysa yesil yanlýssa kýrmýzý yanýp yol gösterir.
 * Javadaki Action interfaceini implemente eder AbstractAction sýnýfýndan kalýtýlýr.
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
