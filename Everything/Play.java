public class Play{

    public static void main(String [] args){
	String game = args[0];
	String [] test = new String[5];
	if (game.equals("Connect4")){
	    Connect4.main(test);
	    return;
	}
	if (game.equals("Mancala")){
	    Mancala.main(test);
	    return;
	}
	if (game.equals("Hanoi")){
	    Hanoi.main(test);
	    return;
	}
	if (game.equals("TicTacToe")){
	    TicTacToe.main(test);
	    return;
	}
	System.out.println("Error: Invalid game name. Please input either 'Connect4', 'Mancala', 'TicTacToe' or 'Hanoi'");
	
	

    }


}
