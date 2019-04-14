package Bite_Beat_1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BiteBeat extends JFrame implements ActionListener{

	private Image titleImage;
	private Image screenImage;
	private Image expBar;
	private Image rankingBoard = new ImageIcon(Main.class.getResource("../images/Ranking.png")).getImage();
	private Graphics screenGraphic;
	private Image background = new ImageIcon(Main.class.getResource("../images/BITE_BEAT_start.jpg")).getImage();
	
	// main ������
	private ImageIcon menuBarImg = new ImageIcon(Main.class.getResource("../images/MenuBar_.png"));
	private ImageIcon exitButtonBasicIcon = new ImageIcon(Main.class.getResource("../images/remove.png"));
	private ImageIcon exitButtonEnteredIcon = new ImageIcon(Main.class.getResource("../images/remove_c.png"));
	private ImageIcon signupButtonBasic = new ImageIcon(Main.class.getResource("../images/signupBasic.png"));
	private ImageIcon signupButtonEntered = new ImageIcon(Main.class.getResource("../images/signupEntered.png"));
	private ImageIcon loginButtonBasic = new ImageIcon(Main.class.getResource("../images/loginBasic.png"));
	private ImageIcon loginButtonEntered = new ImageIcon(Main.class.getResource("../images/loginEntered.png"));
	private ImageIcon leftButtonBasic = new ImageIcon(Main.class.getResource("../images/leftarrow.png"));
	private ImageIcon rightButtonBasic = new ImageIcon(Main.class.getResource("../images/rightarrow.png"));
	private ImageIcon backButtonBasic = new ImageIcon(Main.class.getResource("../images/backButton.png"));
	private ImageIcon backButtonEntered = new ImageIcon(Main.class.getResource("../images/backButton_c.png"));	
	private ImageIcon loginFinBasic = new ImageIcon(Main.class.getResource("../images/checked.png"));
	private ImageIcon signupFinBasic = new ImageIcon(Main.class.getResource("../images/checked.png"));
	private ImageIcon starBasic = new ImageIcon(Main.class.getResource("../images/uncheckStar.png"));
	private ImageIcon starEntered = new ImageIcon(Main.class.getResource("../images/checkedStar.png"));	
	private ImageIcon starList = new ImageIcon(Main.class.getResource("../images/listChecked.png"));	
	private ImageIcon searchImg = new ImageIcon(Main.class.getResource("../images/magnifying-glass.png"));
	private ImageIcon gameEndBasic = new ImageIcon(Main.class.getResource("../images/logout.png"));

	private ImageIcon easyButtonBasic = new ImageIcon(Main.class.getResource("../images/easyButton.png"));
	private ImageIcon easyButtonEntered = new ImageIcon(Main.class.getResource("../images/easyButton_c.png"));	
	private ImageIcon normalButtonBasic = new ImageIcon(Main.class.getResource("../images/normalButton.png"));
	private ImageIcon normalButtonEntered = new ImageIcon(Main.class.getResource("../images/normalButton_c.png"));	
	private ImageIcon hardButtonBasic = new ImageIcon(Main.class.getResource("../images/hardButton.png"));
	private ImageIcon hardButtonEntered = new ImageIcon(Main.class.getResource("../images/hardButton_c.png"));	

	private JButton exitButton = new JButton(exitButtonBasicIcon);
	private JButton signupButton = new JButton(signupButtonBasic);
	private JButton loginButton = new JButton(loginButtonBasic);
	private JButton backButton = new JButton(backButtonBasic);
	private JButton loginFinButton = new JButton(loginFinBasic);
	private JButton signupFinButton = new JButton(signupFinBasic);
	private JButton leftButton = new JButton(leftButtonBasic);
	private JButton rightButton = new JButton(rightButtonBasic);
	private JButton easyButton = new JButton(easyButtonBasic);
	private JButton normalButton = new JButton(normalButtonBasic);
	private JButton hardButton = new JButton(hardButtonBasic);
	private JButton starButton = new JButton(starBasic);
	private JButton starListButton = new JButton(starList);
	private JButton searchButton = new JButton(searchImg);
	private JButton gameEndButton = new JButton(gameEndBasic);

	private JPanel loginPanel = new JPanel();
	private JPanel searchPanel = new JPanel();
	
	private JLayeredPane layeredPane = new JLayeredPane();
	private JTextField signup_IdTf = new JTextField(10);
	private JPasswordField signup_pwdTf = new JPasswordField(12);
	private JTextField login_IdTf = new JTextField(10);
	private JPasswordField login_pwdTf = new JPasswordField(12);	
	private JTextField searchBarTf = new JTextField(15);
	
	private JLabel menuBar = new JLabel(menuBarImg);

	private int mouseX, mouseY; // mouse�� x,y��ǥ
	
	private boolean isMainScreen = false; // Main�� �ƴ� ȭ���� ���� ������ ������ false
	private boolean isGameScreen = false; // ���� ȭ������ �Ѿ�Դ����� ���� ����
	private static boolean isOverScreen = false;
		
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image selectedImage; 
	private Music selectedMusic;
	private Music intromusic = new Music("introMusic_.mp3", true); // true�̱� ������ ���� ����
	
	private int nowSelected = 0; // Ʈ�� ��ȣ
	private Graphics2D gameScore_2D;
	private int togelKey = 0;
	
	static int gameLevel = 1;
	static int expSum = 0;
	private static int FeverNum = Note.FeverNum;
		
	public static Game game;
	public static Note note;
	
	public BiteBeat() {	
		trackList.add(new Track("../albumImage/nct127_albumImage.jpg", "../Music/NCT 127 - REGULAR.mp3", "../Music/REGULAR_start.mp3", "NCT 127 - REGULAR", "nct127.png"));
		trackList.add(new Track("../albumImage/exo_albumImage.jpg", "../Music/EXO - TEMPO.mp3", "../Music/TEMPO_start.mp3", "EXO - TEMPO", "exo.png"));
		trackList.add(new Track("../albumImage/twice_albumImage.jpg", "../Music/TWICE - YES OR YES.mp3", "../Music/YES OR YES_start.mp3", "TWICE - YES OR YES", "twice.png"));	
			
		setUndecorated(true); // �⺻������ �����ϴ� �޴��ٰ� �Ⱥ������� ��.
		// setTitle("Bite Beat! ��Ʈ�� ��~��");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); // ȸ�� -> ���
		setLayout(null); // ��ư�̳� JLable���� �� �߰����� �� ���� �� ��ġ�� �־���	
		addKeyListener(new KeyListener());		
		intromusic.start();
			
		// ���̾ƿ� ����
		layeredPane.setBounds(256, 137, 600, 400);
		layeredPane.setLayout(null);
					
		// ȸ������-���̵� �ʵ�
		signup_IdTf.setBounds(212, 200, 400, 52);
		signup_IdTf.setFont(new Font("210 ��α� B", Font.PLAIN, 25));
		layeredPane.add(signup_IdTf);
		signup_IdTf.setOpaque(false);
		signup_IdTf.setForeground(Color.white);
		signup_IdTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		signup_IdTf.setVisible(false);
		
		// ȸ������-�н����� �ʵ�
		signup_pwdTf.setBounds(212, 275, 400, 52);
		signup_IdTf.setFont(new Font("210 ��α� B", Font.PLAIN, 25));
		layeredPane.add(signup_pwdTf);
		signup_pwdTf.setOpaque(false);
		signup_pwdTf.setForeground(Color.white);
		signup_pwdTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		signup_pwdTf.setVisible(false);
		
		// ȸ������-���̵� �ʵ�
		login_IdTf.setBounds(212, 200, 400, 52);
		login_IdTf.setFont(new Font("210 ��α� B", Font.PLAIN, 25));
		layeredPane.add(login_IdTf);
		login_IdTf.setOpaque(false);
		login_IdTf.setForeground(Color.white);
		login_IdTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		login_IdTf.setVisible(false);
		
		// ȸ������-�н����� �ʵ�
		login_pwdTf.setBounds(212, 275, 400, 52);
		login_IdTf.setFont(new Font("210 ��α� B", Font.PLAIN, 25));
		layeredPane.add(login_pwdTf);
		login_pwdTf.setOpaque(false);
		login_pwdTf.setForeground(Color.white);
		login_pwdTf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		login_pwdTf.setVisible(false);
			
		layeredPane.add(loginPanel);
		add(layeredPane);
		setVisible(true);
				
		// search Bar �ʵ�
		
		searchPanel.add(searchBarTf);
		add(searchPanel);
		
		/*############################*/
		loginFinButton.setBounds(840, 325, 150, 150);
		loginFinButton.setBorderPainted(false);
		loginFinButton.setContentAreaFilled(false);
		loginFinButton.setFocusPainted(false);
		loginFinButton.setVisible(false);
		loginFinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginFinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				enterMain();
							}
		});
		add(loginFinButton);
		
		/*############################*/
		signupFinButton.setBounds(840, 325, 150, 150);
		signupFinButton.setBorderPainted(false);
		signupFinButton.setContentAreaFilled(false);
		signupFinButton.setFocusPainted(false);
		signupFinButton.setVisible(false);
		signupFinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signupFinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mousePressed(MouseEvent e) {	
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				// try, catch ���� �ֱ�
				// �α��� ���� �� �Ű��� ��
				try {
					
				}catch(Exception e1){
					e1.printStackTrace();					
				}
				signupFinButton.setVisible(false);
				loginFinButton.setVisible(true);
				signup_IdTf.setVisible(false);
				signup_pwdTf.setVisible(false);
				login_IdTf.setVisible(true);
				login_pwdTf.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/loginBackground.jpg")).getImage();						
			}
			
			
		});
		
			
		add(signupFinButton);
			
		/*############################*/
		exitButton.setBounds(1232, 4, 40, 40);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredIcon);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicIcon);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(300);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);		
		
		/*############################*/
		backButton.setBounds(20, 60, 50, 50);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�
		backButton.setVisible(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				backButton.setIcon(backButtonEntered);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// ���콺 Ŭ�� ȿ����
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasic);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				signupButton.setVisible(false);
				loginButton.setVisible(false);
				//background = new ImageIcon(Main.class.getResource("../images/mainBackground.png")).getImage();
				backMain();
			}
		});
		add(backButton);
		
		/*############################*/
		signupButton.setBounds(390, 480, 130, 130);
		signupButton.setBorderPainted(false);
		signupButton.setContentAreaFilled(false);
		signupButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�
		signupButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				signupButton.setIcon(signupButtonEntered);
				signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// ���콺 Ŭ�� ȿ����
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				signupButton.setIcon(signupButtonBasic);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				signupButton.setVisible(false);	
				loginButton.setVisible(false);
				signupFinButton.setVisible(true);
				signup_IdTf.setVisible(true);
				signup_pwdTf.setVisible(true);
				// try, catch �� �ֱ�
				// �޼��� ���� �ٷ� login ȭ������ ��ȯ (�α��� �Ͻðڽ��ϱ�?)
				background = new ImageIcon(Main.class.getResource("../images/signinBackground.jpg")).getImage();
			}
		});
		add(signupButton);
		
		/*############################*/
		loginButton.setBounds(775, 480, 130, 130);
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				loginButton.setIcon(loginButtonEntered);
				loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// ���콺 Ŭ�� ȿ����
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				loginButton.setIcon(loginButtonBasic);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				signupButton.setVisible(false);
				loginButton.setVisible(false);
				loginFinButton.setVisible(true);
				signup_IdTf.setVisible(true);
				signup_pwdTf.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/loginBackground.jpg")).getImage();
			}
		});
		add(loginButton);
		
		/*############################*/
		leftButton.setBounds(360, 330, 90, 90);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�
		leftButton.setVisible(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasic);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				selectLeft();
			}
		});
		add(leftButton);	
		
		/*############################*/
		rightButton.setBounds(830, 330, 90, 90);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�
		rightButton.setVisible(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasic);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				selectRight();
			}
		});
		add(rightButton);	
		
		/*############################*/
		easyButton.setVisible(false);
		easyButton.setBounds(400, 600, 135, 67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�	
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEntered);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasic);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "Easy");
			}
		});
		add(easyButton);
		
		/*############################*/
		normalButton.setVisible(false);
		normalButton.setBounds(575, 600, 135, 67);
		normalButton.setBorderPainted(false);
		normalButton.setContentAreaFilled(false);
		normalButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�	
		normalButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				normalButton.setIcon(normalButtonEntered);
				normalButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				normalButton.setIcon(normalButtonBasic);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "Normal");

			}
		});
		add(normalButton);
		
		/*############################*/
		hardButton.setVisible(false);
		hardButton.setBounds(750, 600, 135, 67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�	
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEntered);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasic);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "Hard");
			}
		});
		add(hardButton);
		
		/*############################*/
		starButton.setVisible(false);
		starButton.setBounds(870, 140, 50, 50);
		starButton.setBorderPainted(false);
		starButton.setContentAreaFilled(false);
		starButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�	
		starButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				starButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				starButton.setIcon(starEntered);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(togelKey == 0) {
					starButton.setIcon(starBasic);
				}
			}
			 // ���Ű�� �⺻�� 0 ^^
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();		
				if(togelKey == 0) {
					togelKey = 1;				
					starButton.setIcon(starEntered);
				}else if(togelKey == 1) {
					togelKey = 0;
					starButton.setIcon(starBasic);
				}
			}
		});
		add(starButton);
		
		/*############################*/
		starListButton.setVisible(false);
		starListButton.setBounds(1210, 650, 50, 50);
		starListButton.setBorderPainted(false);
		starListButton.setContentAreaFilled(false);
		starListButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�	
		starListButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				starListButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				songList();
			}
		});
		add(starListButton);
		
		
		
		/*############################*/
		searchButton.setVisible(false);
		searchButton.setBounds(1218, 60, 50, 50);
		searchButton.setBorderPainted(false);
		searchButton.setContentAreaFilled(false);
		searchButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�	
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
			}
		});
		add(searchButton);
		
		/*############################*/
		gameEndButton.setVisible(false);
		gameEndButton.setBounds(1205, 60, 70, 60);
		gameEndButton.setBorderPainted(false);
		gameEndButton.setContentAreaFilled(false);
		gameEndButton.setFocusPainted(false); // �� �� �������� png ó���� �� �� �ִ�	
		gameEndButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				gameEndButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("Mouse_click.mp3", false);
				buttonEnteredMusic.start();
				gameEnd(gameScore_2D);
			}
		});
		add(gameEndButton);
				
		
		/*############################*/
		menuBar.setBounds(0, 0, 1280, 50);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if(isMainScreen) {
			g.drawImage(selectedImage, 430, 150, null);
			g.drawImage(titleImage, 420, 70, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("EXP", 20, 80);		
			gameExp(gameLevel, expBar);	
		}
		if(isGameScreen) {
			game.screenDraw(g);
		}
		if(isOverScreen) {
			String gameScore_Str = Integer.toString(Note.getGameScore());
			String gameExp_Str = Integer.toString(Note.getGameScore()/2);
			g.drawImage(rankingBoard, 150, 150, null);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 40));
			g.drawString("Your Score", 900, 350);
			g.drawString(gameScore_Str, 970, 400);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Exp : ", 900, 450);
			g.drawString(gameExp_Str, 1000, 455);	
			gameLevel(gameLevel);
			gameExp(gameLevel, expBar);
		}
		paintComponents(g);
		// Image�� ����� ���� �ƴ϶� J~ �� ����� �͵��� �׷��ִ� �Լ�
		// �޴��ٿ� ���� ��쿡�� �׻� �����Ǿ� �ִ� ���̱� ������
		// drawImage�� �ƴ� paintComponents �Լ��� �̿��Ѵ�.
		try {
			Thread.sleep(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();	
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getAlbumImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		System.out.println(nowSelected);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0)
			nowSelected = trackList.size() -1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis()-startTime;
		if(selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		normalButton.setVisible(false);
		hardButton.setVisible(false);
		/*==========================================*/
		if(Note.FeverNum >= 7) {
			while(endTime != 7) {
				background = new ImageIcon(Main.class.getResource("../images/fevertime.png")).getImage();
			}
		}else {
			background = new ImageIcon(Main.class.getResource("../images/gameStartBackground.jpg")).getImage();	
		}
		backButton.setVisible(true);
		starButton.setVisible(false);
		starListButton.setVisible(false);
		searchPanel.setVisible(false);
		searchButton.setVisible(false);
		gameEndButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
	}
	
	public void backMain() {
		isMainScreen = true;	
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		normalButton.setVisible(true);
		hardButton.setVisible(true);
		rightButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/gameBackground_.png")).getImage();
		backButton.setVisible(false);
		starButton.setVisible(false);
		starListButton.setVisible(true);	
		searchButton.setVisible(true);
		gameLevel(gameLevel);
		gameExp(gameLevel, expBar);
		selectTrack(nowSelected);
		isOverScreen = false;
		isGameScreen = false;
		searchPanel.setVisible(true);
		game.close();
	}
	
	public void enterMain() {
		signup_IdTf.setVisible(false);
		signup_pwdTf.setVisible(false);
		login_IdTf.setVisible(false);
		login_pwdTf.setVisible(false);
		loginFinButton.setVisible(false);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		normalButton.setVisible(true);
		hardButton.setVisible(true);
		starButton.setVisible(true);
		starListButton.setVisible(true);
		searchButton.setVisible(true);
		// �α��� ������ ��� -> try, catch ���� �ֱ�
		// �α��� ���� �� �Ű��� ��
		background = new ImageIcon(Main.class.getResource("../images/gameBackground_.png")).getImage();
		gameExp(gameLevel, expBar);
		isMainScreen = true;
		searchPanel.setVisible(true);
		intromusic.close();
		selectTrack(0);
	}
	
	public void gameEnd(Graphics2D g) {		
		if(selectedMusic != null)
			selectedMusic.close();		
		gameEndButton.setVisible(false);
		backButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/scoreBoard.png")).getImage();	
		isOverScreen = true;
		isGameScreen = false;
		game.close();
		setFocusable(true);
	}
	
	public void gameLevel(int gameLevel) {
		switch(gameLevel) {
		case 1:
			if(Note.getGameScore()/2 >= 5000) 
				gameLevel++;
			break;
		case 2:
			if(Note.getGameScore()/2 >= 10000) 
				gameLevel++;
			break;
		case 3:
			if(Note.getGameScore()/2 >= 20000) 
				gameLevel++;
			break;
		case 4:
			break;
		}
	}
	
	public void gameExp(int gameLevel, Image expBar) {
		int Line1 = 2000;
		int Line2 = 10000;
		int Line3 = 20000;
		
		switch(gameLevel) {
		case 1:
			if (Note.getGameScore() / 2 <= Line1 / 4)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_0.png")).getImage();
			else if(Note.getGameScore() / 2 >= Line1 / 4)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_25.png")).getImage(); 
			else if(Note.getGameScore()/2 >= Line1/2)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_50.png")).getImage(); 		
			else if(Note.getGameScore()/2 >= Line1/1.5)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_70.png")).getImage(); 
			else if(Note.getGameScore()/2 >= Line1/1.2)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_90.png")).getImage(); 		
		case 2:
			if(Note.getGameScore() / 2 - Line1 <= (Line2-Line1) / 4)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_25.png")).getImage(); 
			else if(Note.getGameScore() / 2 - Line1 >= (Line2-Line1) / 4)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_25.png")).getImage(); 
			else if(Note.getGameScore() / 2 - Line1 >= (Line2-Line1) / 2)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_50.png")).getImage(); 		
			else if(Note.getGameScore() / 2 - Line1 >= (Line2-Line1) / 1.5)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_70.png")).getImage(); 
			else if(Note.getGameScore() / 2 - Line1 >= (Line2-Line1) / 1.2)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_90.png")).getImage(); 	
		case 3:
			if(Note.getGameScore()/2 - (Line1+Line2) >= (Line3 - Line1 + Line2) / 4)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_25.png")).getImage(); 
			else if(Note.getGameScore()/2 - (Line1+Line2) >= (Line3 - Line1 + Line2) / 2)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_50.png")).getImage(); 		
			else if(Note.getGameScore()/2 - (Line1+Line2) >= (Line3 - Line1 + Line2) / 1.5)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_70.png")).getImage(); 
			else if(Note.getGameScore()/2 - (Line1+Line2) >= (Line3 - Line1 + Line2) / 1.2)
				expBar = new ImageIcon(Main.class.getResource("../images/exp_90.png")).getImage(); 				
		default:
			break;
		}
	}
	
	public void songList() {
		
	}
	
	/* DB */
	
	private void insertMember() {
		// 사용자가 입력한 정보 삽입
		MemberDTO dto = getViewData();
		MemberDAO dao = new MemberDAO();
		boolean ok = dao.insertMember(dto);
		
		if(ok) {
			JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다.");
		}
	} // insertMember()
	
	public MemberDTO getViewData() {
		// 사용자가 입력한 정보 삽입
		MemberDTO dto = new MemberDTO();
		String id = signup_IdTf.getText();
		String pwd = signup_pwdTf.getText();
		
		// dto에 담기
		dto.setId(id);
		dto.setPwd(pwd);
		
		return dto;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==signupFinButton) {
			insertMember();
			System.out.println("insertMember 호출");
		} else if(ae.getSource()==loginFinButton) {
			// loginFin 하고 나서 호출할 함수, Dialog로 띄우거나
			System.out.println("loginFin 호출");
		}
	}
}
