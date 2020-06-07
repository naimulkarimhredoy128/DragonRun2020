package com.neet.GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.neet.Audio.JukeBox;
import com.neet.Entity.PlayerSave;
import com.neet.Handlers.Keys;
import com.neet.Main.GamePanel;
import javax.swing.JOptionPane;

public class MenuState extends GameState {
	
	private BufferedImage head;
	
	private int currentChoice = 0;
	private String[] options = {
		"Start",
		"Quit",
                "help" ///update gameplan
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	private Font font2;
	
	public MenuState(GameStateManager gsm) {
		
		super(gsm);
		
		try {
			
			// load floating head lifes
			head = ImageIO.read(
				getClass().getResourceAsStream("/HUD/Hud.gif")
			).getSubimage(0, 12, 12, 11);
			
			// titles and fonts
			titleColor = Color.cyan;
			titleFont = new Font("cursive", Font.BOLD, 28);
			font = new Font("Arial", Font.BOLD, 14);
			font2 = new Font("Arial", Font.BOLD, 10);
			
			// load sound fx
			JukeBox.load("/SFX/menuoption.mp3", "menuoption");
			JukeBox.load("/SFX/menuselect.mp3", "menuselect");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() {}
	
	public void update() {
		
		// check keys
		handleInput();
		
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("ONE MAN ARMY", 50, 90);
		
		// draw menu options
		g.setFont(font);
		g.setColor(Color.CYAN);
		g.drawString("Start", 145, 165);
		g.drawString("Quit", 145, 185);
                g.drawString("Help", 145, 205);//new added











		
		// draw floating head
		if(currentChoice == 0) g.drawImage(head, 125, 154, null);
		else if(currentChoice == 1) g.drawImage(head, 125, 174, null);
		else if(currentChoice == 2) g.drawImage(head, 125, 194, null);//update help
		// other
		g.setFont(font2);
		g.drawString("2020 Naimul K.", 10, 232);
		
	}
	
	private void select() {
		if(currentChoice == 0) {
			JukeBox.play("menuselect");
			PlayerSave.init();
			gsm.setState(GameStateManager.LEVEL1ASTATE);
		}
		else if(currentChoice == 1) {
			System.exit(0);
		}
                else if(currentChoice == 2) {
		JOptionPane.showMessageDialog(null,"W=FLY\n"+"D=fire\n"+"A=RUN\n"+"MOVE LEFT <- ARROW\n"+"MOVE RIGHT -> ARROW\n"+"ENTER=OK\n"+"ESC=PAUSE","INFORMATION",JOptionPane.OK_CANCEL_OPTION);
                }
                
	}
	
	public void handleInput() {
		if(Keys.isPressed(Keys.ENTER)) select();
		if(Keys.isPressed(Keys.UP)) {
			if(currentChoice > 0) {
				JukeBox.play("menuoption", 0);
				currentChoice--;
			}
		}
		if(Keys.isPressed(Keys.DOWN)) {
			if(currentChoice < options.length - 1) {
				JukeBox.play("menuoption", 0);
				currentChoice++;
			}
		}
	}
	
}










