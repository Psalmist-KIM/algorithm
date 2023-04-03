package week4_0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987 {
	//16987. ������� ���ġ��

	static int N,ans=0;
	static Egg[] eggs;
	
	static class Egg {
		int d; // ������ 
		int w;// ����
		boolean s; //���� ����
		
		public Egg(int d, int w, boolean s) {
			super();
			this.d = d;
			this.w = w;
			this.s = s;
		}		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//����� �� N
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];
		 
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
	
			eggs[i] = new Egg(d,w,true); 
		}
		
		breakEgg(0,0);
		
		System.out.println(ans);
	}
	
	private static void breakEgg(int now, int cnt) {
		//������ ������� ������ ����
		if(now == N) {
			ans = Math.max(ans, cnt);
			return;
		}

		//�տ� �� ����� ���� �ְų� ������ ����� ���� �ִٸ� ���� �������
		if(!eggs[now].s || cnt == N-1) {
			breakEgg(now+1, cnt);
			return;
		}

		//��� �ε�����
		int tmp = cnt;
		for(int i=0; i<N; i++) {
			//�տ� ��� �ִ� ����� ������ �Ѿ
			if(now == i) continue;
			
			//���� ����̸� �Ѿ
			if(!eggs[i].s) continue;
			
			//��� ����(������ - ����)
			eggs[now].d -= eggs[i].w;
			eggs[i].d -= eggs[now].w;
			
			//���� �� ���� �ٲٰ� cnt++
			if(eggs[now].d<=0) {
				eggs[now].s = false;
				cnt++;
			}
			if(eggs[i].d<=0) {
				eggs[i].s = false;
				cnt++;
			}
			
			//���� �������
			breakEgg(now+1, cnt);
			
			//���󺹱�
			eggs[now].d += eggs[i].w;
			eggs[now].s = true;
			eggs[i].d += eggs[now].w;
			eggs[i].s = true;
			cnt = tmp;
		}	
	}
}
