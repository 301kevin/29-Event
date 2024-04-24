import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorForm extends Frame implements ActionListener {
	// 컴포넌트
	TextField textField = new TextField("0");

	Panel panelNum = new Panel();

	Button[] buttons = new Button[16];

	Button buttonResult = new Button("=");
	// 버튼 16개에 들어갈 문자열 설정
	String[] strs_num = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "+/-", ".", "+" };

	// 계산 관련 변수들
	// 숫자 1세트 저장
	String input = "";
	// 음수, 양수, 판단용
	boolean positive = true;
	// 숫자 2개와 결과값 저장
	double num1, num2, result;
	// 연산식 저장
	String op;
	// 소숫점 버튼 클릭횟수 저장
	int point_cnt = 0;

	// frame 기본설정
	public CalculatorForm() {
		setSize(250, 200);
		setTitle("계산기");
		setLocation(950, 350);
		init();
		start();
		// 화면 크기 고정
		setResizable(false);
		setVisible(true);
	}

	private void init() {
		// frame 설정
		setLayout(new BorderLayout());
		add("North", textField);
		add("Center", panelNum);
		add("South", buttonResult);

		// textField 설정
		// 입력 금지
		textField.setEditable(false);
		// = 의 글자 색
		buttonResult.setForeground(Color.BLUE);

		// panelNum 설정
		// 레이아웃
		panelNum.setLayout(new GridLayout(4, 4, 4, 4));
		// 배경색
		panelNum.setBackground(Color.LIGHT_GRAY);
		// 버튼 추가하기 버튼을 배열로 설정하고 안에 들어갈것도 설정 해놔서 포문 한방에 다 들어가짐
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(strs_num[i]);
			panelNum.add(buttons[i]);
			buttons[i].setForeground(Color.BLUE);
		}

	}

	private void start() {

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// button 이벤트 설정
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);	// this == ActionEvent e
		}
		buttonResult.addActionListener(this);	// this == ActionEvent e
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// e = start 에서 this 로 호출함, getSource는 this 가 == () 일떄 란 뜻임

		if (e.getSource() == buttons[0]) { 			// "7"
			input += "7";
			
		} else if (e.getSource() == buttons[1]) { 	// "8"
			input += "8";
			
		} else if (e.getSource() == buttons[2]) { 	// "9"
			input += "9";
			
		} else if (e.getSource() == buttons[3]) { 	// /
			if (input.equals(""))
				return; // 강제종료
			num1 = Double.parseDouble(input);
			op = "/"; // 스위치 문에서 case 로 구분하기 위해 각각에 맞는 기호를 문자열로 박음
			input = ""; // 초기화
			positive = true; // positive 초기화
			point_cnt = 0; 	 // 포인트 카운트 초기화
			
		} else if (e.getSource() == buttons[4]) { 	// 4
			input += "4";
			
		} else if (e.getSource() == buttons[5]) { 	// 5
			input += "5";
			
		} else if (e.getSource() == buttons[6]) { 	// 6
			input += "6";
			
		} else if (e.getSource() == buttons[7]) { 	// *
			if (input.equals(""))
				return; // 강제종료
			num1 = Double.parseDouble(input);
			op = "*"; // 스위치 문에서 case 로 구분하기 위해 각각에 맞는 기호를 문자열로 박음
			input = ""; // 초기화
			positive = true; // positive 초기화
			point_cnt = 0; 	 // 포인트 카운트 초기화
			
		} else if (e.getSource() == buttons[8]) { 	// 1
			input += "1";
			
		} else if (e.getSource() == buttons[9]) { 	// 2
			input += "2";
			
		} else if (e.getSource() == buttons[10]) { 	// 3
			input += "3";
			
		} else if (e.getSource() == buttons[11]) { 	// -
			if (input.equals(""))	
				return; // 강제종료
			num1 = Double.parseDouble(input);
			op = "-"; // 스위치 문에서 case 로 구분하기 위해 각각에 맞는 기호를 문자열로 박음
			input = ""; // 초기화
			positive = true; // positive 초기화
			point_cnt = 0; 	 // 포인트 카운트 초기화
			
		} else if (e.getSource() == buttons[12]) { 	// 0
			input += "0";
			
		} else if (e.getSource() == buttons[13]) { 	// +/-
			if (positive) {
				// 양수를 음수로 변경
				input = "-" + input;
				positive = false;
			} else {
				// 음수를 양수로 변경
				input = input.substring(1);
				positive = true;
			}
			
		} else if (e.getSource() == buttons[14]) { 	// .
			if (point_cnt == 0) {
				input += ".";
				point_cnt++;
			}
			
		} else if (e.getSource() == buttons[15]) { 	// +
			if (input.equals(""))
				return; // 강제종료
			num1 = Double.parseDouble(input);
			op = "+"; // 스위치 문에서 case 로 구분하기 위해 각각에 맞는 기호를 문자열로 박음
			input = ""; // 초기화
			positive = true; // positive 초기화
			point_cnt = 0; 	 // 포인트 카운트 초기화
			
		} else if (e.getSource() == buttonResult) { 	// =
			if (input.equals(""))
				return; // 강제종료
			num2 = Double.parseDouble(input);
			switch (op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				if (num2 != 0) {
					result = num1 / num2;
				} else {
					result = 0;
				}
				break;
			}

			textField.setText(String.valueOf(result)); // setText는 문자열만 들어가짐 result 는 double 이기에 string.valueof로 문자열로 바꿈

			// 초기화
			input = ""; // 초기화
			positive = true; // positive 초기화
			num1 = num2 = 0; 
			point_cnt = 0; 	 // 포인트 카운트 초기화
			return; // 함수 강제 종료
		}

		// input 에 저장된 문자열을 textField로 출력
		textField.setText(input);

	}

}
