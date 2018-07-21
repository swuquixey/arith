import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CC {

    /**
     * 生成全排列
     */
    public static List<List<Integer>> cc(int i) {
        if (i == 0) {
            List<Integer> lst = new ArrayList();
            lst.add(0);
            List<List<Integer>> l = new ArrayList();
            l.add(lst);
            return l;
        }
        List<List<Integer>> ll = cc(i - 1);
        List<List<Integer>> reLst = new ArrayList();
        for (List tmpLst : ll) {
            for (int j = 0; j < tmpLst.size() + 1; j++) {
                List<Integer> newLst = new ArrayList();
                newLst.addAll(tmpLst);
                newLst.add(j, i);
                reLst.add(newLst);
            }
        }
        return reLst;

    }

    public static void main(String[] args) {
        List<List<Integer>> ll = cc(3);
        for (List tmpLst : ll) {
            System.out.println(Arrays.toString(tmpLst.toArray()));
            /*for(int j = 0; j<tmpLst.size(); j++){
				System.out.print(tmpLst.get(j));	
				}*/
            System.out.println();
        }

    }

}
