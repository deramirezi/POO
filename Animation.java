package window;

/**
 *
 * @author edgarFelVera
 */

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animation {

	private int speed;
	private int frames;
	
	private int index = 0;
	private int actual = 0;
	
	private BufferedImage[] images;
	private BufferedImage actualImage;
	
	public Animation(int speed, BufferedImage... args ){
		this.speed = speed;
		images = new BufferedImage[args.length];
		for(int i = 0; i < args.length; i++){
			images[i]= args[i];
		}
		frames = args.length;
	}
	
	public void runAnimation(){
			index++;
			if(index > speed){
				index = 0;
				nextFrame();
			}
	}
	
	private void nextFrame(){
		for(int i = 0; i < frames; i++){
			if(actual == i){
				actualImage = images[i];
			}
		}
		actual++;
		if(actual > frames){
			actual = 0;
		}
	}
	
	public void drawAnimation(Graphics g, int x, int y){
		g.drawImage(actualImage, x, y, null);	
	}
	
	public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY){
		g.drawImage(actualImage, x, y, null);	
	}
}
