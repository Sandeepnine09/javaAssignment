package abstractExample;

public abstract class shape {
	
	
	private int side1,side2,side3;
	
	
	public  shape()
	{
		
	}
	
	public shape(int side)
	{
		this.side1=this.side2=this.side3=side;
	}
	
	
	public shape(int side1,int side2)
	{
		this.side1=side1;
		this.side2=side2;
	}
	
	

	public int getSide1() {
		return side1;
	}

	public void setSide1(int side1) {
		this.side1 = side1;
	}

	public int getSide2() {
		return side2;
	}

	public void setSide2(int side2) {
		this.side2 = side2;
	}

	public int getSide3() {
		return side3;
	}

	public void setSide3(int side3) {
		this.side3 = side3;
	}
	
	public abstract  int calcArea();
	
	public abstract int calcPerimeter();
	

}
