package mymain;

import java.awt.Graphics;

// �� ���� ��� Ŭ���� 

public class Snow extends Item {
	public Snow() {
		pos.width 	= MyImages.img_snow.getWidth(null);
		pos.height 	= MyImages.img_snow.getHeight(null);
	}
	public int speed;
	
	// ���� ���� �� ������ ��������
	@Override
	public boolean move() {
		pos.y += speed;	
		return (pos.y <= MyConst.GamePan.GAMEPAN_H);
	}
	
	// ���� �׷���
	@Override
	public void draw(Graphics g) {
		g.drawImage(MyImages.img_snow,pos.x,pos.y,null);
	}
}
