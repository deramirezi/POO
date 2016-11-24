package objects;

/**
 *
 * @author pedroVan99
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import window.Animation;
import window.Camera;
import window.Handler;
import window.RunTrump;

public class Player extends GameObject {

	private float width = 50, height = 60;
	protected float gravity = 0.5f;
	private final float MAX_SPEED = 10;
	private Handler handler;
	Texture tex = RunTrump.getInstance();
	private Animation playerWalk;
	private Animation playerWalkLeft;
	private int facing = 1;
	public static int LEVEL=1;
	private Camera cam;
	
	public Player(int x , int y, Handler handler,Camera cam, ObjectId id){
			super(x,y,id);
			this.handler = handler;
			playerWalk = new Animation(5,  tex.player[8], tex.player[9]);
			playerWalkLeft = new Animation (5, tex.player[2], tex.player[5]);
			this.cam = cam;
	}
	
	public void tick(LinkedList<GameObject> object) {
		x+=velX;
		y+=velY;
		
		if(velX<0){
			facing = -1;
		} else if (velX>0){
			facing = 1;
		}
		
		if(falling || jumping){
				velY+=gravity;
				if(velY> MAX_SPEED){
					velY = MAX_SPEED;
				}
		}
		collision(object);
		playerWalk.runAnimation();
		playerWalkLeft.runAnimation();
	}

	private void collision(LinkedList<GameObject>object){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId()==ObjectId.Block){
				if(getBoundsTop().intersects(tempObject.getBounds())){
					y=tempObject.getY()+32;
					velY=0;
				} 
				
				if(getBounds().intersects(tempObject.getBounds())){
					y=tempObject.getY()-height;
					velY=0;
					falling = false;
					jumping = false;
				} else {
					falling = true;
				}
				
				if(getBoundsRight().intersects(tempObject.getBounds())){
					x=tempObject.getX()-width;
				} if(getBoundsLeft().intersects(tempObject.getBounds())) {
					x=tempObject.getX()+width*0.55f;
				}
			}else if(tempObject.getId()==ObjectId.WhiteJaus){
				if(getBounds().intersects(tempObject.getBounds())){
					handler.nextLevel();
				}
				
			}
		}
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.BLUE);
		if(jumping){
			if(facing == 1){
				g.drawImage(tex.player[9], (int)x, (int)y, null);
			} else if (facing == -1){
				g.drawImage(tex.player[2], (int)x, (int)y, null);
			}
			
		} else {
			if(velX !=0){
			if (facing == 1){
				playerWalk.drawAnimation(g, (int)x, (int)y);
			} else {
				playerWalkLeft.drawAnimation(g, (int)x, (int)y);
			}
			
		} else {
			g.drawImage(tex.player[0], (int)x, (int)y, null);
		}
		}
		
		
		
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)(x+(width/2)-(width/2)/2), (int)(y+(height/2)), (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsTop() {
		return new Rectangle((int)(x+(width/2-(width/2)/2)), (int)y, (int)width/2, (int)height/2);
	}
	public Rectangle getBoundsRight() {
		return new Rectangle((int)(x+width-5), (int)y+5, (int)5, (int)height-10);
	}
	public Rectangle getBoundsLeft() {
		return new Rectangle((int)x, (int)y+5, (int)5, (int)height-10);
	}
	

}
