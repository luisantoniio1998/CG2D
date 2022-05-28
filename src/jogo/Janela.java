package jogo;

import java.awt.*;

import java.awt.Canvas;

import javax.swing.*;



public class Janela extends Canvas {
	
	//Cria janela 
	private static final long serialVersionUID = 7351925177675762142L;
	
	public Janela(int width, int height, String title, Jogo jogo) {
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(jogo);
		frame.setVisible(true);
		jogo.start();
	}

}
