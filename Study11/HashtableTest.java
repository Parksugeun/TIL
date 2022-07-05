package basic05_collection;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class HashtableTest {

	public HashtableTest() {
		
	}
	public void start() {
		// Map : key¿Í value¸¦ ÀÌ¿ëÇÏ¿© °´Ã¼¸¦ »ç¿ëÇÑ´Ù.
		//       key Áßº¹µÇ¸é ¾ÈµÈ´Ù.
		
		Hashtable<String, MemberVO> ht = new Hashtable<String, MemberVO>();
		
		ht.put("1", new MemberVO(1000, "È«±æµ¿","ÃÑ°ýºÎ","010-1111-2222"));
		ht.put("A", new MemberVO(2000, "È«±æµ¿2","ÃÑ°ýºÎ","010-1111-9999"));
		ht.put("±è±æµ¿", new MemberVO(3000, "±è±æµ¿","ÃÑ°ýºÎ","010-1111-4444"));
		ht.put("B", new MemberVO(4000, "È«±æµ¿3","ÃÑ°ýºÎ","010-1111-8888"));
		ht.put("100", new MemberVO(5000, "È«±æµ¿4","ÃÑ°ýºÎ","010-1111-3333"));
	
		//Å°¸¦ ÀÌ¿ëÇÑ °´Ã¼¾ò¾î¿À±â
		MemberVO vo1 = ht.get("B");
		System.out.println(vo1.toString());
		System.out.println("*******************************");
		// key ¸ñ·Ï ±¸ÇÏ±â
		Set<String> keyList = ht.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			String key = ii.next();
			MemberVO vo2 = ht.get(key);
		System.out.println(vo2.toString());
		}
		System.out.println("---------------------------------------");
		
		// value ¸ñ·Ï ±¸ÇÏ±â
		Collection<MemberVO> value = ht.values();
		Iterator<MemberVO> iii = value.iterator();
		while(iii.hasNext()) {
			System.out.println(iii.next().toString());
		}
	}
	public static void main(String[] args) {
		new HashtableTest().start();

	}

}
