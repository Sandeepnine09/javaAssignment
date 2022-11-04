package abstractExample;

public class square extends shape {

	
	public square(int side)
	{
		super(side);
	}
	
	@Override
   public int calcArea()
   {
	  return this.getSide1() * this.getSide1();
   }
	
	@Override
	public int calcPerimeter()
	{
		return this.getSide1() * 4;
	}
}