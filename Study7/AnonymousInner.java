package InnerClass;

public class AnonymousInner {

	public AnonymousInner() {
		// 실행
		Student s = new Student() {
			//오버라이딩
			@Override
			public void studentOutput() {
				System.out.println("no="+ no);
				System.out.println("name="+name);
				System.out.println("grade="+grade);
			}
		};
		s.studentOutput();
		
	}
	
	public static void main(String[] args) {
		new AnonymousInner();

	}

}
