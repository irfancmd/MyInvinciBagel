package com.example.myInvinciBagel;

import javafx.scene.image.Image;

public class Bagel extends Hero{
    public Bagel(String SVGdata, double xLoc, double yLoc, Image... spriteStates) {
        super(SVGdata, xLoc, yLoc, spriteStates);
    }

    @Override
    public void update() {

    }

    @Override
    public boolean collide(Actor actor) {
        return false;
    }
}
