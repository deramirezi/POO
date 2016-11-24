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

public class Bill extends GameObject{

	BufferedImageLoader loadBill;
	BufferedImage bill;
	
	public Bill(float x, float y, ObjectId id,  int velX) {
		super(x, y, id);
		loadBill = new BufferedImageLoader();
		bill = loadBill.loadImage("/bill.png");
		this.velX = velX;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		x+=velX;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(bill, (int)x+15, (int)y+20, null);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y, 15,15);
	}

}
