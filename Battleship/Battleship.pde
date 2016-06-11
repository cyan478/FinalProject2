class Tile {
  int x, y, i, j, size, val;
  Tile(int i_index, int j_index, int xcor, int ycor) {
    x = xcor;
    y = ycor;
    i = i_index;
    j = j_index;
    size = 25;
    val = -1;
  }

  boolean overRect() {
    if (mouseX >= x && mouseX <= x+size && 
      mouseY >= y && mouseY <= y+size) {
      return true;
    } else {
      return false;
    }
  }
  void display() {
    if (overRect()  && ( x >= 300)) 
      stroke(#15FF55);
    else 
    stroke(0);
    if (val == -1)
      fill(#FFFFFF);
    else 
    fill(#FF0516);
    rect(x, y, size, size);
  }
}


Tile [][] s = new Tile [5][5]; //board
int [][] b = new int[5][5]; //shown board
Tile [][] sComp = new Tile [5][5];
int [][] bComp = new int [5][5];

void setup() {
  size(500, 500);
  s = initialize(s);
  sComp = initializeC(sComp);
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
      board[i][j] = new Tile(i, j, 25*j + 75, 25*i + 200);
    }
  }
  return board;
}

Tile[][] initializeC(Tile [][] board) { // all elements are -1
  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      board[i][j] = new Tile(i, j, 25*j + 300, 25*i + 200);
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

void draw() {
  background(0); 
  textSize(40);
  text("BATTLESHIP", 135, 75); 
  textSize(15);
  text("Type in the next tile to attack:", 140, 100); 
  textSize(25);
  text("YOU", 108, 165); 
  text("COMPUTER", 290, 165);
  textSize(20);
  text("1  2  3  4  5", 80, 195);
  text("1  2  3  4  5", 305, 195);
  text("a", 60, 220);
  text("b", 60, 245);
  text("c", 60, 270);
  text("d", 60, 295);
  text("e", 60, 320);
  text("a", 285, 220);
  text("b", 285, 245);
  text("c", 285, 270);
  text("d", 285, 295);
  text("e", 285, 320);

  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      s[i][j].display();
    }

    for (int r = 0; r < 5; r++) {
      for (int c = 0; c < 5; c++) {
        sComp[r][c].display();
      }
    }
  }
}