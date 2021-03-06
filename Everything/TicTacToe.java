public class TicTacToe{

    public int[] _board;
    public int _turn;
    public boolean _won;
    
    public TicTacToe(){
	_board = new int [9];
	_turn = 1;
	_won = false;
    }

    public void turn(int i){
	if (i >= 9 || i<0){
	    System.out.println("\nInvalid Number: Please input a number between 1 and 9 inclusive\n");
	    return;
	}
	if (_board[i] != 0){ 
	    System.out.println("\nSorry, that position is already occupied. Please choose a position that does not have an X or an O\n");
	    return;
	}
	int k = _turn%2;
	if (k==1) _board[i] = 1;
	else _board[i] = 2;
	_turn++;
	int j =(int)((k*-1.0)+2);
	System.out.println(this);
	if ( win(j)){
	    System.out.println("GAME OVER: Player "+j+" wins!\n");
	    _won = true;
	    return;
	}
	if (_turn == 10){
	    System.out.println("GAME OVER: No winner\n");
	    return;

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
	for (int i = 0; i<4; i++){
	    ans = ans || win(i, 8-i, 4,k);
	}
	ans = ans || win(0, 1, 2,k) || win(2,5,8,k) || win(6,7,8,k) || win(0,3,6,k);
	return ans;
    }

    public int getTurn(){
	return _turn;
    }

    public boolean win(int a, int b, int c, int k){
	return (_board[a] == k &&  _board[a] == _board[b] && _board[b] == _board[c]);
    }

    public String toString(){
	String ans = "\n";
	ans += "\t1   2   3\n\t4   5   6\n\t7   8   9\n\n";
	ans += "\t" +getValue(0) + " | "+ getValue(1) + " | " + getValue(2);
	ans += "\n\t---------\n";
	ans += "\t"+getValue(3) + " | " + getValue(4) + " | " + getValue (5);
	ans += "\n\t---------\n";
	ans += "\t"+getValue(6) + " | " + getValue(7) + " | " + getValue(8);
	return ans+"\n";

    }

    public static void main(String [] args){
	TicTacToe a = new TicTacToe();
	System.out.println(a+"\n");
	
	while (a.getTurn()<=9&&!a.isWon()){
	    if (a.getTurn()%2==1) System.out.print("Player 1 (X): ");
	    else System.out.print("Player 2 (O): ");
	    System.out.println("Which position would you like to put down?");
	    int x = StdIn.readInt();
	    a.turn(x-1);
	    
	}
	a = null;


	
	
    }

}
