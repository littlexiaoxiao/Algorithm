package pocketGem;

public class Strstr {
    //Returns the index of the first occurrence of target in base, or -1 if target is not part of base.
	//time complexity O((n-m+1)*m)=O(n*m)
	public static void main(String[] args) {
		int res = FindTargetInBase("aaaaab", "ab");
		System.out.println(res);

	}
	
	public static int FindTargetInBase(String base, String target) {
		if(base == null || base.length() == 0 || base.length() < target.length())
			return -1;
		
		if (base.isEmpty() && target.isEmpty()) 
    		return 0;
		
		int diff = base.length() - target.length();
		int baseIndex = 0;
		int targetIndex = 0;
		for(int i = 0; i <= diff; i++) {
			baseIndex = i;
			targetIndex = 0;
			while(baseIndex < base.length() && targetIndex < target.length() 
					&& target.charAt(targetIndex) == base.charAt(baseIndex)) {
				baseIndex ++;
				targetIndex ++;
			}
			if(targetIndex == target.length())
				return i;
		}
		return -1;
	}
}
