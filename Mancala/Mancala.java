import java.util.Scanner;

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

    public int size(){
	return _red.length;
    }

    public static void turn(int i){
	i = i-1;
	if (_turn == 1 || _turn % 2 == 1){ //ODD -- PLAYER1
	    //take from the red
	    _hand = _red[i];
	    _red[i] = 0;
	    //if hand == 0 we throw exception
	    addRed(i-1);
	    while (_hand != 0){
		if (_hand != 0){ //if u reach front of red array
		    _redPit++; //just drop one in pit
		    _hand--;
		}
		if (_hand != 0){ //if you still have more
		    addBlue(0); //start at blue pit
		} 
		System.out.println("yay")
		if (_hand != 0){ //final check 
		    _bluePit++; //drop one in pit
		    _hand--;
		}
		if (_hand != 0){
		    addRed(_red.length);
		}
		if (_hand == 0)
		    break;
	    } //while loop until your hand is 0 (aka no more marbles)
	}
	else { //EVEN -- PLAYER2
	    //take from the blue
	    _hand = _blue[i];
	    _blue[i] = 0;
	    //if hand == 0 we throw exception
	    addBlue(i);
	    while (_hand != 0){
		if (_hand != 0){ //if u reach end of blue array
		    _bluePit++; //just drop one in pit
		    _hand--;
		}
		if (_hand != 0){ //if you still have more
		    addRed(_red.length); //start at end of red pit
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
	    _red[i]++;
	    _hand--;
	}
    }

    public static void addBlue(int index){
	for (int i = 0; i <= index; i++){
	    _blue[i]++;
	    _hand--;
	}
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
	//int a = Integer.parseInt(args[0]);
	//int b = Integer.parseInt(args[1]);
	System.out.println();
	System.out.println("Welcome to Mancala! This is your board:");
	while (_winnerr == false){
	    System.out.println(game);
	    if (_turn % 2 == 1) 
		System.out.println("Player 1: Which hole would you like to pick up from? ");
	    if (_turn % 2 == 0)
		System.out.println("Player 2: Which hole would you like to pick up from? ");
	    int x = io.nextInt();
	    turn(x);
	}
	System.out.println(game); //prints even when play wins
	
    }

} //end



