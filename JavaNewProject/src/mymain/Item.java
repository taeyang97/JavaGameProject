package mymain;

import java.awt.Graphics;
import java.awt.Rectangle;

// �� ���� �߻�Ŭ����

public abstract class Item {
	public Rectangle pos = new Rectangle();
	public abstract boolean move();
	public abstract void draw(Graphics g);
}