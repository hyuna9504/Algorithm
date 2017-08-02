import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * '내려가기'문제
 * intput
 * 3
1 2 3
4 5 6
4 9 0
output
18 6
 */
public class num2096 {
	static int N;
	static int[][] inputValue;
	static int[][] max_min;
	static int Max;
	static int Min;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		inputValue = new int[N][3];
		max_min = new int[N][3];
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++) {
				inputValue[i][j] = scan.nextInt();
			}
		}
		max_min[0][0] = inputValue[0][0];
		max_min[0][1] = inputValue[0][1];
		max_min[0][2] = inputValue[0][2];
		for(int i =1; i<N; i++) {
			max_min[i][0] = Max(max_min[i-1][0],max_min[i-1][1]) + inputValue[i][0];
			max_min[i][1] = Max(max_min[i-1][2], Max(max_min[i-1][0],max_min[i-1][1])) + inputValue[i][1];
			max_min[i][2] = Max(max_min[i-1][2],max_min[i-1][1]) + inputValue[i][2];
		}
		Max = Max(max_min[N-1][2], Max(max_min[N-1][0],max_min[N-1][1]));
		
		for(int i =1; i<N; i++) {
			max_min[i][0] = Min(max_min[i-1][0],max_min[i-1][1]) + inputValue[i][0];
			max_min[i][1] = Min(max_min[i-1][2], Min(max_min[i-1][0],max_min[i-1][1])) + inputValue[i][1];
			max_min[i][2] = Min(max_min[i-1][2],max_min[i-1][1]) + inputValue[i][2];
		}
		Min = Min(max_min[N-1][2], Min(max_min[N-1][0],max_min[N-1][1]));
		
		System.out.println(Max +" "+ Min);
	}
	public static int Max(int a, int b) {
		return a>b?a:b;
		
	}
	public static int Min(int a, int b) {
		return a>b?b:a;
		
	}
}
