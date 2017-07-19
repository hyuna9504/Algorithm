import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * �Է�
 * 7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

���
3
7
8
9
 */
public class num2667 {
	static Boolean[][] visited;
	static int[][] arr;
	static int N;
	static int cnt;
	static int house;
	static ArrayList list = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		visited = new Boolean[N][N];
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = false;
			}
		}
		// �迭 �Է¹ޱ�
		String[] temp = new String[N];
		for (int i = 0; i < N; i++) {
			temp[i] = sc.nextLine();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(String.valueOf(temp[i].charAt(j)));
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					house=0;
					countvillage(i, j);
					
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	// �Լ� �����ϱ�
	public static void countvillage(int a, int b) {
		if (visited[a][b] == true) {
			return;
		}
		Queue<String> q = new LinkedList<>();
		visited[a][b] = true;
		q.add(a + "/" + b);
		house++;
		while (!q.isEmpty()) {
			String[] spiltData = q.remove().split("/");
			int valueOfa = Integer.parseInt(spiltData[0]);
			int valueOfb = Integer.parseInt(spiltData[1]);
			// ������
			if (valueOfb + 1 < N && !visited[valueOfa][valueOfb + 1] && arr[valueOfa][valueOfb + 1] == 1) {
				visited[valueOfa][valueOfb + 1] = true;
				q.add(valueOfa + "/" + (valueOfb+1));
				house++;
			}
			// ����
			if (valueOfb - 1 >= 0 && !visited[valueOfa][valueOfb - 1] && arr[valueOfa][valueOfb - 1] == 1) {
				visited[valueOfa][valueOfb - 1] = true;
				q.add(valueOfa + "/" + (valueOfb - 1));
				house++;
			}
			// �Ʒ���
			if (valueOfa + 1 < N && !visited[valueOfa + 1][valueOfb] && arr[valueOfa + 1][valueOfb] == 1) {
				visited[valueOfa + 1][valueOfb] = true;
				q.add((valueOfa + 1) + "/" + valueOfb);
				house++;
			}
			// ����
			if (valueOfa - 1 >= 0 && !visited[valueOfa - 1][valueOfb] && arr[valueOfa - 1][valueOfb] == 1) {
				visited[valueOfa - 1][valueOfb] = true;
				q.add((valueOfa - 1) + "/" + valueOfb);
				house++;
			}
		}
		// ������ �� ����
		cnt++;
		list.add(house);

	}

}
