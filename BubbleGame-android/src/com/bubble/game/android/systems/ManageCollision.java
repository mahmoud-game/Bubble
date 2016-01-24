package com.bubble.game.android.systems;

import com.artemis.Aspect.Builder;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.EntitySystem;
import com.artemis.annotations.Wire;
import com.artemis.managers.GroupManager;
import com.artemis.managers.TagManager;
import com.artemis.systems.EntityProcessingSystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.bubble.game.android.components.Position;
import com.bubble.game.android.components.Size;
import com.bubble.game.android.components.Velocity;
import com.bubble.game.android.components.State;

public class ManageCollision extends EntityProcessingSystem {    

	@SuppressWarnings("unchecked")
	public ManageCollision() {
	    super(Aspect.all(Position.class, Size.class, Velocity.class));
	}

	@Wire private ComponentMapper<Position> mapperPos;    
	@Wire private ComponentMapper<Size> mapperDim;
    @Wire private ComponentMapper<State> mapperEtat;
    @Wire private ComponentMapper<Velocity> mapperVit;
 
    private static float coefAngle = 5f;
    private static float maxIncX = 300;
 
    @Override
    protected void process(Entity arg0) {

    }
}
