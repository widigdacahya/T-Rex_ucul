package id.ac.its.trexucul.game.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.Random;

import id.ac.its.trexucul.game.framework.KeyInput;
import id.ac.its.trexucul.game.framework.ObjectId;
import id.ac.its.trexucul.game.object.Block;
import id.ac.its.trexucul.game.object.Player;

public class Game extends Canvas implements Runnable {
	
	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH, HEIGHT;
	
	//object 
	Handler handler;
	Camera cam;
	Texture tex;
	
	Random rand = new Random();
	
	private void init() {
		
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		tex = new Texture();
		
		handler = new Handler();
		
		cam = new Camera(0,0);
		
		//the moving object maybe
		handler.addObject(new Player(100,100, handler, ObjectId.Player));
		
		//seems like floor
		handler.createLevel();
		
		this.addKeyListener(new KeyInput(handler));
	}
	
	
	public synchronized void start() {
		if (running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		
		this.requestFocus();
		init();
		
		//System.out.println("Thread has begun");
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + "| TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
			
		}
		
	}
	
	private void tick() {
		handler.tick();
		
		for(int u=0; u < handler.object.size(); u++ ) {
			
			if(handler.object.get(u).getId() == ObjectId.Player) {
				cam.tick(handler.object.get(u));
				
			}
			
		}
		
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		//drawing item below will be drawn on window
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g2d.translate(cam.getX(),cam.getY());
		handler.render(g);
		g2d.translate(-cam.getX(), -cam.getY());
		//
		
		g.dispose();
		bs.show();
		
	}
	
//	if((red == 255) && (green == 255) && (blue == 255)) handler.addObject(new Block(xx*32, yy*32, 0, ObjectId.Block));
//	if((red == 128) && (green == 128) && (blue == 128)) handler.addObject(new Block(xx*32, yy*32, 1, ObjectId.Block));
//	if((red == 0) && (green == 0) && (blue == 255)) handler.addObject(new Block(xx*32, yy*32, handler, ObjectId.Block));
	
	public static Texture getInstance() {
		return tex;
	}
	
	public static void main(String args[]) {
		new Window(800, 600, "Neon Platform Game Prototype", new Game());
	}
	
	
}
