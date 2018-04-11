
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;


public class Planet {
    String name;
    float x;
    float y;
    float z;
    float s;
    PApplet p;
    float angle;
    float rX;
    float rY;
    float rZ;
    float acceleration;
    int r;
    int g;
    int b;
    PShape globe;
    PImage texture;
    public Planet(PApplet p,String name,float x, float y, float z, float s,float angle, float rX,float rY,float rZ,PImage texture){
        this.name = name;
        this.p = p;
        this.x = x;
        this.y = y;
        this.z = z;
        this.s = s;
        this.angle = angle;
        this.rX = rX;
        this.rY = rY;
        this.rZ = rZ;
        r = (int) p.random(1,255);
        g = (int) p.random(1,255);
        b = (int) p.random(1,255);
        this.texture = texture;
    }
    public void acceleration(){
        acceleration = (float) (rY*0.0002)/s;
        x = rX*p.sin(angle);
        y = rY*p.cos(angle);
        z = rZ*(p.sin(angle)+p.cos(angle));
        
    }
    public enum Planets{
        EARTH,MARS,VENUS,JUPITER,MERCURY,SATURN,URANUS,NEPTUNE,SUN;
    }
    public void show(){
        p.beginShape();
        globe = p.createShape(p.SPHERE,s);
        globe.setTexture(texture);
        p.endShape();
        angle = angle+acceleration;
        p.pushMatrix();
        p.translate(x,y,z);
        p.shape(globe);
        p.popMatrix();
       
    }
}
