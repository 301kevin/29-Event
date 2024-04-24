package score;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut {
	// 객체 출력
	public boolean write(String path, List<ScoreVo> list) {
		boolean result = false;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			// 리스트의 전체 데이터 개수를 파일로 저장
			oos.writeInt(list.size());
			// 리스트에 저장된 객체를 파일로 저장
			for (int i = 0; i < list.size(); i++) {
				ScoreVo vo = list.get(i);
				oos.writeObject(vo);
			}
			// 예외 발생 없이 여기까지 코드가 동작되었다는것은 성공했다는 의미
			result = true;
			
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없습니다. >> " + path);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >> " + path);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + path);
		} finally {
			try {
				if (oos != null)
					oos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 객체 입력
	public List<ScoreVo> read(String path) {
		List<ScoreVo> list = new ArrayList<ScoreVo>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(path);
			ois = new ObjectInputStream(fis);
			int num = ois.readInt();
			for (int i = 0; i < num; i++) {
				ScoreVo vo = (ScoreVo) ois.readObject();
				list.add(vo);
			}
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없습니다. >> " + path);
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 읽기 실패 >> " + path);
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + path);
			// e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}
