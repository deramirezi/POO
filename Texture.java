package framework;

/**
 *
 * @author jfern00
 */

import java.awt.image.BufferedImage;

import window.BufferedImageLoader;

public class Texture {

	SpriteSheet bs,ps;
	private BufferedImage blockSheet= null;
	private BufferedImage playerSheet= null;
	public BufferedImage [] block = new BufferedImage[2];
	public BufferedImage [] player = new BufferedImage[10];
	
	public Texture(){
		BufferedImageLoader loader = new BufferedImageLoader();
		try{
			blockSheet=loader.loadImage("/spriteSheet.png");
			playerSheet=loader.loadImage("/trumpSprite.png");
		} catch (Exception e){
			e.printStackTrace();
		}
		
		bs = new SpriteSheet(blockSheet);
		ps = new SpriteSheet(playerSheet);
		
		getTextures();
	}
	
	private void getTextures(){
		block[0] = bs.grabImage(1,3,34,34);
		block[1] = bs.grabImage(2,4,34,34);
		player[0] = ps.grabImage(1,1,50,60);
		player[1] = ps.grabImage(1,2,50,60);
		player[2] = ps.grabImage(1,3,50,60);
		player[3] = ps.grabImage(2,1,50,60);
		player[4] = ps.grabImage(2,2,50,60);
		player[5] = ps.grabImage(2,3,50,60);
		player[6] = ps.grabImage(3,1,50,60);
		player[7] = ps.grabImage(3,2,50,60);
		player[8] = ps.grabImage(3,3,50,60);
		player[9] = ps.grabImage(1,4,50,60);
		
	}
}
