public class Connect4{
    
    public int _turn;
    public int [][]  _board;
    public int [] _bot;
    //1=*
    //2= $
    //1 goes first

    public Connect4(){
	_board= new int [6][7];
	_turn = 1;
	_bot = new int[7];
	for (int i = 0; i<6; i++){
	    for (int j = 0; j<7; j++)
		_board[i][j] = 0;
	}
	for (int i=0; i<6; i++)
	    _bot[i] = 5;
    }

    public void turn(int i){
	if (i<0||i>6)
	    return;
	if (_turn%2 ==1)
	    _board[_bot[i]][i]=1;
	else _board[_bot[i]][i] = 2;
	_bot[i]++;
	_turn++;
    }

    //(potato) chips
    public String toString(){
	String ans = "";
	for (int i = 0; i< _board.length; i++){
	    ans += "|";
	    for(int j =0;j<_board[i].length; j++){
		if (_board[i][j]==0)
		    ans+= "   |";
		else{ if (_board[i][j]==1)
		    ans+=" * |";
		else ans+=" $ |";
		}
	    }
	    ans+="\n\n";

	}
	return ans;

    }

    public static void main(String [] args){
	Connect4 a = new Connect4();
	System.out.println(a+"\n");
	a.turn(1);
	a.turn(1);
	a.turn(1);
	a.turn(1);
	a.turn(1);
	
    }

} //end
