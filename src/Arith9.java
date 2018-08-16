import java.util.HashMap;
import java.util.Map;

/**
 * Created by wo on 8/16/18.
 */
public class Arith9 {
    //输入一个正整数 n，输出所有和为 n 的连续正整数序列。
    public static void doit(int n){
        int l = 1;
        int r = 2;
        int sum = 3;
        while(r < n){
            r = r + 1;
            sum = sum + r;
            if(sum == n){
                System.out.println("-------");
                System.out.println(l);
                System.out.println(r);
            }else if(sum > n){
                while(sum > n){
                    sum = sum - l;
                    l = l + 1;
                }
                if(sum == n){
                    System.out.println("-------");
                    System.out.println(l);
                    System.out.println(r);
                }
            }
        }
    }

    private static Map<Integer, Integer> cache = new HashMap<>(128);

/**现在有两种砖，分别是1*1的砖和1*2的砖，用这两种砖铺 1*N 的地面。
 问共有多少种铺法？（输入为N，请输出相应的铺法数，经典铺砖问题）
 * */
    public static int paveBrick(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(cache.get(n) != null){
            return cache.get(n);
        }
        int result = paveBrick(n - 1) + paveBrick(n - 2);
        cache.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(paveBrick(20));
    }
}
