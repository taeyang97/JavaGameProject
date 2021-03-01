package mymain;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Firstpage extends JPanel {
	private Image imgBack;
	private int width, height;
	private JPanel gamePan;
	private SnowMaker snowManager = new SnowMaker();
	private SubLogo SubLogo2 = new SubLogo();
	private MainClass win;

	public Firstpage(MainClass win) {
		this.win = win;
		gameImage();
		timer();
		imgBack = MyImages.img_background;
		mouseClick();
	}

	// FirstPage���� ���콺�� ������ �Ǹ� LastPage�� ȭ�� ��ȯ
	private void mouseClick() {
		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				win.change("lastPage");
			}
		};
		gamePan.addMouseListener(adapter);
	}

	// Ÿ�̸� �̿��Ͽ� �׸��� �������� ���̰� ��� �׷��ش�.
	private void timer() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snowMake();
				gamePan.repaint();
			}
		};
		Timer timer = new Timer(10, listener);
		timer.start();
	}

	// ���� ����
	private void snowMake() {
		snowManager.make_snow();
		snowManager.move();
	}

	// firstPage �׸����� ����
	private void gameImage() {
		gamePan = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				if (width == 0 || height == 0) {
					width = getWidth();
					height = getHeight();
					imgBack = imgBack.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				}
				g.drawImage(imgBack, 0, 0, this);
				g.drawImage(MyImages.img_mainLogo, 120, 200, null);
				SubLogo2.draw(g);
				snowManager.draw(g);
			}
		};
		gamePan.setPreferredSize(new Dimension(MyConst.GamePan.GAMEPAN_W, MyConst.GamePan.GAMEPAN_H));
		this.add(gamePan);
	}
}
