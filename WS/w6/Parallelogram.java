package shapes;

public class Parallelogram extends Rectangle{
	
	
	public Parallelogram(double width, double height) throws Exception {
		super(width, height);
	}
	


	@Override
	public double getPerimeter() {
		return (getWidth()+getHeight())*2;
	}
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+ " {w="+getWidth()+", h="+getHeight()+"} perimeter = "
				+ String.format("%.4f", getPerimeter());
	}

}
