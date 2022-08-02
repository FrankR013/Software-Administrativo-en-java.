
package Controlador;

import Modelo.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ComboboxSucursal {
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;

    public ComboboxSucursal() {
        
        
    }
    
    public  ArrayList gatListaSucursalkes(){
        System.out.println("Funcion get lista() "); 
        ArrayList mListasucursales = new ArrayList();
        Sucursal sucursal = null;
        try{
            
            connection = conexion.getConection();
            st= connection.createStatement();
            rs=st.executeQuery("SELECT idSucursal, nombreSucursal FROM sucursal");
            while(rs.next()){
                System.out.println("*");
                sucursal = new Sucursal();
                sucursal.setIdSucursal(rs.getInt("idSucursal"));
                sucursal.setNombreSucursal(rs.getString("nombreSucursal"));
                mListasucursales.add(sucursal);
                
                
            }
            
            
        }catch(SQLException e){
            System.out.println("error no concta lista");
        }
        return mListasucursales;
    }
    
}
