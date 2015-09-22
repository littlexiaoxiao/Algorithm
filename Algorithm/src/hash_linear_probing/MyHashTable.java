package hash_linear_probing;

public class MyHashTable implements MyHTInterface {
	private DataItem[] hashArray;
	private int size = 0;
	private int numOfCollisions = 0;
	private static final DataItem DELETED = new DataItem("#DEL#");

	// TODO implement constructor with no initial capacity
	public MyHashTable() {
		hashArray = new DataItem[10];
	}

	// TODO implement constructor with initial capacity
	public MyHashTable(int capacity) {
		if(capacity <= 0) {
			throw new RuntimeException();
		}
		hashArray = new DataItem[capacity];
	}

	/**
	 * Inserts a new String value (word). Frequency of each word be stored too.
	 *
	 * @param value
	 *            String value to be added.
	 */
	@Override
	public void insert(String value) {
		if(value == null || value.length() == 0)
			return;
		
		for(int i = 0;i < value.length(); i++) {
			if(value.charAt(i) < 'a' || value.charAt(i) > 'z') {
				return;
			}
		}
		int hashValue = hashFunc(value);
		boolean collison = false;
		int originValue = hashValue;
		while(hashArray[hashValue] != null && hashArray[hashValue].value.equals(DELETED.value)) {
			if(!collison && this.hashFunc(hashArray[hashValue].value )== originValue) {
				collison = true;
			}
			if(value.equals(hashArray[hashValue].value)) {
				hashArray[hashValue].frequency ++;
				return;
			}
			collison = true;
			hashValue = (hashValue + 1) % hashArray.length;
		}
		DataItem item = new DataItem(value);
		hashArray[hashValue] = item;
		hashArray[hashValue].frequency ++;
		size++;
		if(collison == true) {
			numOfCollisions ++;
		}
		rehash();
	}

	/**
	 * Returns the size, number of items, of the table
	 *
	 * @return the number of items in the table.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Displays the values of the table If an index is empty, it shows ** If
	 * previously existed item is deleted, then it should show #DEL#
	 */
	@Override
	public void display() {
		for(int i = 0; i < hashArray.length; i++) {
			if(hashArray[i] == null) {
				System.out.print("** ");
			} else if (hashArray[i].value.equals("#DEL#")) {
				System.out.print("#DEL# ");
			} else {
				System.out.print("[" + hashArray[i].value + ", " + hashArray[i].frequency + "]");
			}
		}
		System.out.println();
	}

	/**
	 * Returns true if value is contained in the table
	 *
	 * @param key
	 *            String key value to be searched
	 * @return true if found, false if not found.
	 */
	@Override
	public boolean contains(String key) {
		if(key == null || key.length() == 0)
			return false;
		int hashValue = hashFunc(key);
		while(hashArray[hashValue] != null) {		
			if(key.equals(hashArray[hashValue].value))
				return true;	
			hashValue = (hashValue + 1) %  hashArray.length;
		}
		return false;
	}

	/**
	 * Returns the number of collisions in relation to insert and rehash.
	 *
	 * When rehashing process happens, the number of collisions should be
	 * properly updated.
	 *
	 * The definition of collision is
	 * "two different keys map to the same hash value."
	 *
	 * Be careful with the situation where you could over count. Try to think as
	 * if you are using separate chaining!
	 * "How would you count the number of collisions in separate chaining?"
	 *
	 * @return number of collisions
	 */
	@Override
	public int numOfCollisions() {
		return numOfCollisions;
	}

	/**
	 * Returns the hash value of a String
	 *
	 * @param value
	 *            value for which the hash value should be calculated
	 * @return int hash value of a String.
	 */
	@Override
	public int hashValue(String value) {
		return hashFunc(value);
	}

	/**
	 * Returns the frequency of a key String
	 *
	 * @param key
	 *            key string value to find its frequency
	 * @return frequency value if found. If not found, return 0
	 */
	@Override
	public int showFrequency(String key) {
		int frequency = 0;
		if(key == null || key.length() ==0)
			return frequency;
		
		int hashValue = hashFunc(key);
		while(hashArray[hashValue] != null) {
			if(key.equals(hashArray[hashValue].value)) {
				frequency =  hashArray[hashValue].frequency;
				return frequency;
			}
			hashValue = (hashValue + 1) % hashArray.length;
		}
		return frequency ;
	}

	/**
	 * Removes and returns removed value
	 *
	 * @param value
	 *            String value to be removed
	 * @return value that is removed
	 */
	@Override
	public String remove(String key) {
		if(key == null || key.length() == 0)
			return null;
	
		for(int i = 0; i < key.length(); i++) {
			if(key.charAt(i) < 'a' || key.charAt(i) > 'z' ) {
				return null;
			}
		}
		
		int hashValue = hashFunc(key);
		while(hashArray[hashValue] != null) {
			if(key.equals(hashArray[hashValue].value)) {
				String deleItem = hashArray[hashValue].value;
				hashArray[hashValue] = DELETED;
				size --;
				return deleItem;
			}
			hashValue = (hashValue + 1) % hashArray.length;
		}
		return null;
	}

	/*
	 * Instead of using String's hashCode, you are to implement your own here,
	 * taking the table length into your account.
	 * 
	 * In other words, you are to combine the following two steps into one step
	 * here. 1. converting Object into integer value 2. compress into the table
	 * using modular hashing (division method)
	 * 
	 * Helper method to hash a string for English lowercase alphabet and blank,
	 * we have 27 total. But, you can assume that blank will not be added into
	 * your table. Refer to the instructions for the definition of words.
	 * 
	 * For example, "cats" : 3*27^3 + 1*27^2 + 20*27^1 + 19*27^0 = 60,337
	 * 
	 * But, to make the hash process faster, Horner's method should be applied
	 * as follows;
	 * 
	 * var4*n^4 + var3*n^3 + var2*n^2 + var1*n^1 + var0*n^0 can be rewritten as
	 * (((var4*n + var3)*n + var2)*n + var1)*n + var0
	 * 
	 * Note: You must use 27 for this homework.
	 * 
	 * However, if you have time, I would encourage you to try with other
	 * constant values other than 27 and compare the results but it is not
	 * required.
	 */
	private int hashFunc(String input) {
		if(input == null || input.length() ==0)
			return 0;
		
		int res = 0;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
				res =  (res * 27 + input.charAt(i) - 'a' + 1) % hashArray.length;
			}
		}
		return res;
	}

	// doubles array length and rehash items whenever the load factor is reached
	private void rehash() {
		if((double)size / hashArray.length > 0.5) {
			int len = hashArray.length * 2;
			while(!isPrime(len)){
				len ++;
			}
			System.out.println(String.format("Rehashing %d items, new size is %d", size, len));
			this.numOfCollisions = 0;
			this.size = 0;
			DataItem[] temp = hashArray;
			hashArray = new DataItem[len];
			for(int i = 0; i < temp.length; i++) {
				if(temp[i] != null && !temp[i].value.equals(DELETED.value)) {
					for(int j = 0; i < temp[j].frequency; j++) {
						this.insert(temp[j].value);
					}
					
				}
			}
		}
	}

	private boolean isPrime(int n) {
		return false;
	}

	// private static data item nested class
	private static class DataItem {
		private String value;
		private int frequency = 0;

		public DataItem(String value) {
			this.value = value;
		}
	}

}