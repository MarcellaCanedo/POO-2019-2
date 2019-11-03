import config.SQLConnection;
import view.MarcaView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Principal {

    public static void main(String[] args){
        Principal p = new Principal();
        p.menuPrincipal();
    }

    public void menuPrincipal(){

        MarcaView mv = new MarcaView();
        mv.menuMarca();
    }

    /*
Mostrando os bancos de dados existentes na maquina
atraves da classe principal
*/

    /*public class Config {

        public static void main(String[] args) {

            Connection conn = Conn.getConnection();

            try {
                PreparedStatement preparedStatement = conn.prepareStatement("show databases");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String name =  resultSet.getString("DATABASE");
                    System.out.println(name);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }*/