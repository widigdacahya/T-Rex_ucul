package id.ac.its.trexucul.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
	
	public static int x;
	public static int y;
	public static boolean btnLeft;
	public static boolean btnRight;
	
	public MouseHandler() {
		x = 0;
		y = 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			btnLeft = true;
		if(e.getButton() == MouseEvent.BUTTON2)
			btnRight= true;
	}

	@Override
	public void mousePressed(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON1)
			btnLeft = true;
		if(e.getButton() == MouseEvent.BUTTON2)
			btnRight= true;
	}
	
	@Override
	public void mouseReleased(MouseEvent e){
		if(e.getButton() == MouseEvent.BUTTON1)
			btnLeft = false;
		if(e.getButton() == MouseEvent.BUTTON2)
			btnRight= false;
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
