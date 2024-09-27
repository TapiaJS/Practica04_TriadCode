package proxy.state;

import singleton.Printer;

public class PrintedState implements State {
    private static final long serialVersionUID = 2L;
    transient Printer printer;

    public PrintedState(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void waitingPrint() {
        System.out.println("Preparando la impresora para el proximo trabajo...");
        printer.setState(new WaitingState(printer));  // Transición de nuevo al estado de espera
    }

    @Override
    public void printing() {
        System.out.println("No hay archivos que imprimir. Volviendo a esperar.");
    }

    @Override
    public void printed() {
        System.out.println("La impresora ha terminado de imprimir.");
    }
}
