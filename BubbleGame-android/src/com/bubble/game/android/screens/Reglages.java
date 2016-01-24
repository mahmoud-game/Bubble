package com.bubble.game.android.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;

public class Reglages implements Screen {

	  @Override
	  public void render(float delta) {
	      Gdx.gl.glClearColor(1, 0, 0, 1);
	 
	      Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
	      Gdx.app.log("OVER", "Dans le GameOver");        
	  }

	  @Override
	  public void resize(int width, int height) {
	  }

	  @Override
	  public void show() {
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
