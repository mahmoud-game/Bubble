package com.bubble.game.android.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.bubble.game.android.MyGame;

public class GameOver implements Screen {

    MyGame g;
    
    public GameOver(MyGame game) {
        g = game;
    }
 
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