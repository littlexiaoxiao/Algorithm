package MyStack;

public class MyStackTest {

	public static void main(String[] args) {
		MyArrayStack<Integer> astack = new MyArrayStack<Integer>();
		System.out.println("astack size = " + astack.size());
		for(int i = 1; i <= 30; i++) {
			astack.push(i);
		}
		astack.display();
		astack.poll();
		astack.poll();
		astack.poll();
		astack.poll();
		astack.display();
		System.out.println("astack size = " + astack.size());
		System.out.println("astack.peek() = " + astack.peek());
	}

}
