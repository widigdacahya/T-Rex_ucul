package id.ac.its.trexucul.collisiondetection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

	private Timer timer;
	private SpaceShip spaceShip;
	private final int DELAY = 15;
	private final int ICRAFT_X = 40;
	private final int ICRAFT_Y = 60;
	private List<Alien> aliens;
	private boolean ingame;
	private final int B_WIDTH = 1280;
	private final int B_HEIGHT = 720;
	private int x, y;
	
	private boolean firstOpen = false;
	private boolean initTime = false;
	private boolean startGame = false;
	
	private Long startTime = 0l;
	private Long currentTime = 0l;
	private int timeSec = 0;
	private int counter = 3;
	
	private final int [][] pos = {
			{2380,29}, {2500,59}, {1380,89},
			{780,109}, {580,139}, {680,239},
			{790, 259}, {760, 50}, {790, 150},
	        {980, 209}, {560, 45}, {510, 70},
	        {930, 159}, {590, 80}, {530, 60},
	        {940, 59}, {990, 30}, {920, 200},
	        {900, 259}, {660, 50}, {540, 90},
	        {810, 220}, {860, 20}, {740, 180},
	        {820, 128}, {490, 170}, {700, 30}
	};
	
	public Board() {
		initBoard();
	}
	
	private void initBoard() {
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		ingame = true;
		
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		
		spaceShip = new SpaceShip(ICRAFT_X,ICRAFT_Y);
		
		initAliens();
		
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	private void firstInstruction() {
		JOptionPane.showMessageDialog(null, "Place your cursor at left outside this window!\n" +
				"To avoid the collision of your spaceship with aliens", "Suggestion", 
				JOptionPane.INFORMATION_MESSAGE);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public void initAliens() {
		aliens = new ArrayList<>();
		
		for (int[] p: pos) {
			aliens.add(new Alien(p[0],p[1]));
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(ingame) {
			drawObjects(g);
		} else {
			drawGameOver(g);
		}

		Toolkit.getDefaultToolkit().sync();
	}
	
	private void drawObjects(Graphics g) {
		
		if(spaceShip.isVisible()) {
			g.drawImage(spaceShip.getImage(), 
					spaceShip.getX(),spaceShip.getY(),this);
		}
		
		List<Missile> ms = spaceShip.getMissiles();
		
		for(Missile missile : ms) {
			if(missile.isVisible()) {
				g.drawImage(missile.getImage(),
						missile.getX(), missile.getY(), this);
			}
		}
		
		for(Alien alien : aliens) {
			if(alien.isVisible()) {
				g.drawImage(alien.getImage(), 
						alien.getX(), alien.getY(), this);
			}
		}
		
		g.setColor(Color.white);
		g.drawString("Aliens left: " + aliens.size(), 5, 15);
		g.setColor(Color.white);
		g.drawString("Spaceship position: " + x + " " + y, B_WIDTH-185, 15);
		
		if (!startGame) {
			String msg = Integer.toString(counter - timeSec);
			Font medium = new Font("Helvetica", Font.BOLD, 18);
			FontMetrics fm = getFontMetrics(medium);
			
			g.setColor(Color.white);
			g.setFont(medium);
			if (counter - timeSec > 0)
				g.drawString(msg, (B_WIDTH - fm.stringWidth(msg))/2, B_HEIGHT/2);
			else
				g.drawString("Go!", (B_WIDTH - fm.stringWidth("Go!"))/2, B_HEIGHT/2);
		}
	}
	
	private void drawGameOver(Graphics g) {
		String msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);
		
		g.setColor(Color.white);
		g.setFont(small);
		g.drawString(msg, (B_WIDTH - fm.stringWidth(msg))/2, 
				B_HEIGHT/2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		inGame();
		
		if (!firstOpen) {
			firstInstruction();
			firstOpen = true;
		}
		
		if (startGame) {
			updateShip();
			updateMissiles();
			updateAliens();
			
			checkCollisions();
		} else {
			countingStart();
		}
		
		repaint();
	}
		
	private void inGame() {
		if(!ingame) {
			timer.stop();
		}
	}
	
	private void updateShip() {
		if(spaceShip.isVisible()) {
			spaceShip.move();
		}
	}

	private void updateMissiles() {
		List<Missile> missiles = spaceShip.getMissiles();
		
		for (int i =0; i<missiles.size(); i++ ) {
			
			Missile missile = missiles.get(i);
			
			if(missile.isVisible()) {
				missile.move();
			} else {
				missiles.remove(i);
			}
		}
	}
	
	private void updateAliens() {
		
		if(aliens.isEmpty()) {
			ingame = false;
			return;
		}
		
		for(int i=0; i< aliens.size(); i++) {
			
			Alien a = aliens.get(i);
			
			if(a.isVisible()) {
				a.move();
			} else {
				aliens.remove(i);
			}
		}
	}
	
	private void checkCollisions() {
		Rectangle r3 = spaceShip.getBounds();
		
		for (Alien alien : aliens) {
			
			Rectangle r2 = alien.getBounds();
			
			if (r3.intersects(r2)) {
				
				spaceShip.setVisible(false);
				alien.setVisible(false);
				ingame = false;
			}
		}
		
		List<Missile> ms = spaceShip.getMissiles();
		
		for (Missile m : ms) {
			
			Rectangle r1 = m.getBounds();
			
			for (Alien alien : aliens) {
				
				Rectangle r2 = alien.getBounds();
				
				if(r1.intersects(r2)) {
					
					m.setVisible(false);
					alien.setVisible(false);
				}
			}
		}
	}
	
	private void countingStart() {
		if (!initTime) {
			startTime = System.currentTimeMillis();
			initTime = true;
		}
		
		currentTime = System.currentTimeMillis() - startTime;
		timeSec = currentTime.intValue()/1000;
		
		if (counter - timeSec < 0) {
			startGame = true;
		}
	}
	
	private class TAdapter extends KeyAdapter {
//		@Override
//		public void keyReleased(KeyEvent e) {
//			spaceShip.keyReleased(e);
//		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			spaceShip.keyPressed(e);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		spaceShip.fire();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		spaceShip.updatePosition(e.getX(), e.getY());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		spaceShip.updatePosition(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		spaceShip.fire();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		spaceShip.updatePosition(e.getX(), e.getY());
		
		x = e.getX();
		y = e.getY();
		
		mousePressed(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		spaceShip.updatePosition(e.getX(), e.getY());
		
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
