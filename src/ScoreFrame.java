import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreFrame extends Frame implements ActionListener {
	// 컴포넌트
	// center 컴포넌트
	// label : 문자열 1개를 보여주는 클래스
	Label labelKor = new Label("국어");
	Label labelEng = new Label("영어");
	Label labelTot = new Label(" 총점 : ");
	Label labelAvg = new Label(" 평균 : ");
	// TextField : 문자열 1개 입력받는 클래스
	TextField textFieldKor = new TextField(25);
	TextField textFieldEng = new TextField(25);
	// panel
	Panel panelKor = new Panel();
	Panel panelEng = new Panel();
	Panel panelBind = new Panel();

	// south 컴포넌트
	Button buttoninput = new Button("입력");
	Button buttoncancel = new Button("취소");
	Panel panelButton = new Panel();

	public ScoreFrame() {
		// Frame 기본 설정
		setSize(500, 300);
		setTitle("성적계산");
		setLocation(900, 350);
		init();
		start();
		input();
		setVisible(true);
	}

	private void init() {
		// Frame 설정
		setLayout(new BorderLayout());
		add("Center", panelBind);
		add("South", panelButton);

		// 컴포넌트 위치 pButton
		panelButton.setLayout(new GridLayout(1, 2, 3, 0));
		panelButton.add(buttoninput);
		panelButton.add(buttoncancel);

		// 컴포넌트 설정 pButton
		buttoninput.setBackground(Color.YELLOW);
		buttoncancel.setBackground(Color.YELLOW);

		// 컴포넌트 위치 pBind
		panelBind.setLayout(new GridLayout(4, 1));
		panelBind.add(panelKor);
		panelBind.add(panelEng);
		panelBind.add(labelTot);
		panelBind.add(labelAvg);

		// panelKor 설정
		panelKor.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelKor.add(labelKor);
		panelKor.add(textFieldKor);
		// panelEng 설정
		panelEng.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEng.add(labelEng);
		panelEng.add(textFieldEng);

	}

	private void start() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// button
		buttoninput.addActionListener(this);
		buttoncancel.addActionListener(this);
		
		// 엔터 했을때만 input 함수 호출하기 위한 코드
		textFieldEng.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n') {
					input();
				}
			}
		});

	}

	public void input() {
		// 입력 검사
		if (textFieldKor.getText().trim().equals("")) {
			return;		// 함수 강제 종료
		}
		if (textFieldEng.getText().trim().equals("")) {
			return;		// 함수 강제 종료
		}
		int kor = Integer.parseInt(textFieldKor.getText().trim());
		int eng = Integer.parseInt(textFieldEng.getText().trim());
		int tot = kor + eng;
		double avg = (double) tot / 2;

		labelTot.setText(" 총점 : " + tot);
		labelAvg.setText(" 평균 : " + avg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼 이벤트
		if (e.getSource() == buttoninput) {
//			System.out.println("input");
			input();
		} else if (e.getSource() == buttoncancel) {
			textFieldKor.setText("");
			textFieldEng.setText("");
			labelTot.setText(" 총점 : ");
			labelAvg.setText(" 평균 : ");
		}

	}

}
