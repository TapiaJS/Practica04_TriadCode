package proxy.state;

import singleton.Printer;

public class PrintingState implements State {
    private static final long serialVersionUID = 2L;
    transient Printer printer;

    public PrintingState(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void waitingPrint() {
        System.out.println("No se puede esperar, la impresora esta imprimiendo.");
    }

    @Override
    public void printing() {
        System.out.print("La impresora está imprimiendo:");
    }

    @Override
    public void printed() {
        System.out.println("Cambiando estado a impreso...");
        printer.setState(new PrintedState(printer));  // Transición al estado impreso
    }
}
