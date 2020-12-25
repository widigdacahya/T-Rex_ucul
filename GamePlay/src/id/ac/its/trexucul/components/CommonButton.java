package id.ac.its.trexucul.components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import id.ac.its.trexucul.gfx.Assets;
import id.ac.its.trexucul.util.ClickListener;
import id.ac.its.trexucul.util.MouseHandler;

public class CommonButton {
	
	protected String btnName;
	private int x, y;
	private Rectangle bounds;
	private boolean hovering;
	private ClickListener click;
	
	protected Image btn;
	protected Image btnHov;
	
	public CommonButton(String name, int x, int y, ClickListener click) {
		this.btnName = name;
		this.x = x;
		this.y = y;
		this.click = click;
		hovering = false;
		initBtn();
	}
	
	private void initBtn() {
		btn = Assets.getImageBtn(btnName + ".png");
		btnHov = Assets.getImageBtn(btnName + "_hov.png");
	}
	
	public void update(){		
		if(bounds != null && bounds.contains(MouseHandler.x, MouseHandler.y)) {
			hovering = true;
			if(MouseHandler.leftBtn)
				click.onClick();
		} else
			hovering = false;
	}
	
	public void render(Graphics g) {
		if(hovering) {
			g.drawImage(btnHov, this.x, this.y, null);
			bounds = new Rectangle(x, y, btnHov.getWidth(null), btnHov.getHeight(null));
		} else {
			g.drawImage(btn, this.x, this.y, null);
			bounds = new Rectangle(x, y, btn.getWidth(null), btn.getHeight(null));
		}
	}
}
