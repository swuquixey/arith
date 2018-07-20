import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

//分割长度为2n数组为两个长度为n的数组，使数组和最接近
public class Test5 {
	public Map<String, Boolean> map = new HashMap<>();
	public Map<String, List<Integer>> reMap = new HashMap<String, List<Integer>>();
	public Map<String, Integer> prefixMap =  new HashMap<>();
	public boolean ifMeet(int[] arr, int tail, int num, int sum){
		if (map.get("" + num + "-" + sum) != null) {
			if (prefixMap.get("" + num + "-" + sum) <= tail && map.get("" + num + "-" + sum)) {
				return map.get("" + num + "-" + sum);
			}
			if (prefixMap.get("" + num + "-" + sum) >= tail && !map.get("" + num + "-" + sum)) {
				return map.get("" + num + "-" + sum);
			}
		}
		if(sum < 0){
			return false;
		}
		if(tail <= num -1){
			return false;
		}
		List<Integer> tmpLst = null;
		if(num == 1){
			for(int i = 0; i <= tail; i++){
				if(arr[i] == sum){
					tmpLst = new ArrayList<>();
//					tmpLst.add(arr[i]);
					tmpLst.add(i);
					reMap.put("" + num + "-" + sum, tmpLst);
					map.put("" + num + "-" + sum, Boolean.TRUE);
					prefixMap.put("" + num + "-" + sum, tail);
					return true;
				}
			}
			return false;
		}
		boolean re = ifMeet(arr, tail - 1, num, sum) || ifMeet(arr, tail - 1, num - 1, sum - arr[tail]);
		
		if(re){
			if(ifMeet(arr, tail - 1, num, sum)){
				
			}else{
				tmpLst = reMap.get("" + (num -1) + "-" + (sum- arr[tail]));
				List<Integer > newlst = new ArrayList<>();
				newlst.addAll(tmpLst);
//				newlst.add(arr[tail]);
				newlst.add(tail);
				reMap.put("" + num + "-" + sum, newlst);
				
			}
			
		}
		map.put("" + num + "-" + sum, re);
		prefixMap.put("" + num + "-" + sum, tail);
		return re;
	}

	public static void main(String[] args) {
		int count = 2000;
        int[] a = new int[count];

        for (int i=0; i<count; i++){
            a[i] = (int)(Math.random()*10 + 1);
        }
      
        int sum = IntStream.of(a).sum()/2;
        Test5 tt = new Test5();
        for(int j = sum; j > 0; j--){
        	System.out.println(j);
        	if(tt.ifMeet(a, a.length - 1, a.length/2, j)){
        		System.out.println("Test5.ifMeet");
        		System.out.println(j);
        		System.out.println(Arrays.toString(tt.reMap.get("" + a.length/2 + "-" + j).toArray()));
        		break;
        	}
        }

	}

}
