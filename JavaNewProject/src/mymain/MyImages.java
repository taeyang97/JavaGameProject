package mymain;

import java.awt.Image;
import javax.swing.ImageIcon;

// 로고 이미지
public class MyImages {
	public static Image img_snow;
	public static Image img_subLogo;
	public static Image img_mainLogo;
	public static Image img_background;
	public static Image img_background2;
	public static Image img_zol;
	public static Image img_right;
	public static Image img_left;
	
	static {
		img_snow = new ImageIcon("img/snowball.png").getImage();
		img_subLogo = new ImageIcon("img/SubLogo.png").getImage();
		img_mainLogo = new ImageIcon("img/MainLogofinal.png").getImage();
		img_background = new ImageIcon("img/background.png").getImage();
		img_background2 = new ImageIcon("img/background2.png").getImage();
		img_zol = new ImageIcon("img/zol.png").getImage();
		img_right = new ImageIcon("img/right.png").getImage();
		img_left = new ImageIcon("img/left.png").getImage();
	}
}