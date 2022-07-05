package InnerClass;

public class MethodInnerClass {
	int age = 25;
	public MethodInnerClass(){
		
	}
	public void start() {
		String tel = "010-7896-8547";
		//내부클래스 
		class InnerTest{
			int num = 100;
			String name="세종대왕";
			InnerTest() {}
			InnerTest(int num, String name){
				this.num = num;
				this.name = name;
			}
			void print() {
				System.out.println(num + "->"+ name);
				System.out.println("나이="+ age);
				System.out.println("연락처="+ tel);
				//System.out.println("주소="+addr);//클래스가 정의된 이후의 값은 접근 불가
			}
		}
		String addr = "영등포구 여의도동";
		////////////////////
		InnerTest it = new InnerTest(500,"이순신");
		it.print();
	}
	public static void main(String[] args) {
		MethodInnerClass mic = new MethodInnerClass();
		mic.start();

	}

}
