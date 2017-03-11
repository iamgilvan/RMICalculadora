import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadora extends Remote {
   
    public double sum(double x, double y) throws RemoteException;
    
    public double sub(double x, double y) throws RemoteException;
    
    public double mult(double x, double y) throws RemoteException;
    
    public double div(double x, double y) throws RemoteException;  
}