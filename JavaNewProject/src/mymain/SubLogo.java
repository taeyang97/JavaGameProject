package mymain;

import java.awt.Graphics;

// ���� ���� �� ������ press any key�� �����̰� ���ִ� Ŭ����

public class SubLogo {
	public static final int SUBLOGO_INTERVER=100;
	int sublogo_interver = SUBLOGO_INTERVER;
	public void draw(Graphics g) {
		if(sublogo_interver <= 50)
		{
			g.drawImage(MyImages.img_subLogo,180,550,null);
		}
		sublogo_interver--;
		if(sublogo_interver<0) 
			sublogo_interver = SUBLOGO_INTERVER;
		}
	}