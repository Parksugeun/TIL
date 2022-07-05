package InnerClass;

class Test {
	public int a=3;
	public void print() {a+=5; System.out.print("f");}
	
	class Ex extends Test{
		public int a=8;
		public void print() {this.a+=5; 
		System.out.print("b");
		}
	}
	public class Sam {
		public static void main(String[] args) {
		Test ob = new Ex();
		ob.print();
		System.out.print(ob.a);
	}

}
}