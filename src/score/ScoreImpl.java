package score;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score {
	Scanner sc = new Scanner(System.in);
	// 전체 학생 데이터를 저장할 리스트
	List<ScoreVo> list = new ArrayList<ScoreVo>();
	ObjectInOut objectInOut = new ObjectInOut();
	String path = "Score.txt";
	String str;

	// 입력
	@Override
	public String input(ScoreVo vo) {
		System.out.println(vo);
		
		// 리스트에 학생 1명 데이터 저장
		list.add(vo);
		
		return "저장성공";
	}

	// 출력
	@Override
	public void print(ScoreVo vo) {
		printTitle();
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			System.out.println(vo.toString());
		}
	}

	// 제목 출력
	@Override
	public void printTitle() {
		String str = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s\t", "학번", "이름", "국어", "영어", "수학", "총점", "평균");
		System.out.println(str);
	}

	// 검색 : 학번
	@Override
	public void searchHak() {
		System.out.println("검색할 학번 : ");
		String hak = sc.next();

		printTitle();
		for (int i = 0; i < list.size(); i++) {
			ScoreVo vo = list.get(i);
			if (vo.getHak().equals(hak)) {
				System.out.println(vo.toString());
			}
		}

	}

	// 검색 : 이름
	@Override
	public void searchName() {
		System.out.println("검색할 이름 : ");
		String name = sc.next();

		printTitle();
		for (int i = 0; i < list.size(); i++) {
			ScoreVo vo = list.get(i);
			if (vo.getName().equals(name)) {
				System.out.println(vo.toString());
			}
		}
	}

	// 정렬 : 총점, 내림차순
	@Override
	public void descSortTot() {
		// 정렬 기준 설정
		Comparator<ScoreVo> comparator = new Comparator<ScoreVo>() {

			@Override
			public int compare(ScoreVo vo1, ScoreVo vo2) {
				return vo1.getTot() < vo2.getTot() ? 1 : -1;
			}
		};
		// 정렬
		list.sort(comparator);
		// Collections.sort(list, comparator);
		// 출력
//		print();

	}

	// 정렬 : 학번, 오름차순
	@Override
	public void ascSortHak() {
		// 정렬 기준 설정
		Comparator<ScoreVo> comparator = new Comparator<ScoreVo>() {

			@Override
			public int compare(ScoreVo vo1, ScoreVo vo2) {
				return vo1.getHak().compareTo(vo2.getHak());
			}
		};
		// 정렬
		list.sort(comparator);
		// Collections.sort(list, comparator);
		// 출력
//		print();
	}

	@Override
	public void write() {
		boolean result = objectInOut.write(path, list);
		if (result) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
			
		}
		System.out.println(list.size() + "개 저장됨");
	}

	@Override
	public void read() {
		List<ScoreVo> list_result = objectInOut.read(path);
		for (int i = 0; i < list_result.size(); i++) {
			System.out.println(list_result.get(i).toString());
		}
		System.out.println(list.size() + "개 출력됨");
	}

}
