package dfsdfd;

import java.util.ArrayList;
import java.util.Iterator;

public class ReverList {

	public static void main(String[] args) {

		ArrayList<Integer> a1 = new ArrayList();
		// System.out.println(a1);
		a1.add(1);
		a1.add(2);
		String rv = "";
		Iterator i1 = a1.iterator();
	    //String.join(",",a1);
		System.out.println("Initial list:");
		while (i1.hasNext()) {
			Object str = i1.next();
			System.out.println(str);
			rv = str + rv;
		}
		ArrayList a2 = new ArrayList();
		for (int i = 0; i < rv.toCharArray().length; i++){
		a2.add(rv.charAt(i));
		}
		Iterator i2 = a2.iterator();
		System.out.println("reverse List data:");
		while (i2.hasNext()) {
			Object str = i2.next();
			System.out.println(str);
		}
	}

}
