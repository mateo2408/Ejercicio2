public class Almacen {
    private Pila[] pilas;

    public Almacen(int numPilas, int capacidadPila) {
        pilas = new Pila[numPilas];
        for (int i = 0; i < numPilas; i++) {
            pilas[i] = new Pila(capacidadPila);
        }
    }

    public boolean agregarCaja(Caja caja) {
        for (Pila pila : pilas) {
            if (pila.agregarCaja(caja)) {
                return true;
            }
        }
        return false;
    }

    public String buscarCaja(int numero) {
        for (int i = 0; i < pilas.length; i++) {
            Caja caja = pilas[i].buscarCaja(numero);
            if (caja != null) {
                return "Caja encontrada en Pila " + (i + 1) + " en la posición " + (pilas[i].getCajas().size() - 1);
            }
        }
        return "Caja no encontrada";
    }

    public String sacarCaja(int numero) {
        for (int i = 0; i < pilas.length; i++) {
            Caja caja = pilas[i].sacarCaja(numero);
            if (caja != null) {
                return "Caja retirada de Pila " + (i + 1);
            }
        }
        return "Caja no encontrada";
    }

    public void imprimirPilas() {
        for (int i = 0; i < pilas.length; i++) {
            System.out.println("Pila " + (i + 1) + ": " + pilas[i].getCajas());
        }
    }
}