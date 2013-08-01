package cz.velim.deepcopy;

public class ClassA  implements Cloneable{

	private int a;
	private int b;

	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}

	public void memberSetter(int a, int b) {
		this.a = a;
		this.b = b;
	
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}
	
}
