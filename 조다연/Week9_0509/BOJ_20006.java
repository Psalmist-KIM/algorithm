package week9_0509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_20006 {
	//��ŷ�� ��⿭
	static int p, m;
	static ArrayList<Player> room;
	static Player[] players;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//�÷��̾� �� p, ���� ���� m
		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		players = new Player[p];

		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			//�÷��̾� ���� l, �г��� n
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			
			players[i] = new Player(l, n);
		}
		
		for(int i=0; i<p; i++) {
			room = new ArrayList<>();
			//�濡 �������� ���� �÷��̾�
			if(!players[i].check) {
				for(int j=i; j<p; j++) {
					//������ ������ ���̸� ���ο� ������
					if(room.size() == m) {
						break;
					}
					
					int level = players[j].level;
					String nick = players[j].nick;
					//���� +-10�̸� ���� ����
					if(!players[j].check 
							&& players[i].level-10 <= level 
							&& players[i].level+10 >= level) {
						players[j].check = true;
						room.add(new Player(level, nick));
					}
				}
				
				//�г��� ��
				Collections.sort(room);
				if(room.size() == m) {
					sb.append("Started!").append("\n");
				} else  {
					sb.append("Waiting!").append("\n");
				}
				
				for(Player player : room) {
					sb.append(player.level).append(" ")
						.append(player.nick).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	static class Player implements Comparable<Player>{
		int level;
		String nick;
		boolean check;
		
		public Player(int level, String nick) {
			super();
			this.level = level;
			this.nick = nick;
		}

		@Override
		public int compareTo(Player o) {
			return nick.compareTo(o.nick);
		}
	}

}
