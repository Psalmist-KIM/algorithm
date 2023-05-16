package week10_0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138 {
	//������ ����ġ
	static int N;
	static int answer = 987654321;
	static boolean[] arr1, arr2, after;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //���� ��
		
		arr1 = new boolean[N];
		arr2 = new boolean[N];
		after = new boolean[N];
		
		//���� ���� ����
		String current = br.readLine();		
		//������� �ϴ� ���� ����
		String wish = br.readLine();
		
		for(int i=0; i<N; i++) {
			arr1[i] = current.charAt(i) != '0';
			arr2[i] = current.charAt(i) != '0';
			after[i] = wish.charAt(i) != '0';
		}

		//ù ��° ���� �̿� x
		bulb(1, 0, arr1);
		//ù ��° ���� �̿� o -> ù ��° ���� ���� �ٲ��ֱ�
		bulb(1, 1, swicth(0, arr2));
		
		System.out.println(answer == 987654321 ? -1 : answer);
	}

	private static void bulb(int idx, int cnt, boolean[] arr) {
		//���������� ������
		if(idx == N) {
			//���� �Ȱ����� �ϼ�
			if(arr[idx-1] == after[idx-1]) {
				answer = Math.min(answer, cnt);
			}
			return;
		}
		
		if(arr[idx-1] != after[idx-1]) {
			//�� ����ġ�� ���°� �ٸ��� �� ����ġ ���� �ٲ��༭ �����ֱ�
			bulb(idx+1, cnt+1, swicth(idx, arr));
		} else {
			//���� ������ �������� �Ѿ
			bulb(idx+1, cnt, arr);
		}
		
	}

	// ���� ���� 0,1 �ٲ��ֱ�
	private static boolean[] swicth(int idx, boolean[] arr) {
		//i-1, i, i+1
		for(int i=idx-1; i<=idx+1; i++) {
			if(i>=0 && i<N) {
				arr[i] = !arr[i];
			}
		}
		return arr;
	}

}
