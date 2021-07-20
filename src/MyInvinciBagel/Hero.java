package MyInvinciBagel;

import javafx.scene.image.Image;

/*
This class only represents the sprites that are movable or simply 'motion sprites'
*/
public abstract class Hero extends Actor{
    // Java compiler will automatically assign default values to the uninitialized variables;
    protected double vX, vY; // Sprite velocity
    protected double lifeSpan;
    protected double damage;
    protected double offsetX, offsetY;
    protected float boundScale, boundRotation;
    protected float friction, gravity, bounce;

    public Hero(String SVGdata, double xLoc, double yLoc, Image... spriteStates) {
        super(SVGdata, xLoc, yLoc, spriteStates);
        lifeSpan = 1000;
    }

    @Override
    public abstract void update();

    public boolean collide(Actor actor) {
        return false;
    }

    public double getVX() {
        return vX;
    }

    public void setVX(double vX) {
        this.vX = vX;
    }

    public double getVY() {
        return vY;
    }

    public void setVY(double vY) {
        this.vY = vY;
    }

    public double getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(double lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(double offsetX) {
        this.offsetX = offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(double offsetY) {
        this.offsetY = offsetY;
    }

    public float getBoundScale() {
        return boundScale;
    }

    public void setBoundScale(float boundScale) {
        this.boundScale = boundScale;
    }

    public float getBoundRotation() {
        return boundRotation;
    }

    public void setBoundRotation(float boundRotation) {
        this.boundRotation = boundRotation;
    }

    public float getFriction() {
        return friction;
    }

    public void setFriction(float friction) {
        this.friction = friction;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getBounce() {
        return bounce;
    }

    public void setBounce(float bounce) {
        this.bounce = bounce;
    }
}
