/**
 * Created by wo on 11/25/19.
 */
//https://leetcode.com/problems/edit-distance/
public class EditDis {
    private static int calDis(String str1, String str2){
        if(str1.length() == 0){
            return  str2.length();
        }
        if(str2.length() == 0){
            return str1.length();
        }
        int dis1 = 0;
        if(str1.substring(str1.length() -1).equals(str2.substring(str2.length()-1))){
            dis1 = calDis(str1.substring(0, str1.length() -1), str2.substring(0, str2.length() -1));
        }else {
            dis1 = calDis(str1.substring(0, str1.length() -1), str2.substring(0, str2.length() -1)) + 1;
        }
        int dis2 = calDis(str1.substring(0, str1.length() -1), str2) + 1;
        int dis3 = calDis(str1, str2.substring(0, str2.length() -1)) + 1;
        if(dis1 > dis2){
            dis1 = dis2;
        }
        if(dis1 > dis3){
            dis1 = dis3;
        }
        return dis1;
    }

    public static void main(String[] args){
        System.out.println(calDis("horse", "ros"));
    }
}
