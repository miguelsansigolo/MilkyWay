
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Milky extends PApplet{
    ArrayList<Planet> planets = new ArrayList<>();
    Planet sun;
    Planet space;
    PShape globe;
    PImage sunImg;
    PImage earth;
    PImage jup;
    PImage mars;
    PImage merc;
    PImage nep;
    PImage sat;
    PImage uranus;
    PImage venus;
    PImage milky;
    float zoom;
    float panX;
    float panY;
    float panZ;
    float sPX;
    float sPY;
    public static void main(String[] args) {
        PApplet.main("Milky");
    }
    public void settings() {
        size(1253, 696, P3D);
    }
    public void setup(){
        milky= loadImage("milky.jpg");
        earth = loadImage("earth.jpg");
        sunImg = loadImage("sun.jpg");
        jup = loadImage("jup.jpg");
        mars = loadImage("mars.jpg");
        merc = loadImage("merc.jpg");
        nep = loadImage("nep.jpg");
        sat = loadImage("sat.jpg");
        uranus = loadImage("uranus.jpg");
        venus = loadImage("venus.jpg");
        space = new Planet(this,"space",width/2,height/2,0,(float)3000,1,0,0,0,milky);
        sun = new Planet(this,"sun",width/2,height/2,0,(float)69.5,1,0,0,0,sunImg);
        planets.add(new Planet(this,"earth",width/2,height/2,0,(float)1.6371,1,149+(sun.s/2),149+(sun.s/2),0,earth));//wrong size
        planets.add(new Planet(this,"jup",width/2,height/2,0,(float)6.99,1,778+(sun.s/2),778+(sun.s/2),0,jup));
        planets.add(new Planet(this,"mars",width/2,height/2,0,(float)1.339,1,227+(sun.s/2),227+(sun.s/2),0,mars));//wrong size
        planets.add(new Planet(this,"merc",width/2,height/2,0,(float)1.244,1,57+(sun.s/2),57+(sun.s/2),0,merc));//wrong size
        planets.add(new Planet(this,"nep",width/2,height/2,0,(float)2.46,1,4495+(sun.s/2),4495+(sun.s/2),0,nep));
        planets.add(new Planet(this,"sat",width/2,height/2,0,(float)5.82,1,1429+(sun.s/2),1429+(sun.s/2),0,sat));
        planets.add(new Planet(this,"uranus",width/2,height/2,0,(float)2.53,1,2871+(sun.s/2),2871+(sun.s/2),0,uranus));
        planets.add(new Planet(this,"venus",width/2,height/2,0,(float)1.605,1,108+(sun.s/2),108+(sun.s/2),0,venus));//wrong size
        
        
    }
    public void keyPressed(){
        if(keyPressed==true) {
            if(key == 'w'&&keyPressed==true){
                panY+=10;
            }
            if(key=='s'&&keyPressed==true){
                panY-=10;
            }
            if(key=='d'&&keyPressed==true){
                panX+=10;
            }
            if(key=='a'&&keyPressed==true){
                panX-=10;
            }
            if(key=='e'&&keyPressed==true){
                panZ+=10;
            }
            if(key=='q'&&keyPressed==true){
                panZ-=10;
            }
            if(key=='+'&&keyPressed==true){
                zoom+=10;
            }
            if(key=='-'&&keyPressed==true){
                zoom-=10;
                println("test");
            }
            
        }
            if(key=='1'){
                sPX = planets.get(0).x;
                sPY = planets.get(0).y;
                println("planeta");
            }
            if(key=='2'){
                sPX = planets.get(1).x;
                sPY = planets.get(1).y;
            }
            if(key=='3'){
                sPX = planets.get(2).x;
                sPY = planets.get(2).y;
            }
            if(key=='4'){
                sPX = planets.get(3).x;
                sPY = planets.get(3).y;
            }
            if(key=='5'){
                sPX = planets.get(4).x;
                sPY = planets.get(4).y;
            }
            if(key=='6'){
                sPX = planets.get(5).x;
                sPY = planets.get(5).y;
            }
            if(key=='7'){
                sPX = planets.get(6).x;
                sPY = planets.get(6).y;
            }
            if(key=='8'){
                sPX = planets.get(7).x;
                sPY = planets.get(7).y;
            }
            if(key=='0'){
                sPX = 0;
                sPY = 0;
            }
       /* if(keyPressed!=true) {
	      sPX = 0;
              sPY = 0;
	}*/
    }
    public void draw(){
        keyPressed();
        noStroke();
        fill(255);
        
        translate(width/2,height/2,0);
        camera(panX,panY,panZ,sPX,sPY,1,(float)1.0,(float)1.0,(float)1.0);
        
        sun.show();
        sun.acceleration();
        space.show();
        space.acceleration();
        for(int i = 0;i<=planets.size()-1;i++){
            noStroke();
            planets.get(i).show();
            planets.get(i).acceleration();
           
        }
        for(int i = 0;i<=planets.size()-1;i++){
            stroke(255);
            strokeWeight((float)0.8);
            noFill();
            arc(0,0,planets.get(i).rX*2,planets.get(i).rY*2,0,360);
        }
    }

}
