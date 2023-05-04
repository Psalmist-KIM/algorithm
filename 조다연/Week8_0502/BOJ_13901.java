package week8_0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13901 {
	//�κ�
	static int R,C, sr, sc, idx;
	static int[][] room;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] d = new int[4];
	static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//��ֹ� ��ġ
			room[r][c] = -1; 
		}
		
		//�κ� ���� ��ġ
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());
		
		//�̵� ���� ����
		//1: ��, 2: �Ʒ�, 3: ����, 4: ������
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			d[i] = Integer.parseInt(st.nextToken())-1;
		}
		
		bfs();
		
		System.out.println(sr+" "+sc);
	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(sr,sc));
		v = new boolean[R][C];
		v[sr][sc] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			int cr = p.r;
			int cc = p.c;
			
			for(int i=0; i<4; i++) {
				int dir = d[(idx+i)%4];
				int nr = cr+dr[dir];
				int nc = cc+dc[dir];
				
				//���̰ų� ��ֹ��� �ְų� �湮�߾��ٸ� ���� �ٲ���� ��
				if(!check(nr,nc) || v[nr][nc] || room[nr][nc] == -1) {
					continue;
				}
				
				q.add(new Point(nr,nc));
				v[nr][nc] = true;
				idx = (idx+i)%4;
				
				sr = nr;
				sc = nc;
				
				break;
			}
		}
		
	}

	private static boolean check(int nr, int nc) {
		if(nr>=0 && nr<R && nc>=0 && nc<C) {
			return true;
		}
		
		return false;
	}
	
	static class Point {
		int r; 
		int c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
