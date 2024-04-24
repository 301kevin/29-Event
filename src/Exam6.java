import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Form6 extends Frame implements ActionListener {
	Button button1 = new Button("button1");
	Button button2 = new Button("button2");
	Panel panel = new Panel();

	public Form6() {
		// Frame 기본 설정
		setSize(300, 200);
		setTitle("Form");
		setLocation(900, 350);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		// 레이아웃 설정
		setLayout(new BorderLayout());
		add("South",panel);
		
		// Panel 설정
		panel.setLayout(new GridLayout(1,2));
		panel.add(button1);
		panel.add(button2);
		
		// 버튼 설정
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.GREEN);

	}

	private void start() {
		// X 버튼 이벤트
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}

public class Exam6 {
	public static void main(String[] args) {
		new Form6();
	}
}
