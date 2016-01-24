package com.bubble.game.android.screens;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.bubble.game.android.MyGame;


public class Menu implements Screen {	
	
	Stage stage;
    MyGame game;// Instance de MyGame pour accéder aux méthodes intéressantes pour changer d'écran
    Skin skin;
    
    private Image title;
    private ImageButton boutonSound;
    private ImageButton boutonPlay;
   
    private float largeur_ecran;
    private float hauteur_ecran;   
    
    private boolean hpTouch;  
	
	@Override
	public void show() {
		stage=new Stage(new ScreenViewport());
		skin =new Skin();
		hpTouch = false;
		//Dimension
        largeur_ecran = Gdx.graphics.getWidth();
        hauteur_ecran = Gdx.graphics.getHeight();
        
        //Actors
		title = new Image(new Texture(Gdx.files.internal("title.png"))); 
        title.setSize(xUnite(400), yUnite(140));
        title.setPosition(xUnite(40), yUnite(170));
        stage.addActor(title);

        skin.add("sound_on", new Texture("HP_on.png"));
        skin.add("sound_off", new Texture("HP_off.png"));
		boutonSound = new ImageButton(skin.getDrawable("sound_on"), skin.getDrawable("sound_off"), skin.getDrawable("sound_off"));
        boutonSound.setSize(xUnite(32), yUnite(32));
        boutonSound.setPosition(xUnite(446), yUnite(298));        
        stage.addActor(boutonSound);
        //788 340 2.32
        skin.add("play", new Texture("play.png"));
        skin.add("play2", new Texture("play2.png"));
        boutonPlay = new ImageButton(skin.getDrawable("play"), skin.getDrawable("play2"));
        boutonPlay.setSize(xUnite(173), yUnite(75));
        boutonPlay.setPosition(xUnite(140), yUnite(100));        
        stage.addActor(boutonPlay);	            
		
        hpTouch = false;  
		
	}

	@Override
	public void render(float delta) {
		
		game = new MyGame();
		Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	    stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();	    
	    boutonSound.addListener(new onSoundListener());
	    boutonPlay.addListener(new onPlayListener());
	    Gdx.input.setInputProcessor(stage);
		
	}

    // Fonction qui maintien le rapport entre les positions Y
    // vis-à-vis de la taille de l'écran
    private float xUnite(float x)
    {
          return x*largeur_ecran/480f;
    }
   
    // Fonction qui maintien le rapport entre les positions Y
    // vis-à-vis de la taille de l'écran
    private float yUnite(float y)
    {
          return y*hauteur_ecran/320;
    }
    
    class onSoundListener extends InputListener {

        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            return true;
        }

        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {        	                   	
        	if(!hpTouch){        		
        		boutonSound.setBackground(skin.getDrawable("sound_off"));
	    		//Couper son        		
	    		hpTouch = true;
    		}else{    			
    			boutonSound.setBackground(skin.getDrawable("sound_on"));
	    		//Remettre son
	    		hpTouch = false;
    		}
        }
    }   
    
    class onPlayListener extends InputListener {

        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        	boutonPlay.setBackground(skin.getDrawable("play2"));
        	return true;
        }

        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {        	           
        	boutonPlay.setBackground(skin.getDrawable("play"));
    		stage.addAction(Actions.fadeOut(1f));
    		game.setScreen(new Play());
        	
        }
    }
    
	@Override
	public void hide() {
	}
	
	@Override
	public void resize(int width, int height) {
	}
	
	@Override
	public void pause() {
	}
	
	@Override
	public void resume() {
	}
	
	@Override
	public void dispose() {		
	    stage.dispose();  	
	}

}
