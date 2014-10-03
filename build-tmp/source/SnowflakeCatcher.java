import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] snows;
public void setup()
{
  size(300,300);
  background(0);
  snows = new SnowFlake[100];
  for (int i = 0; i<snows.length; i++){
    snows[i] = new SnowFlake();
  }
}
public void draw()
{
  for (int i = 0; i<snows.length; i++){
    snows[i].erase();
    snows[i].lookDown();
    snows[i].move();
    snows[i].wrap();
    snows[i].show(); 
  }
}
public void mouseDragged()
{

  if(mouseButton != RIGHT){
    strokeWeight(15);
    stroke(30,184,240);
    line(mouseX,mouseY,pmouseX,pmouseY);
  }
  else{
    fill(0,0,0);
    noStroke();
      rectMode(CENTER);
      rect(mouseX,mouseY,30,30);
  }
}

class SnowFlake
{

  int x, y;
  boolean isMoving;
  SnowFlake()
  {
    x=(int)(Math.random()*300);
    y=(int)(Math.random()*300);
    isMoving=true;
  }
  public void show()
  {
    noStroke();
    fill(255);
    ellipse(x,y,5,5);
  }
  public void lookDown()
  {
    if(y>=0 && y<=300){
      if(get(x,y+4)!=color(0,0,0)){
        isMoving=false;
      }
      else{
        isMoving=true;
      }
    }
  }
  public void erase()
  {
    noStroke();
    fill(0);
    ellipse(x,y,8,8);
  }
  public void move()
  {
    if (isMoving==true){
      y+=1;
    }
  }
  public void wrap()
  {
    if(y>=293){
      y=0;
      x=(int)(Math.random()*300);
    }
  }

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
