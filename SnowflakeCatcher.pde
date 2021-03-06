SnowFlake [] snows;
void setup()
{
  size(300,300);
  background(0);
  snows = new SnowFlake[100];
  for (int i = 0; i<snows.length; i++){
    snows[i] = new SnowFlake();
  }
}
void draw()
{
  for (int i = 0; i<snows.length; i++){
    snows[i].erase();
    snows[i].lookDown();
    snows[i].move();
    snows[i].wrap();
    snows[i].show(); 
  }
}
void mouseDragged()
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
  void show()
  {
    noStroke();
    fill(255);
    ellipse(x,y,5,5);
  }
  void lookDown()
  {
    //change get to lower number to slow down. like barrier
    if(y>=0 && y<=300){
      if(get(x,y+4)!=color(0,0,0)){
        isMoving=false;
      }
      else{
        isMoving=true;
      }
    }
  }
  void erase()
  {
    noStroke();
    fill(0);
    ellipse(x,y,8,8);
  }
  void move()
  {
    if (isMoving==true){
      y+=1;
    }
  }
  void wrap()
  {
    if(y>=293){
      y=0;
      x=(int)(Math.random()*300);
    }
  }

}