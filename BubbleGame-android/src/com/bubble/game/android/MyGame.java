package com.bubble.game.android;

import com.badlogic.gdx.Game;
import com.bubble.game.android.screens.Play;

public class MyGame extends Game {
		
    @Override
    public void create() { // La méthode que l'on doit implementer    	    	
    	this.setScreen(new Play()); //Au lancement de notre jeu, le premier écran à s'afficher est le menu
    }
}