/*
 * num1026
 * 
 * 입력
 * 5
1 1 1 6 0
2 7 8 3 1

출력
18
 */
import java.util.*;

public class num1026 {

	static int N;
	static int result=0;
	static int temp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		if(N>50 ||N<0) {
			System.exit(999);
		}
		int[] arrA = new int[N];
		int[] arrB = new int[N];
	
		for(int i=0; i<N; i++) {
			
			arrA[i] = scanner.nextInt();
			if(arrA[i] >100 | arrA[i] <0) {
				System.exit(999);
			}
		}
		for(int i=0; i<N; i++) {
			arrB[i] = scanner.nextInt();
			if(arrB[i] >100 | arrB[i] <0) {
				System.exit(999);
			}
		}
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		for(int i=0; i<N/2; i++) {
			temp = arrB[i];
			arrB[i] = arrB[N-1-i];
			arrB[N-1-i] = temp;
		}
		System.out.println(S(arrA,arrB));
		
	}
	static int S(int arra[], int arrb[]) {
		for(int i=0; i<N; i++) {
			result += arra[i]*arrb[i];
		}
		return result;
	}
	



}
