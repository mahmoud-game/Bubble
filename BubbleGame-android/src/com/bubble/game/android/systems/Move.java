package com.bubble.game.android.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.bubble.game.android.components.Position;
import com.bubble.game.android.components.Velocity;

public class Move extends EntityProcessingSystem {
	
    @Wire ComponentMapper<Position> mapperPos;
    @Wire ComponentMapper<Velocity> mapperVit;
 
    @SuppressWarnings("unchecked")
	public Move() {
        super(Aspect.all(Position.class, Velocity.class));
    }
 
    @Override
    protected void process(Entity e) {
        float delta = Gdx.graphics.getDeltaTime();
        
        Position p = mapperPos.get(e);
        Velocity v = mapperVit.get(e);
     
        p.posX += v.incX * delta;
        p.posY += v.incY * delta;         
    }
     
}
