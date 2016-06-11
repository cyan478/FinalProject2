Tile [][] s = new Tile [5][5]; //board
int [][] b = new int[5][5]; //shown board
Tile [][] sComp = new Tile [5][5];
int [][] bComp = new int [5][5];

String letter = "";
String num = "";

void setup() {
  size(500, 500);
  s = initialize(s);
  sComp = initialize(sComp);
  b = randomize(b);
  bComp = randomize(b);
  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      print(b[i][j]);
    }
    println();
  }
}

Tile[][] initialize(Tile [][] board) { // all elements are -1
  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      board[i][j] = new Tile(25*j + 75, 25*i + 200);
    }
  }
  return board;
}

int[][] randomize(int [][] board) {
  for (int s = 0; s < 3; s++) {

    if (s == 0) { // single tile ship
      int rX = (int)(Math.random()*5); 
      int rY = (int)(Math.random()*5); 

      while (board[rX][rY] > 0) {
        rX = (int)(Math.random()*5); 
        rY = (int)(Math.random()*5);
      }

      board[rX][rY] = 1;
    } else if (s == 1) { // vertical 2-tile ship
      int rX = (int)(Math.random()*4); 
      int rY = (int)(Math.random()*5); 

      while ((board[rX][rY] > 0) || (board[rX + 1][rY] > 0)) {
        rX = (int)(Math.random()*4); 
        rY = (int)(Math.random()*5);
      }

      board[rX][rY] = 2;
      board[rX+1][rY] = 2;
    } else { // horizontal 2-tile ship
      int rX = (int)(Math.random()*5); 
      int rY = (int)(Math.random()*4); 

      while ((board[rX][rY] > 0) || (board[rX][rY + 1] > 0)) {
        rX = (int)(Math.random()*5); 
        rY = (int)(Math.random()*4);
      }

      board[rX][rY] = 3;
      board[rX][rY + 1] = 3;
    }
  }
  return board;
}

boolean isEmpty(String s) {
  return s.length() == 0;
}

int letterToNum(String chr) {
  if (chr.indexOf('a') != -1) return 0;
  else if (chr.indexOf('b') != -1) return 1;
  else if (chr.indexOf('c') != -1) return 2;
  else if (chr.indexOf('d') != -1) return 3;
  else return 4;
}

/*
void keyPressed() {

  if (key == ENTER) {

    if (!letter.isEmpty() && !num.isEmpty()) {
      int i = letterToNum(letter);
      int j = Integer.parseInt(num)-1; 
      println(i);
      println(j);
      s[i][j] = b[i][j];
    }
    letter = "";
    num = "";
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        print(s[i][j]);
      }
      println();
    }
  } else if (key == 'r') {
    if (!num.isEmpty()) 
      num = "";
    else if (!letter.isEmpty()) 
      letter = "";
  } else {
    if ( (key == 'a' || key == 'b' ||key == 'c' || key == 'd' || key == 'e') &&
      (letter.isEmpty()) ) {
      letter += Character.toString(key);
    } else if ( (key == '1' || key == '2'|| key == '3' || key == '4' || key == '5') &&
      (num.isEmpty()) ) {
      num += Character.toString(key);
    }
  }
}
*/

void draw() {
  background(0); 
  textSize(40);
  text("BATTLESHIP", 135, 75); 
  textSize(15);
  text("Type in the next tile to attack:", 140, 100); 
  textSize(25);
  text("YOU", 108, 165); 
  text(letter, 225, 150); 
  text(num, 250, 150); 
  textSize(20);
  text("1  2  3  4  5", 80, 195);
  text("a", 60, 220);
  text("b", 60, 245);
  text("c", 60, 270);
  text("d", 60, 295);
  text("e", 60, 320);

  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      s[i][j].display();
  }
  
  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      sComp.display();
    }
  }
}