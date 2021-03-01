package mymain;

import java.awt.Graphics;
import java.awt.Rectangle;

// 눈 생성 추상클래스

public abstract class Item {
	public Rectangle pos = new Rectangle();
	public abstract boolean move();
	public abstract void draw(Graphics g);
}