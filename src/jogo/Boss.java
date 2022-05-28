package jogo;


import java.awt.*;
import java.util.*;

public class Boss extends GameObject{
	
	private Handler handler;
	private int timer = 80;
	private int timer2 = 50;
	Random r = new Random();

	public Boss(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		
		this.handler = handler; 
		
		velX = 0;
		velY = 2;

	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int) y, 96, 96);
	}


	@Override
	public void tick() {
		
		x += velX; 
		y += velY;
		
		if(timer<=0) velY = 0; 
		else timer--;
		
		if(timer<= 0) timer2--;
		if(timer2<=0)
		{
			if(velX == 0) velX = 2; 
			int spawn = r.nextInt(10);
			if(spawn == 0) handler.addObject(new BossBullet((int)x +48, (int)y + 95, ID.BasicEnemy, handler));
			
		}
		
		//if( y <= 0 || y >= Jogo.HEIGHT -32) velY *= -1; 
		if( x <= 0 || x >= Jogo.WIDTH -16) velX *= -1; 
		
		//handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.008f, handler ));
	}
	
	

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.yellow);
		g.fillRect((int)x, (int)y, 96, 96);
		
	}

}
