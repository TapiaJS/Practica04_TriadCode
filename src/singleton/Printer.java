package singleton;

import proxy.Employ;
import proxy.PrinterRemote;
import proxy.PrinterState;
import proxy.State;

import java.rmi.*;
import java.rmi.server.*;
import java.util.LinkedList;
import java.util.Queue;

public class Printer extends UnicastRemoteObject implements PrinterRemote {
    private static final long serialVersionUID = 2L;
    private Employ employ;
    private State state;
    private Queue<String> queuePrinter;
    private static Printer printerUniqueInstance;

    private Printer() throws RemoteException {
        queuePrinter = new LinkedList<>();
        state.waitingPrint();
        state = new PrinterState();
        employ = null;
    }

    // el patrón singleton para que solo haya una instancia es nuestra impresora
    public static Printer getInstance() {
        if(printerUniqueInstance == null) {
            try{
                printerUniqueInstance = new Printer();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return printerUniqueInstance;
    }
    // agrega los archivos a la cola
    // aqui pensar en como agregar el state y
    public void addFile(String file, Employ employ){
        this.employ = employ;
        queuePrinter.add(file);
        this.state.printing();
    }
    public State getState(){
        return state;
    }
    public void setState(State state){
        if(state == null)
            throw new NullPointerException();
        this.state = state;
    }
    // imprime la cola de la impresora
    // Pensar en si también imprime al usuario que lo mandó en ese caso se me ocurre
    // Crear otra cola para el usuario e irlas imprimiendo al mismo tiempo
    public void printFiles(){
        if(queuePrinter.isEmpty()) {
            state.waitingPrint();
            System.out.println("No hay archivos que imprimir");
            return;
        }
        state.printing();
        while(!queuePrinter.isEmpty()){
            if(employ.getArea().equals("Desarrollo y Mercadoctenia")){
                System.out.println("El documento se imprimió a color:" );
                System.out.println("Se está imprimiendo: " +queuePrinter.poll());
                return;
            }
            System.out.println("El documento se imprimió en blanco y negro" );
            System.out.println("Se está imprimiendo: " +queuePrinter.poll());
        }
        state.printed();
    }

}
