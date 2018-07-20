import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


public class Test7 {

	public static void main(String[] args) {
		int[] sum = new int[10 * 19];
		int[] mul = new int[10 * 19];
		int k = 0;
		for(int i = 1; i <= 20; i++){
			for(int j = i + 1; j <= 20; j++){
				sum[k] = i + j;
				mul[k] = i * j;
				k += 1;
			}
		}
		Arrays.sort(sum);
		Arrays.sort(mul);
		
		System.out.println(Arrays.toString(sum));
		System.out.println(Arrays.toString(mul));
		Set<Integer> ms = new LinkedHashSet<>();
		Set<Integer> ss = new LinkedHashSet<>();
		for(int i = 1; i < mul.length - 1; i++){
			if(mul[i] == mul[i-1] || mul[i] == mul[i+1]){
				ms.add(mul[i]);
			}
			if(sum[i] == sum[i-1] || sum[i] == sum[i+1]){
				ss.add(sum[i]);
			}
		}
		
		for(Integer i : ms){
			System.out.print(i + ", ");
		}
		System.out.println(", ");
		for(Integer i : ss){
			System.out.print(i + ", ");
		}
//		for(int i = 1; i <= 20; i++){
//			for(int j = i + 1; j <= 20; j++){
//				if(ms.contains(Integer.valueOf(i*j)) && ss.contains(Integer.valueOf(i + j))){
//					System.out.println(i + ", " + j);
//				}
//
//			}
//		}

	}

}
