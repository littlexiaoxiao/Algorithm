
public class Q134Gas_Station {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length)
            return -1;
        
        int sum = 0;
        int total = 0;
        int start = 0;
        
        for(int i =0;i< gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0) {
                start ++;
                sum = 0;
            }
        }
        
        if(total < 0) {
            return -1;
        } else {
            return start;
        }
    }
}
