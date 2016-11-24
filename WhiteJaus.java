package objects;

/**
 *
 * @author jfern00
 */

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import framework.GameObject;
import framework.ObjectId;
import window.BufferedImageLoader;

public class WhiteJaus extends GameObject{

	BufferedImageLoader loadJaus;
	BufferedImage jaus;
	
	public WhiteJaus(float x, float y, ObjectId id) {
		super(x, y, id);
		loadJaus = new BufferedImageLoader();
		jaus = loadJaus.loadImage("/whitejaus.png");
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(jaus, (int)x, (int)y, null);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y, 30,30);
	}

}
