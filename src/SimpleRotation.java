/* angle in right triangle: "SOHCAHTOA":
* Sin(theta) = Opposite / Hypothenuse
* Cos(theta) = Adjacent / Hypothenuse
* Tan(theta) = Opposite / Adjacent
* -> theta = angle in question
*
* cartesian (x,y) to polar (r, theta) coordinates:
* sin(th) = y/r -> y = r × sin(th)
* cos(th) = x/r -> x = r× cos(th)
*/
import processing.core.PApplet;

public class SimpleRotation extends PApplet {
    float angle = 0;
    float angVel = 0;
    float angAcc = 0;

    final int sizeX = 640;
    final int sizeY = 480;


    public static void main(String[] args) {
        PApplet.main("SimpleRotation", args);
    }


    //setup screen
    public void settings() {
        size(sizeX, sizeY);
    }

    public void mouseClicked() {
    }

    public void draw() {
        background(255);

        //set center as origin of rectangulars
        rectMode(CENTER);
        stroke(0);
        fill(150);
        //show mouseX
        text(mouseX, 10, 30, 10);
        // map mouseX to acceleration
        angAcc = map(mouseX, 0, width, -0.001f, 0.001f);
        // show acceleration - shifted to see more digits.
        text(angAcc*10000 + "×E^-10.000", 10, 60, 10);

        //add forces
        angVel += angAcc;
        angle += angVel;

        // store current coordinate matrix
        pushMatrix();
        //shift coordination to center
        translate (width/2, height/2);
        // rotate
        rotate(angle);
        // draw rectangle
        rect(0, 0, 64, 36);
        // restore previous coordinate matrix
        popMatrix();
    }
}
