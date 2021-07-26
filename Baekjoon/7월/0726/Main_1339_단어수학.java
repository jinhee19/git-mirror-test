package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main_1339_단어수학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		HashMap<Character, int[]> map = new HashMap<>(); // 알파벳, {위치, 등장한 개수}
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			words[i] = word;
			for(int j = 0; j < word.length(); j++) {
				char ch = word.charAt(j);
				if(map.get(ch) == null) {
					map.put(ch, new int[] {word.length() - j, 1});
				}
				else {
					int[] temp = map.get(ch);
					int loc = temp[0];
					if(loc < word.length() - j)
						loc = word.length() -j;
					map.put(ch, new int[] {loc, temp[1]+1});
				}
			}
		}
		
		// 위치순, 개수 순으로 정렬
		ArrayList<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Character, int[]>>() {

			@Override
			public int compare(Entry<Character, int[]> o1, Entry<Character, int[]> o2) {
				if(o1.getValue()[0] == o2.getValue()[0])
					return o2.getValue()[1] - o1.getValue()[1];
				return o2.getValue()[0] - o1.getValue()[0];
			}

		});
		
		
		int num = 9;
		for(int i = 0; i < list.size(); i++) {
			char ch = list.get(i).getKey();
			for(int j = 0; j < N; j++) {
				words[j] = words[j].replace(ch, (char)(num +'0'));
			}
			num--;
		}
		
		for(int i = 0; i < N; i++)
			answer += Integer.parseInt(words[i]);

		System.out.println(answer);
		
	}
}

/*
 * 분류 : 그리디 알고리즘, 브루트포스 알고리즘
 * 아이디어
 *  1. 자리수가 큰 위치의 알파벳부터 순서대로
 *  2. 자리수가 같은 알파벳의 경우 등장한 빈도가 클 수록
 * 
 * 배운 내용 
 *  1. HashMap를 Value 기준으로 List를 이용해서 정렬하는 방법
 *  2. HashMap 요소 확인하는 방법 -> entrySet(), keySet()
 *  3. int to char -> (char)(num + '0')
 */
