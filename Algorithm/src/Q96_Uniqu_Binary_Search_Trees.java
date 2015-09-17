public class Q96_Uniqu_Binary_Search_Trees {

	public static void main(String[] args) {
		int res = numTrees(3);
		System.out.println(res);

	}

	public static int numTrees(int n) {
		if (n == 0 || n == 1)
			return 1;

		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {// 代表以j 为节点的答案有多少种。
				count[i] += count[j -1] * count[i - j];
				//System.out.println(count[i]);
			}
		}
		return count[n];
	}

}
