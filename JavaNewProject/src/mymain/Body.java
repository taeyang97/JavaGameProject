package mymain;

// 캐릭터 클래스
public class Body {
	double x;
	double y;
	double change;

	// 게임 캐릭터 위치값
	public Body() {
		x = MyConst.GamePan.GAMEPAN_W / 2;
		y = MyConst.GamePan.GAMEPAN_H - 30;
		change = 0;
	}
}
