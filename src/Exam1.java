import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// 이벤트 처리 클래스 만들기 : 따로 분리시켜서 만들었음
// ActionListener : 마우스 클릭 또는 enter key
class ActionDefine implements ActionListener{		// 마우스 클릭이나 키보드 엔터를 누르면 이벤트가 일어나게 만드는 이벤트 핸들러 상속

	@Override
	public void actionPerformed(ActionEvent e) {	// 이 함수 호출하면 시스템 종료
		System.exit(0);
	}
	
}

class Event1 extends Frame {						// 이벤트라는 클래스를 만들고 frame 상속
	Button button = new Button("확인");				// 버튼을 만들고 버튼에 확인 글씨 적음
	ActionDefine ad = new ActionDefine();			// 위에 만든 클래스 new 만들어서 부를 준비
	
	public Event1() {								// 이벤트 메소드 만들어서 안에서 frame 기본 설정을 넣는다
		// Frame 기본 설정
		setSize(300, 200);							// 사이즈
		setTitle("Event");							// 제목(창 위에 적힘)
		setLocation(750, 350);						// 창위 처음에 뜨는 위치
		
		init();										// 함수 호출
		start();									// 함수 호출
		
		setVisible(true);							// 만든거 보여줘
	}

	private void init() {							// 이벤트에 대한 설정
		// layout 설정
		setLayout(null);							// 레이아웃
		add(button);								// 버튼을 추가
		// button 설정
		button.setBackground(Color.YELLOW);			// 버튼 어떻게 만들지 설정(색, 위치)
		button.setBounds(100, 100, 80, 30);
	}

	private void start() {							// 이벤트 실행 설정
		// 버튼에 이벤트 클래스를 등록
		button.addActionListener(ad);				// 이벤트를 언제 실행? .이벤트핸들러 앞에 버튼 즉 버튼 누르면 실행 = 시스템 종료
		
	}
}

public class Exam1 {
	public static void main(String[] args) {
		new Event1();								// 호출하면 주르륵 실행함
	}
}
