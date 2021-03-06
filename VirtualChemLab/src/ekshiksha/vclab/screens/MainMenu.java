package ekshiksha.vclab.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

import ekshiksha.vclab.VCLabStarter;

public class MainMenu implements Screen {
	VCLabStarter vclab;
	SpriteBatch batch;
	Stage stage;
	
	TextButton btn_student, btn_teacher;
	Skin skin;
	TextureAtlas atlas;
	BitmapFont black,white;
	Label label;
	Table table;
	public MainMenu(VCLabStarter lab) {
		this.vclab = lab;		
	}
	@Override
	public void render(float delta) {
		Gdx.app.log(VCLabStarter.LOG,": Rendering MainMenu");
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		batch.begin();
		stage.draw();
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
        stage.setViewport(800, 480, true);
        stage.getCamera().translate(-stage.getGutterWidth(), -stage.getGutterHeight(), 0);

	}

	@Override
	public void show() {
		stage = new Stage();
		batch = new SpriteBatch();
		atlas = new TextureAtlas("data/button.pack");
		skin = new Skin();
		skin.addRegions(atlas);
		table = new Table(skin);
		white = new BitmapFont(Gdx.files.internal("data/utsaahi_white.fnt"), false);
		black = new BitmapFont(Gdx.files.internal("data/utsaahi_black.fnt"), false);
		Gdx.input.setInputProcessor(stage);
		
		//creating heading
		LabelStyle ls = new LabelStyle(white, Color.WHITE);
		label = new Label(VCLabStarter.TITLE,ls);
		label.setFontScale(2);
		label.setX(100);
		label.setY(Gdx.graphics.getHeight() / 2 + 200);
		//label.setWidth(width);
		label.setAlignment(Align.center);
		
		
		//creating buttons
		TextButtonStyle style = new TextButtonStyle();
		style.up = skin.getDrawable("buttonnormal");
		style.down = skin.getDrawable("buttonpressed");
		style.font = black;
		btn_student = new TextButton("Perform Experiment",style);
		btn_student.setWidth(400);
		btn_student.setHeight(100);
		btn_student.setX(Gdx.graphics.getWidth() / 2 - btn_student.getWidth() / 2);
		btn_student.setY(Gdx.graphics.getHeight() / 2 - btn_student.getHeight() / 2 + 100);
		btn_student.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				vclab.setScreen(new HomePage(vclab));
			}
		});
		btn_teacher = new TextButton("View Demo",style);
		btn_teacher.setWidth(400);
		btn_teacher.setHeight(100);
		btn_teacher.setX(Gdx.graphics.getWidth() / 2 - btn_teacher.getWidth() / 2);
		btn_teacher.setY(Gdx.graphics.getHeight() / 2 - btn_teacher.getHeight() / 2 - 100);
		btn_teacher.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				vclab.setScreen(new HomePage(vclab));
			}
		});
		stage.addActor(btn_student);
		stage.addActor(btn_teacher);
		stage.addActor(label);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		skin.dispose();
		//atlas.dispose();
		//white.dispose();
		//black.dispose();
		stage.dispose();
	}

}
