package day1_0313;

import java.util.Scanner;

public class BOJ_11279_1 {
	//���� 1���� �����ϱ� ���ؼ�
	static int heap[] = new int[100001];
	//������ ���� ��
	static int top=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//������ ����
		int N = sc.nextInt();
		
		//������ ������ŭ ���� x �ޱ�
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			
			//�־��� x�� 0�̶�� 
			//�迭���� ���� ū �� ����ϰ� �ش� �� �����ϱ�
			if(x == 0) {
				//�迭�� ��� �ִٸ� 0 ���
				if(top == 0) {
					System.out.println("0");
				}
				//��� ���� �ʴٸ� ���� ū �� ��� �� ����
				else {
					System.out.println(pop());
				}
			}
			//0�� �ƴ϶�� �� �־��ֱ�
			else {
				push(x);
			}
			
		}
	}
	
	private static void push(int x) {
		//0�� ����ΰ� 1���� �����ϱ�
		//���� ���� �ڿ� �ش� �� �־��ֱ�
		heap[++top] = x;
		int idx = top;
		//ù ��°�� ���� ���ڰ� �ƴϸ� 
		//�θ� ��� ������ ���������� ���� ��� ���ڰ� ũ�ٸ�
		//�� ���� ���ֱ�
		while(idx>1 && heap[idx/2] < heap[idx]) {
			//�ռ� �θ��� ���� ���� ���߿� ���� ū ���� �ڸ��� �ٲ��ֱ�
			swap(idx, idx/2);
			idx/=2;
		}
		
	}

	private static void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}

	private static int pop() {
		//���� ū ���� ���� �տ� �ִ� ��
		int result = heap[1];
		
		//���� �ڿ� �ִ� ���� ù ��°�� �ű� �� �� ���� �ٽ� ���ֱ�
		heap[1] = heap[top];
		//������ ���� �� ����� �� ���� �� �������ֱ�
		heap[top--]=0;
		
		for(int idx=1; idx*2<=top;) {
			//�̹� ���� ũ�ٸ� �������� �ʿ� x
			if(heap[idx]>heap[idx*2] && heap[idx]>heap[idx*2+1]) break;
			
			//���ʰ� ������ ��� �� �� ū ���� �θ� ���� �ٲٱ�
			//���� ���� �� ũ�ٸ�
			else if(heap[idx*2]>heap[idx*2+1]) {
				swap(idx, idx*2);
				idx=idx*2;
			}
			//������ ���� �� ũ�ٸ�
			else {
				swap(idx, idx*2+1);
				idx=idx*2+1;
			}
		}
		
		//�ִ밪 ��ȯ
		return result;
	}
}
