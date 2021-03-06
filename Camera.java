package window;

/**
 *
 * @author David Ram�rez
 */

import framework.GameObject;

public class Camera {

	private float x;
	private float y;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void tick(GameObject player){
		x = -player.getX()+RunTrump.WIDTH/2;	
	}
	
}
