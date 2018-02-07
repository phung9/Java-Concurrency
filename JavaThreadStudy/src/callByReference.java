
public class callByReference {
	public static void main(String[] args){
		Number n = new Number();
		n.a = 10;
		n.b = 20;
		System.out.println("a : " + n.a + ", b : " + n.b);
		swap(n.a,n.b);
		System.out.println("a : " + n.a + ", b : " + n.b);
	}
	public static void swap (int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}
}
class Number {
	public int a;
	public int b;
}
