import config.SQLConnection;
import view.MarcaView;

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

}
