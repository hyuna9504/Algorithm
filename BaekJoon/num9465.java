import java.util.Scanner;

/*
 * input
 * 2
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80
output
260
290
 */

public class num9465 {
	static int testCase;
	static int arrSize;
	static int[][] inputValue;
	static int[][] cost;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		for (int t = 0; t < testCase; t++) {
			
			arrSize = sc.nextInt();
			inputValue = new int[2][arrSize];
			cost = new int[2][arrSize];
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < arrSize; j++) {
					inputValue[i][j] = sc.nextInt();
				}
			}
			
			for(int i= 0; i<arrSize; i++) {
				cost[0][i] = Math.max(areaCheck(1,i-1), areaCheck(1,i-2)) + inputValue[0][i];
				cost[1][i] = Math.max(areaCheck(0,i-1), areaCheck(0,i-2)) + inputValue[1][i];
			}
			
			System.out.println(Math.max(areaCheck(0,arrSize-1), areaCheck(1,arrSize-1)));
		}
	}
	public static int areaCheck(int a, int b) {
		if( a <0 || b < 0) {
			return 0;
		}
		return cost[a][b];
	}
}
