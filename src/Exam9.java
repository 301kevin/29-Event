import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Sub9 extends Frame implements ActionListener {
	Label label1 = new Label("결과 출력");
	Label label2 = new Label("입력 : ", Label.RIGHT);
	TextArea textArea = new TextArea();
	TextField textField = new TextField();
	Panel panel = new Panel();

	public Sub9() {
		setSize(300, 200);
		setTitle("Test");
		setLocation(950, 350);
		init();
		start();
		setVisible(true);

	}

	private void init() {
		// frame 설정
		setLayout(new BorderLayout());
		add("North", label1);
		add("Center", textArea);
		add("South", panel);

		// TextArea 쓰기 금지
		textArea.setEditable(false);

		// panel 설정
		panel.setLayout(new BorderLayout());
		panel.add("West", label2);
		panel.add("Center", textField);
	}

	private void start() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// textfield 이벤트 설정
		textField.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = textField.getText();
		if(!textArea.getText().equals("")) {
			str = textArea.getText() + "\n" + str;
		}
		textArea.setText(str);
		// textArea 마지막줄 표시
		textArea.setCaretPosition(str.length());
		textField.setText(""); // 초기화
	}

}

public class Exam9 {
	public static void main(String[] args) {
		new Sub9();
	}
}
