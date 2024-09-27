package singleton;

import proxy.Employ;
import proxy.PrinterRemote;
import proxy.state.State;
import proxy.state.WaitingState;

import java.rmi.*;
import java.rmi.server.*;
import java.util.LinkedList;
import java.util.Queue;

public class Printer extends UnicastRemoteObject implements PrinterRemote {
    private static Printer printerUniqueInstance;
    private static final long serialVersionUID = 2L;
    private Queue<String> printerQueue;
    private Queue<Employ> employQueue;
    private State state;
    private Employ employ;

    private Printer() throws RemoteException {
        printerQueue = new LinkedList<>();
        employQueue = new LinkedList<>();
        state = new WaitingState(this);  // Estado inicial de la impresora
        employ = null;
    }

    // el patron singleton para que solo haya una instancia es nuestra impresora
    public static Printer getInstance() {
        if(printerUniqueInstance == null) {
            try {
                printerUniqueInstance = new Printer();
            } catch (RemoteException e) {
                System.err.println("Error al inicializar la impresora: " + e.getMessage());
                e.printStackTrace();
                System.exit(1);
            }
        }
        return printerUniqueInstance;
    }

    // agrega los archivos a la cola
    // aqui pensar en como agregar el state y
    public void addFile(String file, Employ employ){
        this.employQueue.add(employ);
        this.printerQueue.add(file);
        this.state.printing();
        this.state.printing();
    }

    @Override
    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    // imprime la cola de la impresora
    // Pensar en si también imprime al usuario que lo mandó en ese caso se me ocurre
    // Crear otra cola para el usuario e irlas imprimiendo al mismo tiempo
    public void printFiles(){
        if(printerQueue.isEmpty()) {
            state.waitingPrint();
            System.out.println("No hay archivos que imprimir");
            return;
        }
        state.printing();
        while(!printerQueue.isEmpty()){
            Employ currentEmploy = employQueue.poll();
            state.printing();
            if(currentEmploy.getArea().equals("Desarrollo y Mercadotecnia")){
                System.out.println(printerQueue.poll());
                System.out.println("El documento se imprimio a color por: " + currentEmploy.getName());
                return;
            }
            System.out.println(printerQueue.poll());
            System.out.println("El documento se imprimio en blanco y negro por: " + currentEmploy.getName());
        }
        state.printed();
        state.printed();
    }
}
