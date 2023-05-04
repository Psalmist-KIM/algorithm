package week8_0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3649 {
	//�κ� ������Ʈ
	static int x, n;
	static int[] legos;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while((s=br.readLine()) != null) { 
			//���� �ʺ�
			x = Integer.parseInt(s)* 10000000;
			
			//���� ���� ��
			n = Integer.parseInt(br.readLine());
			legos = new int[n];
			for(int i=0; i<n; i++) {
				legos[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(legos);
			
			int left = 0;
			int right = n-1;
			boolean flag = false;
			
			while(left<right) {
				int sum = legos[left] + legos[right];
				
				if(sum == x) { //���۰� ��ġ�ϸ� ���Ŀ� �� �ִ��� ���簪�� ���밪 ���̰� ���� ū ��
					flag = true;
					break;
				}else if(sum > x) { //���ۺ��� ũ�� ū���� �ٿ���
					right--;
				} else { //���ۺ��� ������ �������� �÷���
					left++;
				}
			}
			
			if(flag) {
				System.out.println("yes " + legos[left]+" "+ legos[right]);
			} else {
				System.out.println("danger");
			}

		}
	}

}
