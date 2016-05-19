//goes in a circular direction counterclockwise

public class Mancala {

    public int [] _red, _blue;
    public int _redPit, _bluePit, _hand, _turn;

    public Mancala(){
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

    public void turn(int i){
	if (_turn % 2 == 1){ //ODD -- PLAYER1
	    //take from the red
	    _hand = _red[i];
	    _red[i] = 0;
	    //if hand == 0 we throw exception
	    addRed(i);
	    while (_hand != 0){
		if (_hand != 0){ //if u reach front of red array
		    _redPit++; //just drop one in pit
		    _hand--;
		}
		if (_hand != 0){ //if you still have more
		    addBlue(0); //start at blue pit
		} 
		if (_hand != 0){ //final check 
		    _bluePit++; //drop one in pit
		    _hand--;
		}
		if (_hand != 0){
		    addRed(_red.length);
		}
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
	_turn++;
	System.out.println(this);
	}
    }

    public void addRed(int index){
	for (int i = index; i>0; i--){
	    _red[i]++;
	    _hand--;
	}
    }

    public void addBlue(int index){
	for (int i = 0; i < index; i++){
	    _blue[i]++;
	    _hand--;
	}
    }
    
    public boolean winner(){ //true means the game ends
	boolean redEmpty = true;
	boolean blueEmpty = true;
	for (int i = 0; i < _red.length; i++){
	    if (_red[i] != 0)
		redEmpty = false; //if there are still marbles in red
	    if (_blue[i] != 0)
		blueEmpty = false; //same for blue
	}
	return redEmpty || blueEmpty; //if any array is empty -> true
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
	System.out.println(game);

    }

} //end



