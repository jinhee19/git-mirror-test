package programmers.april;

import java.util.HashMap;
import java.util.ArrayList;

// 참고 블로그 : https://velog.io/@qweadzs/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%98%A4%ED%94%88%EC%B1%84%ED%8C%85%EB%B0%A9java
public class Solution_오픈채팅방 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		
		// 아이디 + ~ 매핑
		for(int i = 0; i < record.length; i++) {
			String[] temp = record[i].split(" ");
			
			if(temp[0].equals("Enter")) {
				list.add(temp[1] + "님이 들어왔습니다.");
				map.put(temp[1], temp[2]); // 아이디, 닉네임
			}else if(temp[0].equals("Leave")){
				list.add(temp[1] + "님이 나갔습니다.");
			}else{
				map.put(temp[1], temp[2]);
			}
		}
		String[] answer = new String[list.size()];
		
		for(int i = 0; i < list.size(); i++) {
			String temp = list.get(i);
			int idx = temp.indexOf("님");
			String id = temp.substring(0, idx);
			String msg = map.get(id) + temp.substring(idx, temp.length());
			answer[i] = msg;
		}
		
		for(int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
	}
}


/*
 * 시행착오 
 * Member(String nickname, int[] loc)
 * 라는 현재 닉네임과 메세지가 저장된 위치를 멤버로 가지는 클래스를 정의해서 
 * HashMap에 아이디, member로 저장했다.
 * enter와 leave, 그리고 아이디에 변경이 있을 때마다 메시지가 저장된 위치로 가서 닉네임으로 바꿔주는 과정을 처리했다.
 * 테스트 케이스 오류가 많이 났고 런타임 에러도 많이 떠서 방식을 바꿈
 */
