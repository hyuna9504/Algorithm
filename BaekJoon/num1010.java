/**
 * 마을사이의 다리놓기
 */
import java.util.Scanner;

public class num1010 {
	static int[][] dp = new int[100][100];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String testcase = scan.nextLine();
		String[][]NandM = new String[Integer.parseInt(testcase)][2];

		for (int i = 0; i < Integer.parseInt(testcase); i++) {
			for (int j = 0; j < 2; j++) {
				NandM[i][j] = scan.next();
			}
		}
		for (int i = 0; i < Integer.parseInt(testcase); i++) {
			System.out.println(Combination(Integer.parseInt(NandM[i][1]), Integer.parseInt(NandM[i][0])));
		}
	}

	public static int Combination(int n, int r) {
	      if (n == r || r == 0)
	         return 1;
	      if (dp[n][r] > 0)
	         return dp[n][r];
	      dp[n][r] = Combination(n - 1, r - 1) + Combination(n - 1, r);
	      return dp[n][r];
	   }
}
