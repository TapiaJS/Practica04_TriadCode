package proxy.state;

import singleton.Printer;

public class WaitingState implements State {
    private static final long serialVersionUID = 2L;
    transient Printer printer;

    public WaitingState(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void waitingPrint() {
        System.out.println("La impresora esta esperando.");
    }

    @Override
    public void printing() {
        System.out.println("Cambiando estado a imprimiendo...");
        if(!printer.getPrinterQueue().isEmpty()){ // porque puede pasar que no haya en la cola
            printer.setState(new PrintingState(printer));
        }else{
            printer.setState(new PrintingState(printer));  // Transición al estado de impresión
        }
    }

    @Override
    public void printed() {
        System.out.println("No se puede marcar como impreso, no hay archivos en cola.");
    }
}