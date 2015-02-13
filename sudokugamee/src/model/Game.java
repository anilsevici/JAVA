package model;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;


/**Bu class Command pattern icin receiver.Ve Observer pattern icin Observable özelligi tasýr.Oyundaki herhangi bir degisiklikte
 * SudokuPanel ve ButtonPanele bildirir.Oyunicin olusturulan sudoku ve kullanýcýnýn olusturdugu sudoku matrisleri vardýr.
 * @author ANIL
 *
 **/
public class Game extends Observable {
    private int[][] solution;      
    private int[][] game;           
    private boolean[][] check;      
    private int selectedNumber;     
    private boolean help;           

    
    public Game() {
        newGame();
        check = new boolean[9][9];
        help = true;  
    }


   public int[][] getSolution() {
		return solution;
	}


	public int[][] getGame() {
		return game;
	}


	//Bu sýnýfý izleyen(observerlara) yeni oyun mesajýný yollar.
    public void newGame() {
        solution = generateSolution(new int[9][9], 0);
        game = generateGame(copy(solution));
        /*System.out.println("----------------------");
        for(int i=0 ; i<9; i++)
        {
        	for(int j=0 ; j<9 ; j++)
        	{
        		  System.out.print(solution[i][j]);
        		  System.out.print("  ");
        	}
        System.out.println();
        }*/
        setChanged();
        notifyObservers(UpdateAction.NEW_GAME);
    }
    
    //Oyun cozumu istegi yollanýr.
    public void quickSolution(){
    	selectedNumber=0;
    	setChanged();
    	notifyObservers(UpdateAction.SOLUTION);
    }
    
    //Kullanýcý oyunu bitirmek isterse calýsýr.
    public void setFinishGame(){
    	GameStatus();
    	setChanged();
    	notifyObservers(UpdateAction.FINISH);
    }

    //Kullanýcýnýn olusturdugu oyunla yaratýlan sudoku oyunu karsýlastýrýlýr.
    public void checkGame() {
        GameStatus();
        selectedNumber = 0;
        setChanged();
        notifyObservers(UpdateAction.CHECK);
    }

   //Help özelligine baglý olarak observerlara bildirim yapýlýr.
    public void setHelp(boolean help) {
        this.help = help;
        setChanged();
        notifyObservers(UpdateAction.HELP);
    }

   //Butonlarýndan secilen rakam secildiginde observarlara ilgili bildirim yapýlýr.
    public void setSelectedNumber(int selectedNumber) {
        this.selectedNumber = selectedNumber;
        setChanged();
        notifyObservers(UpdateAction.SELECTED_NUMBER); 
    }
    
    private void GameStatus(){
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++)
                check[y][x] = game[y][x] == solution[y][x];  
            
        }
    	
    }

  
    public int getSelectedNumber() {
        return selectedNumber;
    }

  
    public boolean isHelp() {
        return help;
    }

   
    public boolean isSelectedNumberCandidate(int x, int y) {
        return game[y][x] == 0 && isPossibleX(game, y, selectedNumber)
                && isPossibleY(game, x, selectedNumber) && isPossibleBlock(game, x, y, selectedNumber);
    }

 
    public void setNumber(int x, int y, int number) {
        game[y][x] = number;
    }

    public int getSolution(int x , int y) {
		return  solution[y][x];
	}


    public int getNumber(int x, int y) {
        return game[y][x];
    }

    
    public boolean isCheckValid(int x, int y) {
        return check[y][x];
    }

 
    private boolean isPossibleX(int[][] game, int y, int number) {
        for (int x = 0; x < 9; x++) {
            if (game[y][x] == number)
                return false;
        }
        return true;
    }

   
    private boolean isPossibleY(int[][] game, int x, int number) {
        for (int y = 0; y < 9; y++) {
            if (game[y][x] == number)
                return false;
        }
        return true;
    }

  
    private boolean isPossibleBlock(int[][] game, int x, int y, int number) {
        int x1 = x < 3 ? 0 : x < 6 ? 3 : 6;
        int y1 = y < 3 ? 0 : y < 6 ? 3 : 6;
        for (int yy = y1; yy < y1 + 3; yy++) {
            for (int xx = x1; xx < x1 + 3; xx++) {
                if (game[yy][xx] == number)
                    return false;
            }
        }
        return true;
    }

  
    private int getNextPossibleNumber(int[][] game, int x, int y, List<Integer> numbers) {
        while (numbers.size() > 0) {
            int number = numbers.remove(0);
            if (isPossibleX(game, y, number) && isPossibleY(game, x, number) && isPossibleBlock(game, x, y, number))
                return number;
        }
        return -1;
    }

   
    private int[][] generateSolution(int[][] game, int index) {
        if (index > 80)
            return game;

        int x = index % 9;
        int y = index / 9;

        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) numbers.add(i);
        Collections.shuffle(numbers);

        while (numbers.size() > 0) {
            int number = getNextPossibleNumber(game, x, y, numbers);
            if (number == -1)
                return null;

            game[y][x] = number;
            int[][] tmpGame = generateSolution(game, index + 1);
            if (tmpGame != null)
                return tmpGame;
            game[y][x] = 0;
        }

        return null;
    }

  
    private int[][] generateGame(int[][] game) {
        List<Integer> positions = new ArrayList<Integer>();
        for (int i = 0; i < 81; i++)
            positions.add(i);
        Collections.shuffle(positions);
        return generateGame(game, positions);
    }

  
    private int[][] generateGame(int[][] game, List<Integer> positions) {
        while (positions.size() > 0) {
            int position = positions.remove(0);
            int x = position % 9;
            int y = position / 9;
            int temp = game[y][x];
            game[y][x] = 0;

            if (!isValid(game))
                game[y][x] = temp;
        }

        return game;
    }

   
    private boolean isValid(int[][] game) {
        return isValid(game, 0, new int[] { 0 });
    }

  
    private boolean isValid(int[][] game, int index, int[] numberOfSolutions) {
        if (index > 80)
            return ++numberOfSolutions[0] == 1;

        int x = index % 9;
        int y = index / 9;

        if (game[y][x] == 0) {
            List<Integer> numbers = new ArrayList<Integer>();
            for (int i = 1; i <= 9; i++)
                numbers.add(i);

            while (numbers.size() > 0) {
                int number = getNextPossibleNumber(game, x, y, numbers);
                if (number == -1)
                    break;
                game[y][x] = number;

                if (!isValid(game, index + 1, numberOfSolutions)) {
                    game[y][x] = 0;
                    return false;
                }
                game[y][x] = 0;
            }
        } else if (!isValid(game, index + 1, numberOfSolutions)) 
            return false;

        return true;
    }

   
    private int[][] copy(int[][] game) {
        int[][] copy = new int[9][9];
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++)
                copy[y][x] = game[y][x];
        }
        return copy;
    }
}