

package pasaxeirosvoosoracleneodatis;

public class Reserva {
 private int codr;
 private String dni;
 private int idvooida;
 private int idvoovolta ;
 private int prezoreserva;
 private int confirmado; 

    public Reserva(int codr, String dni, int idvooida, int idvoovolta, int prezoreserva, int confirmado) {
        this.codr = codr;
        this.dni = dni;
        this.idvooida = idvooida;
        this.idvoovolta = idvoovolta;
        this.prezoreserva = prezoreserva;
        this.confirmado = confirmado;
    }

    public int getCodr() {
        return codr;
    }

    public void setCodr(int codr) {
        this.codr = codr;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdvooida() {
        return idvooida;
    }

    public void setIdvooida(int idvooida) {
        this.idvooida = idvooida;
    }

    public int getIdvoovolta() {
        return idvoovolta;
    }

    public void setIdvoovolta(int idvoovolta) {
        this.idvoovolta = idvoovolta;
    }

    public int getPrezoreserva() {
        return prezoreserva;
    }

    public void setPrezoreserva(int prezoreserva) {
        this.prezoreserva = prezoreserva;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "codr=" + codr + ", dni=" + dni + ", idvooida=" + idvooida + ", idvoovolta=" + idvoovolta + ", prezoreserva=" + prezoreserva + ", confirmado=" + confirmado + '}';
    }
 
 
 
}
