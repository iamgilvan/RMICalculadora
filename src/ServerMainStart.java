import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMainStart {
   
    public static void main(String[] args) {
        try {
            
            /*
            * Agora instancio um objeto registry
            * para que eu possa está registrando meu servidor
            * e coloca a porta da minha preferencia.
            * */
            Registry registry = LocateRegistry.createRegistry(1099);
            
            /*
            * eu instancio um objeto da class ICalculadora.java e
            * digo que essa instancia será = a minha class CalcServiceImpl.java
            * que foi quem ha implementou.     
            * */
            ICalculadora calc = new CalcServiceImpl();
            
            /*
            * Aqui eu registro um bind tipo de marcação para que
            * meu cliente reconheça as ações que ele irá receber
            * após envia os dados para serem processados no servidor.
            * */
            registry.bind("Calculo", calc);
            System.out.println(calc + "\n");
            System.out.println(registry + "\n");
            // Servidor está preparado para solicitações de clientes
            System.out.println("Calculadora Server ready.");
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e);
        }
    }
}