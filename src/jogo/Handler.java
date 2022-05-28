package jogo;

import java.util.LinkedList;
import java.awt.Graphics;

public class Handler {
	
	//Class para loopar os objetos e fazer update aos mesmos 
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		
		
		for(int i = 0 ; i < object.size(); i++) {
			GameObject  tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0 ; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void clearEnemys ( ) {
		for(int i = 0 ; i < object.size(); i++) {
			GameObject  tempObject = object.get(i);


			if(tempObject.getId()  == ID.Player ) {
				object.clear();
				addObject(new Player(Jogo.WIDTH/2 -32, Jogo.HEIGHT/2-32 , ID.Player, this));
			}
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	
}
