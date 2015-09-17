package Other_Interviews;

public class CountBits {
	public static long CountBits(long input) {
		int count = 0;
		while(input != 0) {
			count ++;
			input ^= input & -input;
		}
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//public static int myBitCount(long L){
//    int count = 0;
//    while (L != 0) {
//       count++;
//       L ^= L & -L; 
//    }
//    return count;
//}