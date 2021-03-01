package mymain;

import java.awt.Graphics;

// 눈 생성 담당 클래스 

public class Snow extends Item {
	public Snow() {
		pos.width 	= MyImages.img_snow.getWidth(null);
		pos.height 	= MyImages.img_snow.getHeight(null);
	}
	public int speed;
	
	// 눈이 생성 후 밑으로 떨어지게
	@Override
	public boolean move() {
		pos.y += speed;	
		return (pos.y <= MyConst.GamePan.GAMEPAN_H);
	}
	
	// 눈을 그려냄
	@Override
	public void draw(Graphics g) {
		g.drawImage(MyImages.img_snow,pos.x,pos.y,null);
	}
}
