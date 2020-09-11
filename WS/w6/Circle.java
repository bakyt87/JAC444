package shapes;

public class Circle implements Shape, Area{
	
    private double radius;
    //private final double PI= Math.PI;
    Shape circleArea;
    
	public Circle(double radius) throws CircleException {
		setRadius(radius);
	}
	
    
	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius)throws CircleException {
		if(radius > 0) 
		{
		this.radius = radius;
		}
		else
		{
			throw new CircleException("Invalid radius!");
		}
	}

    @Override
	public double getPerimeter() {
		return Math.PI*(getRadius()*2);
	}
	
    // lambda
    Area area = ()->  Math.PI *(getRadius() * getRadius());
    
    public double circleArea(double radius, Area area) {
    	return area.getArea();
    }
    
    @Override
	public double getArea() {
		return circleArea(getRadius(), area);
	}
    
    @Override
	public String toString() {
		return this.getClass().getSimpleName()+ " {r="+getRadius()+"} perimeter = "
				+String.format("%.4f",getPerimeter())+" area = "+String.format("%.4f",getArea());
	}
    }
