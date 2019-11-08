import config.SQLConnection;
import view.MarcaView;
import view.ModeloView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
	
    public static void main(String[] args){
    	
        Principal p = new Principal();
        p.menuPrincipal();
        
    }

    public void menuPrincipal(){
    	
    	int op = 0;
    	System.out.println("========== Menu Garagem ==========");
    	System.out.println("1 - Marca");
    	System.out.println("2 - Modelo");
    	System.out.println("3 - Automóvel");
    	System.out.println("0 - Sair");
    	
    	Scanner sc = new Scanner(System.in);
    	
    	op = sc.nextInt();
    	
    	
    	switch (op) {
    		
    		case 1:{
		        MarcaView mv = new MarcaView();
		        mv.menuMarca();
		        this.menuPrincipal();
	        }
    		
    		case 2:{
		        ModeloView mv = new ModeloView();
		        mv.menuModelo();
		        this.menuPrincipal();
	        }
    		
    		case 0: default:{
    			System.exit(0);
		        break;
	        }
    		
    	}
    }

}
