import javax.swing.ImageIcon;

public class Cards {
	private int number;
	private ImageIcon icon;
	
	public Cards(int number, ImageIcon icon) {
		
		this.number = number;
		this.icon = icon;
	}

	public ImageIcon getIcon() {
		
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	};
}
