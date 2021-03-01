package mymain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 위에서 내리는 눈을 생성해주는 클래스

public class SnowMaker {
	
	// 눈의 생성 주기
	public static final int SNOW_MAKE_INTERVER=15;
	
	// 눈을 동적으로 x좌표에 랜덤 생성
	public List<Snow> snow_list = new ArrayList<Snow>();
	Random rand = new Random();
	int snow_make_interver = SNOW_MAKE_INTERVER;

	// 눈 생성 후 눈의 설정
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
	
	// 눈이 떨어지고 나면 제거
	public void move() {
		for (int i = 0; i < snow_list.size(); i++) {
			Snow snow = snow_list.get(i);
			if(snow.move()==false)
			{
				snow_list.remove(i);
			}
		}
	}
	
	// 눈 생성
	public void draw(Graphics g) {
		for (int i = 0; i < snow_list.size(); i++) {
			Snow snow = snow_list.get(i);
			snow.draw(g);
		}	
	}	
}