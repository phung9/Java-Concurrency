
public class callByValue {

	public static void main( String[] args ) {
	    Dog aDog = new Dog("Max");
	    // we pass the object to foo
	    foo(aDog);
	    // aDog variable is still pointing to the "Max" dog when foo(...) returns
	    System.out.println("foo : "+aDog.getName()); // true, java passes by value
	    
	    foo2(aDog);
	    
	    System.out.println("foo2 : "+aDog.getName());
	}

	public static void foo(Dog d) {
	    d.getName().equals("Max"); // true
	    // change d inside of foo() to point to a new Dog instance "Fifi"
	    d = new Dog("Fifi");
	    d.getName().equals("Fifi"); // true
	}
	public static void foo2(Dog d){
		d.getName().equals("MAX");
		d.setName("FiFi");
	}
	
}
