package inheritance;
//extend : 클래스를 상속받을 때 (1개만 상속가능)
public class Sedan extends Car {
	String color = "Red";
	public Sedan() {
		System.out.println("Sedan()생성자 메소드");
	}
	public Sedan(String color) {
		// 하위클래스의 생성자 메소드에서 상위클래스의 생성자메소드 호출
		// 반드시 첫번째 실행문으로 기술해야 한다.
		super("Lightblue", "소렌토"); // this ()
		//this.color = color;
		//상위클래스 하위클래스에 같은 멤버변수가 존재할때
		//상위클래스를 멤버변수를 지정한다.
		super.color = color;
		System.out.println(this.color +","+ super.color);
	}
	//override : 오버라딩, 상속관계에서 하위클래스에 메소드를 재정의
	public void speedUp() {
		speed += 10;
		if(speed>=200) speed = 200;
	}
	public void speedUp(int lbl) {
		speed +=lbl;
		if(speed>=200) speed = 200;
	}
	public static void main(String a[] ) {
		// 상속관계에서 생성자 메소드 상위클래스의 생성자가 먼저 실행된다.
		Sedan s = new Sedan();
		System.out.println("color="+ s.color);
		s.speedUp();
		System.out.println("speed="+s.speed);
		//////////////
		Sedan ss = new Sedan("Blue");
		System.out.println("Sedan.color->"+ ss.color);
	}

}
