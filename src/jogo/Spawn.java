package jogo;

import java.util.Random;

public class Spawn  {

	private Handler handler; 
	private HUD hud;
	private Random r = new Random();
	
	private int scoreKeep = 0; 
	
	public Spawn (Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() {
		scoreKeep++;
		
		if(scoreKeep >= 250) {
			scoreKeep = 0 ; 
			hud.setLevel(hud.getLevel() + 1);
			
			
			if(hud.getLevel() == 2) {
				handler.addObject(new BasicEnemy(r.nextInt(Jogo.WIDTH - 50), r.nextInt(Jogo.HEIGHT - 50), ID.BasicEnemy, handler ));
			}
			else if(hud.getLevel() == 3) {
				handler.addObject(new BasicEnemy(r.nextInt(Jogo.WIDTH - 50), r.nextInt(Jogo.HEIGHT - 50), ID.BasicEnemy, handler ));
			}
			else if(hud.getLevel() == 4) {
				handler.addObject(new FastEnemy(r.nextInt(Jogo.WIDTH - 50), r.nextInt(Jogo.HEIGHT - 50), ID.BasicEnemy, handler ));
			}
			else if(hud.getLevel() == 5) {
				handler.addObject(new SmartEnemy(r.nextInt(Jogo.WIDTH - 50), r.nextInt(Jogo.HEIGHT - 50), ID.BasicEnemy, handler ));
			}
			else if(hud.getLevel() == 6) {
				handler.addObject(new FastEnemy(r.nextInt(Jogo.WIDTH - 50), r.nextInt(Jogo.HEIGHT - 50), ID.BasicEnemy, handler ));
			}
			else if (hud.getLevel() == 10) {
				handler.clearEnemys();
				handler.addObject(new Boss((int) Jogo.WIDTH /2 -30, (int) -90, ID.Boss, handler ));
				}
		}
	}
}
