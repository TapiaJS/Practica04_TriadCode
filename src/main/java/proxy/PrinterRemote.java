package proxy;

import proxy.state.State;

import java.rmi.*;

public interface PrinterRemote extends Remote {
    State getState() throws RemoteException;
}
