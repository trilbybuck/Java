/* 
Name: Trilby Buck
Student Number: V00798585
Program Name: Picture
Program Description: randomly places three sprites with randomly placed stars 
                     around them on a screen.
*/

import java.util.Random;
import java.io.FileNotFoundException;

public class Picture {
  public static void main(String[] args) throws FileNotFoundException {
    Random r = new Random();
    
    Screen window = new Screen();
    // you don't need to call clear() to set up 
    // anymore with new version of Screen
    
    // set up your sprite filenames here
    String[] filenames = {  
      "Dolphin.txt",
      "island.txt",
      "sun.txt" 
    };
    
    //three Sprite instances
    Sprite d1 = new Sprite(filenames[0]);
    Sprite d2 = new Sprite(filenames[1]);
    Sprite d3 = new Sprite(filenames[2]);

    // make a Sprite array
    Sprite[] sprites = new Sprite[]{d1, d2, d3};
    
    // use loops to draw each Sprite at three different random Points
    for(int i=0; i<sprites.length; i++){
      for (int j=0; j<3; j++){
        //set random corner for sprites
        sprites[i].setCorner(r.nextInt(120), r.nextInt(30));
        sprites[i].put(window);
        //put asterix barnacling around Sprites
        barnacles(sprites[i], window);
        //draw sprites to panel
        sprites[i].draw();
      }
    }
    window.draw();
  }  
  public static void barnacles(Sprite guy, Screen panel){
     Random r1 = new Random();
     Point[] pts = new Point[20];
     //fill points array with random place within bounds 
     //of sprite and translate to sprite's random placement
    for(int i=0; i<20; i++){
      pts[i] = new Point(r1.nextInt(guy.width + 5) + (guy.p.x -2), 
                         r1.nextInt(guy.height + 5) + (guy.p.y-2));
      pts[i].put(panel);
    }

    //draw points
    for(int i=0; i<20; i++){
      pts[i].draw('*');
    }
  }
}