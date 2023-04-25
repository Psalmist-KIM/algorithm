package week7_0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14218 {
	//�׷��� Ž�� 2
	//���ͽ�Ʈ�� : �� ��忡�� ��� ���� ���� �ִܰŸ� 
	//�ִܰŸ� ����迭 + �켱���� ť�� ����
	static int N, M, Q;
	static int[] distance;
	static int INF = Integer.MAX_VALUE;
	static int[][] city;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//������ ���� N, ������ ���� M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//�������
		city = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			//���� �ΰ� -> ���� (���� ����)
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//����ġ 1
			city[a][b] = 1;
			city[b][a] = 1;
		}
		
		//���� ���� ��ȹ�� �� �ִ� ������ �� Q
		Q = Integer.parseInt(br.readLine());
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			//���� �ΰ� -> ����� ���� (���� ����)
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//����ġ 1
			city[a][b] = 1;
			city[b][a] = 1;
			
			//�ִ� �Ÿ� ���� �迭
			distance = new int[N+1];
			Arrays.fill(distance, INF);
			
			//�������� ����, ������ 1��
			//���� ����� ������ �ּ� �� ���� ���� �湮�ϴ��� ���
			//����ġ�� 1�� �ִ� ��� ���ͽ�Ʈ��
			bfs(1);
			
			answer();
		}
	}

	private static void bfs(int idx) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(idx,0));
		v = new boolean[N+1];
		distance[idx] = 0; //������� 0
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			//����� �ּҰ��̸� ����
			if(distance[p.idx] > p.cost) {
				distance[p.idx] = p.cost;
			}
			v[p.idx] = true;

			//city[idx]�� ����� ���� Ȯ��
			for(int i=1; i<city[p.idx].length; i++) {
				//���ΰ� �̾��� �ְ� �湮���� �ʾ�����
				if(city[p.idx][i] == 1 && !v[i]) {
					q.add(new Point(i,p.cost+1));
					v[i]= true;
				}
			}
		}
	}

	private static void answer() {
		for(int j=1; j<=N; j++) {
			if(distance[j] == INF) {
				System.out.print("-1 ");
			} else {
				System.out.print(distance[j]+" ");
			}
		}
		System.out.println();
	}

	static class Point {
		int idx; 
		int cost;
		
		public Point(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
	}
}
