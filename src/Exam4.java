import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Event4 extends Frame {

	Button button = new Button("ok");
	Button button2 = new Button("CANCEL");

	public Event4() {
		setSize(300, 200);
		setTitle("event");
		setLocation(950, 350);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		setLayout(null);
		add(button);
		add(button2);
		// 버튼 설정
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);

		button2.setBackground(Color.GREEN);
		button2.setBounds(200, 100, 80, 30);
	}

	private void start() {
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		WindowListener w1 = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};

		button.addActionListener(al);
		this.addWindowListener(w1);

	}
}

public class Exam4 {
	public static void main(String[] args) {
		new Event4();
	}
}
