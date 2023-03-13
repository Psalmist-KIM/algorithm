package day1_0313;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24060 {
	static int arr[];
	static int tmp[];
	static int K;
	static int cnt = 0;
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//�迭 A�� ũ��
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		tmp = new int[N];
		
		//���� Ƚ��
		K = Integer.parseInt(st.nextToken());
		
		//�迭 A�� ����
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0,arr.length-1);
		System.out.println(result);
	}

	private static void mergeSort(int start, int end) {
		if(cnt>K) return;
		
		if(start<end) {
			int mid = (start+end)/2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			merge(start, mid, end);
		}
	}

	private static void merge(int start, int mid, int end) {
		int p = start;
		int q = mid+1;
		int idx = 0;
		
		while(p <= mid && q <= end) {
			if(arr[p] <= arr[q]) {
				tmp[idx++] = arr[p++];
			} else {
				tmp[idx++] = arr[q++];
			}
		}
		
		//���� �迭�� ���� ���
		while(p<=mid) {
			tmp[idx++] = arr[p++];
		}
		
		//������ �迭�� ���� ���
		while(q<=end) {
			tmp[idx++] = arr[q++];
		}
		
		//��� ����
		p = start;
		idx = 0;
		while(p<=end) {
			//���� ����� �� cnt++
			cnt++;
			
			//cnt ���� K�� �������� ����� ���� result��
			if(cnt == K) {
				result = tmp[idx];
				break;
			}
			
			//��� ���� �迭�� ����
			arr[p++] = tmp[idx++];
		}
	}

}
