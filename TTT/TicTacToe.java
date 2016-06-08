public class TicTacToe{

    public int[] _board;
    public int _turn;
    public boolean _won;
    
    public TicTacToe(){
	_board = new int [9];
	_turn = 1;
	_won = false;
    }

    public voic turn(int i){
	if (i >= 9 || i<0) return;
	if (_board[i] != 0) return;
	int k = _turn%2;
	if (k==1) _board[i] = 1;
	else _board[i] = 2;
	_turn++;
	int j = k;
	if ( win(k)){
	    System.out.println("stuff");
	    _won = true;
	    
	}
    }

    public boolean isWon(){
	return _won;
    }

    private String getValue(int x){
	if (_board[x] == 0)
	    return " ";
	if (_board[x] == 1)
	    return "X";
	else return "O";
    }

    public boolean win(int k){
	//checks if k has TTT
	boolean ans = false;
	for (int i = 0; i<5; i++){
	    ans = ans || win(i, 8-i, 4,k);
	}
	ans = ans || win(0, 1, 2,k) || win(2,5,8,k) || win(6,7,8,k) || win(0,3,6,k);
	return ans;
    }

    public boolean win(int a, int b, int c, int k){
	return (_board[a] == k &&  _board[a] == _board[b] && _board[b] == _board[c] );
    }

    public String toString(){
	String ans = "\n";
	ans += "\t" +getValue(0) + " | "+ getValue(1) + " | " + getValue(2);
	ans += "\n\t---------\n";
	ans += "\t"+getValue(3) + " | " + getValue(4) + " | " + getValue (5);
	ans += "\n\t---------\n";
	ans += "\t"+getValue(6) + " | " + getValue(7) + " | " + getValue(8);
	return ans;

    }

    public static void main(String [] args){
	TicTacToe a = new TicTacToe();
	System.out.println(a);
	System.out.println("pick 1 or 2");
	


	
	
    }

}
