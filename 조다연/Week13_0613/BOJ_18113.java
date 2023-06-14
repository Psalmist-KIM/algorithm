package week13_0613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_18113 {
	//�׸��� �谡��
	static int N,K,M,answer;
	static List<Integer> gimbap;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//��� ���� N, ���ٸ� ���� K, ������� �ּ� ���� M
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		gimbap = new ArrayList<Integer>();
		
		int right = 0;		
		for(int i=0; i<N; i++) {
			int len = Integer.parseInt(br.readLine());
			
			//���ʵ� �� �ڸ��� ����
			if(len <= K) continue;
			
			// 2K���� ��� ���� ���ٸ� �߶�
			// 2K���� ª���� ���ʸ� �߶�
			len = (len<2*K) ? len-K: len-2*K;
			
			//���� �� �ɷ�
			right = Math.max(right, len);
			
			if(len != 0) gimbap.add(len);
		}
		
		int left = 1;
		int mid = 0;
		answer = -1;
		
		if(!gimbap.isEmpty()) {
			while(left <= right) {
				mid = (left+right)/2;
				
				int cnt = 0; 
				for(int i=0; i<gimbap.size(); i++) {
					cnt += gimbap.get(i)/mid;
				}
				
				if(cnt>=M) {//�ּ� ���� �¾�
					answer = mid;
					left = mid + 1;
				} else { //�ּ� ���� �ȵ� �׷� ���� �ٿ�
					right = mid - 1;
				}
			}
		}
		
		System.out.println(answer);
	}

}
