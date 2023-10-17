package Thread;

public class w3Q1 extends Thread {
	
	@Override
	public void run() {
		System.out.println("Hello World");
		System.out.println(this.getName());
	}
	
	public static void main(String[] args) {
		new w3Q1().start();
	}
}
