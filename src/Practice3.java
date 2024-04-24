import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Form33 extends Frame {
	Button button = new Button("Test");
	Button button1 = new Button("Test1");
	Button button2 = new Button("Test2");
	Panel panel = new Panel();
	Panel panel1 = new Panel();

	public Form33() {
		// Frame 기본 설정
		setSize(300, 200);
		setTitle("");
		setLocation(750, 350);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		
		// 기본 틀 설정
		setLayout(new BorderLayout());
		panel.setLayout(new GridLayout(1, 2, 5, 0));
		panel1.setLayout(new GridLayout(2, 1, 0, 2));

		// 위치 조정
		panel.add(button);
		panel1.add(button1);
		panel1.add(button2);
		add("South", panel);
		panel.add(panel1);

		// 버튼 설정
		button.setBackground(Color.YELLOW);
		button1.setBackground(Color.PINK);
		button2.setBackground(Color.GREEN);

	}

	private void start() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

public class Practice3 {
	public static void main(String[] args) {
		new Form33();
	}
}
