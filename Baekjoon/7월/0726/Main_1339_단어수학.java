package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main_1339_단어수학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Character, int[]> map = new HashMap<>(); // 알파벳, {위치, 등장한 개수}
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			
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
		Collections.sort(map, new Comparator<>() {
			
		});
		
		for(Character c : map.keySet()) {
			int[] temp = map.get(c);
			System.out.println(c + " : " + temp[0] + ", " + temp[1]);
		}
		
		
	}
}

/*
 * 분류 : 그리디 알고리즘, 브루트포스 알고리즘
 * 아이디어
 *  1. 자리수가 큰 위치의 알파벳부터 순서대로
 *  2. 자리수가 같은 알파벳의 경우 등장한 빈도가 클 수록
 * 
 */
