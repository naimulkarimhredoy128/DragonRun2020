package com.neet.GameState;

import java.awt.Graphics2D;

public abstract class GameState {
    
    
    ///game state is a abstract class which is connected with gsm which is in game panel.
	 
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
        ///all abstract method which is implement in other class
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void handleInput();
	
}
