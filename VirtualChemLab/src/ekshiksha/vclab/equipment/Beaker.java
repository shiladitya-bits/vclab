package ekshiksha.vclab.equipment;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Beaker {
	Pixmap pixmap;
	Texture texture;
	Image image;
	public boolean long_pressed;
	public Beaker()
	{
		pixmap = new Pixmap(64,64,Format.RGBA8888);
		pixmap.setColor(0,1,0,0.75f);
		pixmap.fillCircle(32,32,32);
		
	}
	public Beaker(Texture texture)
	{
		this.texture = texture;
		image = new Image(texture);
		image.setX(100);
		image.setY(100);
		image.setWidth(64);
		image.setHeight(64);
		long_pressed = false;
	}
	public Pixmap getPixmap()
	{
		return pixmap;
	}
	public void setPixmap(Pixmap pixmap)
	{
		this.pixmap = pixmap;
	}
	public Texture getTexture() 
	{
		return texture;
	}
	public void setTexture(Texture texture) 
	{
		this.texture = texture;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
}