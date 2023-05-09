package week9_0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027 {
	//��������
	static int N;
	static int[] building;
	static int[] cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//���� ����
		building = new int[N];
		//�������� �� �� �ִ� ���� ��
		cnt = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N-1; i++) {
			//�� �� ������ ���� ���� ����
			cnt[i]++;
			cnt[i+1]++;
			//����
			double slope = building[i+1] - building[i];
			//������ Ž��
			for(int j=i+2; j<N; j++) {
				double next = (double) (building[j] - building[i]) / (j-i);
				if(next > slope) {
					slope = next;
					cnt[i]++;
					cnt[j]++;
				}
			}
		}
		
		int answer = Integer.MIN_VALUE;
		for(int i=0; i<cnt.length; i++) {
			answer = Math.max(answer, cnt[i]);
		}
		
		System.out.println(answer);
		
	}

}
