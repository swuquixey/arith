
public class Arith {
	
	public static void exhaust(int[] i){
		for(int a = 0; a < i.length; a++){
			for(int b = a+1; b < i.length; b++){
				for(int c = b+1; c < i.length; c++){
					for(int d = c+1; d < i.length; d++){
						if(i[a] + i[b] + i[c] + i[d] == 24){
							System.out.println(""+i[a] + "+" + i[b] + "+" + i[c] + "+" + i[d] );
						}
					}
					
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] i = {3,2,4,5,1,8,6,7,12,9};
		exhaust(i);
		/*char[] arrB = "sdfjslsfjalskdfjkdfjasldkfjjs;alk".toCharArray();
		char[] arrS = "sfjalskdfj".toCharArray();
		for(int a = 0; a < arrB.length; a++){
			for(int b = 0; b < arrS.length; b++){
				if(arrB[a+b] != arrS[b]){
					break;
				}
				if(b == arrS.length - 1){
					System.out.println(a);
					return;
				}
			}
		}*/
		

	}

}
