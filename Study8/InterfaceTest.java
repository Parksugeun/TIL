package basic03_oop;
//인터페이스는 추상메소드들과 stactic final변수들이 존재하는 클래스
public interface InterfaceTest {
	public static final int MAX = 100;
	public static final int MIN = 1;
	
	public void write();
	public void show();
	public int getName();
}
