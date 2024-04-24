import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Event2 extends Frame implements ActionListener{
	Button button = new Button("확인");
	public Event2() {
		// Frame 기본 설정
		setSize(300,200);
		setTitle("Event");
		setLocation(750, 350);
		init();
		start();
		setVisible(true);
	}
	
	private void init() {
		setLayout(null);
		add(button);
		
		button.setBackground(Color.yellow);
		button.setBounds(100, 100, 80, 30);
	}

	private void start() {
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
}

public class Exam2 {
	public static void main(String[] args) {
		new Event2();
	}
}
