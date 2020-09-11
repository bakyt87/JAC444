

package shapes;
import java.io.*; 


class Main{
	public static void main(String[] args) throws Throwable {
		System.out.println("------->JAC 444 Workshop 6<-------\r\n" + 
				"------->Task 4 ... <-------");
		Shape shape[] = new Shape[50]; // array size
		int numShapes = 0;  // number of items in array
		double minTriangle = 0;
		double maxCircle = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
			String line;
			
			while ((line = br.readLine()) != null) {
			String[] tokens = line.split(",");
			
			/**
			 * switch case to create shape objects
			 */
			switch (tokens[0]) {
			
			
			case "Circle" :
				
				if(tokens.length == 2) {  // if the line has two tokens
				    double radius = Double.parseDouble(tokens[1]);
				    try {
				    if(radius > 0) {
				    Circle c = new Circle(radius);
						if(maxCircle == 0 || maxCircle > c.getPerimeter()) {
							maxCircle = c.getPerimeter();
						}
				         shape[numShapes++] = c; // add to shape array
				    }
				    }catch(CircleException e) {
				    	System.out.println(e.getMessage());
				    } 
				}
			case "Square" :
				
				if(tokens.length == 2 ) { // if the line has two tokens
					  double side = Double.parseDouble(tokens[1]);
					  try {
					  if(side > 0) {
					   Square s = new Square(side);
				       shape[numShapes++] = s;
					  }
					  }catch(SquareException e) {
						  System.out.println(e.getMessage());
					  }
				}
				break;
			case "Rectangle" :
				
				if(tokens.length == 3) { // if line has 3 tokens
					double width = Double.parseDouble(tokens[1]);
					double height = Double.parseDouble(tokens[2]);
					try {
					if(width > 0 && height > 0) {
						shape[numShapes++] = new Rectangle(width, height);
					}
				}
				
				catch (RectangleException e) {
					System.out.println(e.getMessage());
				}
				}
				break;
			case "Parallelogram" :
				
				if(tokens.length == 3) { // if line has 3 tokens
					double width = Double.parseDouble(tokens[1]);
					double height = Double.parseDouble(tokens[2]);
					try {
					if(height > 0 && width > 0) {
					shape[numShapes++] = new Parallelogram(width, height);// add to shape array
				}
					}
					catch(RectangleException e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case "Triangle" :
				
                 if(tokens.length == 4) { // if line has 4 tokens
					double side1 = Double.parseDouble(tokens[1]);
					double side2 = Double.parseDouble(tokens[2]);
					double side3 = Double.parseDouble(tokens[3]);
					try {
					if(side1 > 0 && side2 > 0 && side3 > 0 && side1+side2 > side3
						&& side1+side3 >side2 && side2+side3 >side3) {
					Triangle t = new Triangle(side1, side2, side3);
						if(minTriangle == -1 || minTriangle < t.getPerimeter()) {
							minTriangle = t.getPerimeter();
						}
						shape[numShapes++] = t;// add to shape array
					}
					}catch(TriangleException e) {
						System.out.println(e.getMessage());
					}
                 }
             default :
            	 
            	 line.split(" ");
				break;	
			}
			}
			} catch (IOException e) {
				System.out.println(e.getMessage());
				}
		
		for(int i=0; i<numShapes; i++) {
			if(shape[i].getPerimeter() < 0.0001) {
				shape[i] = null;
				numShapes--;
			}
		}
		
	            System.out.println("\n"+numShapes+" shapes were created:"); // total items were created
	
        // deleting minTriangle
	            for(int i = 0; i < numShapes; i++) {
	            	if(shape[i] instanceof Triangle && shape[i].getPerimeter() == minTriangle) {
	            		System.out.println("Removing "+ shape[i]);
	            		for(int j = i; j < numShapes -1; j++) {
	            			shape[j] = shape[j + 1];
	            		}
	            		numShapes --;
	            		i -- ;
	            	}
	             // deleting maxCircle
	            	if(shape[i] instanceof Circle && shape[i].getPerimeter() == maxCircle) {
	            		System.out.println("Removing "+ shape[i]);
	            		for(int j = i; j < numShapes -1; j++) {
	            			shape[j] = shape[j + 1];
	            		}
	            		numShapes --;
	            		i -- ;
	            	}
	            }
	           
	            double totalParallelogramPerimeter = 0;
	            double totalTrianglePerimeter = 0;
	            // Sum up perimeters of Parallelogram
	            for(int i = 0; i < numShapes; i++) {
	            	if(shape[i] instanceof Parallelogram ) {
	            		totalParallelogramPerimeter += shape[i].getPerimeter();
	            	}
	            
	         // Sum up perimeters of Triangle
	            	 if(shape[i] instanceof Triangle ) {
	                 		totalTrianglePerimeter += shape[i].getPerimeter();
	                 	}
	            	 
	            	System.out.println();
	            	System.out.println(shape[i].toString());
	            }
			
			System.out.println("\n------->Task 3 ... <-------\r\n" + 
					"");
			System.out.println("Total perimeter of Parallelogram is:"+String.format("%.4f", totalParallelogramPerimeter));
			System.out.println("Total perimeter of Triangle is:"+ String.format("%.4f", totalTrianglePerimeter));
		}
      }
		

	
				
				
				
			
 					
				
				
			
