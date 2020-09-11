import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarInterface extends Remote {

    Car generatePlate(Car car) throws RemoteException;
}



