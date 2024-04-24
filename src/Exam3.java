import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Event3 extends Frame {
	Button button = new Button("ok");

	public Event3() {
		// Frame 기본 설정
		setSize(300, 200);
		setTitle("event");
		setLocation(750, 350);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		// 레이아웃 설정
		setLayout(null);
		add(button);
		// 버튼 설정
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
	}

	private void start() {
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// Frame 장의 X 버튼 활성화 설정
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

public class Exam3 {
	public static void main(String[] args) {
		new Event3();
	}

}
