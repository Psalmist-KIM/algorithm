package week10_0516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16918 {
	//������
	static int R, C, N;
	static char[][] map;
	static char[][] tmp, arr;
	static boolean[][] v;
	//					�� �� �� ��
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); //��
		
		map = new char[R][C];
		tmp = new char[R][C];
		arr = new char[R][C];
		
		for(int r=0; r<R; r++) {
			String s = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = s.charAt(c);
				tmp[r][c] = 'O';
			}
		}
		copy(arr, tmp);

		if(N==1) {
			print(map);
		} else if(N==2) {
			print(arr);
		} else {
			int time = 1; //�ʱ���� 1�� ��
			
			while(time<N) {
				v = new boolean[R][C];
				//�̰Ž� 2�� �� ����--
				//�����¿� O�� ä���ֱ�
				for(int r=0; r<R; r++) {
					for(int c=0; c<C; c++) {
						if(map[r][c] == 'O' && !v[r][c]) {
							v[r][c] = true;
							for(int d=0; d<4; d++) {
								int nr = r+dr[d];
								int nc = c+dc[d];
								
								if(nr<R && nr>=0 && nc<C && nc>=0 && !v[nr][nc] && map[nr][nc]=='.') {
									map[nr][nc] = 'O';
									v[nr][nc] = true;
								}
							}
						}
					}
				}
				time++;
				//--
				
				if(time==N) break;
				
				//�̰Ž� 3��--
				//�� ä���� �ʿ��� ��ź ��ġ�� ���� O��ǥ�� Ȱ���� .�� ������ֱ�
				for(int r=0; r<R; r++) {
					for(int c=0; c<C; c++) {
						if(map[r][c] == 'O') {
							tmp[r][c] = '.';
						}
					}
				}

				//�װ��� �������� ������ֱ�
				copy(map, tmp);
				copy(tmp, arr);		
				time++;
				//--
			}

			//��ȭ�� �� ����ϱ�
			if(time%2==0) {
				//¦�� �ʸ��� ��ź �ʹٴ�
				print(arr);
			} else {
				print(map);
			}
		}
	}

	private static void copy(char[][] change, char[][] origin) {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				change[r][c] = origin[r][c];
			}
		}
	}

	private static void print(char[][] map) {
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}

}
