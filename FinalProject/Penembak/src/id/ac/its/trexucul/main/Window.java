package id.ac.its.trexucul.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import id.ac.its.trexucul.main.pages.CharacterPage;
import id.ac.its.trexucul.main.pages.CreditPage;
import id.ac.its.trexucul.main.pages.GameOverPage;
import id.ac.its.trexucul.main.pages.GamePage;
import id.ac.its.trexucul.main.pages.LevelPage;
import id.ac.its.trexucul.main.pages.MenuPage;
import id.ac.its.trexucul.main.pages.PageState;
import id.ac.its.trexucul.main.pages.ScorePage;
import id.ac.its.trexucul.main.pages.SplashPage;
import id.ac.its.trexucul.main.pages.VictoryPage;
import id.ac.its.trexucul.model.gfx.Assets;
import id.ac.its.trexucul.model.id.SelectedGamePage;
import id.ac.its.trexucul.utils.handler.KeyboardHandler;
import id.ac.its.trexucul.utils.handler.MouseHandler;
import id.ac.its.trexucul.utils.helper.Camera;
import id.ac.its.trexucul.utils.listener.KeyTypedListener;

public class Window extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 1280, HEIGHT = 720;
	
	private Canvas canvas;
	private Thread thread;
	private boolean running = false;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private final int FPS = 60;
	private double TARGETTIME = 1000000000/FPS;
	private double delta = 0;
	
	private KeyboardHandler keyBoard;
	private MouseHandler mouse;
	
	private GamePage gamePage;
	
	private LevelPage levelPage;
	private MenuPage menuPage;
	private SplashPage splashPage;
	private GameOverPage gameOverPage;
	private CreditPage creditPage;
	private VictoryPage victoryPage;
	private CharacterPage characterPage;
	private ScorePage scorePage;
	
	public Camera cam;

	public Window(String title) {
		setTitle(title);
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		canvas = new Canvas();
		keyBoard = new KeyboardHandler();
		mouse = new MouseHandler();
		
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);
		
		add(canvas);
		addMouseMotionListener(mouse);
		addMouseListener(mouse);
		
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);
		canvas.addKeyListener(keyBoard);
		setVisible(true);
	}
	
	private void update() {
		if(PageState.currentState != null)
			PageState.currentState.update();
		
		keyBoard.update();
		
		if (PageState.currentState == gamePage) {
			cam.update(gamePage.getPlayer());
		}
	}

	private void draw() {
		bs = canvas.getBufferStrategy();
		
		if(bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		Graphics2D g2d = (Graphics2D)g;

		g2d.translate(cam.getX(), cam.getY());
		
		if(PageState.currentState != null)
			PageState.currentState.render(g);

		g2d.translate(-cam.getX(), -cam.getY());
		
		g.dispose();
		bs.show();
	}
	
	private void init() {
		cam = new Camera(0,0);
		menuPage = new MenuPage(this);
		splashPage = new SplashPage(this);
		levelPage = new LevelPage(this);
		gameOverPage = new GameOverPage(this);
		victoryPage = new VictoryPage(this);
		creditPage = new CreditPage(this);
		characterPage = new CharacterPage(this);
		scorePage = new ScorePage(this);
		
		PageState.currentState = getSplashPage();

		Assets.init();
	}

	@Override
	public void run() {
		long now = 0;
		long lastTime = System.nanoTime();
		long time = 0;
		
		init();
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/TARGETTIME;
			time += (now - lastTime);
			lastTime = now;
			
			if(delta >= 1) {		
				update();
				draw();
				delta --;
			}
			
			if(time >= 1000000000) {
				time = 0;
			}
		}
		
		stop();
	}
	
	public void start() {
		thread = new Thread(this);
		thread.start();
		running = true;		
	}
	
	private void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public GamePage getGamePage() {
		cam.resetCameraPosition();
		return gamePage;
	}

	public void setGamePage(GamePage gamePage) {
		this.gamePage = gamePage;
	}

	public LevelPage getLevelPage() {
		cam.resetCameraPosition();
		return levelPage;
	}

	public void setLevelPage(LevelPage levelPage) {
		this.levelPage = levelPage;
	}

	public MenuPage getMenuPage() {
		cam.resetCameraPosition();
		return menuPage;
	}

	public void setMenuPage(MenuPage menuPage) {
		this.menuPage = menuPage;
	}

	public SplashPage getSplashPage() {
		cam.resetCameraPosition();
		return splashPage;
	}

	public void setSplashPage(SplashPage splashPage) {
		this.splashPage = splashPage;
	}

	public GameOverPage getGameOverPage() {
		cam.resetCameraPosition();
		return gameOverPage;
	}

	public void setGameOverPage(GameOverPage gameOverPage) {
		this.gameOverPage = gameOverPage;
	}
	
	public CreditPage getCreditPage() {
		cam.resetCameraPosition();
		return creditPage;
	}

	public void setCreditPage(CreditPage creditPage) {
		this.creditPage = creditPage;
	}

	public VictoryPage getVictoryPage() {
		cam.resetCameraPosition();
		keyBoard.setKeyListener(new KeyTypedListener() {
			@Override
			public void keyInput(KeyEvent e) {
				victoryPage.updateTextTyped(e);
			}
		});
		
		return victoryPage;
	}

	public void setVictoryPage(SelectedGamePage type, int score) {
		victoryPage.setLevelType(type);
		victoryPage.setScore(score);
	}

	public CharacterPage getCharacterPage() {
		cam.resetCameraPosition();
		return characterPage;
	}

	public void setCharacterPage(CharacterPage characterPage) {
		this.characterPage = characterPage;
	}
	
	public ScorePage getScorePage() {
		cam.resetCameraPosition();
		scorePage.initList();
		return scorePage;
	}
}
