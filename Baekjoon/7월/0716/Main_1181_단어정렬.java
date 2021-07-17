package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main_1181_단어정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) // 길이가 같은 경우
					return o1.compareTo(o2); // 사전순 정렬
				else
					return o1.length() - o2.length();
			}

		});
	 
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
	}
}



/*
 *	분류 : 정렬
 *	
 *	#참고
 * 	Set은 삽입 순서나 글자 순서같은 것과 무관하게 출력
 * 	-> Set에 들어있는 데이터들을 정렬하기 위해서는 Set -> List 변환해야 함
 * 	   (List<> list = new ArrayList<>(set);
 *  => 변환 후 Collections.sort()를 사용해서 정렬
 *     1) 오름차순 : Collections.sort(list)
 *     2) 내림차순 : Collections.sort(list, Collections.reverseOrder())
 */
