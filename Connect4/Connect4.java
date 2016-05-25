import java.util.Scanner;
//use frame??

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





    //check for 5 6 and 7
    public void turn(int i){
	if (i<0||i>6) return;
	int k = _turn%2;
	if (k==1){
	    _board[_bot[i]][i]=1;}
	else _board[_bot[i]][i]=2;
	_bot[i]--;
	_turn++;
       	System.out.println(this);
	if (win(-1*k+2))
	    System.out.println("GAME OVER");
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
	if (x<0||y<0||x>=6||y>=7||_board[x][y]!=k)
	    return false;
	if (cnt >= 4) return true;
	return (winR(x+1,y,k,cnt+1)||winR(x,y+1,k,cnt+1)||winR(x+1,y+1,k,cnt+1)||winR(x+1,y-1,k,cnt+1));
     	
	
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
	a.turn(2);
	a.turn(3);
	a.turn(1);
	a.turn(3);
	
	a.turn(0);
	a.turn(3);
	a.turn(0);
	a.turn(3);
	a.turn(3);
	
    }

} //end
