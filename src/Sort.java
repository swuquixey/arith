//http://www.importnew.com/16266.html
public class Sort {
	
	public static int[] insert(int[] ints){
		for(int i = 1; i < ints.length; i++){
			int a = ints[i];
			for(int j = i-1; j >= 0; j--){
				if(ints[j] > a){
					ints[j + 1] = ints[j];
					if(j == 0){
						ints[j] = a;
					}
				}else{
					ints[j + 1] = a;
					break;
				}
			}
		}
		return ints;
	}
	
	public static int[] hill(int[] ints){
		for(int i = ints.length/2; i >= 1; i = i/2){
			for(int j = 0; j < i; j = j + 1){
				for(int k = j + i; k < ints.length; k = k + i){
					int a = ints[k];
					for(int f = k - i; f >= 0; f = f - i){
						if(ints[f] > a){
							ints[f + i] = ints[f];
							if(f == j){
								ints[f] = a;
							}
						}else{
							ints[f + i] = a;
							break;
						}
					}
				}
			}
		}
		return ints;
	}
	
	public static void heapAdjust(int[] arr, int i, int end){
		if(2*i + 1 > end){
			return;
		}
		if(arr[i] < arr[2*i + 1]){
			swap(arr, i, 2 * i + 1);
			heapAdjust(arr, 2*i + 1, end);
		}
		if(2*i + 2 > end){
			return;
		}
		if(arr[i] < arr[2*i + 2]){
			swap(arr, i, 2 * i + 2);
			heapAdjust(arr, 2*i + 2, end);
		}
	}
	public static void buildHeap(int[] arr){
		for(int i = arr.length/2 - 1; i >= 0; i--){
			heapAdjust(arr, i, arr.length - 1);
		}
	}
	
	public static int[] heapSort(int[] arr){
		buildHeap(arr);
		for(int i = arr.length - 1; i > 0; i--){
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapAdjust(arr, 0, i - 1);
		}
		return arr;
	}
	
	public static void quik(int[] arr, int start, int tail){
		if(start >= tail){
			return;
		}else if(tail - start == 1){
			if(arr[start] > arr[tail]){
				swap(arr, start, tail);
				return;
			}
		}
		int i = start;
		int j = tail;
		int tmp = arr[start];
		boolean fromright = true;
		while(true){
			if(start == tail){
				arr[start] = tmp;
				break;
			}
			if(fromright){
				if(arr[tail] < tmp){
					arr[start]=arr[tail];
					start = start + 1;
					fromright = false;
					continue;
				}else{
					tail = tail - 1;
				}
			}else{
				if(arr[start] > tmp){
					arr[tail] = arr[start];
					tail = tail - 1;
					fromright = true;
					continue;
				}else{
					start = start + 1;
				}
			}
		}
		quik(arr, i, start - 1);
		quik(arr, start + 1, j);
	}
	
	public static void simpleSelect(int[] arr){
		
		for(int i = 0; i < arr.length; i++){
			int index = i;
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[index]){
					index = j;
				}
			}
			swap(arr, i, index);
		}
	}
	
	public static void buble(int[] arr){
		boolean flag = false;
		while(!flag){
			flag = true;
			for(int i = 0; i < arr.length - 1; i++){
				if(arr[i] > arr[i+1]){
					swap(arr, i, i + 1);
					flag = false;
				}
			}
		}
	}
	
	public static void binary(int[] arr){
		for(int i = 1; i < arr.length; i++){
			int t = binGet(arr, 0, i - 1, arr[i]);
			int tmp = arr[i];
			if(t == i -1){
				if(arr[t] > arr[i]){
					swap(arr, t, i);
				}
			}else{
				for(int j = i - 1; j >= t; j--){
					arr[j + 1] = arr[j];
				}
				arr[t] = tmp;
			}
		}
	}
	private static int binGet(int[] arr, int start, int end, int v){
		if(end-start < 2){
			if(arr[start] >= v){
				return start;
			}else{
				return end;
			}
		}
		int mid = start + (end - start) / 2;
		if(arr[mid] >= v){
			return binGet(arr, start, mid, v);
		}else{
			return binGet(arr, mid, end, v);
		}
	}
	
	public  static void swap(int[] data, int i, int j) {  
        // TODO Auto-generated method stub  
        int tmp=data[i];  
        data[i]=data[j];  
        data[j]=tmp;  
    } 
	
	public static void print(int[] i){
		for(int j : i){
			System.out.println(j);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(3/2);
		int[] i = {3,2,4,5,1,8,6,7,12,9,11};
		//quik(i, 0, i.length - 1);
		//binary(i);
		//print(i);

	}

}
