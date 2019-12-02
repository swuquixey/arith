import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * longest ascend sub sequence
 */
public class MaxSubSeq {
    private static  int[] gotIt(int[] arr, int tail){
        if(tail == 0){
            int[] re = {arr[0]};
            return re;
        }
        int[] curArr = null;
        for (int i = 0; i < tail ; i++) {
            if(arr[i] <= arr[tail]){
                int[] tmpArr = gotIt(arr, i);
                if(curArr == null){
                    curArr = tmpArr;
                }else if(curArr.length < tmpArr.length){
                    curArr = tmpArr;
                }

            }
        }
        if(curArr == null){
            int[] rearr = {arr[tail]};
            return rearr;
        }
        int[] rearr = new int[curArr.length +1];
        System.arraycopy(curArr, 0, rearr, 0, curArr.length);
        rearr[rearr.length - 1] = arr[tail];
        return rearr;

    }
    public static void main(String[] args){
        int[] arr = {4,5,6,7,8,9,10,0,1,2,3,5,6,7,8};
        int[] re = null;
        for (int i = 0; i < arr.length; i++) {
            int[] tmp = gotIt(arr, i);
            if(re == null){
                re = tmp;
            }else if(re.length < tmp.length){
                re = tmp;
            }
        }
        System.out.println(Arrays.toString(re));
    }
}
