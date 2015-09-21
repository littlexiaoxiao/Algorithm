package lintcode;

public class Gas_Station {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0 || cost == null || cost.length == 0
				|| gas.length != cost.length) {
			return -1;
		}

		int sum = 0;
		int total = 0;
		int index = -1;
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				sum = 0;
				index = i;
			}
		}
		if (total < 0) {
			return -1;
		} else {
			return index+1;
		}
	}

	public static void main(String[] args) {
		int[] gas = {2,0,1,2,3,4,0};
		int[] cost = {0,1,0,0,0,0,11};
		int res = canCompleteCircuit(gas, cost);
		System.out.println("res = " + res);
	}

}
