package week12_0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16174 {
	//������ �f�� (Large)
	
	static int N;
	static int[][] map;
	static boolean[][] v;
	//				      ��, ��
	static int[] dr = {0, 1};
	static int[] dc = {1, 0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		boolean flag = bfs(0,0);

		//�f���� �� ���� ������ �� ������ HaruHaru 
		//������ �� ������ Hing
		System.out.println(flag ? "HaruHaru" : "Hing");
	}

	private static boolean bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r,c});
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int cr = current[0];
			int cc = current[1];
			int move = map[cr][cc]; //�̵��� �� �ִ� ĭ�� ��
			
			for(int d=0; d<2; d++) {
				//�ش� ĭ��ŭ�� �̵� ���� (�̸�, �ʰ� x)
				int nr = cr+move*dr[d];
				int nc = cc+move*dc[d];
				
				if(check(nr,nc) && !v[nr][nc]) {
					//�������� �¸� ����(������ �� �Ʒ� ĭ): -1
					if(map[nr][nc] == -1) return true;
					
					q.add(new int[] {nr,nc});
					v[nr][nc] = true;
				}
			}
		}
		
		return false;
	}

	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) {
			return true;
		}
		return false;
	}

}
