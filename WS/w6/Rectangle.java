	package shapes;
	
	public class Rectangle implements Shape{
		private double width;
		private double height;
		Shape rectangleArea;
		
		public Rectangle( double width, double height) throws RectangleException {
			setHeight(height);
			setWidth(width);
		}
		
		public double getWidth() {
			return width;
		}
		
		public void setWidth(double width) throws RectangleException {
			if(width > 0) {
				this.width = width;
			}
			else {
				throw new RectangleException("Invalid rec side(s)!");
			}
		}
		
		public double getHeight() {
			return height;
		}
		
		public void setHeight(double height) throws RectangleException {
			if(height > 0) {
				this.height = height;
			}
			else {
				throw new RectangleException("Invalid rec side(s)!");
			}
			
		}
		
		
		
		@Override
		public double getPerimeter() {
			
			return 2*(getHeight()+getWidth());
		}
        // lambda
		Area area =()-> getWidth()*getHeight();
		
		public double rectangleArea(double width, double height, Area area) {
			
			return area.getArea();
		}

		@Override
		public double getArea() {
			
			return rectangleArea(getWidth(), getHeight(), area);
		}
		
		@Override
		public String toString() {
			return this.getClass().getSimpleName()+ " {w="+getWidth()+", h="+getHeight()+"} perimeter = "
					+ String.format("%.4f", getPerimeter())+" area = "+ String.format("%.4f",getArea());
		}
	
	}
