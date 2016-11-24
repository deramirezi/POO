package framework;

/**
 *
 * @author David Ramírez
 */

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import objects.Bill;
import window.Handler;

public class KeyInput extends KeyAdapter {

	Handler handler;
	
	public KeyInput (Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++){
			
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Player){
				if (key == KeyEvent.VK_RIGHT){
						tempObject.setVelX(5);
				}
				if (key == KeyEvent.VK_LEFT){
					tempObject.setVelX(-5);
				}
				if (key == KeyEvent.VK_UP && !tempObject.isJumping()){
					tempObject.setJumping(true);
					tempObject.setVelY(-10);
				}
				if(key == KeyEvent.VK_SPACE){
					handler.addObject(new Bill(tempObject.getX(), tempObject.getY(), ObjectId.Bill,tempObject.getFacing()*10));
					
				}
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(1);
		}
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
for (int i = 0; i < handler.object.size(); i++){
	
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ObjectId.Player){
				if (key == KeyEvent.VK_RIGHT){
						tempObject.setVelX(0);
				}
				if (key == KeyEvent.VK_LEFT){
					tempObject.setVelX(0);
				}
			}
		}
	}
	
}
