package mymain;

import javax.swing.JFrame;

public class MainClass extends JFrame {
	public Firstpage firstPage = null;
	public LastPage lastPage = null;
	LastPage lastPager = new LastPage(null);

	// fistPage에서 마우스 클릭 시 if문 호출 
	public void change(String panelName) {
		if (panelName.equals("lastPage")) {
			getContentPane().removeAll();
			getContentPane().add(lastPager);
			lastPager.requestFocus(); // 키 이벤트 받을 컴포넌트 설정
			lastPager.timer();
			revalidate();
			repaint();
		}
	}

	public static void main(String[] args) {
		MainClass win = new MainClass();
		win.setTitle("눈피하기");
		win.firstPage = new Firstpage(win);
		win.lastPage = new LastPage(win);

		win.add(win.firstPage); // 첫 화면은 firstPage 생성
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(500, 500);
		win.setResizable(false);
		win.setLocation(300, 100);
		win.setVisible(true);
		win.pack();
	}
}