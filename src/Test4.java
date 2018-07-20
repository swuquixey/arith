
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Created by swu on 10/20/16.
 */
public class Test4 {

    static public int[] adjust(int[] a1, int[] a2, int a, int b){
        int sum1 = IntStream.of(a1).sum() + a + b;
        int sum2 = IntStream.of(a2).sum();
        int dif = (sum1 - sum2)/2;
        int[] re = new int[3];
        re[0] = Integer.MAX_VALUE;
        for(int i =0; i < a1.length; i++){
//            for(int j = 0; j < a2.length; j++){
                int tmp = Math.abs(a1[i] - dif);
                if (tmp < re[0]){
                    re[0] = tmp;
                    re[1] = i;
//                    re[2] = j;
                }
//            }
        }
        dif = Math.abs(sum1 - a1[re[1]]  - (sum2 + a1[re[1]]));
        re[0] = dif;
        return re;
    }

    static public int[] adjust(int[] a1, int[] a2){
        int sum1 = IntStream.of(a1).sum();
        int sum2 = IntStream.of(a2).sum();
        int dif = (sum1 - sum2)/2;
        int[] re = new int[3];
        re[0] = Integer.MAX_VALUE;
        for(int i =0; i < a1.length; i++){
            for(int j = 0; j < a2.length; j++){
                int tmp = Math.abs(a1[i] - a2[j] - dif);
                if (tmp < re[0]){
                    re[0] = tmp;
                    re[1] = i;
                    re[2] = j;
                }
            }
        }
        dif = Math.abs(sum1 - a1[re[1]] + a2[re[2]] - (sum2 - a2[re[2]] + a1[re[1]]));
        re[0] = dif;
        return re;
    }
    public static void optimSum(int[] a1, int[] a2){
    	for(int i = 1; i < a1.length; i++){
            int[] b1 = Arrays.copyOfRange(a1, 0, i + 1);
            int[] b2 = Arrays.copyOfRange(a2, 0, i + 1);
            int[] re1 = adjust(b1, b2);
            int t = b1[i];
            b1[i] = b2[i];
            b2[i] = t;
            int[] re2 = adjust(b1, b2);
            int[] c1 = Arrays.copyOfRange(a1, 0, i);
            int[] c2 = Arrays.copyOfRange(a2, 0, i);
            int[] re3 = adjust(c1, c2, a1[i], a2[i]);
            int[] re4 = adjust(c2, c1, a1[i], a2[i]);
            int[] dif = {re1[0], re2[0], re3[0], re4[0]};
            OptionalInt min = IntStream.of(dif).min();
            if(min.getAsInt() == re1[0]){
                int tmp = a1[re1[1]];
                a1[re1[1]] = a2[re1[2]];
                a2[re1[2]] = tmp;
            }else if(min.getAsInt() == re2[0]){
                int tmp = a1[re2[1]];
                a1[re2[1]] = a2[re2[2]];
                a2[re2[2]] = tmp;
                tmp = a1[i];
                a1[i] = a2[i];
                a2[i] = tmp;
            }else if(min.getAsInt() == re3[0]){
                int tmp = a2[i];
                a2[i] = a1[re3[1]];
                a1[re3[1]] = tmp;
            }else if(min.getAsInt() == re4[0]){
                int tmp = a1[i];
                a1[i] = a2[re4[1]];
                a2[re4[1]] = tmp;
            }
//            int[] d1 = Arrays.copyOfRange(a1, 0, i + 1);
//            int[] d2 = Arrays.copyOfRange(a2, 0, i + 1);
            


        }
    }
    
    public static void splitArr(int len, int[] a) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += a[i];
        }
        int n = len / 2;
        // d[j][k]任意的j个数，且这些数之和为k的取法是否存在
        boolean[][] d = new boolean[len + 1][sum / 2 + 1];
        d[0][0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = Math.min(i, n); j >= 1; j--) { //因為最多分割成n的大小
                for (int k = 0; k <= sum / 2; k++) {
                    if (k >= a[i] && d[j - 1][k - a[i]]) {
                        d[j][k] = true;
                    }
                }
            }
        }
        for (int i = sum / 2; i >= 0; i--) {
            if (d[n][i]) {
                System.out.println("the splited sum is:" + i);
                break;
            }
        }
    }
    
    static Map<String, Integer> map = new HashMap<>();
