package com.bubble.game.android.components;

import com.artemis.Component;

public class Velocity extends Component {
 
    public float incX, incY;
 
    public Velocity(float incX, float incY) {
        this.incX = incX;
        this.incY = incY;
    }
}
