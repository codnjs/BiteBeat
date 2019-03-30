package Bite_Beat_1;

public class Track {
	private String titleImage;
	private String albumImage; // �ٹ� �̹���
	private String startMusic; // ���� ���� â ����
	private String gameMusic; // ���� �ش� �� �������� �� ����
	private String titleName; // �� ����
		
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getAlbumImage() {
		return albumImage;
	}
	public void setAlbumImage(String albumImage) {
		this.albumImage = albumImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public Track(String albumImage, String startMusic, String gameMusic, String titleName, String titleImage) {
		super();
		this.albumImage = albumImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
		this.titleImage = titleImage;
	}	
}
