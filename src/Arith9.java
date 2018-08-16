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
                System.out.println(r - l);
            }else if(sum > n){
                while(sum > n){
                    sum = sum - l;
                    l = l + 1;
                }
                if(sum == n){
                    System.out.println("-------");
                    System.out.println(l);
                    System.out.println(r);
                    System.out.println(r - l);
                }
            }
        }
    }
    public static void main(String[] args) {
        doit(102900);
    }
}
