import java.util.Arrays;


public class Test2 {

	public static int search(int[] array, int value) {
		int min = 0;
		int max = array.length - 1;
		while (max >= min) {
			int middle = (min + max) / 2;
			if (array[middle] == value) {
				return middle;
			} else if (array[middle] < value) {
                min = middle + 1;
			} else {
				max = middle - 1;
			}
		}
		return -1;
	}

	public static void swap(int[] a, int[] b, int dif) {

	}
	public static void main(String[] args) {
		int count = 10;
        int[] a = new int[count];

        for (int i=0; i<count; i++){
            a[i] = (int)(Math.random()*10 + 1);
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int t = (int)(Math.random()*10);
        System.out.println(t);
        System.out.println(search(a, t));
	}
}
