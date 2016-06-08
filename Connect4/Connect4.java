import java.util.Scanner;
//use frame?

public class Connect4{
    
    public int _turn;
    public int [][]  _board;
    public int [] _bot;
    public boolean _won;
    //1=*
    //2= $
    //1 goes first

    public static final String HELP = "temp 4 now";

    public boolean isWon(){
	return _won;
    }
    
    public Connect4(){
	_board= new int [6][7];
	_turn = 1;
	_bot = new int[7];
	for (int i = 0; i<6; i++){
	    for (int j = 0; j<7; j++)
		_board[i][j] = 0;
	}
	for (int i=0; i<7; i++)
	    _bot[i] = 5;
	_won = false;
    }

    public int getTurn(){
	return _turn;
    }

    //full col

    //check for 5 6 and 7
    public void turn(int i){


	//fix -12 shit
	if (i<0||i>6){ System.out.println("\nInvalid row number. Please enter an integer between 1 and 7, inclusive.\n");
	    return;
	}
	int k = _turn%2;
	if (k==1){
	    if (_bot[i]<0){
		System.out.println("That column is already full. Please enter the number of a column that is not full\n");
		return;
	    }
	    _board[_bot[i]][i]=1;}
	else {
	      if (_bot[i]<0){
		System.out.println("That column is already full. Please enter the number of a column that is not full\n");
		return;
	    }
	    _board[_bot[i]][i]=2;

	}
	_bot[i]--;
	_turn++;
       	System.out.println(this);
	k = -1*k +2;
	int j = k;
	if (win(j)){
	    System.out.println("GAME OVER: Player "+k+" wins! \n\n\n");
	    _won = true;
	}
    }
    
    //backtrack this
    //i = 1 or i = 2
    public boolean win(int k){
	boolean ans = false;
	for(int i =0; i<6;i++){
	    for(int j = 0; j<7;j++){
		if (_board[i][j]==k){
		    ans = winR(i,j,k,1);
		    if (ans)
			return ans;}
	    }
	}
	return ans;
    }

    public boolean winR(int x, int y, int k, int cnt){
	if (_board[x][y]!=k)
	    return false;
	return (win1(x+1,y,k,cnt+1)||win2(x,y+1,k,cnt+1)||win3(x+1,y+1,k,cnt+1)||win4(x+1,y-1,k,cnt+1));	
    }
    public boolean win1(int x, int y, int k, int cnt){
	if (x<0||y<0||x>=6||y>=7||_board[x][y]!=k)
	    return false;
	if (cnt >= 4) return true;
	return win1(x+1,y,k,cnt+1);
    }
    public boolean win2(int x, int y, int k, int cnt){
	if (x<0||y<0||x>=6||y>=7||_board[x][y]!=k)
	    return false;
	if (cnt >= 4) return true;
	return win2(x,y+1,k,cnt+1);
    }
    public boolean win3(int x, int y, int k, int cnt){
	if (x<0||y<0||x>=6||y>=7||_board[x][y]!=k)
	    return false;
	if (cnt >= 4) return true;
	return win3(x+1,y+1,k,cnt+1);
    }
    public boolean win4(int x, int y, int k, int cnt){
	if (x<0||y<0||x>=6||y>=7||_board[x][y]!=k)
	    return false;
	if (cnt >= 4) return true;
	return win3(x+1,y-1,k,cnt+1);
    }
    
    //(potato) chips
    public String toString(){
	String ans = "\n  ";
	for(int i = 0 ; i<7; i++){
	    ans+= i+1+"   ";
	}
	ans+="\n";
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
	    ans+="\n";
	}
	return ans;
    }

    public static void main(String [] args){
	Connect4 a = new Connect4();
	System.out.println(a+"\n");
	while (a.getTurn()<42&&!a.isWon()){
	    if (a.getTurn()%2==1) System.out.print("Player 1: ");
	    else System.out.print("Player 2: ");
	    System.out.println("Which column would you like to put down?");
	    int x = StdIn.readInt();
	    a.turn(x-1);

	}
	a = null;

    }

} //end
