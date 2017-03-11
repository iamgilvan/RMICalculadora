import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcServiceImpl extends UnicastRemoteObject implements ICalculadora{
        
    public CalcServiceImpl() throws RemoteException {
        super();
    }
    
    @Override
    public double sum(double x, double y) throws RemoteException {
        return x + y;
    }
    
    @Override
    public double sub(double x, double y) throws RemoteException {
        return x - y;
    }
    
    @Override
    public double mult(double x, double y) throws RemoteException {
        return x * y;
    }
    
    @Override
    public double div(double x, double y) throws RemoteException {
        return x / y;
    }
}