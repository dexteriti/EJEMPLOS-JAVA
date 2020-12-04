package Conexion;

import java.sql.*;

public class Conectar{

    static String bd = "BaseProyecto";
    static String login = "sa";
    static String password = "sql123";
    static String url = "jdbc:sqlserver://localhost:1433;DatabaseName="+bd+";integratedSecurity=false";
    Connection connection = null;

    public Conectar(){
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(url,login,password);
        if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" OK\n");
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection(){
        return connection;
    }

    public void desconectar(){
        try{
            System.out.println("Cerrando conexion");
            connection.close();
        }catch(Exception ex){}
    }
    
    public static void main(String[]args){
        Conectar c = new Conectar();
        c.getConnection();
    }

}
