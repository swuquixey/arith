import java.util.*;

/**
 * Created by wo on 8/24/18.
 */
public class Arith10 {
    public static void simplifyPath(){
        String path = "/a/./b/../../c/./a/b";
        String[] part = path.split("/");
        Stack<String> stack = new Stack<>();
        Arrays.stream(part).forEach(str -> {
            if(str.equalsIgnoreCase("..")){
                stack.pop();
            }else if(!str.equalsIgnoreCase(".")){
                stack.push(str);
            }
        });
        System.out.println(String.join("/", stack.toArray(new String[stack.size()])));
    }
    public static void topk(){
        //小根堆
        PriorityQueue<Integer> que = new PriorityQueue<>(5);
//         //大根堆
//        PriorityQueue<Integer> que = new PriorityQueue<>(5, (a, b) -> b-a);
        int[] ints1 = {90,80,70,58,56,45,35,33,23};
        int[] ints2 = {80,70,60,48,46,35,25,23,13};
        int[] ints3 = {81,71,61,49,47,36,26,24,14};
        List<int[]> arrLst = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            que.add(ints1[i]);
        }
        arrLst.add(ints2);
        arrLst.add(ints3);
        for(int[] ints : arrLst){
            for(int j =0; j < ints.length; j++){
                if(que.peek() < ints[j]){
                    que.offer(ints[j]);
                    que.poll();
                }else{
                    break;
                }
            }
        }
        while(que.size() > 0) {
            System.out.println(que.poll());
        }
    }
    //有序数列中找出两个相差为m的数
    public static void find2Num(){
        int[] ints3 = {14,24,26,36,47,49,61,71,81};
        int m = 10;
        int h = 0, t =1;
        while(true){
            if(t >= ints3.length ){
                System.out.println("failed");
                break;
            }
            if(ints3[t] - ints3[h] == m){
                System.out.println(ints3[t]);
                System.out.println(ints3[h]);
                break;
            }else if(ints3[t] - ints3[h] < m){
                t += 1;
            }else{
                h += 1;
            }

        }
    }

    /**Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

     '.' Matches any single character.
     '*' Matches zero or more of the preceding element.
     The matching should cover the entire input string (not partial).

     Note:

     s could be empty and contains only lowercase letters a-z.
     p could be empty and contains only lowercase letters a-z, and characters like . or *.

     https://leetcode.com/problems/regular-expression-matching/description/
     * @param str
     * @param pattern
     * @return
     */
    public static boolean match(String str, String pattern){
        if(pattern.equals(str)){
            return true;
        }
        if(!pattern.contains(".") && !pattern.contains("*")){
            return false;
        }
        if(pattern.startsWith(".*")){
            for(int i = 0; i <= str.length(); i++){
                if(match(str.substring(i), pattern.substring(2))){
                    return true;
                }
            }
        }
        if(pattern.startsWith(".")){
            return  match(str.substring(1), pattern.substring(1));
        }

        if(pattern.charAt(1) != '*'){
            if(pattern.charAt(0) != str.charAt(0)){
                return false;
            }
            return match(str.substring(1), pattern.substring(1));
        }

        int j = 0;
        while(true){
            if( match(str.substring(j), pattern.substring(2))){
                return true;
            }
            if(str.charAt(j) == str.charAt(0)){
                j = j + 1;
            }else{
                return false;
            }
        }


    }
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(match(s,p));
    }
}
