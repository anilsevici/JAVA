package view;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.UIManager;

import model.Game;
import controller.ButtonController;
import controller.SudokuController;



public class Sudoku extends JFrame {
    
	private static final long serialVersionUID = 1L;

	public Sudoku() {
        super("SUDOKU");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        Game game = new Game();//model
        ButtonPanel buttonPanel = new ButtonPanel();//view
        SudokuPanel sudokuPanel = new SudokuPanel();//view
        
        ButtonController controllerButton = new ButtonController(buttonPanel,game);//controller
        controllerButton.updateController();
        
        SudokuController controllerPanel = new SudokuController(sudokuPanel,game);//controller
        controllerPanel.updateController();
        
        add(buttonPanel, BorderLayout.NORTH);
        add(sudokuPanel, BorderLayout.SOUTH);

        game.addObserver(buttonPanel);
        game.addObserver(sudokuPanel);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ex) { ex.printStackTrace(); }
        new Sudoku();
    }
}