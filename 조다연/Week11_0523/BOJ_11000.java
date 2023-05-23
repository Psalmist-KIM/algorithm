package week11_0523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000 {
	//���ǽ� ����
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st;
		
		N = Integer.parseInt(br.readLine());
		
		Lecture[] lectures = new Lecture[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			lectures[i] = new Lecture(S, T);
		}
		
		//�ð� �������� ���� (���� �ð��� ������ ������ �ð�����)
		Arrays.sort(lectures);

		//
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(lectures[0].end);
		
		for(int i=1; i<N; i++) {
			//�켱���� ť ���� ���� ���� �ð��� lectures[i]�� ���� �ð� ��
			if(pq.peek() <= lectures[i].start) {
				pq.poll();
			}
			
			pq.add(lectures[i].end);
		}
		
		System.out.println(pq.size());
	}
	
	static class Lecture implements Comparable<Lecture> {
		
		int start;
		int end;
			
		public Lecture(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			
			if(start == o.start) {
				return end - o.end;
			}
			
			return start - o.start;
		}
		
	}

}
