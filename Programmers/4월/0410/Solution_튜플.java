package programmers.april;

import java.util.Arrays;
import java.util.Comparator;

// 문제 해설 블로그 : https://cheonjoosung.github.io/blog/pg-tuple
public class Solution_튜플 {
	static int[] answer;
	static boolean find(int num) {
		for(int i = 0; i < answer.length; i++) {
			if(answer[i] == num)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "{{20,111},{111}}";
		// 양 옆의 {{,}} 제거
		s = s.substring(2, s.length()-2);
		s = s.replace("},{", "/");
		String[] list = s.split("/");
		answer = new int[list.length];
	
		Arrays.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((String)o1).length() - ((String)o2).length();
			}
			
		});
		
		for(int i = 0; i < list.length; i++) {
			String[] temp = list[i].split(",");
			for(int j = 0; j < temp.length; j++) {
				int c = Integer.parseInt(temp[j]);
				// answer안에 c 값이 존재하는 지 확인하고 없으면 answer에 값 넣기
				if(find(c))
					answer[i] = c;
			}
		}
		for(int i = 0; i < answer.length; i++)
			System.out.print(answer[i] + " ");
	}
}
