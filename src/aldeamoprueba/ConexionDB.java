package aldeamoprueba;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionDB {
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USUARIO = "root";
    private static String PASSWORD = "Daniel950908*";
    private static String URL = "jdbc:mysql://127.0.0.1:3306/bartender";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL DRIVER" + e);
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la Conexion" + e);
        }
        return con;
    }
    public String ejecutarConsulta(Connection con, String a) {
        try {
            String SQL = "SELECT * FROM arrays WHERE id ="+a;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                System.out.println(rs.getString("input_array"));
                return rs.getString("input_array");
            }
  
            rs.close();
            stmt.close();
            }
            catch (Exception e) {
            e.printStackTrace();
            }
        return "";
    }
     
}
