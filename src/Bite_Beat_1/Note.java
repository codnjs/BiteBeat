package Bite_Beat_1;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;	
	
	public static int gameScore = 0;
	public static int FeverNum = 0;
	
	public static int getGameScore() {
		return gameScore;
	}
	public static int getGameExp() {
		return gameScore/2;
	}
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x = 228;
		}
		else if(noteType.equals("D")) {
			x = 332;
		}
		else if(noteType.equals("F")) {
			x = 436;
		}
		else if(noteType.equals("Space")) {
			x = 540;
		}
		else if(noteType.equals("J")) {
			x = 744;
		}
		else if(noteType.equals("K")) {
			x = 848;
		}
		else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(!noteType.equals("Space"))
		{
			g.drawImage(noteBasicImage, x, y, null);
		}
		else
		{
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED; // 7만큼 y좌표 증가
		if(y > 620) {
			System.out.println("Miss");
			close();
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public String judge() {
		if(y >= 603) {
			System.out.println("BAD");
			gameScore += 5;
			FeverNum = 0;
			System.out.println(FeverNum);
			close();
			return "BAD";
		}
		else if(y >= 590) {
			System.out.println("GOOD");
			gameScore += 10;
			FeverNum = 0;
			System.out.println(FeverNum);
			close();
			return "GOOD";
		}		
		else if(y >= 580) {
			System.out.println("GREAT!");
			gameScore += 15;
			FeverNum++;
			System.out.println(FeverNum);
			close();
			return "GREAT!";
		}
		else if(y >= 573) {
			System.out.println("PERFECT!!!");
			gameScore += 20;
			FeverNum++;
			System.out.println(FeverNum);
			close();
			return "PERFECT!!!";
		}
		else if(y >= 566) {
			System.out.println("GREAT!");
			gameScore += 15;
			FeverNum++;
			System.out.println(FeverNum);
			close();
			return "GREAT!";
		}
		else if(y >= 550) {
			System.out.println("GOOD");
			gameScore += 10;
			FeverNum = 0;
			System.out.println(FeverNum);
			close();
			return "GOOD";
		}
		return "None";
	}
	
	public int getY() {
		return y;
	}	
	
		
}
