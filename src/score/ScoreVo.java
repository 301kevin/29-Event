package score;

import java.io.Serializable;

public class ScoreVo implements Serializable{
	private String hak; // 학번
	private String name; // 이름
	private int kor; // 국어
	private int eng; // 영어
	private int mat; // 수학
	private int tot; // 총점
	private double avg; // 평균
	
	
	public ScoreVo() {
		
	}
	
	public ScoreVo(String hak, String name, int kor, int eng, int mat, int tot, double avg) {
		super();
		this.hak = hak;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.avg = avg;
	}

	@Override
	public String toString() {
		String str = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t", hak, name, kor, eng, mat, tot, avg);
		return str;
	}
	
	// getter & setter
	public String getHak() {
		return hak;
	}

	public void setHak(String hak) {
		this.hak = hak;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
}
