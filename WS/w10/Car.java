import java.io.Serializable;
// Car class 
public class Car implements Serializable{
	
	private String model;
	private String color;
	private double mileage;
	private String plate;
	
	public Car(String model, String color, double mileage) {
		super();
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.plate = "Not registered"; // plate is set to default
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	@Override
	public String toString() {
		return "Car model=" + model + ", color=" + color + ", mileage=" + mileage + ", plate=" + plate;
	}
	
	
    
	

}
