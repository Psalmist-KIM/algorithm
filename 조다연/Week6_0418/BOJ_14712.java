package week6_0418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14712 {
	//�۸�۸�(Easy)
	static int N,M;
	static boolean map[][];
	static int answer;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		
		dfs(0,0);
		
		System.out.println(answer);
	}

	private static void dfs(int r, int c) {
		if(r==N) {
			//��ġ�� �۸� 2x2 �Ǵ��� Ȯ��
			for(int i=0; i<=N-2; i++) {
				for(int j=0; j<=M-2; j++) {
					if(map[i][j] && map[i+1][j] 
							&& map[i][j+1] && map[i+1][j+1]) 
						return;
				}
			}
			
			//�۸� 2x2 �ȵǸ� ++
			answer++;
			return;
		}

		//��ǥ �̵�
		int nc = (c+1 == M) ? 0 : c+1;
		int nr = (nc == 0) ? r+1 : r;
		
		//�ش� ĭ�� �۸� �־�
		map[r][c] = true;
		dfs(nr,nc);
		
		
		//�۸� ����
		map[r][c] = false;
		dfs(nr,nc);
	}

}
