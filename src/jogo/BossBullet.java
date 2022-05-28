package jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import java.awt.Rectangle;

public class BossBullet extends GameObject{
	
	private Handler handler;
	Random r = new Random();

	public BossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler; 
		
		velX = r.nextInt(5 - - 5) + -5;
		velY = 5;

	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int) y, 16, 16);
	}


	@Override
	public void tick() {
		
		x += velX; 
		y += velY;
		
		//if( y <= 0 || y >= Jogo.HEIGHT -32) velY *= -1; 
		//if( x <= 0 || x >= Jogo.WIDTH -16) velX *= -1; 
		
		if(y >= Jogo.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.magenta, 16, 16, 0.1f, handler ));
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.magenta);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}

}

