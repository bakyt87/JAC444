import java.rmi.Naming;

public class CarServer{

	public CarServer() {
		try {
			CarInterface carInt = new CarImpl();
			Naming.rebind("rmi://localhost:1099/CarRegistration", carInt);
			System.out.println("Server is running");
		}catch(Throwable e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		
		new CarServer();
	}
}
