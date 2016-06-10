class Tile {
   int size = 25;
   int val = -1;
   boolean isClicked = false;
   
   Tile() { 
 }
 
 int getVal() {
   return val;
 }
 
 void display() {
  if (val == -1) {
    fill(); //WHITE
  }
  else {
      fill(); //RED
  }
     rect(x,y, 25, 25);

 }
  
}