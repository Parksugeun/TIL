package inheritance;

import pac.Information;

public class Student extends Information{ 

	public static void main(String[] args) {
		//패키지가 다르기 때문에 접근할 수 없다.
		//Information i = new Information();
		Student s = new Student();
		System.out.println("userid->"+s.userid);
	
		Information ii = Information.getInstance();
	}

}
