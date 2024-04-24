import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Form extends Frame implements ActionListener {
	Button button1 = new Button("버튼1");
	Button button2 = new Button("버튼2");

	public Form() {
		// Frame 기본 설정
		setSize(300, 200);
		setTitle("Event");
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
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}

public class Practice1 {
	public static void main(String[] args) {
		new Form();
	}
}
