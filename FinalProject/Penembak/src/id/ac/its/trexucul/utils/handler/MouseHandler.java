package id.ac.its.trexucul.utils.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
	
	public static int x;
	public static int y;
	public static boolean leftBtn;
	public static boolean rightBtn;
	
	public MouseHandler() {
		x = 0;
		y = 0;
	}

	@Override
	public void mousePressed(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON1)
			leftBtn = true;
		if(e.getButton() == MouseEvent.BUTTON2)
			rightBtn= true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON1)
			leftBtn = false;
		if(e.getButton() == MouseEvent.BUTTON2)
			rightBtn= false;
	}
	@Override
	public void mouseDragged(MouseEvent e){
		x = e.getX();
		y = e.getY();
	}
	@Override
	public void mouseMoved(MouseEvent e){
		x = e.getX();
		y = e.getY();
	}
}
