/* 
Name: Trilby Buck
Student Number: V00798585
Program Name: Sprite object
Program Description: sets up Sprite object to read a given file with ASCII art
                     draw it at a given point.
*/


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sprite {
  Screen panel;
  private char[][] art;
  Point p;
  int width;
  int height;
  
  // this is the constructor we want to use when initializing objects
  public Sprite(String filename) throws FileNotFoundException {
    File inF = new File(filename);
    Scanner inputF = new Scanner(inF);

    // remember to call an extra nextLine() after nextInt() when reading the file
    height = inputF.nextInt();
    width = inputF.nextInt();
    // you need to use nextLine() and not next(), in order to
    // allow you to use space chars in the sprite file
    inputF.nextLine();
    art = new char[height][width];

    // setup the characters in array art
    for (int i=height-1; i>=0; i--) {
        String save = inputF.nextLine();
        for (int j=0; j<save.length(); j++){
          art[i][j] = save.charAt(j); 
        }
        for(int k=save.length(); k<width-1; k++){
          art[i][k] = ' ';
        }
    }
  }
  
  public void setCorner(double x, double y) {
    // set up Point p
    p = new Point(x,y);
  }
  
  public void put(Screen panel) {
    // set up Screen panel
    this.panel = panel;
  }
  
  public char get(int x, int y) {
    // return the entry in array art
    return art[y][x];
  }
  
  public void draw() {
  
    //set point vairables to tell where to draw
    int x = (int)p.x;
    int y = (int)p.y;
    
    //loop for the if statement
    for(int i=0; i<width; i++){
      for (int j=0; j<height; j++){
        // don't draw space chars to panel
        if(get(i,j) != ' '){
          //set counters to update p position
          int j2 = 0;
          //use x, y to tell loop bounds of each line of characters 
          for(int k = y; k< p.y+height; k++){
            int i2 = 0;
            for(int n = x; n< p.x+width; n++){
              // send chars to panel
              panel.set(n,k,get(i2,j2));
              //update counters
              i2++;
            }
            j2++;
          }
        }
      }
    }
  }
}