import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 
 * 1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000
 * 
 * 입력10 1 10 2 1
 * 출력 6
 * 
 */
public class num5014 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 총 층
		int F = sc.nextInt();
		int S = sc.nextInt();
		int G = sc.nextInt();
		int U = sc.nextInt();
		int D = sc.nextInt();

		int pollValue =S;
		int[] cnt = new int[F + 1];

		// 노드들을 넣을 큐
		Queue<Integer> q = new LinkedList<>();
		// 방문한 노드는 다시 할 필요 없음 -> 배열에 저장
		Boolean[] visited = new Boolean[F + 1];
		
		q.add(S);
		for(int i=1; i<visited.length; i++) visited[i] = false;
		visited[S] = true;

		while (!q.isEmpty()) {
			pollValue = q.poll();
			if (pollValue == G) {
				System.out.println(cnt[G]);
				System.exit(999);
			}
			
			if (pollValue + U <= F && !visited[pollValue + U]) {
				q.add(pollValue + U);
				visited[pollValue + U] = true;
				cnt[pollValue + U] = cnt[pollValue]+1;
			}
			if (pollValue - D > 0 && !visited[pollValue - D]) {
				q.add(pollValue - D);
				visited[pollValue - D] = true;
				cnt[pollValue - D] = cnt[pollValue]+1;
			}
		}
		System.out.println("use the stairs");
	}

}
