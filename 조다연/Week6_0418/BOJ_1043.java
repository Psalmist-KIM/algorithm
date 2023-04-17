package week6_0418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043 {
	//������
	static int N, M;
	static boolean knowPeople[];
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//�����̴� ������ �ƴ� �ڰ� ���� ���� �������� �� �� ����
		//������ �� �� �ִ� ��Ƽ ���� �ִ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//��� �� 
		N = Integer.parseInt(st.nextToken());
		//��Ƽ ��
		M = Integer.parseInt(st.nextToken());

		//���� �ƴ� ��� ���� �޾ƿ���
		//knowPeople[�׻����ȣ] = true
		st = new StringTokenizer(br.readLine());
		//������ �ƴ� ��� ��
		int knowCnt = Integer.parseInt(st.nextToken());
		//������ �ƴ� ����� ���ٸ� ��Ƽ �� ���
		if(knowCnt == 0 ) {
			System.out.println(M);
			return;
		}
		//������ �ƴ� ��� �迭
		knowPeople = new boolean[N+1];
		for(int i=0; i<knowCnt; i++) {
			int num = Integer.parseInt(st.nextToken());
			knowPeople[num] = true;
		}
		
		//union-find �ʱ�ȭ
		parent = new int[N+1];
		for(int i=1;i<=N; i++) {
			parent[i] = i;
		}
		
		//�� ��Ƽ ������ ���
		//���� ��Ƽ�� ������ ����� union
		ArrayList<Integer>[] party = new ArrayList[M+1];
        for(int i=1; i<=M; i++) {
            party[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=M; i++) {
        	st = new StringTokenizer(br.readLine());
        	//��Ƽ ���� �ο� ��
        	int attend = Integer.parseInt(st.nextToken());
        	
        	for(int j=0; j<attend; j++) {
        		party[i].add(Integer.parseInt(st.nextToken()));
        		
        		if(j != 0) {
        			//���� ��Ƽ�� ������ ��� union
        			int a = party[i].get(j);
            		int b = party[i].get(j-1);
            		
            		union(a,b);
        		}
        	}
        }
        
    	//������ �ƴ� ����� ���� ��Ƽ�� ������ ����� true�� 
    	boolean v[] = new boolean[N+1];
    	for(int i=1; i<=N; i++) {
    		if(knowPeople[i] && !v[i]) {
    			int root = find(i);
    			
    			for(int j=1; j<=N; j++) {
    				if(root == find(j)) {
    					knowPeople[j] = true;
    					v[j] = true;
    				}
    			}
    		}
    	}

    	//��Ƽ�� ������ �ƴ� ����� �ִ���
    	boolean goParty[] = new boolean[M+1];
    	for(int i=1; i<=M; i++) {
    		for(int j=1; j<=N; j++) {
    			if(knowPeople[j]) { //������ �ƴ� �����
    				if(party[i].contains(j)) //�ش� ��Ƽ�� ����������
    					goParty[i] = true;
    			}
    		}
    	}
    	
    	int answer = 0;
    	for(int i=1; i<=M; i++) {
    		if(!goParty[i]) answer++;
    	}
    	
    	System.out.println(answer);
	}

	//�θ� ã��
	private static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}

	//��ġ��
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			if(a < b) {
				parent[b] = a;
			} else {
				parent[a] = b;
			}
		}
	}

}
