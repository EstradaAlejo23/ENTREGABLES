package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDb {
    public static Connection objConnection = null;

    public static Connection openConnection(){
        try{
            //Llamanos al driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //creamos la variable de conexion
            String url = "jdbc:mysql://b9gdaubhhy45laq8nhzu-mysql.services.clever-cloud.com:3306/b9gdaubhhy45laq8nhzu";
            String user = "urpebwxadrjgpfma";
            String password = "Wr3SbZdF3ZmlIx2KBDOa";
            //Establecemos conexion
            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Ingreso a db");

        } catch (ClassNotFoundException error){
            JOptionPane.showMessageDialog(null,"ERROR >> Driver no instalado"+error.getMessage());
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR >> No conecté a base de datos"+e.getMessage());
        }
        return objConnection;
    }

    public static void closeConnection(){
        try {
            if (objConnection != null){
                objConnection.close();
                System.out.println("Se finalizó con éxito la conexión");
            } else {
                System.out.println("No hay conexiones abiertas");
            }
        } catch (SQLException error){
            System.out.println("Error"+ error.getMessage());
        }
    }
}
