package week11_0523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	//��ȣ �����
	static int L, C;
	static String[] key, alpa;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		key = new String[L];
		alpa = new String[C];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			alpa[i] = st.nextToken();
		}
		
		//�̸� ���ĺ� ����
		Arrays.sort(alpa);
		combination(0, 0);
	}

	private static void combination(int cnt, int start) {
		if(cnt == L) { //L�� ���� ������
			if(check(key)) { //���ǿ� �����ϴ��� üũ
				for(String s : key) {
					System.out.print(s);
				}
				System.out.println();
			}
			return;
		}
		
		for(int i=start; i<C; i++) {
			key[cnt] = alpa[i];
			combination(cnt+1, i+1);
		}
		
	}

	private static boolean check(String[] arr) {
		int con = 0; //���� 
		int vow = 0; //����
		
		for(int i=0; i<arr.length; i++) {
			//�����̸�
			if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i")
					|| arr[i].equals("o") || arr[i].equals("u")) {
				vow++;
			} else { //�����̸�
				con++;
			}
		}
		
		//���� 2�� �̻� ���� 1�� �̻� ���� ������ true
		if(con>=2 && vow>=1) return true;
		else return false;
	}

}
