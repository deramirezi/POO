package framework;

/**
 *
 * @author edgarFelVera
 */

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public abstract class GameObject {

	protected float x, y;
	protected ObjectId id;
	protected float velX = 0, velY = 0;
	protected int facing = 1;
	
	public int getFacing() {
		return facing;
	}

	public void setFacing(int facing) {
		this.facing = facing;
	}

	public GameObject(float x, float y, ObjectId id){
		this.x = x;
		this.y = y;	
		this.id = id;
	}

	protected boolean falling =true;
	protected boolean jumping = false;
	
	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
	}
	
	
	
	public abstract void tick(LinkedList<GameObject> object);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public float getX(){
			return x;	
	}
	public float getY(){
		return y;
		
	}
	public void setX(float x){
			this.x = x;
	}
	public void setY(float y){
			this.y = y;
	}
	
	public  float getVelX(){
		return velX;
		
	}
	public  float getVelY(){
		return velY;
	}
	public  void setVelX(float x){
			this.velX = x;
		
	}
	public  void setVelY(float y){
		this.velY = y;
	}
	
	public  ObjectId getId(){
				return id;
	}
}


