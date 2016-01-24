package com.bubble.game.android.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.bubble.game.android.components.Position;
import com.bubble.game.android.components.Size;
import com.bubble.game.android.components.Type;

public class DrawBubble extends EntityProcessingSystem {

	@Wire private ComponentMapper<Position> mapperPos;
    @Wire private ComponentMapper<Size> mapperDim;
    @Wire private ComponentMapper<Type> mapperForme;
     
    private ShapeRenderer renderer;
 
    @SuppressWarnings("unchecked")
	public DrawBubble() {
        super(Aspect.all(Position.class, Size.class, Type.class));
    }
 
    @Override
    protected void initialize() {
        renderer = new ShapeRenderer();
    }
 
    @Override
    protected void begin() {
        // on démarre notre renderer de façon à ce qu'il dessine des contours
        renderer.begin(ShapeRenderer.ShapeType.Line);
    }
 
    @Override
    protected void end() {
        //à la fin de l'éxecution de notre système, on referme notre renderer
        renderer.end();
    }
 
    @Override
    protected void process(Entity e) {
        // on récupère la position à l'aide du mapper de position
        Position p = mapperPos.get(e);
        // on récupère la dimension à l'aide du mapper de dimensions
        Size d = mapperDim.get(e);
        
        renderer.circle(p.posX, p.posY, d.rayon);
        
    }
	
}
