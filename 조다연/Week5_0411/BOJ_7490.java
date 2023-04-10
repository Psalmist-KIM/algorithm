package week5_0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BOJ_7490 {
	//7490. 0 �����
	static int N;
	static List<String> answer;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			
			//���鿬���� ���, ���� ���ڿ� ���ļ� ���ο� ���� ������ �ϱ� ������
			//�ʱ� sum�� 0���� ����
			//op : 1(���ϱ�), -1(����)
			dfs(1, 1, 0, 1, "1");
			
			System.out.println(sb);
		}
		
	}

	private static void dfs(int idx, int num, int sum, int op, String express) {
		if(idx == N) {
			sum += (num*op);
			
			if(sum == 0) 
				sb.append(express + "\n");
			
			return;
		}
		
		//���鿬�� ��
		//ex) 1 2 => 1*10+(1+1) = 10+2 = 12
		//ASCII ���� : sp, +, -
		dfs(idx+1, num*10+(idx+1), sum, op, express+" "+Integer.toString(idx+1));
		dfs(idx+1, idx+1, sum+(num*op), 1, express+"+"+Integer.toString(idx+1));
		dfs(idx+1, idx+1, sum+(num*op), -1, express+"-"+Integer.toString(idx+1));
	}

}
