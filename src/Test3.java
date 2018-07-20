import java.util.Arrays;
import java.util.stream.IntStream;

public class Test3 {

	public static void swap(int[] a, int[] b) {
		// Arrays.sort(a);
		// Arrays.sort(b);
		int sumA = 0;
		int sumb = 0;
		for (int i = 0; i < a.length; i++) {
			sumA += a[i];
			sumb += b[i];
		}
		int dif = sumA - sumb;
		if (dif == 0) {
			return;
		}
		// int[] big = a;
		// int[] small =b;

		/*
		 * if (sumA < sumb){ big = b; small = a; dif = sumb - sumA; }
		 */
		int curdif, bigj, smallk;
		curdif = Math.abs(a[a.length - 1] - b[0] - dif / 2);
		bigj = a.length - 1;
		smallk = 0;
		for (int j = a.length - 1; j >= 0; j--) {
			for (int k = 0; k < b.length; k++) {

				if (a[j] - b[k] == dif / 2) {
					int tmp = a[j];
					a[j] = b[k];
					b[k] = tmp;
					return;
				}
				int ttemp = Math.abs(a[j] - b[k] - dif / 2);
				if (ttemp < curdif) {
					curdif = ttemp;
					bigj = j;
					smallk = k;
				}
			}

		}
		if (curdif < Math.abs(dif / 2)) {
			int tmp = a[bigj];
			a[bigj] = b[smallk];
			b[smallk] = tmp;
		} else {
			return;
		}
		swap(a, b);

	}

	public static void main(String[] args) {
		int[] a1 = new int[100];
		int[] a2 = new int[100];
		for (int i = 0; i < 100; i++) {
			a1[i] = (int) (Math.random() * 10000 + 1);
			a2[i] = (int) (Math.random() * 10000 + 1);
		}
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(a2));
		swap(a1, a2);
		Arrays.sort(a1);
		Arrays.sort(a2);
		System.out.println();
		System.out.print(Arrays.toString(a1));
		System.out.println("  " + IntStream.of(a1).sum());
		System.out.print(Arrays.toString(a2));
		System.out.println("  " + IntStream.of(a2).sum());
		System.out.println();

	}

}