//    static List<Integer> result = new LinkedList<>();
    static int aC = 0;
    public static int diff(int[] arr, int parIndex, int count, int sum){
    	Integer target = map.get("" + parIndex + "-" + count + "-" + sum);
    	if (target != null){
//    		System.out.println(aC+=1);
//    		System.out.println("" + parIndex + "-" + count + "-" + sum);
//    		System.out.println();
    		aC+=1;
    		return target.intValue();
    	}
    	int diff = Integer.MAX_VALUE;
    	if(sum < 0) return diff;
    	if(count == parIndex + 1){
    		int curSum = 0;
    		for(int j = 0; j <= parIndex; j++){
    			curSum += arr[j];
//    			result.add(arr[j]);
    		}
    		diff = Math.abs(curSum - sum); 
    		map.put("" + parIndex + "-" + count + "-" + sum, diff);
    		return diff;
    	}
    	
    	if(count == 1){
    		int tmpIndex = 0;
    		for(int i = 0; i <= parIndex; i++){
    			if(arr[i] - sum < diff && arr[i] - sum >= 0){
    				diff = arr[i] - sum;
    				tmpIndex = i;
    			}
    		}
    		map.put("" + parIndex + "-" + count + "-" + sum, diff);
//    		result.add(arr[tmpIndex]);
    		return diff;
    	}
    	int aDiff = diff(arr, parIndex-1, count, sum);
    	int bDiff = diff(arr, parIndex -1, count -1, sum - arr[parIndex]);
    	if(aDiff > bDiff){
//    		result.add(arr[parIndex]);
    	}
    	Integer t = Math.min(aDiff, bDiff);
    	map.put("" + parIndex + "-" + count + "-" + sum, t);
    	return t;
    }

    public static void main(String[] args)  {
    	int count = 100;
        int[] a1 = new int[count];
        int[] a2 = new int[count];
//    	int[] a1 = {801, 998, 166, 322, 355, 283, 98, 194, 313, 693};
//    	int[] a2 = {21, 306, 108, 559, 915, 6, 327, 756, 335, 98};

        for (int i=0; i<count; i++){
            a1[i] = (int)(Math.random()*1000 + 1);
            a2[i] = (int)(Math.random()*1000 + 1);
//        	a1[i] = i;
//            a2[i] = i + count;
        }
        int[] d1 = Arrays.copyOfRange(a1, 0, a1.length);
        int[] d2 = Arrays.copyOfRange(a2, 0, a2.length);
        int[] c1 = Arrays.copyOfRange(a1, 0, a1.length);
        int[] c2 = Arrays.copyOfRange(a2, 0, a2.length);
//        int[] a1 = {33, 11, 12, 39, 7, 2, 24, 8, 51, 37};
//        int[] a2 = {1, 19, 49, 48, 95, 25, 95, 94, 50, 59};
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        optimSum(a1, a2);
        System.out.println();
        System.out.print(Arrays.toString(a1));
        System.out.println("  " + IntStream.of(a1).sum());
        System.out.print(Arrays.toString(a2));
        System.out.println("  " + IntStream.of(a2).sum());
        System.out.println();
        
        Test3.swap(a1, a2);
        System.out.println();
        System.out.print(Arrays.toString(a1));
        System.out.println("  " + IntStream.of(a1).sum());
        System.out.print(Arrays.toString(a2));
        System.out.println("  " + IntStream.of(a2).sum());
        System.out.println();
        
        Test3.swap(d1, d2);
        System.out.println();
        System.out.print(Arrays.toString(d1));
        System.out.println("  " + IntStream.of(d1).sum());
        System.out.print(Arrays.toString(d2));
        System.out.println("  " + IntStream.of(d2).sum());
        System.out.println();
        
        optimSum(d1, d2);
        System.out.println();
        System.out.print(Arrays.toString(d1));
        System.out.println("  " + IntStream.of(d1).sum());
        System.out.print(Arrays.toString(d2));
        System.out.println("  " + IntStream.of(d2).sum());
        System.out.println();

        int aLen = c1.length;
        int bLen = c2.length;
        int[] both= new int[aLen+bLen];
        System.arraycopy(c1, 0, both, 0, aLen);
        System.arraycopy(c2, 0, both, aLen, bLen);
      
        int sum = IntStream.of(both).sum()/2;
//        System.out.println(diff(both, 2*count -1, count, IntStream.of(both).sum()/2) + sum);
//        System.out.println(Arrays.toString(result.toArray()));
        Test5 tt = new Test5();
        for(int j = sum; j > 0; j--){
        	System.out.println(j);
        	if(tt.ifMeet(both, both.length - 1, both.length/2, j)){
        		System.out.println("Test5.ifMeet");
        		System.out.println(j);
        		System.out.println(Arrays.toString(tt.reMap.get("" + both.length/2 + "-" + j).toArray()));
        		break;
        	}
        }
       

        
        

    }


}
