package controller;



import controller.actions.CheckAction;
import controller.actions.ExitAction;
import controller.actions.FinishGameAction;
import controller.actions.HelpAction;
import controller.actions.NewGameAction;
import controller.actions.SelectNumberAction;
import controller.actions.SolutionAction;
import model.Game;
import view.ButtonPanel;


/**
 * Command pattern icin invoker classtýr.
 * @author ANIL
 *
 */
public class ButtonController  {
   
      
	private ButtonPanel button;
	private Game game;
    public ButtonController(ButtonPanel button,Game game) {
       this.button=button;
       this.game=game;
       
    }

   
   public void updateController(){  
	   button.getBtnNew().addActionListener(new NewGameAction(game));
	   button.getBtnExit().addActionListener(new ExitAction(game));
	   button.getBtnFinish().addActionListener(new FinishGameAction(game));
	   button.getCbHelp().addActionListener(new HelpAction(game));
	   button.getBtnCheck().addActionListener(new CheckAction(game));
	   button.getBtnSolution().addActionListener(new SolutionAction(game));
	   
	   for (int i = 0; i < 9; i++)
		button.getBtnNumbers()[i].addActionListener(new SelectNumberAction(game));   
	   
   }
}
