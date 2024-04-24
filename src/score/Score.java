package score;
// 목차
// => 함수의 구성을 한눈에 파악하기 위해서
public interface Score {
	public String input(ScoreVo vo);		// 입력
	public void print(ScoreVo vo);		// 출력
	public void printTitle();	// 제목 출력
	public void searchHak();	// 검색 : 학번
	public void searchName();	// 검색 : 이름
	public void descSortTot();	// 정렬 : 총점, 내림차순
	public void ascSortHak();	// 정렬 : 학번, 오름차순
	public void write();		// 파일 저장
	public void read();			// 파일 읽기
}
