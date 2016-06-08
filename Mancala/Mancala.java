import java.util.Scanner;
//fu celine

//goes in a circular direction counterclockwise

public class Mancala {

    public static int [] _red, _blue;
    public static int _redPit, _bluePit, _hand;
    public static int _turn;
    public static boolean _winnerr;
    public static Scanner io;

    public Mancala(){
	io = new Scanner(System.in);
	_winnerr = false;
	_red = new int[6];
	_blue = new int [6];
	for (int i = 0; i<6; i++){
	    _red[i] = 4;
	    _blue[i] = 4;
	}
	_redPit = _bluePit = _hand = 0;
	_turn = 1;
    }

    public static int size(){
	return _red.length;
    }

    public static void turn(String k){
	int i = 0;
	try {
	    i = Integer.parseInt(k);
	}
	catch (NumberFormatException e){
	    System.out.println("Invalid hole. Please enter a number between 1 to 6, inclusive.");
	    return;
	}
	if (i ==0)
	    i = 15;
	if (!(i >= 1 || i <= 6)){
	    System.out.println("Invalid hole. Please enter a number between 1 to 6, inclusive.");
	    return;
	}
	
	i = i-1;
	if (_turn == 1 || _turn % 2 == 1){ //ODD -- PLAYER1
	    //take from the red
	    _hand = _red[i];
	    _red[i] = 0;
	    //if hand == 0 we throw exception
	    addRed(i-1);
	    System.out.println("a" + _hand);
	    while (_hand != 0){
		if (_hand != 0){ //if u reach front of red array
		    _redPit++; //just drop one in pit
		    _hand--;
		}
		System.out.println(_hand);
		if (_hand != 0){ //if you still have more
		    addBlue(0); //start at blue pit
		} 
		System.out.println(_hand);
		if (_hand != 0){ //final check 
		    _bluePit++; //drop one in pit
		    _hand--;
		}
		System.out.println(_hand);
		if (_hand != 0){
		    addRed(size()-1);
		}
		//System.out.println("woo");
		if (_hand == 0)
		    break;
	    } //while loop until your hand is 0 (aka no more marbles)
	}
	else { //EVEN -- PLAYER2
	    //take from the blue
	    _hand = _blue[i];
	    _blue[i] = 0;
	    //if hand == 0 we throw exception
	    addBlue(i+1);
	    while (_hand != 0){
		if (_hand != 0){ //if u reach end of blue array
		    _bluePit++; //just drop one in pit
		    _hand--;
		}
		if (_hand != 0){ //if you still have more
		    addRed(size()-1); //start at end of red pit
		} 
		if (_hand != 0){ 
		    _redPit++; //drop one in red pit
		    _hand--;
		}
		if (_hand != 0){
		    addBlue(0); //start at index 0
		}
		if (_hand == 0){
		    break; 
		}
	    } //while loop until your hand is 0 (aka no more marbles)
	}
	_turn++;
    }

    public static void addRed(int index){
	if (index == -1) return;
	for (int i = index; i>=0; i--){
	    System.out.println("w" + _hand);
	    if (_hand == 0)
		break;
	    _red[i]++;
	    _hand--;
	}
    }

    public static void addBlue(int index){
	if (index == size()) return;
	for (int i = index; i < size(); i++){
	    System.out.println("blue" + _hand);
	    if (_hand == 0) 
		break;
	    _blue[i]++;
	    _hand--;
	}
	System.out.println("hi");
    }
    
    public void winner(){ //true means the game ends
	boolean redEmpty = true;
	boolean blueEmpty = true;
	for (int i = 0; i < _red.length; i++){
	    if (_red[i] != 0)
		redEmpty = false; //if there are still marbles in red
	    if (_blue[i] != 0)
		blueEmpty = false; //same for blue
	}
        _winnerr = redEmpty || blueEmpty; //if any array is empty -> true
    }

    //toString =============================================
    public String toString(){
	String ans = "\n";
	ans += "=============== Turn: " + _turn + " ===============";
	ans += "\n\n";
	ans += "           "; 
	for (int i = 0; i < size(); i++)
	    ans += _red[i] + "  ";
	ans += "\n\n";
	ans += "Red Pit: " + "                      Blue Pit: ";
	ans += "\n";
	ans += _redPit + "                              " + _bluePit;
	ans += "\n\n";
        ans += "           "; 
	for (int i = 0; i < size(); i++)
	    ans += _blue[i] + "  ";
	ans += "\n";
	return ans;
    }

    public static void main(String[] args){
	Mancala game = new Mancala();
	int x = 0;
	System.out.println();
	System.out.println("Welcome to Mancala! This is your board:");
	while (_winnerr == false){
	    System.out.println(game);
	    if (_turn % 2 == 1) 
		System.out.println("Player 1: Which hole would you like to pick up from? ");
	    if (_turn % 2 == 0)
		System.out.println("Player 2: Which hole would you like to pick up from? ");
	    String y = io.next();
	    turn(y);
	}
	System.out.println(game); //prints even when play wins
        x = 0;
	if (_turn % 2 == 1)
	    x = 1;
	if (_turn % 2 == 0)
	    x = 2;
	System.out.println("Congratulations to Player " + x + "!");
	System.out.println("It took you " + _turn + " turns to finish the game.");
    }

} //end



