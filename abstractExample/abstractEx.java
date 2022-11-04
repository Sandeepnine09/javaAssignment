package abstractExample;

public class abstractEx {

	public static void main(String[] args) {
	
		shape s;
		
		//s = new shape(10);
		
	    s = new square(5);
	    
	    System.out.println(s.calcArea());
	    System.out.println(s.calcPerimeter());
	    
	    s = new rectangle(4,5);
	    
	    System.out.println(s.calcArea());
	    System.out.println(s.calcPerimeter());

	}

}
