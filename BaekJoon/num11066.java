import java.util.Scanner;

/*
 * input
 * 2
4
40 30 30 50
15
1 21 3 4 5 35 5 4 3 5 98 21 14 17 32

output
300
864
 */
public class num11066 {
	static final int MAX = Integer.MAX_VALUE;
	static int T;
	static int K;
	static int[] C;
	static int[] S;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int t=0; t<T; t++) {
			K = sc.nextInt();
			C = new int[K+1];
			S = new int[K+1];
			S[0] = 0;
			for(int i=1; i<=K; i++) {
				C[i] = sc.nextInt();
				S[i] = S[i-1] + C[i];
			}
			dp = new int[K+1][K+1];
			for(int i=1; i<=K; i++) {
				for(int j=1; j<=K; j++) {
					dp[i][j] = MAX;
				}
			}
			//System.out.println(solve(dp,C,S,1,K));
			solve(dp,C,S,1,K);
			for(int i =0; i<=K; i++) {
				for( int j=0; j<=K; j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}
	public static int solve(int dp[][],int c[], int s[], int start, int end) {
		if(start>=end) {
			return 0 ;
		}
		if(start + 1 == end) {
			return c[start] + c[end];
		}
		if(dp[start][end] < MAX) {
			return dp[start][end];
		}
		for(int i=start; i<end; i++) {
			int temp = solve(dp,C,S,start,i) + solve(dp,C,S,i+1,end) + S[end] - S[start-1];
			dp[start][end] = Math.min(dp[start][end], temp);
		}
		return dp[start][end];
	}

}
