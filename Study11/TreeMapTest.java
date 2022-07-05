package basic05_collection;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
		
	}
	public void star() {
		// TreeMap : key¿Í value¸¦ ÀÌ¿ëÇÏ¿© ÄÃ·º¼ÇÀ» »ç¿ëÇÑ´Ù
		//			 key¸¦ ±âÁØÀ¸·ÎÇÑ´Ù
		TreeMap<String, MemberVO> tm = new TreeMap<String, MemberVO>();
		
		tm.put("1", new MemberVO(1000, "È«±æµ¿","ÃÑ°ýºÎ","010-1111-2222"));
		tm.put("A", new MemberVO(2000, "È«±æµ¿2","ÃÑ°ýºÎ","010-1111-9999"));
		tm.put("±è±æµ¿", new MemberVO(3000, "±è±æµ¿","ÃÑ°ýºÎ","010-1111-4444"));
		tm.put("B", new MemberVO(4000, "È«±æµ¿3","ÃÑ°ýºÎ","010-1111-8888"));
		tm.put("100", new MemberVO(5000, "È«±æµ¿4","ÃÑ°ýºÎ","010-1111-3333"));
	
		Set<String> keys = tm.keySet();
		Iterator<String> keyList = keys.iterator();
		while(keyList.hasNext()) {
			String key = keyList.next();
			MemberVO vo = tm.get(key);
			System.out.println(key+"->"+vo.toString());
		}
	}
	public static void main(String[] args) {
		new TreeMapTest().star();

	}

}
