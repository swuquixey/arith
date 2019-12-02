/**
 * Created by wo on 11/25/19.
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMin {
    private static int findMin(int[] arr, int start, int end){
        if(start == end || start+1 == end){
            return arr[start] > arr[end] ? arr[end] : arr[start];
        }
        int mid = (end + start)/2;
        if(arr[mid] >= arr[end]){
            return findMin(arr, mid, end);
        }else {
            return findMin(arr, start, mid);
        }
    }
    public static void main(String[] args){
        int[] arr = {4,5,6,7,8,9,10,0,1,2,3};
        System.out.println(findMin(arr, 0, arr.length - 1));
    }
}
