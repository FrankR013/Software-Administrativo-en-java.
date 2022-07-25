
package Principal;
import vitas.*;
import Modelo.*;
public class main {
    public static void main(String[] args) {
        
        login login = new login();
        login.setVisible(true);
        Conexion conexion = new Conexion();
        conexion.getConection();
        
        
        
    }
}
