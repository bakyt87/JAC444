import java.rmi.Naming;

public class CarClient {
	public static void main(String[] args) throws java.rmi.RemoteException {
		
		Car car = new Car("Lexus", "black", 7777); //car object
		System.out.println(car.toString());
		
		try {
			CarInterface carInt = (CarInterface) Naming.lookup("rmi://localhost:1099/CarRegistration"); //searches for the server
			car = carInt.generatePlate(car);
			System.out.println(car.toString());
		}catch(Throwable e){
			System.out.println(e);
		}
	}

}
