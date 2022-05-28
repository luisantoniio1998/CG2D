package jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
	
	
	

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler; 
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle ((int)x,(int) y, 32, 32);
	}

	@Override
	public void tick() {
		
		x += velX;
		y += velY; 
		
		x = Jogo.clamp(x, 0, Jogo.WIDTH -37 );
		y = Jogo.clamp(y, 0, Jogo.HEIGHT -60);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.1f, handler ));
		collision();
	}
	
	//Fun��o de colis�o para o player
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.Boss) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					HUD.HEALTH -= 2; 
				}
				
			}
		}
	}

	//Renderizacao Player
	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
		
	}

}
