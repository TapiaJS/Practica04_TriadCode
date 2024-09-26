package proxy;

import java.rmi.*;

public interface PrinterRemote extends Remote {
    // Si se agrea la cola de empleados por aqui podria estar
    public State getState() throws RemoteException;
    // getEmpleado o no se
    //
}
