import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Form22 extends Frame {
	Button button1 = new Button("버튼 1");
	Button button2 = new Button("버튼 1");

	public Form22() {
		// Frame 기본 설정
		setSize(300, 200);
		setTitle("event2");
		setLocation(750, 350);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		setLayout(null);
		add(button1);
		add(button2);
		
		button1.setBackground(Color.YELLOW);
		button1.setBounds(65, 90, 80, 30);
		
		button2.setBackground(Color.GREEN);
		button2.setBounds(155, 90, 80, 30);
		
	}

	private void start() {
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

	}

}

public class Practice2 {
	public static void main(String[] args) {
		new Form22();
	}
}
