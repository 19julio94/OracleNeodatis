package pasaxeirosvoosoracleneodatis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Pasaxeirosvoosoracleneodatis {

    public static final String ODB_NAME = "internacional";

    ODB odb = null;

    static Connection conn = null;

    public static void Conexion() throws SQLException {

        String driver = "jdbc:oracle:thin:";
        String host = "localhost.localdomain";
        String porto = "1521";
        String sid = "orcl";
        String usuario = "hr";
        String password = "hr";
        String url = driver + usuario + "/" + password + "@" + host + ":" + porto + ":" + sid;
        conn = DriverManager.getConnection(url);

        if (conn != null) {

            System.out.println("Conexion realizada");

        } else {

            System.out.println("Erro ao conectar");
        }
    }

    public static void Cerrar() throws SQLException {
        conn.close();

    }

    public static void main(String[] args) throws SQLException {
        Conexion();
        Metodos();
        Cerrar();
    }

    public static void Metodos() throws SQLException {
        ODB odb = ODBFactory.open(ODB_NAME);

        Objects<Reserva> lista = odb.getObjects(Reserva.class);

        Reserva res = null;

        while (lista.hasNext()) {
            res = lista.next();

            res.setConfirmado(1);

            odb.store(res);

            int cod = res.getCodr();
            int ida = res.getIdvooida();
            int volta = res.getIdvoovolta();
            int prezoreserva = res.getPrezoreserva();
            int confirmado = res.getConfirmado();
            String dni = res.getDni();

            System.out.println("COD :" + cod + " IDA: " + ida + " VOLTA: " + volta + " PREZO:" + prezoreserva + " CONFIRMADO: " + confirmado);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select nreservas from pasaxeiros where DNI='" + dni + "'");
            while (rs.next()) {

                int reserva = rs.getInt(1) + 1;

                System.out.println("NRESERVA: " + reserva);

                //st.executeUpdate("UPDATE pasaxeiros SET nreservas=" + reserva + " WHERE dni='" + dni + "'");
               // System.out.println("UPDATE FINALIZADO");
            }
            int prezovolta = 0;
            int prezoida = 0;
            int total ;
            ResultSet rs2 = st.executeQuery("Select prezo from voos where voo=" + ida);

            while (rs2.next()) {

                prezoida = rs2.getInt(1);

                System.out.println(prezoida);
            }
            ResultSet rs3 = st.executeQuery("Select prezo from voos where voo=" + volta);
            while (rs3.next()) {

                prezovolta = rs3.getInt(1);

                System.out.println(prezovolta);
            }

            total = prezoida + prezovolta;

            res.setPrezoreserva(total);
            odb.store(res);
        }
        odb.close();
    }
    
}
