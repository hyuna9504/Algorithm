import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * 일곱 난쟁이
 * 
 * 아홉난쟁이중 가짜난쟁이 두 명을 찾아라!
 * 일곱난쟁이의 키의 합은 100임!
 * 일곱 난쟁이의 키를 오름차순으로 출력!
 * 
 * 1.키 9 개를 잊력받아 배열에 넣어두기
 * 2.두개씩 짝지어서 빼서 계산하는걸 순환한다.
 */
public class num2309 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int[] dwarf = new int[9];
		int sum;

		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
		}

		// 두개씩 빼기
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				// 두개 뺀것 더하기
				sum = 0;

				for (int k = 0; k < 9; k++) {
					if (k != i && k != j) {
						sum += dwarf[k];
					}
				}
				if (sum == 100) {
					for (int k = 0; k < 9; k++) {
						if (k != i && k != j) {
							list.add(dwarf[k]);
						}
					}
					for (int m = 0; m < list.size(); m++) {
						Collections.sort(list);
						System.out.println(list.get(m));

					}
				}
			}
		}

	}

}
