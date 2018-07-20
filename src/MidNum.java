import java.util.Arrays;


public class MidNum {
	
	
	public static void quikSort(int[] arr, int start, int end){
		if(start >= end){
			return;
		}
		if(end - start == 1){
			if (arr[start] < arr[end]){
				Sort.swap(arr, start, end);
				return;
			}
		}
		int tmp = arr[start];
		int cur = start;
		int r = end, l = start + 1;
		boolean fromR = true;
		while(true){
			if(fromR){
				if(arr[r] > tmp){
					arr[cur] =arr[r];
					cur =r;
					fromR = false;
				}else{
					r--;
				}
			}else{
				if(arr[l] < tmp){
					arr[cur] = arr[l];
					cur = l;
					fromR = true;
				}else{
					l++;
				}
			}
			if(l == r){
				arr[l] = tmp;
				break;
			}
		}
		/*if(l - start  == n ){
			return arr[l];
		}else if(l - start  < n ){
			return quikSort(arr, l + 1, end, n - (l-start+1));
		}else{
			return quikSort(arr, start, l - 1, n);
		}*/
		quikSort(arr, start, l - 1);
		quikSort(arr, l+1, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = {3,2,4,5,1,8,6,7,12,9,11};
		/*Sort.buildHeap(i);
		for(int j = i.length/2 + 1; j < i.length; j++){
			if(i[j]<i[0]){
				Sort.swap(i, 0, j);
				Sort.heapAdjust(i, 0, i.length/2);
			}
		}*/

		System.out.println(i[0]);
		quikSort(i, 0, i.length-1);
		System.out.println(Arrays.toString(i));
	}
	
	

}
