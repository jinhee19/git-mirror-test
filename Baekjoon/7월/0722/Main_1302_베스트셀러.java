package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main_1302_베스트셀러 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String title = br.readLine();
			if(map.get(title) == null)
				map.put(title, 1);
			map.put(title,  map.get(title)+1);
		}
		
		ArrayList<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue() == o2.getValue())
					return o1.getKey().compareTo(o2.getKey());
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		System.out.println(list.get(0).getKey());
		
	}
}

/*
 * 분류 : 자료구조, 문자열, 정렬, 해시를 사용한 집합과 맵
 * # Map 키(key), 값(value) 정렬 방법과 자동 정렬 참고 : https://ponyozzang.tistory.com/404
 */
