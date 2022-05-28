package jogo;

import java.awt.*;

public class HUD {
	
	public static float HEALTH = 100; 
	
	private int greenValue = 255; // Valor RGB 
	
	private float score = 0; 
	private float level = 1;
	
	public void tick() {
		
		HEALTH = Jogo.clamp(HEALTH,0, 100);
		greenValue = (int) Jogo.clamp(greenValue, 0, 255);
		
		greenValue = (int) (HEALTH*2);
		
		score++;
		
	}
	
	public void render(Graphics g) {
	g.setColor(Color.gray);
	g.fillRect(15, 15, 200, 32);
	g.setColor(new Color(75, greenValue, 0));
	g.fillRect((int)15,(int) 15, (int) (HEALTH * 2), 32);
	g.setColor(Color.white);
	g.drawRect(15, 15, 200, 32);
	
	g.drawString("Score: " + score, 15, 64);
	g.drawString("Level: " +level, 15, 80);
	}
	
	public void setScore(float score) {
		this.score = score; 
	}
	public float getScore(){
		return score;
	}
	
	public float getLevel(){
		return level;
	}
	
	public void setLevel(float level) {
		this.level = level;
	}
}
