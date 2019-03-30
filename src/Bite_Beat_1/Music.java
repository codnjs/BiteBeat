package Bite_Beat_1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	
	private Player player; // Player �ڷ����� javazoom ���̺귯���� ��������
	private boolean isLoop; // ���� ���ѹݺ����� �ѹ��ݺ�����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file); // file�� ��ġ�� ������
			bis = new BufferedInputStream(fis); // �ش� file�� ���ۿ� ��Ƽ� ���� �� �ְ� ��
			player = new Player(bis); // �ش� file�� ���� �� �ְ� ��
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {
		// ���� ����ǰ� �ִ� ������ � ��ġ�� ����ǰ� �ִ��� �˷���
		// ���� ��� ���� 0:10 �� Ʋ������ ������ 10000�� ��ȯ
		if (player == null)
			return 0;
		return player.getPosition(); // ��Ʈ�� ������ �ð��� �м�
	}
	
	public void close() { // �������� ������ �����ų �� �ִ� �Լ�. (�ڷΰ��� ��ư���� ��)
		isLoop = false; // ȭ���� ������ ���ǵ� ���ÿ� ����, �� ������ �����Ű�� �ִ� ���ȿ��� ��� �����
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {
		try {
		// do-while������ �����Ŵ���ν� ���� �� �� ������ ��Ŵ
			do {
				player.play(); 
				fis = new FileInputStream(file); // file�� ��ġ�� ������
				bis = new BufferedInputStream(fis); // �ش� file�� ���ۿ� ��Ƽ� ���� �� �ְ� ��
				player = new Player(bis); // �ش� file�� ���� �� �ְ� ��
			} while (isLoop); // isLoop�� boolean ��. true�� �� ����(�ݺ�), false�� ����
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
