import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test6 {
	/**
	 * 请完善以下程序，输入为字符数组（数组内每个字符均不相同）和个数n，返回值是由这些字符组成的所有长度为n的字符串
例如输入为{'a','b','c'}和个数1，则返回值为{"a","b","c"}
例如输入为{'a','b','c','d'}和个数2，则返回值为{"ab","ac","ad","ba","bc","bd","ca","cb","cd","da","db","dc"}

	 * */
	public static String[] doit(char[] chars, int n){
		if(n > chars.length){
			String[] tt = {};
			return tt;
			}
		if(n == 1){
			String[] strs = new String[chars.length];
			for(int i = 0; i < chars.length; i++){
				strs[i] = String.valueOf(chars[i]);
			}
			return strs;
		}
		List<String> reLst = new ArrayList<String>();
		for(int j = 0; j < chars.length; j++){			
			char[] tc = new char[chars.length - 1 - j];
			for(int h = j + 1; h < chars.length; h++){
				tc[h - 1 - j] = chars[h];
			}
			String[] preRes = doit(tc, n - 1);
			
			for(int k = 0; k < preRes.length; k++){
				char[] tchs = preRes[k].toCharArray();
				for(int l =0; l < n; l++){
					char[] chs = new char[n];
					for(int h = 0; h < n; h++){
						if(h == l) chs[h] = chars[j];
						if(h < l) chs[h] = tchs[h];
						if(h > l) chs[h] = tchs[h-1];
					}
					reLst.add(String.valueOf(chs));
				}
			}
			
		}
		
		
		return (String[])reLst.toArray(new String[0]);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = {'a','b','c','d'};
		System.out.println(Arrays.toString(doit(chars, 2)));

	}

}
