package srikanth;


public class Constructorrr {

	public Constructorrr() {
		this(10);
		System.out.println("default");
	}

	public Constructorrr(int a) {
		this(23, 24);
		System.out.println("one arg");
	}

	public Constructorrr(int b, int c) {
		this(25, 36, 46);
		System.out.println("two arg");
	}

	public Constructorrr(int d, int e, int f) {
		System.out.println("three arg");
	}
	
	public static void main(String[] args) {
		Constructorrr p = new Constructorrr();
	}
}