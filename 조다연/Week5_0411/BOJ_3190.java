package week5_0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3190 {
	//3190. ��
	static int board[][];
	static int N, K, L;
	static int dir[][];
	//				      ��    ��      ��      ��
	static int dr[] = {0, 1,  0, -1};
	static int dc[] = {1, 0, -1,  0};
	static int index = 0; //������ �������� ����
	static List<int[]> snake;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//���� ũ��
		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		
		//��� ����
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			//��� ��ġ (��,��)
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			board[r][c] = 2;
		}
		
		//���� ���� ��ȯ Ƚ�� 
		L = Integer.parseInt(br.readLine());
		dir = new int[L][2];
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			//X�� �� C�������� ȸ�� (L:���� / D:���������� 90�� ȸ��)
			int X = Integer.parseInt(st.nextToken());
			dir[i][0] = X;
			
			char C = st.nextToken().charAt(0);
			//L : -1 , D : 1
			dir[i][1] = (C=='L') ? -1 : 1;	
		}
		
		
		//{1,1}���� ����
		snake = new LinkedList<>();
        snake.add(new int[]{1, 1});
        int cr=1; int cc=1;
        
		int time = 0;
		int turn = 0;
		
		//���� �� �Ǵ� �ڱ��ڽ��� ���� �ε����� ���� ����
		while(true) {
			time++;
			
			int nr = cr + dr[index];
			int nc = cc + dc[index];
			
			//���� �Ǵ���
			if(check(nr,nc)) break;
			
			//��� �ִ���
			if(board[nr][nc] == 2) {
				//����� ������ ������ �״�� �Ӹ��� �÷�
				board[nr][nc] = 0;
				snake.add(new int[] {nr,nc});
			} else { //����� ���ٸ� �Ӹ� �ø��� ������ �ٿ�
				snake.add(new int[] {nr,nc});
				snake.remove(0);
			}
			
			//���� �Ǵ��� ��� �ִ��� �� ������ ��� �̵�
			cr = nr;
			cc = nc;
			
			//���� �ٲ�� �Ǵ���
			if(turn<L) {
				if(time == dir[turn][0]) {
					if(dir[turn][1] == -1) { //����
						index--;
						if(index == -1) index=3;
					}
					if(dir[turn][1] == 1) { //������
						index++;
						if(index == 4) index=0;
					}
					
					//���� �ٲ�� Ƚ��++
					turn++;
				}
			}
		}
		
		System.out.println(time);
	}


	private static boolean check(int nr, int nc) {
		//��
		if(nr<1 || nc<1 || nr>=N+1 || nc>=N+1)
			return true;
		
		//�ڱ��ڽ�
		for(int i=0; i<snake.size(); i++) {
			if(nr == snake.get(i)[0] && nc == snake.get(i)[1])
				return true;
		}
		
		return false;
	}

}
