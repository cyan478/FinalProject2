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
	int r;
	if (_turn%2 == 1){
	    //take from the red
	    r = _red[i];
	    _red[i] = 0;
	}
	else{
	    //take from blue
	    r = _blue[i];
	    _blue[i] = 0;
	}
  	
	_turn++;
	System.out.println(this);
    }

    //hi



    //increment ============================================
    public void inc(int hand){
	hand++;
    }

    //decrement ============================================
    public void dec(int hand){
	hand--;
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



