package week4_0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304 {
	//2304. â�� �ٰ���
	
	static int storage[] = new int[1001];
	static int start = Integer.MAX_VALUE;
	static int end = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//����� ����
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//��� �� 1 
			//�� ����� ���� ���� ��ġ L, ���� H 
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			//L ��ġ�� ���� H
			storage[L] = H;
			
			//����, �� ����
			start = Math.min(L, start);
			end = Math.max(L, end);
		}
		
		Stack<Integer> stack = new Stack<>();
	
		//���ʺ��� ����
		int h = storage[start];
		for(int i=start+1; i<=end; i++) {
			//���� ����� �� ��պ��� �۴ٸ�
			if(storage[i]<h) {
				//���ÿ� �ش� ��� ��ġ �־��ֱ�
				stack.push(i);
			} else {
				//���� ����� �� ��պ��� ���� �ʴٸ�
				//���ÿ� ����� ��ġ�� �̿��Ͽ� �� ��� ����(h) �־��ֱ�
				while(!stack.isEmpty()) {
					int idx = stack.pop();
					storage[idx] = h;
				}
				//ū ���� �ݿ�
				h = storage[i];
			}
		}
		//���
		stack.clear();
		
		//�����ʺ��� ����
		h = storage[end];
		//���ʺ��� ����
		for(int i=end-1; i>=start; i--) {
			//���� ����� �� ��պ��� �۴ٸ�
			if(storage[i]<h) {
				//���ÿ� �ش� ��� ��ġ �־��ֱ�
				stack.push(i);
			} else {
				//���� ����� �� ��պ��� ���� �ʴٸ�
				//���ÿ� ����� ��ġ�� �̿��Ͽ� �� ��� ����(h) �־��ֱ�
				while(!stack.isEmpty()) {
					int idx = stack.pop();
					storage[idx] = h;
				}
				//ū ���� �ݿ�
				h = storage[i];
			}
		}
		//���
		stack.clear();
		
		//�迭�� ����� ���� �����ֱ�
		int ans = 0;
		for(int i=start; i<=end; i++) {
			ans += storage[i];
		}
		
		System.out.println(ans);
	}
}
