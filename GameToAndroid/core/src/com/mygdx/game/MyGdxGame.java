package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.java.Game;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fon, crossBowMan, mage, monk, peasant, rouge, sniper, spearMan;
	Music music;
	Game game;

	
	@Override
	public void create () {
		game = new Game();
		game.setTeams(10);

		batch = new SpriteBatch();
		fon = new Texture("фоны/"+ Fons.values()[new Random().nextInt(Fons.values().length)] +".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("Музыка/"+ Muslo.values()[new Random().nextInt(Muslo.values().length)] +".mp3"));
		music.setLooping(true);
		music.setVolume(0.125f);
		music.play();

		crossBowMan = new Texture("персонажи/CrossBowMan.png");
		mage = new Texture("персонажи/Mage.png");
		monk = new Texture("персонажи/Monk.png");
		peasant = new Texture("персонажи/Peasant.png");
		rouge = new Texture("персонажи/Rouge.png");
		sniper = new Texture("персонажи/Sniper.png");
		spearMan = new Texture("персонажи/SpearMan.png");
	}

	@Override
	public void render () {

		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT )|| (Gdx.input.isTouched())){
			game.setTurnOrder();
			game.gameTurn();
			game.turnCount++;
			Gdx.graphics.setTitle(String.valueOf("Ход № "+game.turnCount));
		}

		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(fon, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for (int i=game.teamSize-1; i>=0; i--){
			batch.setColor(1, 1, 1, 1);
			if (game.team1.get(i).state.equals("dead")) batch.setColor(Color.RED);
			int x = game.team1.get(i).pos.x * Gdx.graphics.getWidth()/12;
			int y = (game.team1.get(i).pos.y-1) * Gdx.graphics.getHeight()/12;
			switch (game.team1.get(i).getInfo()){
				case "Арбалетчик ":
					batch.draw(crossBowMan, x, y);
					break;
				case "Маг ":
					batch.draw(mage, x, y);
					break;
				case "Монах ":
					batch.draw(monk, x, y);
					break;
				case "Крестьянин ":
					batch.draw(peasant, x, y);
					break;
				case "Разбойник ":
					batch.draw(rouge, x, y);
					break;
				case "Снайпер ":
					batch.draw(sniper, x, y);
					break;
				case "Копейщик ":
					batch.draw(spearMan, x, y);
			}

			batch.setColor(1, 1, 1, 1);
			if (game.team2.get(i).state.equals("dead")) batch.setColor(Color.RED);
			x = game.team2.get(i).pos.x * Gdx.graphics.getWidth()/12;
			y = (game.team2.get(i).pos.y-1) * Gdx.graphics.getHeight()/12;
			switch (game.team2.get(i).getInfo()){
				case "Арбалетчик ":
					Sprite sprite = new Sprite(crossBowMan);
					sprite.setPosition(x, y);
					sprite.flip(true, false);
					sprite.draw(batch);
					break;
				case "Маг ":
					sprite = new Sprite(mage);
					sprite.setPosition(x, y);
					sprite.flip(true, false);
					sprite.draw(batch);
					break;
				case "Монах ":
					sprite = new Sprite(monk);
					sprite.setPosition(x, y);
					sprite.flip(true, false);
					sprite.draw(batch);
					break;
				case "Крестьянин ":
					sprite = new Sprite(peasant);
					sprite.setPosition(x, y);
					sprite.flip(true, false);
					sprite.draw(batch);
					break;
				case "Разбойник ":
					sprite = new Sprite(rouge);
					sprite.setPosition(x, y);
					sprite.flip(true, false);
					sprite.draw(batch);
					break;
				case "Снайпер ":
					sprite = new Sprite(sniper);
					sprite.setPosition(x, y);
					sprite.flip(true, false);
					sprite.draw(batch);
					break;
				case "Копейщик ":
					sprite = new Sprite(spearMan);
					sprite.setPosition(x, y);
					sprite.flip(true, false);
					sprite.draw(batch);
			}

		}
		batch.setColor(1, 1, 1, 1);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		fon.dispose();
	}
}
