package window;

/**
 *
 * @author pedroVan99
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import framework.GameObject;
import framework.ObjectId;
import objects.Block;
import objects.Player;
import objects.WhiteJaus;

public class Handler {

	public LinkedList<GameObject> object = new LinkedList<GameObject>();
	public GameObject tempObject;
	private Camera cam;
	private BufferedImage level2 = null;
	private BufferedImage level1 = null;
	
	public Handler(Camera cam){
		this.cam = cam;
		BufferedImageLoader loader = new BufferedImageLoader();
		level2 = loader.loadImage("/level2.png");
			
	}
	
	public void tick(){
			
		for (int i = 0; i < object.size(); i++){
				
			tempObject = object.get(i);
			tempObject.tick(object);
		}
		
	}
	
	private  void clearLevel(){
		object.clear();
	}
	
	public void render(Graphics g){
			
		for(int i = 0; i < object.size(); i++){
				tempObject = object.get(i);
				tempObject.render(g);
		}
		
	}
	
	public void addObject(GameObject object){
			this.object.add(object);
	}
	
	public void removeObject(GameObject object){
			this.object.remove(object);
	}
	
	public void loadImageLevel(BufferedImage image){
		int w = image.getWidth();
		int h = image.getHeight();
		
		System.out.println("width, height: "+w+", "+ h); 
		
		for (int xx = 0; xx < h; xx++){
			for(int yy = 0; yy < w; yy++){
				int pixel = image.getRGB(xx,yy);
				int red = (pixel>>16) & 0xff;
				int green = (pixel>>8) & 0x0ff;
				int blue = pixel & 0xff;
				
				if (red == 255 && green ==255 && blue ==255){
					addObject(new Block(xx*32, yy*32,0, ObjectId.Block));			
				}
				if (red == 0 && green == 0 && blue == 255){
					addObject(new Player(xx*32, yy*32,this,cam,  ObjectId.Player));	
				}
				if (red == 255 && green == 0 && blue == 0){
					addObject(new WhiteJaus(xx*32, yy*32,ObjectId.WhiteJaus));	
				}
			}
		}
}
	
	public void nextLevel(){
		clearLevel();
		cam.setX(0);
		switch(RunTrump.LEVEL){
		case 1: 
			loadImageLevel(level2);
			break;
		case 2:
			loadImageLevel(level2);
			break;
		}
	}
	
	/*
	public void createLevel(){
		for (int yy = 0; yy < RunTrump.HEIGHT+32; yy+=32){
			addObject(new Block(0, yy, ObjectId.Block));
		}
		
		for(int xx = 0; xx < RunTrump.WIDTH*2; xx+=32){
			addObject(new Block(xx,RunTrump.HEIGHT-32, ObjectId.Block));	
		}
		
		for(int xx = 200; xx < 600; xx+=32){
			addObject(new Block(xx,400, ObjectId.Block));	
		}
		
	}
	*/
}
