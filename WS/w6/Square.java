package shapes;


public class Square implements Shape{
	double side;
	Shape squareArea;

	
	public Square(double side) throws SquareException{
		setSide(side);
	}
	
	public double getSide() {
		return side;
	}
   
	public void setSide(double side) throws SquareException  {
		if(side > 0) {
		this.side = side;
		}
		else {
			throw new SquareException("Invalid side!");
		}
	}
	
	@Override
	public double getPerimeter() {
		return side*4;
	}

   
	

	//lambda
	Area area = ()-> getSide()*getSide();
	
	public double squareArea(double side, Area area) {
		return area.getArea();
	}
	

	@Override
	public double getArea() {
		return squareArea(getSide(), area);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+ " {s="+getSide()+"} perimeter = "
				+ String.format("%.4f",getPerimeter())+" area = "+String.format("%.4f",getArea());
	}
}
