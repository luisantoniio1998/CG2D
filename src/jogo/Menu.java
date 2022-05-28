package jogo;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import jogo.Jogo.STATE;


public class Menu extends MouseAdapter {
	
	private Jogo jogo;
	private	Handler handler;
	private HUD hud;
	private Random r = new Random();
	
public Menu(Jogo jogo, Handler handler, HUD hud) {
	this.jogo = jogo;
	this.handler = handler;
	this.hud = hud;
}

	
public void mousePressed(MouseEvent e) {
	int mx = e.getX();
	int my = e.getY();
	
	//Play Button
	if(mouseOver(mx, my, 210, 150, 200, 64 )){
		jogo.gameState = STATE.Game;
		handler.object.clear();
		handler.addObject(new Player(Jogo.WIDTH/2-32, Jogo.HEIGHT/2-32 , ID.Player, handler));
		handler.addObject(new BasicEnemy(r.nextInt(Jogo.WIDTH - 50), r.nextInt(Jogo.HEIGHT - 50), ID.BasicEnemy, handler ));
	}
	
	//Help button
	if(mouseOver(mx, my, 210, 250, 200, 64 )) {
		jogo.gameState = STATE.Help;
	}
	
	//Back button (help)
	if(jogo.gameState == STATE.Help) {
		if(mouseOver(mx, my, 210, 350, 200, 64 )) {
			jogo.gameState = STATE.Menu;
			return;
		}
	}
	
	//Back button (help)
	if(jogo.gameState == STATE.End) {
		if(mouseOver(mx, my, 210, 350, 200, 64 )) {
			jogo.gameState = STATE.Game;
			hud.setLevel(1);
			hud.setScore(0);
			handler.object.clear();
			handler.addObject(new Player(Jogo.WIDTH/2-32, Jogo.HEIGHT/2-32 , ID.Player, handler));
			handler.addObject(new BasicEnemy(r.nextInt(Jogo.WIDTH - 50), r.nextInt(Jogo.HEIGHT - 50), ID.BasicEnemy, handler ));
		}
	}
	
	//Quit button
	if(jogo.gameState == STATE.Menu) {
	if(mouseOver(mx, my, 210, 350, 200, 64 ))
	System.exit(1);
	}
}

public void mouseReleased(MouseEvent e) {
	
}


private boolean mouseOver (int mx, int my, int x, int y , int width, int height) {
	if(mx > x && mx < x + width ) {
		if(my > y && my < y + height) {
			return true;
		} else return false;
	}else return false;
	
}

public void tick() {
	
	
}

public void render(Graphics g) {
	if(jogo.gameState == STATE.Menu ) {
	
	Font fnt = new Font("arial", 1, 50);
	Font fnt2 = new Font("arial", 1, 30);
	
	g.setFont(fnt);
	g.setColor(Color.white);
	g.drawString("Projeto 2D", 180, 70);
	
	g.setFont(fnt2);
	g.drawRect(210 , 150, 200, 64);
	g.drawString("Play", 270, 190);
	

	g.drawRect(210 , 250, 200, 64);
	g.drawString("Help", 270, 290);
	
	
	g.drawRect(210 , 350, 200, 64);
	g.drawString("Quit", 270, 390);
	
		}else if(jogo.gameState == STATE.Help) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 240, 70);
			
			g.setFont(fnt3);
			g.drawString("Usar WASD para mover Jogador", 170, 190);
			
			g.setFont(fnt3);
			g.drawString("Objetivo : Fugir dos inimigos o mais tempo possivel" , 80, 270);
			
			
			
			g.setFont(fnt2);
			g.drawRect(210 , 350, 200, 64);
			g.drawString("Back", 270, 390);
		}else if(jogo.gameState == STATE.End) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 180, 70);
			
			g.setFont(fnt3);
			g.drawString("You lost with a score of " + hud.getScore(), 175, 200);
			
			
			
			g.setFont(fnt2);
			g.drawRect(210 , 350, 200, 64);
			g.drawString("Try Again", 245, 390);
		}

	}

}
