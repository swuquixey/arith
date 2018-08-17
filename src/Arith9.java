import java.util.*;

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
//        System.out.println(paveBrick(20));
        List<DualList> lst = arrange(12);
        for(DualList dual : lst){
            System.out.println(Arrays.toString(dual.lst1.toArray()));
            System.out.println(Arrays.toString(dual.lst2.toArray()));
        }
        System.out.println(lst.size());
    }

    static class DualList{
        List<Integer> lst1, lst2;
    }

    /*
    12个高矮不同的人，排成两排，每排必须是从矮到高排列，且第二排比第一排对应的人高。

求排列方式有多少种？
    * **/
    public static List<DualList> arrange(int n){
        if(n % 2 != 0){
            return null;
        }
        if(n == 2){
            DualList dualList = new DualList();
            dualList.lst1 = new ArrayList<>();
            dualList.lst2 = new ArrayList<>();
            dualList.lst1.add(2);
            dualList.lst2.add(1);
            List<DualList> lst = new ArrayList<>();
            lst.add(dualList);
            return lst;
        }
        List<DualList> lst = arrange(n - 2);
        List<DualList> relst = new ArrayList<>();
        for(DualList dual : lst){
            dual.lst1.add(n -1);
            dual.lst1.add(n);
            for(int i : dual.lst1){
                List<Integer> newLst1 = (ArrayList)((ArrayList)dual.lst1).clone();
                List<Integer> newLst2 = (ArrayList)((ArrayList)dual.lst2).clone();
                newLst1.remove((Integer) i);
                for(int j = 0; j < newLst2.size(); j++){
                    if(newLst2.get(j) > i){
                        newLst2.add(j,i);
                        break;
                    }
                    if(j == newLst2.size() -1){
                        newLst2.add(i);
                        break;
                    }
                }
                boolean flag = true;
                for(int k = 0; k < newLst1.size(); k++){
                    if(newLst1.get(k) < newLst2.get(k)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    DualList dualList = new DualList();
                    dualList.lst1 = newLst1;
                    dualList.lst2 = newLst2;
                    relst.add(dualList);
                }
            }
        }
        return relst;
    }









}
