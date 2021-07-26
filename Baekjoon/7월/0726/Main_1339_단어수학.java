package baekjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main_1339_�ܾ���� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Character, int[]> map = new HashMap<>(); // ���ĺ�, {��ġ, ������ ����}
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
		
		// ��ġ��, ���� ������ ����
		Collections.sort(map, new Comparator<>() {
			
		});
		
		for(Character c : map.keySet()) {
			int[] temp = map.get(c);
			System.out.println(c + " : " + temp[0] + ", " + temp[1]);
		}
		
		
	}
}

/*
 * �з� : �׸��� �˰���, ���Ʈ���� �˰���
 * ���̵��
 *  1. �ڸ����� ū ��ġ�� ���ĺ����� �������
 *  2. �ڸ����� ���� ���ĺ��� ��� ������ �󵵰� Ŭ ����
 * 
 */
