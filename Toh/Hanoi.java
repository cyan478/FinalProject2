public class Hanoi{
  
  public NodeStack<Integer> _s1, _s2, _s3;
  public int _max, _turn;
  public boolean _won;
  
  
  public Hanoi( int i ){
    _won = false;
    _max = i;
    _turn = 0;
    _s1 = new NodeStack<Integer>();
    _s2 = new NodeStack<Integer>();
    _s3 = new NodeStack<Integer>();
    for (int j = _max; j>= 1;j--)
      _s2.push(j);
  }
  
  public boolean win(){
    if (_s1.size() != _max && _s3.size() != _max) return false;
    return true;
  }
  
  public void turn(int take, int put){
    if (take>3||take<1||put>3||put<1){
      System.out.println("You're trying to pick up or put down a ring in an tower that does not exist. Please pick a tower between 1 and 3 inclusive.");
      return;
    }
    if ((take == 1 && _s1.isEmpty()) || (take == 2 && _s2.isEmpty()) || (take == 3 && _s3.isEmpty())){ 
      System.out.println("You are trying to pick up a ring from an empty tower. Please choose a tower that is not empty.");
      return;
    }
    Integer tempint = _max;
    if (take == 1){
     tempint = _s1.pop(); 
    }
    if (take == 2){
     tempint = _s2.pop(); 
    } if (take == 3){
     tempint = _s3.pop(); 
    }
    Integer top = 0;
    if (put == 1){
      top = _s1.top();
     }
    if (put == 2){
      top = _s2.top();
    }
    if (put == 3){
      top = _s3.top(); 
    }
    if (tempint > top){
      System.out.println("When you move a ring, it may not be placed on top of a smaller ring.");
      if (take == 1)_s1.push(tempint);        
      if (take == 2)_s2.push(tempint);
      if (take == 3)_s3.push(tempint);
      return;
    }
    if (put == 1) _s1.push(tempint);
    if (put == 2) _s2.push(tempint);
    if (put == 3) _s3.push(tempint); 
    _turn++;
    System.out.println(this);
    if (win()){
      System.out.println("Congratulations, you solved the puzzle in " + _turn+" turns. The smallest possible number of turns for " + _max + " rings is " + (Math.pow(2,_max)-1));
      _won = true;
    }
  }
  public String toString(){
    String ans = "\n\tTurn:"+_turn+"\n";
    ans += "\tTower 1: " + _s1 +"\n\tTower 2: "+_s2+"\n\tTower 3: "+_s3+"\n";
    return ans;
  }
  
  public static void main( String [] args){
    Hanoi a = new Hanoi(10);
    System.out.println(a);
    a._s2.pop();
    a._s2.pop();
    System.out.println(a);
  }
  
  
  
}
