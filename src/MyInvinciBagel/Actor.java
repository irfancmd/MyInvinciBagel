package MyInvinciBagel;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.SVGPath;

import java.util.ArrayList;
import java.util.Arrays;

/* This class represents any object in the game that has to do something with the player. For instance, the player
itself, its enemies, obstacles, treasures etc. Basically any sprite. */
public abstract class Actor {
    protected ArrayList<Image> imageStates = new ArrayList<>();  // Stores different images/states of the sprite for animation. Basically, frames of the animation
    protected ImageView spriteFrame; // ImageView that contains the sprite image
    protected SVGPath spriteBound; // Boundary around sprite for collision detection
    protected double iX, iY; // For the initial position of the sprite
    protected double pX, pY; // Pivot points for rotation of the sprite
    protected boolean isAlive;
    protected boolean isFixed; // Always true for fixed sprites. For movable sprites, true when they're not moving
    protected boolean isBonus;
    protected boolean hasValue; // Is the sprite valuable? Like treasure?
    protected boolean isFlipV; // Flip vertically
    protected boolean isFlipH; // Flip horizontally

    public Actor(String SVGdata, double xLoc, double yLoc, Image... spriteStates) {
        spriteBound = new SVGPath();
        spriteBound.setContent(SVGdata);
        spriteFrame = new ImageView(spriteStates[0]); // Initially the sprite will display the very first image
        imageStates.addAll(Arrays.asList(spriteStates));
        iX = xLoc;
        iY = yLoc;
        pX = pY = 0;
        isFixed = true; // Initially the sprite will be fixed;
        isAlive = isBonus = hasValue = isFlipV = isFlipH = false;
    }

    public abstract void update(); // This method gets called in every pulse of the game loop

    public ArrayList<Image> getImageStates() {
        return imageStates;
    }

    public void setImageStates(ArrayList<Image> imageStates) {
        this.imageStates = imageStates;
    }

    public ImageView getSpriteFrame() {
        return spriteFrame;
    }

    public void setSpriteFrame(ImageView spriteFrame) {
        this.spriteFrame = spriteFrame;
    }

    public SVGPath getSpriteBound() {
        return spriteBound;
    }

    public void setSpriteBound(SVGPath spriteBound) {
        this.spriteBound = spriteBound;
    }

    public double getiX() {
        return iX;
    }

    public void setiX(double iX) {
        this.iX = iX;
    }

    public double getiY() {
        return iY;
    }

    public void setiY(double iY) {
        this.iY = iY;
    }

    public double getpX() {
        return pX;
    }

    public void setpX(double pX) {
        this.pX = pX;
    }

    public double getpY() {
        return pY;
    }

    public void setpY(double pY) {
        this.pY = pY;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public void setBonus(boolean bonus) {
        isBonus = bonus;
    }

    public boolean hasValue() {
        return hasValue;
    }

    public void setHasValue(boolean hasValue) {
        this.hasValue = hasValue;
    }

    public boolean isFlipV() {
        return isFlipV;
    }

    public void setFlipV(boolean flipV) {
        isFlipV = flipV;
    }

    public boolean isFlipH() {
        return isFlipH;
    }

    public void setFlipH(boolean flipH) {
        isFlipH = flipH;
    }
}
