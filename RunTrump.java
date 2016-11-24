package window;

/**
 *
 * @author jfern00
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import framework.KeyInput;
import framework.ObjectId;
import framework.Texture;
import objects.Block;
import objects.Player;
import objects.WhiteJaus;

public class RunTrump extends Canvas implements Runnable{
	
	
	private static final long serialVersionUID = 1L;

	private boolean running = false;
	private Thread thread;
	Camera cam;
	public static int WIDTH, HEIGHT;
	public BufferedImage level = null, level2 = null;
	static Texture tex;
	BufferedImage bg = null;
	public static int LEVEL =1;
	
	Handler handler;
	private void init(){
		WIDTH = getWidth();
		HEIGHT = getHeight();
		tex = new Texture();
		
		BufferedImageLoader loader = new BufferedImageLoader();
		bg = loader.loadImage("/background.png");
		level = loader.loadImage("/level1.png");
		level2 = loader.loadImage("/level1.png");
		cam = new Camera(0,0);
		handler = new Handler(cam);
		
		//handler.addObject(new Player(100,100,handler, ObjectId.Player));
		//handler.createLevel();
		handler.loadImageLevel(level);
		this.addKeyListener(new KeyInput(handler));
		
	}
	
	public synchronized void start(){
		
		if(running){
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void run (){
		
		init();
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		
	}
	
	private void tick(){
		
		handler.tick();
		for(int i = 0; i < handler.object.size(); i++){
			if(handler.object.get(i).getId() == ObjectId.Player){
				cam.tick(handler.object.get(i));
			}
		}	
	}
	
	private void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null){
				this.createBufferStrategy(3);
				return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D)g;
		
		
		
		
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(bg, 0,0,null);
		g2d.translate(cam.getX(), cam.getY());
		
			handler.render(g);
			
		g2d.translate(-cam.getX(), -cam.getY());
		g.dispose();
		bs.show();
	}
	
	
	
	public static Texture getInstance(){
		return tex;
		
	}
	
	public static void main(String args[]){
			
		new Window(1920, 1080, "Run Trump!", new RunTrump());
		
	}
	
}
