package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
    private final String bd = "agenda";
    private final String usuario = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + bd;
    private Connection conn = null;
    public Connection getOpenConnetion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(url, usuario, password);
        } catch (SQLException |ClassNotFoundException e) {
            System.out.println(e);
        } 
        return conn;
    }
}
