
import java.rmi.RemoteException;

public class CarImpl extends java.rmi.server.UnicastRemoteObject implements CarInterface {


    CarImpl() throws RemoteException {
        super();
    }
// implement method generatePlate() defined by carInterface
    public Car generatePlate(Car car) throws java.rmi.RemoteException {
        car.setPlate(Integer.toString(car.hashCode())); // generates plate number
        return car;
    }

}
