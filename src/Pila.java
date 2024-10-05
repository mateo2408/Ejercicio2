import java.util.Stack;

public class Pila {
    private Stack<Caja> cajas;
    private int capacidad;

    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.cajas = new Stack<>();
    }

    public boolean agregarCaja(Caja caja) {
        if (cajas.size() < capacidad) {
            cajas.push(caja);
            return true;
        }
        return false;
    }

    public Caja buscarCaja(int numero) {
        for (Caja caja : cajas) {
            if (caja.getNumero() == numero) {
                return caja;
            }
        }
        return null;
    }

    public Caja sacarCaja(int numero) {
        Stack<Caja> pilaAuxiliar = new Stack<>();
        Caja cajaEncontrada = null;

        while (!cajas.isEmpty()) {
            Caja caja = cajas.pop();
            if (caja.getNumero() == numero) {
                cajaEncontrada = caja;
                break;
            } else {
                pilaAuxiliar.push(caja);
            }
        }

        while (!pilaAuxiliar.isEmpty()) {
            cajas.push(pilaAuxiliar.pop());
        }

        return cajaEncontrada;
    }

    public Stack<Caja> getCajas() {
        return cajas;
    }
}