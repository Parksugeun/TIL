package InnerClass;
//내부클래스는 클래스 내의 클래스를 말한다.
//1. 클래스의 멤버영역에 내부클래스 만들기
//2. 메소드내에 내부클래스 만들기
//3. 익명의 내부클래스 만들기 - 메소드내에 생성하여야 한다.
public class OuterClass {
	String name="홍길동";
	int age = 30;
	//
	public OuterClass() {
		//외부클래스의 멤버변수, 메소드는 내부클래스에서 접근이 불가능하고
		//내부클래스에서는 외부클래스의 멤버변수, 메소드를 접근할 수 있다.
		//System.out.println(addr);
	}
	public void output() {
		System.out.println("이름="+name);
	}
	//내부클래스
	class InnerClass{
		String addr = "강남구 역삼동";
		InnerClass() {
			output();
		}
		void memberOutput() {
			System.out.println("주소="+addr);
			System.out.println("이름="+ name +", 나이="+ age);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		//내부클래스를 사용하기 위해서는 외부클래스가 객체 생성되어야 한다.
		//1. 객체생성방법
		OuterClass oc = new OuterClass();
		OuterClass.InnerClass ic = oc.new InnerClass();
		ic.memberOutput();
		// 내부클래스 객체에서 외부클래스의 변수, 메소드는 호출할 수 없다.
		//ic.output();
		//oc.output();
		//2. 객체생성방법
		OuterClass.InnerClass ic2= new OuterClass().new InnerClass();
		ic2.memberOutput();
		
		//ic2.output();
	}
	//
}
