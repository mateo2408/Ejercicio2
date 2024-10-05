public class Caja {
    private int numero;
    private String nombreEmpresa;

    public Caja(int numero, String nombreEmpresa) {
        this.numero = numero;
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    @Override
    public  String toString(){
        return "Caja numero: " + numero + " de la empresa: " + nombreEmpresa;
    }
}
