package week6_0418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187 {
	//��ġ�� ��
	static int R, C;
	static char map[][];
	static boolean v[][];
	// 				    ��, ��, ��, ��
	static int dr[] = {0, 0, -1, 1};
	static int dc[] = {1, -1, 0, 0};
	static int sheep = 0;
	static int wolf = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//����, ����
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		v = new boolean[R][C];
		
		//map �Է¹ޱ�
		for(int r=0; r<R; r++) {
			String s = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		//print(map);
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				//��Ÿ�� ����
				if(map[r][c] != '#' && !v[r][c]) {
					bfs(r,c);
				}
			}
		}
		
		//��Ƴ��� �Ǵ� ��� ���� �� ���
		System.out.println(sheep+" "+wolf);
	}

	
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		v[r][c] = true;
		
		int wolfCnt = 0;
		int sheepCnt = 0;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int cr = p.r;
			int cc = p.c;
			
			if(map[cr][cc] == 'v') { //������
				wolfCnt++;
			} else if(map[cr][cc] == 'k') { //���̶��
				sheepCnt++;
			}
			
			//4��Ž��
			for(int d=0; d<4; d++) {
				int nr = cr+dr[d];
				int nc = cc+dc[d];
				
				//���� �� && ��湮 && ���Ÿ��
				if(check(nr,nc) && !v[nr][nc] && map[nr][nc] != '#') {
					q.add(new Point(nr,nc));
					v[nr][nc] = true;
				}
			}
		}
		//���� ���ڰ� ���뺸�� ũ�� �縸 ��Ƴ���
		if(sheepCnt > wolfCnt) {
			sheep += sheepCnt;
		} else { //�� �ܴ� ���밡 ��Ƴ���
			wolf += wolfCnt;
		}
	}
	
	private static boolean check(int nr, int nc) {
		if(nr>=0 && nc>=0 && nr<R && nc<C) {
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

	//�� ���Դ�?
	private static void print(char[][] map) {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
		
	}

}
