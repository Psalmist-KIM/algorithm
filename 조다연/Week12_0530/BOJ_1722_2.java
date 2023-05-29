package week12_0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1722_2 {
	//������ ����
	static int N;
	static int[] arr;
	static boolean[] v;
	static long[] f;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		v = new boolean[N+1];
		f = new long[N+1];
		f[0] = 1;
		for(int i=1; i<=N; i++) f[i] = f[i-1]*i; //���丮 ������
		
		st = new StringTokenizer(br.readLine());
		int ques = Integer.parseInt(st.nextToken());
		if(ques == 1) {
			long k = Long.parseLong(st.nextToken());
			one(k);
		} else {
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			two();
		}
		
		
	}

	private static void one(long k) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(v[j]) continue;
				
				//���丮�� ���� k���� ������ k���� ���丮�� ���� ����
				if(f[N-i] < k) {
					k-=f[N-i];
				} else { 
					//���丮�� ���� k���� ũ�� �ش��ϴ� ������ ���ڸ� ã�� ��
					//arr[i]�� �����ϰ� ������ �����ϴ� ���� üũ����
					arr[i] = j;
					v[j] = true;
					break;
				}
			}
		}
		
		for(int i=1; i<=N; i++) System.out.print(arr[i] +" ");
	}

	private static void two() {
		long ans = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<arr[i]; j++) {
				//1���� �ش��ϴ� ���ұ��� ���丮�� ���� �÷����� ������
				if(!v[j]) {
					ans+=f[N-i];
				}
			}
			
			//������ �����ϴ� ���ڴ� �ִٰ� ǥ������
			v[arr[i]] = true;
		}
		
		System.out.println(ans);
		
	}

}
