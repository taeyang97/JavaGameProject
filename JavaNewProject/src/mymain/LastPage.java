package mymain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LastPage extends JPanel {
	private Image imgBack;
	private int width, height;
	private JPanel gamePan;
	private SnowMaker snowManager = new SnowMaker();
	private MainClass win;
	int score;

	final static double acc = 0.5; // acceleration of body
	final static double SpdLimit = 3.0; // Speed limit of the body

	Body body = new Body();

	boolean pressedL = false;
	boolean pressedR = false;

	public LastPage(MainClass win) {
		addKeyListener(new Keyboard());
		this.win = win;
		imgBack = MyImages.img_background2;
		gameImage();
	}

	// 타이머 이용하여 그림이 동적으로 보이게 계속 그려준다.
	void timer() {
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snowMake();
				run();
				checkCollision();
				checkCollision2();
				gamePan.repaint();
			}
		};
		Timer timer = new Timer(10, listener);
		timer.start();
	}

	// 눈을 생성
	protected void snowMake() {
		snowManager.make_snow();
		snowManager.move();
	}

	// lastPage 그림들을 생성
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
				if (pressedR == true) {
					g.drawImage(MyImages.img_right, (int) body.x, (int) body.y - 20, this);
				} else if (pressedL == true) {
					g.drawImage(MyImages.img_left, (int) body.x, (int) body.y - 20, this);
				} else {
					g.drawImage(MyImages.img_zol, (int) body.x, (int) body.y - 20, this);
				}

				g.drawString("Body x=" + (int) body.x + " \t\t y=" + (int) body.y, 10, 10);
				g.drawString("Speed=" + body.change, 10, 25);

				g.setFont(new Font(null, Font.TRUETYPE_FONT, 30));
				g.setColor(Color.blue);
				g.drawString("Score : " + score, 200, 50);
				snowManager.draw(g);
			}
		};
		gamePan.setPreferredSize(new Dimension(MyConst.GamePan.GAMEPAN_W, MyConst.GamePan.GAMEPAN_H));
		this.add(gamePan);
	}

	// 눈이 바닥으로 떨어짐 score+1점
	void checkCollision() {
		for (Snow t : snowManager.snow_list) {
			if (MyConst.GamePan.GAMEPAN_H <= t.pos.y) {
				score += 1;
			}
		}
	}

	// 캐릭터와 눈의 충돌
	void checkCollision2() {
		for (Snow t : snowManager.snow_list) {
			if (t.pos.x > body.x - 10 && t.pos.x < body.x + 15 && 635 < t.pos.y && 685 > t.pos.y) {
				JOptionPane.showMessageDialog(null, "점수는 " + score + "점", "눈에맞음", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0); // 시스템 종료
			}
		}
	}

	// 캐릭터 이동
	public void run() {

		if (pressedR == false) {
			if (body.change > 0) {
				body.change -= acc;
			}
		}

		if (pressedL == false) {
			if (body.change < 0) {
				body.change += acc;
			}
		}

		// 가속력 구현하기 위해 캐릭터가 달리다 멈추면 기본 속도로 점점 돌아간다.
		if (body.x < SpdLimit && body.change < 0)
			body.change = 0;
		else if (body.x > (MyConst.GamePan.GAMEPAN_W - SpdLimit * 2) && body.change > 0)
			body.change = 0;

		body.x += body.change;

	}

	// 키보드 누를 시 캐릭터 이동
	class Keyboard extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (body.change < SpdLimit)
					body.change += acc;
				pressedR = true;
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (body.change > -SpdLimit)
					body.change -= acc;
				pressedL = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				pressedR = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				pressedL = false;
			}

		}
	}
}
