package view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import model.UpdateAction;




/**
 * Bu class Butonlarýn  olusturdugu kýsýmdýr.Gamedeki degisikleri(update) uygulayan classlardan biridir.
 * @author ANIL
 *
 */
public class ButtonPanel extends JPanel implements Observer {
   
	
	private static final long serialVersionUID = 1L;
	private JButton btnNew, btnCheck, btnExit,btnSolution,btnFinish;   
    private JCheckBox cbHelp;               
    private ButtonGroup bgNumbers;          
    private JToggleButton[] btnNumbers;     

  
    public ButtonPanel() {
        super(new BorderLayout());

        JPanel pnlAlign = new JPanel();
        pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.Y_AXIS));
        add(pnlAlign, BorderLayout.NORTH);

        JPanel pnlOptions = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlOptions.setBorder(BorderFactory.createTitledBorder(" SECENEKLER "));
        pnlAlign.add(pnlOptions);

        btnNew = new JButton("NEW GAME");
        btnNew.setFocusable(false);
        btnNew.setBackground(Color.RED);
        btnNew.setForeground(Color.blue);
        btnNew.setPreferredSize(new Dimension(100,50));
        pnlOptions.add(btnNew);

        btnCheck = new JButton("CHECK");
        btnCheck.setFocusable(false);
        btnCheck.setBackground(Color.RED);
        btnCheck.setForeground(Color.blue);
        btnCheck.setPreferredSize(new Dimension(100,50));
        pnlOptions.add(btnCheck);
        
        btnFinish = new JButton("FINISH GAME");
        btnFinish.setFocusable(false);
        btnFinish.setBackground(Color.RED);
        btnFinish.setForeground(Color.blue);
        btnFinish.setPreferredSize(new Dimension(100,50));
        pnlOptions.add(btnFinish);
        
        btnSolution=new JButton("QUICKSOLUTION");
        btnSolution.setFocusable(false);
        btnSolution.setBackground(Color.RED);
        btnSolution.setForeground(Color.blue);
        btnSolution.setPreferredSize(new Dimension(150,50));
        pnlOptions.add(btnSolution);
        

        btnExit = new JButton("EXIT GAME");
        btnExit.setFocusable(false);
        btnExit.setBackground(Color.RED);
        btnExit.setForeground(Color.blue);
        btnExit.setPreferredSize(new Dimension(100,50));
        pnlOptions.add(btnExit);

        JPanel pnlNumbers = new JPanel();
        pnlNumbers.setLayout(new BoxLayout(pnlNumbers, BoxLayout.Y_AXIS));    
        pnlNumbers.setBorder(BorderFactory.createTitledBorder("NUMBERS"));  
        pnlAlign.add(pnlNumbers);

        JPanel pnlNumbersHelp = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlNumbers.add(pnlNumbersHelp);

        cbHelp = new JCheckBox("HELP", true);
        cbHelp.setBackground(Color.GREEN);
        cbHelp.setPreferredSize(new Dimension(60,30));
        cbHelp.setFocusable(false);
        pnlNumbersHelp.add(cbHelp);

        
        JPanel pnlNumbersNumbers = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlNumbers.add(pnlNumbersNumbers);   

        bgNumbers = new ButtonGroup();
        btnNumbers = new JToggleButton[9];
        for (int i = 0; i < 9; i++) {
            btnNumbers[i] = new JToggleButton("" + (i + 1));
            btnNumbers[i].setPreferredSize(new Dimension(50, 50));
            btnNumbers[i].setForeground(Color.RED);
            btnNumbers[i].setFont(new Font("Serif", Font.BOLD, 14));
            btnNumbers[i].setFocusable(false);
            bgNumbers.add(btnNumbers[i]);
            pnlNumbersNumbers.add(btnNumbers[i]);
        }
       
    }

    public JButton getBtnSolution() {
		return btnSolution;
	}

	public JButton getBtnNew() {
		return btnNew;
	}

	public JButton getBtnCheck() {
		return btnCheck;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public JButton getBtnFinish() {
		return btnFinish;
	}

	public JCheckBox getCbHelp() {
		return cbHelp;
	}

	public ButtonGroup getBgNumbers() {
		return bgNumbers;
	}

	public JToggleButton[] getBtnNumbers() {
		return btnNumbers;
	}

	
    public void update(Observable o, Object arg) {
        switch ((UpdateAction)arg) {
            case NEW_GAME:
            case CHECK:    
                bgNumbers.clearSelection(); 
                break;
		default:
			break;
        }
    }

   
}