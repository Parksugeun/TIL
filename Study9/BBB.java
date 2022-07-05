package inheritance;

public class BBB extends AAA {
	private int x = 300;//1234
	BBB() {
		System.out.println(x);
		//상위클래스의 멤버변수 private으로 상속하지 않는다.
		//System.out.println(n);
		// output()메소드 private 접근제한자로 상속이 되지 않는다.
		//output();
	}
}
