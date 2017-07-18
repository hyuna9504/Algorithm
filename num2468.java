import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * ��������ã��
 */
public class num2468 {
	static int N;
	static Boolean[][] visited;
	static int[][] origin;
	static int cnt;
	static int max=0;

	public static void main(String[] args) {
		// �迭�� ũ�� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		visited = new Boolean[N][N];
		
		// ������ �迭�� �Է��ϱ�
		if(N<2 && N>100) {
			System.exit(999);
		}
		origin = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				origin[i][j] = sc.nextInt();
			}
		}
		// ������ ������ ���� 0���� �ٲ�
		for (int rainfall = 0; rainfall <= 100; rainfall++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(origin[i][j] <= rainfall) 
						origin[i][j] = 0;
				}
			}
			cnt = 0;
			for(int i =0; i<N; i++) {
				for (int j =0; j<N; j++) {
					visited[i][j] = false;
				}
			}
			//���Ϸ��� ã��
			for(int i =0; i<N; i++) {
				for (int j = 0; j<N; j++) {
					if(origin[i][j] != 0)
						
						safeIsland(i,j);
				}
			}
			max = max<=cnt? cnt:max;
		}
		
		System.out.println(max);
			
	}
	public static void safeIsland(int a, int b) {
		if(visited[a][b] ==true) {
			return;
		}
		Queue<String> q = new LinkedList<>();
		visited[a][b]=true;
		q.add(a+"/"+b);
		while(!q.isEmpty()) {
			String[] spiltData = q.remove().split("/");
			int valueOfa = Integer.parseInt(spiltData[0]);
			int valueOfb = Integer.parseInt(spiltData[1]);
			//������
			if(valueOfb+1<N && visited[valueOfa][valueOfb+1]!= true && origin[valueOfa][valueOfb+1]!=0) {
				visited[valueOfa][valueOfb+1] = true;
				q.add(valueOfa+"/"+(valueOfb+1));
			}
			//����
			if(valueOfb-1 >=0 && !visited[valueOfa][valueOfb-1] && origin[valueOfa][valueOfb-1]!=0 ) {
				visited[valueOfa][valueOfb-1] = true;
				q.add(valueOfa+"/"+(valueOfb-1));
			}
			//�Ʒ���
			if(valueOfa+1 <N && !visited[valueOfa+1][valueOfb] && origin[valueOfa+1][valueOfb]!=0) {
				visited[valueOfa+1][valueOfb] = true;
				q.add((valueOfa+1)+"/"+valueOfb);
			}
			//����
			if(valueOfa-1 >=0 && !visited[valueOfa-1][valueOfb] && origin[valueOfa-1][valueOfb]!=0) {
				visited[valueOfa-1][valueOfb] = true;
				q.add((valueOfa-1)+"/"+valueOfb);
			}
			
		}
		cnt++;
		
	}
		
	
}
