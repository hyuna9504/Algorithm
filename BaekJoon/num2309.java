import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * �ϰ� ������
 * 
 * ��ȩ�������� ��¥������ �� ���� ã�ƶ�!
 * �ϰ��������� Ű�� ���� 100��!
 * �ϰ� �������� Ű�� ������������ ���!
 * 
 * 1.Ű 9 ���� �ط¹޾� �迭�� �־�α�
 * 2.�ΰ��� ¦��� ���� ����ϴ°� ��ȯ�Ѵ�.
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

		// �ΰ��� ����
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				// �ΰ� ���� ���ϱ�
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
