public class TicTacToe{

    public int[][] _board;
    public int _turn, _aiInt;
    public boolean _won;
    
    public TicTacToe(){
	_board = new int [3][3];
	_turn = 1;
	_won = false;
	for (int i =0 ; i<3; i++)
	    for (int j = 0; j<3; j++)
		_board[i][j] = 0;

    }

    public void ins(int x, int y){
	if (x>2||y>2||x<0||y<0){
	    System.out.println("invalid row and/or column number. Please input a a valid number");
	    return;
	}
	if (_board[x][y] != 0){
	    System.out.println("that space is already taken");
	}
	_board[x][y] = 
    }


    public void respond(){
	

    }
	    
    private void depositFirstEmpty(int k){
	for (int i =0 ; i<3; i++)
	    for (int j = 0; j<3; j++)
		if (_board[i][j] == 0)
		    _board[i][j] = k;
    }

    private int emptySpaces(){
	int ans = 0;
	for (int i = 0; i<3; i++)
	    for (int j = 0 ; j <3; j++)
		if (_board[i][j] == 0)
		    ans++;
	return ans;
    }


    private String getValue(int x, int y){
	if (_board[x][y] == 0)
	    return " ";
	if (_board[x][y] == 1)
	    return "X";
	else return "O";
    }

    public String toString(){
	String ans = "\n";
	ans += "\t" +getValue(0,0) + " | "+ getValue(0,1) + " | " + getValue(0,2);
	ans += "\n\t---------\n";
	ans += "\t"+getValue(1,0) + " | " + getValue(1,1) + " | " + getValue (1,2);
	ans += "\n\t---------\n";
	ans += "\t"+getValue(2,0) + " | " + getValue(2,1) + " | " + getValue(2,2);

	return ans;

    }

    public static void main(String [] args){
	TicTacToe a = new TicTacToe();
	System.out.println(a);
	System.out.println("pick 1 or 2");
	


	
	
    }

}
