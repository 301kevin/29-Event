package score;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreForm extends Frame implements ActionListener{
	Panel panelButton = new Panel();
	Panel panelCenter = new Panel();
	Panel panelName = new Panel();
	Panel panelSNum = new Panel();
	Panel panelTot = new Panel();
	Panel panelAvg = new Panel();
	Panel panelKor = new Panel();
	Panel panelEng = new Panel();
	Panel panelMat = new Panel();
	Panel panelNum = new Panel();
	Panel panelWrite = new Panel();

	// 아래
	Button buttoninput = new Button("입력");
	Button buttonoutput = new Button("출력");
	Button buttonNumsh = new Button("학번 검색");
	Button buttonNamesh = new Button("이름검색");
	Button buttonFileWrite = new Button("파일 저장");
	Button buttonFileread = new Button("파일 읽기");

	// 왼
	Label labelSN = new Label("학번");
	Label labelName = new Label("이름");
	Label labelKor = new Label("국어");
	Label labelEng = new Label("영어");
	Label labelMat = new Label("수학");
	Label labelTot = new Label("");
	Label labelAvg = new Label("");

	// 오
	TextField textFieldSNum = new TextField(25);
	TextField textFieldName = new TextField(25);
	TextField textFieldKor = new TextField(25);
	TextField textFieldEng = new TextField(25);
	TextField textFieldMat = new TextField(25);
	TextArea textArea = new TextArea();
	
	Score score = new ScoreImpl();

	public ScoreForm() {
		setTitle("성적관리");
		setSize(700, 500);
		setLocation(950, 350);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		setLayout(new BorderLayout());
		add("South", panelButton);
		add("Center", panelCenter);
		

		panelButton.setLayout(new GridLayout(1, 6, 3, 0));
		panelButton.add(buttoninput);
		panelButton.add(buttonoutput);
		panelButton.add(buttonNumsh);
		panelButton.add(buttonNamesh);
		panelButton.add(buttonFileWrite);
		panelButton.add(buttonFileread);
		buttoninput.setBackground(Color.yellow);
		buttonoutput.setBackground(Color.yellow);
		buttonNumsh.setBackground(Color.yellow);
		buttonNamesh.setBackground(Color.yellow);
		buttonFileWrite.setBackground(Color.yellow);
		buttonFileread.setBackground(Color.yellow);
		
		panelCenter.setLayout(new GridLayout(1,2));
		panelCenter.add("West", panelNum);
		panelCenter.add("East", textArea);
		textArea.setEditable(false);

		panelNum.setLayout(new GridLayout(5, 1));
		panelNum.add(panelSNum);
		panelNum.add(panelName);
		panelNum.add(panelKor);
		panelNum.add(panelEng);
		panelNum.add(panelMat);

		panelSNum.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelSNum.add(labelSN);
		panelSNum.add(textFieldSNum);

		panelName.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelName.add(labelName);
		panelName.add(textFieldName);

		panelKor.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelKor.add(labelKor);
		panelKor.add(textFieldKor);

		panelEng.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEng.add(labelEng);
		panelEng.add(textFieldEng);

		panelMat.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelMat.add(labelMat);
		panelMat.add(textFieldMat);


	}

	private void start() {

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		buttoninput.addActionListener(this);
		buttonoutput.addActionListener(this);
		buttonNumsh.addActionListener(this);
		buttonNamesh.addActionListener(this);
		buttonFileWrite.addActionListener(this);
		buttonFileread.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttoninput) {
			ScoreVo vo = new ScoreVo();
			
			String SNum = textFieldSNum.getText();
			vo.setHak(SNum); // 학번
			
			String Name = textFieldName.getText();
			vo.setName(Name); // 이름
			
			String Kor = textFieldKor.getText();
			vo.setKor(Integer.parseInt(Kor)); // 국어
			
			String Eng = textFieldEng.getText();
			vo.setEng(Integer.parseInt(Eng)); // 영어
			
			String Mat = textFieldMat.getText();
			vo.setMat(Integer.parseInt(Mat)); // 수학
			

			int tot = vo.getKor() + vo.getEng() + vo.getMat();
			double avg = (double) tot / 3;
			vo.setTot(tot);
			vo.setAvg(avg);
			System.out.println(vo);
			
			String result = score.input(vo);
			System.out.println(result);
			textArea.setCaretPosition(result.length());
			textArea.setText(result);
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
