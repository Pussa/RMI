import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdditionInterface extends Remote {
    public String Work(String city) throws RemoteException;
}
