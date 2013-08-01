package cz.velim.immutableobject;

public class ImmObject {
	private ClassA classA;
	
	public ImmObject(){
		classA = new ClassA();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImmObject immobject = new ImmObject();
		System.out.println(immobject.classA.getA());
	}


}
