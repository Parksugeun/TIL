package inheritance;



public class TypeCasting {

	public static void main(String[] args) {
		
		
		double n = 5.25;
		int i = (int)n;
		
		Sedan s = new Sedan();
		Car c = new Car();
		Car cc = new Sedan();
		//Sedan ss = new Car();
		Object obj = new Sedan();
		
		//하위클래스의 오버라이딩은 상위클래스로 형변환되어도 하위클래스의 메소드기능이 구현된다.
		cc.speedUp();
		System.out.println("cc.speed->"+ cc.speed);
		
		//cc.speedUp(20);
		
		Sedan sss = (Sedan)cc;
		sss.speedUp(30);
		
		Object oo = new Sedan();
		//oo.speedUp();
		Sedan ssss = (Sedan)oo;
		ssss.speedUp();
		
		Object o1 = new String();
		Object o2 = new Scanner(System.in);
		
		//Scanner scan = (Scanner)o2;
		scan.nextInt();
		
	}

}
