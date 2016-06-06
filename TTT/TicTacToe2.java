public class TicTacToe2{

    public int[] _board;
    public int _turn, _userInt, _aiInt;
    public boolean _won;
  

    public TicTacToe2(int i){
	_userInt = i;
	_aiInt = 3-i;
	//1 = user goes on odd turns
	//2 = user goes on even turns
	_board = new int[9];
	_turn = 1;
	_won = false;
	_str = "_________";
    }

    public String strMake(){
	String ans = ""
	for (int i = 0; i<9; i++){
	    if ( _board[i] == 0)
		ans+="_";
	    else if (_board[i] == 1)
		ans +="X";
	    else ans+="O";
	}
	return ans;
    }

    public void deposit(int i){
	_board[i]=_aiInt;
    }
    
    public int firstEmpty(){
	for (int i = 0; i<9; i++){
	    if (_str.substring(i,i+1).equals("_"))
		return i;
	}
	return -1;
    }


    public void respond(){
	if (_turn == 8)
	    deposit(firstEmpty());
    }

    public String toString(){
	String ans = "\n\n";
	ans += "\t"+ _board[0] +" | "+ _board[1] + " | " + _board[2] + "\n";
	ans += "\t---------\n";
	ans += "\t"+ _board[3] +" | "+ _board[4] + " | " + _board[5] + "\n";
	ans += "\t---------\n";
	ans += "\t"+ _board[6] +" | "+ _board[7] + " | " + _board[8] + "\n";

    }

    public static void main (String [] args){
	TicTacToe2 a= new TicTacToe2(1);
	System.out.println(a);
	
    }
}

