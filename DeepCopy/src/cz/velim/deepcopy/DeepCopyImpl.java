package cz.velim.deepcopy;

public class DeepCopyImpl implements Cloneable {
	private int p;
	private ClassA classA;

	public DeepCopyImpl() {
		this.p = 15;
		this.classA = new ClassA();
	}

	public Object clone() throws CloneNotSupportedException {
		DeepCopyImpl dci = (DeepCopyImpl) super.clone();
		dci.classA = (ClassA) dci.classA.clone();
		return dci;
	}

	/**
	 * @param args
	 * @throws CloneNotSupportedException
	 */
	public static void main(String[] args) throws CloneNotSupportedException {

		DeepCopyImpl dci = new DeepCopyImpl();
		DeepCopyImpl dciCloned = (DeepCopyImpl) dci.clone();

		dci.classA.memberSetter(1, 1);
		dciCloned.classA.memberSetter(3, 3);

		System.out.println("original object: a =  " + dci.classA.getA()
				+ ", b =  " + dci.classA.getB() + ", p =  " + dci.p);
		System.out
				.println("cloned object: a =  " + dciCloned.classA.getA()
						+ ", b =  " + dciCloned.classA.getB() + ", p =  "
						+ dciCloned.p);
	}

}
