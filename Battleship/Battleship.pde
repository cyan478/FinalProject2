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
  boolean overRectC() {
    if ((mouseX >= x && mouseX <= x+size && 
      mouseY >= y && mouseY <= y+size) && (x >= 300)) {
      return true;
    } else {
      return false;
    }
  }

  void setVal(int newVal) {
    val = newVal;
  }

  int getVal() {
    return val;
  }

  void display() {
    if (overRectC()) 
      stroke(#0AFF18);
    else 
    stroke(0);
    if (val > 0) {
      fill(#FF0A0A);
    } else if (val == 0)
      fill(#58FFFE);
    else
      fill(#FFFFFF);
    rect(x, y, size, size);
    if ((b[i][j] > 0) && (x < 300)) {
      fill(0);
      text("X", x+5, y+20);
    }
  }
}


Tile [][] s = new Tile [5][5]; //board
int [][] b = new int[5][5]; //shown board
Tile [][] sComp = new Tile [5][5];
int [][] bComp = new int [5][5];
int numRed = 0;
int numRedC = 0;
PFont source;

void setup() {
  size(500, 500);
  s = initialize(s);
  sComp = initializeC(sComp);
  b = randomize(b);
  bComp = randomize(bComp);
  source = loadFont("SourceCodePro-Bold-15.vlw");
  textFont(source);
  for (int i = 0; i<5; i++) {
    for (int j = 0; j<5; j++) {
      print(b[i][j]);
    }
    println();
  }
}

Tile[][] initialize(Tile [][] board) { // all elements are -1
  for (int j = 0; j < 5; j++) {
    for (int i = 0; i < 5; i++) {
      board[j][i] = new Tile(j, i, 25*i + 75, 25*j + 200);
    }
  }
  return board;
}

Tile[][] initializeC(Tile [][] board) { // all elements are -1
  for (int j = 0; j < 5; j++) {
    for (int i = 0; i < 5; i++) {
      board[j][i] = new Tile(j, i, 25*i + 300, 25*j + 200);
    }
  }
  return board;
}

int[][] randomize(int [][] board) {
  for (int s = 0; s < 4; s++) {

    if (s <= 1) { // vertical 2-tile ship
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

boolean newMove() {
  if ((mousePressed) && 
    (mouseX >= 300) && (mouseX <= 425) 
    && (mouseY >= 200) && (mouseY <= 325)) {
    for (int r = 0; r < 5; r++) {
      for (int c = 0; c < 5; c++) {
        if ( (mouseX >= (25*r + 300)) && (mouseX <= (25*(r+1) + 300)) 
          && (mouseY >= (25*c + 200)) && (mouseY <= (25*(c+1) + 200)) ) {
          if (sComp[c][r].getVal() == -1) {
            sComp[c][r].setVal(bComp[c][r]);
            if (bComp[c][r] > 0) numRedC++;
            if (numRedC < 8)
              makeMove();
            return true;
          } else return false;
        }
      }
    }
  }
  return false;
}

void makeMove() {
  int r1 = (int)(Math.random()*5);
  int r2 = (int)(Math.random()*5);
  while (s[r1][r2].getVal() != -1) {
    r1 = (int)(Math.random()*5);
    r2 = (int)(Math.random()*5);
  }
  s[r1][r2].setVal(b[r1][r2]);
  if (b[r1][r2] > 0) numRed++;
}

void restart() {
  s = new Tile [5][5]; //board
  b = new int[5][5]; //shown board
  sComp = new Tile [5][5];
  bComp = new int [5][5];
  numRed = 0;
  numRedC = 0;
}

boolean overButton() {
  if (mouseX >= 195 && mouseX <= 300 && 
    mouseY >= 380 && mouseY <= 420) {
    return true;
  } else {
    return false;
  }
}

void draw() {
  background(0); 
  textSize(40);
  fill(#0AFF18);
  text("battleship", 135, 75); 
  textSize(25);
  fill(#FFFFFF);
  text("YOU", 108, 165); 
  text("COMPUTER", 300, 165);
  textSize(20);
  fill(#0AFF18);
  text("1 2 3 4 5", 80, 195);
  text("1 2 3 4 5", 305, 195);
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
  rect(195, 380, 105, 40);
  fill(0);
  text("restart", 205, 405);

  for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
      s[i][j].display();
      sComp[i][j].display();
    }
  }

  if ((numRed == 8) || (numRedC == 8)) {
    textSize(40);
    fill(#FC0008);
    if ((numRed == 8) && (numRedC == 8)) text("tie", 300, 120);
    else if (numRed == 8) text("computer wins", 100, 120);
    else if (numRedC == 8) text("you win", 160, 120);
  }
  else newMove();

  if (overButton()) {
    stroke(#FFFFFF);
    fill(#0AFF18);
    rect(195, 380, 105, 40);
    fill(#FFFFFF);
    textSize(20);
    text("restart", 205, 405);
    if (mousePressed) {
      restart();
      setup();
    }
  }
}