package Week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1722_순열의_순서 {
	static int CNT, K;
	static long[] FACTORIAL;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int type = Integer.parseInt(st.nextToken());
		
		FACTORIAL = new long[T+1];
		FACTORIAL[1] = 1;
		calcFactorial(T);
		
		int index = T-1;
		boolean[] check = new boolean[T+1];
		
		if(type == 1) {
			K = Integer.parseInt(st.nextToken());
			int[] resArray = new int[T];
			
			for(int i=0; i<resArray.length; i++) {
				int cntNum = 1;
				
				for(int j=1; j<=T; j++) {
					if(K > FACTORIAL[index] && !check[j]) {
						K -= FACTORIAL[index];
						cntNum++;
					}
				}				
				System.out.print(cntNum+" ");
				check[cntNum] = true;
				index--;
			}
		} 
		else if(type == 2) {
			long result = 1;
			
			for(int seq=0; seq<T; seq++) {
				int num = Integer.parseInt(st.nextToken());

				for(int i=1; i<=T; i++) {
					if(i < num && !check[i]) {
						result += FACTORIAL[index];
						
					}
				}
				check[num] = true;
				index--;
			}
			System.out.println(result);
		}
	}

	private static long calcFactorial(int n) {
		if(n <= 1) return 1;
		if(FACTORIAL[n] != 0) return FACTORIAL[n];
		return FACTORIAL[n] = n * calcFactorial(n-1);
	}

}
