package sudokugamee;

import junit.framework.Assert;
import model.Game;

import org.junit.BeforeClass;
import org.junit.Test;


@SuppressWarnings("deprecation")
public class SudokuGameTest {
     
	private static Game game;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		game = new Game();
		
	}
    
	//Hücrelerin oyundaki testi.
	@Test
	public void testFields() {
		 game.setNumber(2, 2, 9);
		 Assert.assertEquals(game.getNumber(2, 2), 9);
	}
	
	//Sütun , satýr ya da blocklarýn sudokudaki toplamý 45 olmalýdýr.
    @Test
    public void testSumTotals(){
    	
        for (int i=0 ; i <9 ; i++){
        	Assert.assertEquals(sumRow(game.getSolution(),i), 45);
        	Assert.assertEquals(sumColumn(game.getSolution(),i), 45);
        	
        	for(int j=0 ; j<3; j++)
        		Assert.assertEquals(sumBlock(game.getSolution(),i,j*3), 45);
        	
        }
    	
    }
    
    private int  sumRow (int [][] solution , int row){
    	int sum=0;
    	for(int i=0 ; i<solution[row].length; i++)
    		sum+=solution[row][i];
    	
    	return sum;
    }
    
    private int  sumColumn (int [][] solution , int col){
    	int sum=0;
    	for(int i=0 ; i<solution[col].length; i++)
    		sum+=solution[i][col];
    	
    	return sum;
    }
    
    private int sumBlock ( int [][] solution , int index1 , int index2){
    	
    	int sum=0;
    	index1=index1 - (index1 %3);
    	index2=index2 - (index2%3);
    	
    	for(int i=index1 ; i<index1+3 ; i++)
    		for(int j=index2 ; j<index2+3; j++ )
    			   sum+=solution[i][j];
    	
    	return sum;
    }
    
    //Kullanýcýnýn girdigi degerin dogrulugunun testi.
    @Test
    public void GameTests(){
    	game.setNumber(0, 0, game.getSolution(0, 0));
    	game.checkGame();
    	Assert.assertTrue(game.isCheckValid(0, 0));
    }
    
    //Oyun dogru yaratýlmýs mý testi.
    @Test
    public void isGameEquals(){
    	Assert.assertTrue(game.getGame().equals(game.getGame()));
    }

}
