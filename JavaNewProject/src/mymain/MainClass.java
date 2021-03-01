package mymain;

import javax.swing.JFrame;

public class MainClass extends JFrame {
	public Firstpage firstPage = null;
	public LastPage lastPage = null;
	LastPage lastPager = new LastPage(null);

	// fistPage���� ���콺 Ŭ�� �� if�� ȣ�� 
	public void change(String panelName) {
		if (panelName.equals("lastPage")) {
			getContentPane().removeAll();
			getContentPane().add(lastPager);
			lastPager.requestFocus(); // Ű �̺�Ʈ ���� ������Ʈ ����
			lastPager.timer();
			revalidate();
			repaint();
		}
	}

	public static void main(String[] args) {
		MainClass win = new MainClass();
		win.setTitle("�����ϱ�");
		win.firstPage = new Firstpage(win);
		win.lastPage = new LastPage(win);

		win.add(win.firstPage); // ù ȭ���� firstPage ����
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(500, 500);
		win.setResizable(false);
		win.setLocation(300, 100);
		win.setVisible(true);
		win.pack();
	}
}