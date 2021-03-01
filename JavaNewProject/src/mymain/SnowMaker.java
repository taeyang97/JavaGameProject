package mymain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// ������ ������ ���� �������ִ� Ŭ����

public class SnowMaker {
	
	// ���� ���� �ֱ�
	public static final int SNOW_MAKE_INTERVER=15;
	
	// ���� �������� x��ǥ�� ���� ����
	public List<Snow> snow_list = new ArrayList<Snow>();
	Random rand = new Random();
	int snow_make_interver = SNOW_MAKE_INTERVER;

	// �� ���� �� ���� ����
	public void make_snow() {
		if(snow_make_interver == SNOW_MAKE_INTERVER)
		{
			Snow snow = new Snow(); 
			snow.pos.y = -snow.pos.height;
			snow.pos.x = rand.nextInt(MyConst.GamePan.GAMEPAN_W) - snow.pos.width/2;//0 ~ 499
			snow.speed = rand.nextInt(3) + 2; // 3~6			
			snow_list.add(snow);
		}		
		snow_make_interver--;
		if(snow_make_interver<0) 
			snow_make_interver = SNOW_MAKE_INTERVER;		
	}
	
	// ���� �������� ���� ����
	public void move() {
		for (int i = 0; i < snow_list.size(); i++) {
			Snow snow = snow_list.get(i);
			if(snow.move()==false)
			{
				snow_list.remove(i);
			}
		}
	}
	
	// �� ����
	public void draw(Graphics g) {
		for (int i = 0; i < snow_list.size(); i++) {
			Snow snow = snow_list.get(i);
			snow.draw(g);
		}	
	}	
}