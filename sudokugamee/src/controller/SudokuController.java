package controller;


import controller.actions.SudokuPanelAction;
import model.Game;
import view.SudokuPanel;



/**
 * Sudokudaki CommandPattern invoker classtýr.Her panele mouselistener eklenir.
 *
 */
public class SudokuController {
   

    private SudokuPanel panel;
    private Game game;
    public SudokuController(SudokuPanel panel,Game game) {
        this.panel=panel;
        this.game=game;
    }

    public void updateController() {
    	for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++)
                 panel.getPanels()[y][x].addMouseListener(new SudokuPanelAction(game));
                
        } 
    	
    }
    
}
    
  

