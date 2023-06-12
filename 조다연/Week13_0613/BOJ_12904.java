package week13_0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904 {
	//A�� B
	static int answer;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//S�� T��
		String S = br.readLine();
		StringBuilder T = new StringBuilder(br.readLine());
		
		answer = 0;
		change(S,T);
		
		//S�� T�� �ٲ� �� ������ 1, ������ 0
		System.out.println(answer);
	}

	private static void change(String S, StringBuilder T) {
		//���̰� �������� ����
		if(T.length() == S.length()) {
			if(T.toString().equals(S)) {
				answer = 1;
				return;
			}
			return;
		}
		
		//�� �ڰ� A��� �׳� ����
		if(T.charAt(T.length()-1) == 'A') {
			T.delete(T.length()-1, T.length());
		} else { 
			//�� �ڰ� B��� �����ϰ� �������ֱ�
			//if(T.charAt(T.length()-1) == 'B')
			T.delete(T.length()-1, T.length()).reverse();
		}
		
		change(S, T);
	}

}
