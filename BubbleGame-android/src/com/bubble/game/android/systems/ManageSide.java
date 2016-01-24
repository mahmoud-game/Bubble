package com.bubble.game.android.systems;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.artemis.managers.GroupManager;
import com.artemis.systems.EntityProcessingSystem;
import com.artemis.utils.ImmutableBag;
import com.badlogic.gdx.Gdx;
import com.bubble.game.android.components.Position;
import com.bubble.game.android.components.Size;
import com.bubble.game.android.components.Velocity;

public class ManageSide extends EntityProcessingSystem {    

	@SuppressWarnings("unchecked")
	public ManageSide() {
	    super(Aspect.all(Position.class, Size.class, Velocity.class));
	}

   @Wire private ComponentMapper<Position> mapperPos;
   @Wire private ComponentMapper<Velocity> mapperVit;
   @Wire private ComponentMapper<Size> mapperDim;

   @Override
   protected void process(Entity arg0) {
       //on récupère toutes les balles de notre jeu
       ImmutableBag<Entity> balles = world.getSystem(GroupManager.class).getEntities("BULLES");
       
       int nbBalles = balles.size();
       for(int i=0; i<nbBalles; i++){
            
           //récupération des composants de chacunes de nos balles.
           Entity balle = balles.get(i);
           Position pBalle = mapperPos.get(balle); 
           Velocity vBalle = mapperVit.get(balle);
           Size dBalle = mapperDim.get(balle);
            
           float xMinBalle = ResponsiveManager.xUnite(pBalle.posX, Gdx.graphics.getWidth());
           float xMaxBalle = ResponsiveManager.xUnite(pBalle.posX + (dBalle.rayon * 2), Gdx.graphics.getWidth());
           float yMinBalle = ResponsiveManager.yUnite(pBalle.posY, Gdx.graphics.getHeight());
            
           //Si la bulle touche à gauche ou à droite...
           if(xMinBalle < 0 || xMaxBalle > Gdx.graphics.getWidth()){
               //... on change la vitesse horizontale
               vBalle.incX = - vBalle.incX;
           }
           
           // Si la bulle a touché en bas ou  en haut...
           if(yMinBalle < 0 || yMinBalle > Gdx.graphics.getHeight()){
           //... on change la vitesse verticale
               vBalle.incY = - vBalle.incY;
           }
       }       

   }

}
