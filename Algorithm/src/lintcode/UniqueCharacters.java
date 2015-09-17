package lintcode;

import java.util.Arrays;

public class UniqueCharacters {
    public static boolean isUnique(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for(int i = 1; i < chars.length; i++) {
            if(chars[i] == chars[i-1]) 
                return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		System.out.println(isUnique("$7*i(i)j"));
	}

}
