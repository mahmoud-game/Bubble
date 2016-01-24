package com.bubble.game.android.screens;

import javax.microedition.khronos.opengles.GL10;

import com.artemis.World;
import com.artemis.WorldConfiguration;
import com.artemis.managers.GroupManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.bubble.game.android.systems.DrawBubble;
import com.bubble.game.android.systems.FabriqueEntite;
import com.bubble.game.android.systems.ManageSide;
import com.bubble.game.android.systems.Move;
import com.bubble.game.android.systems.ResponsiveManager;

public class Play implements Screen {	
	
    private World world;
    private WorldConfiguration worldC;
    private Camera camera;
    
    private float largeur_ecran;
    private float hauteur_ecran; 
    
	@Override
	public void render(float delta) { 
        //on efface tout (couleur noire)
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
         
        //mise à jour cam
        camera.update();
         
        //mise à jour du monde. Exécution des processing systèmes
        world.process();        
	}
	
    @Override
	public void resize(int width, int height) {
	}
	
	@Override
	public void show() {
		
        largeur_ecran = Gdx.graphics.getWidth();
        hauteur_ecran = Gdx.graphics.getHeight();
        
        //initialisation de la camera libGDX
        camera = new OrthographicCamera();
        worldC = new WorldConfiguration();
        
        //on ajoute les managers dont on va se servir par la suite
        worldC.setSystem(new GroupManager());
        
        //on assigne nos systèmes à notre world
        worldC.setSystem(new DrawBubble());
        
        //Pour faire déplacer la bulle
        worldC.setSystem(new Move());    
        
        //Gestion des collisions sur les côtés
        worldC.setSystem(new ManageSide()); 

        // on initialise notre world artemis
        world = new World(worldC);
         
        //creation de notre balle et ajout dans le world
        FabriqueEntite.creerBalle(world, ResponsiveManager.xUnite(300, largeur_ecran), ResponsiveManager.yUnite(300, largeur_ecran), 50f, 50f, 50);
        FabriqueEntite.creerBalle(world, ResponsiveManager.xUnite(100, hauteur_ecran), ResponsiveManager.yUnite(100, hauteur_ecran), 50f, 50f, 100);
                
	}
	
	@Override
	public void hide() {
	}
	
	@Override
	public void pause() {
	}
	
	@Override
	public void resume() {
	}
	
	@Override
	public void dispose() {
	}
}
