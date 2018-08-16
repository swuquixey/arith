import java.util.Arrays;


public class Test {
	public static void swap(int[] a, int[] b, int dif){
		
	}

	public static void main(String[] args) {
		int n, m;

        String result = "";

        char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        n = 42;
        m = 16;


        while (n > 0)

        {

            result = num[n % m] + result;

            n = n / m;

        }

        System.out.println(result);
		          
		  
		}  



}
