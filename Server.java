import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server {
    public Server() {
    }
    public static void main(String[] argv) {
        try {
            Cities cities = new
                    Cities(new String[]{"москва", "санкт-петербург", "челябинск","анапа"});
            AdditionInterface stub = (AdditionInterface)
                    UnicastRemoteObject.exportObject(cities, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Addition", stub);
            System.err.println("Server ready");
        } catch (Exception ex) {
            System.err.println("Server exception: " + ex.toString());
            ex.printStackTrace();
        }
    }
}
