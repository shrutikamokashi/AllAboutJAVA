import java.util.*;
/*
 * Whack a mole game.
 */

public class WhackAMole {
    
    int score, molesLeft, attemptsLeft = 0;
    char[][] moleGrid;
    
    /* Constructor to define number of attempts and Grid dimension. 
     * It also initializes our grid.
     */
    WhackAMole(int numAttempts, int gridDimension) {
	this.attemptsLeft = numAttempts;
	moleGrid = new char[gridDimension][gridDimension];
	for(int i = 0; i < gridDimension; i++) {
	    for(int j = 0; j < gridDimension; j++) {
		moleGrid[i][j] = '*';
	    }	    
	}
    }
    
    /*
     *Method to place moles in the given location. 
     */
    boolean place(int x, int y) {
	if(moleGrid[x][y] == '*') {
	    moleGrid[x][y] = 'M';
	    molesLeft += 1;
	    return true;
	}
	else {
	    return false;
	}
    }
    
    /*
     * Method to whack the mole where i & j are coordinates provided by user.
     */
    void whack(int x, int y) {
	attemptsLeft -= 1;
	if (moleGrid[x][y] == 'M') {
	    moleGrid[x][y] = 'W';
	    score += 1;
	    molesLeft -= 1;
	}		
    }
    
    /*
     * Method to Print the grid to used without showing the moles.
     */
    void printGridToUser(int gridDimension) {
	for(int i = 0; i < gridDimension; i++) {
	    String row = "";
	    for(int j = 0; j < gridDimension; j++) {
		if (moleGrid[i][j] == 'M') {
		    row = row + " " + '*';
		}
		else {
		    row = row + " " + moleGrid[i][j];
		}
	    }
	    System.out.println(row);	    
	}
	
    }
    
    /*
     * Method to print the grid as is.
     */
    void printGrid(int gridDimension) {
	for(int i = 0; i < gridDimension; i++) {
	    String row = "";
	    for(int j = 0; j < gridDimension; j++) {
		row = row + " " + moleGrid[i][j];
	    }
	    System.out.println(row);	    
	}
	
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("Hello to Whack a mole game!"+"\n"+
	"You have max 50 attempts to get all moles."+"\n"+"Or enter -1,-1 to exit!");
	
	WhackAMole whkm = new WhackAMole(50,10);
	
	// Place 10 moles, at random places in grid
	Random randNum = new Random();
	int i = 1;
	while (i <= 10) {
	    int x = randNum.nextInt(10);
	    int y = randNum.nextInt(10);
	    boolean result = whkm.place(x,y);
	    if (result){
		i++;
	    }
	}
	
	// Scanner to take the coordinates from user.
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a coordinate from 0-9 to whack!: ");
	while(whkm.attemptsLeft <= 50) {
	    String input =  sc.nextLine();
	    String[] arrOfStr = input.split(",", 2);
	    int x = Integer.valueOf(arrOfStr[0]);
	    int y = Integer.valueOf(arrOfStr[1]);
	    if (x >= 0 && y >= 0) {
		whkm.whack(x, y);
		whkm.printGridToUser(10);
	    }
	    else {
		whkm.printGrid(10);
	    }
	}
	whkm.printGrid(10);    
	
	

    }

}
