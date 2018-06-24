package Java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Collections {

	public static void main(String[] args) {

		Map<Integer, String> mp = new HashMap<>();

		mp.put(1, "apple");
		mp.put(2, "pear");
		mp.put(3, "watermelon");

		/*
		 * Iterator it=mp.keySet().iterator(); while(it.hasNext()) {
		 * System.out.println(it.next()); }
		 */

		/*
		 * Iterator it=mp.entrySet().iterator(); while(it.hasNext()) {
		 * System.out.println(it.next()); }
		 */

		for (Integer m : mp.keySet()) {
			System.out.println(mp.get(m));

		}
		
		for (Map.Entry<Integer, String> n: mp.entrySet()) {
			System.out.println(n);
			
		}
		
		
	
	}

}
