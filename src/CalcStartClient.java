import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class CalcStartClient {
    
    private static double x;
    private static double y;
    private static ICalculadora myCalc;
    private static Scanner scanner;
    
    // Aqui será simulado o "menu"
    public static void listaMetodos() {
       System.out.println("/****************************************/");
       System.out.println("/* Sistema para pequenos cálculos */");
       System.out.println("/* Calculadora Distribuída */");
       System.out.println("/****************************************/\n");
       System.out.println("Escolha uma opção:");
       System.out.println("1 => (+) Adição");
       System.out.println("2 => (-) Subtração");
       System.out.println("3 => (*) Multiplicação");
       System.out.println("4 => (/) Divisão");
       System.out.println("5 => Sair");
       System.out.println("Digite sua opção: ");
       System.out.println("/****************************************/");
    }

    // Aqui será o método a ser executado será escolhido
    // de acordo com a opção passada pelo teclado
    public static void executeMetodo(int opcao) {
        try
        {
            switch (opcao) {
            case 1:
                System.out.println("Operador de Adição escolhido.");
                soma();
                break;
            case 2:
                System.out.println("Operador de Substração escolhido.");
                subtrair();
                break;
            case 3:
                System.out.println("Operador de Multiplização escolhido.");
                multiplica();
                break;
            case 4:
                System.out.println("Operador de Divisão escolhido.");
                divide();
                break;
            case 5:
                System.out.println("Encerrado");  
                System.exit(0);
            default:
                System.out.println("Opção inválida");
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void soma() throws RemoteException, NotBoundException {
        System.out.println("Digite o primeiro número:");
        x = scanner.nextDouble();
        System.out.println("Digite o segundo número:");
        y = scanner.nextDouble();
        double resultSum = myCalc.sum(x, y);
        System.out.println("Soma: " + resultSum);
    }
    
    private static void subtrair() throws RemoteException, NotBoundException {
        System.out.println("Digite o primeiro número:");
        x = scanner.nextDouble();
        System.out.println("Digite o segundo número:");
        y = scanner.nextDouble();
        double resultSub = myCalc.sub(x, y);
        System.out.println("Subtração: " + resultSub);
    }
    
    private static void multiplica() throws RemoteException, NotBoundException {
        System.out.println("Digite o primeiro número:");
        x = scanner.nextDouble();
        System.out.println("Digite o segundo número:");
        y = scanner.nextDouble();
        double resultMult = myCalc.mult(x, y);
        System.out.println("Multiplicação: " + resultMult);
    }
    
    private static void divide() throws RemoteException, NotBoundException {
        System.out.println("Digite o primeiro número:");
        x = scanner.nextDouble();
        System.out.println("Digite o segundo número:");
        y = scanner.nextDouble();
        double resultDiv = myCalc.div(x, y);
        System.out.println("Divisão: " + resultDiv);
    }

    public static void main(String[] args) {
        try 
        {
          // Localiza o serviço pelo nome
          myCalc = (ICalculadora) Naming.lookup("rmi://127.0.1.1:1099/Calculo");
            
          scanner = new Scanner(System.in);
          int opcao;

          while (true) {
              listaMetodos();
              opcao = scanner.nextInt();
              executeMetodo(opcao);
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}