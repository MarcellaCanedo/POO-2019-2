import config.SQLConnection;
import view.AutomovelView;
import view.MarcaView;
import view.ModeloView;

import java.awt.SystemColor;
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
    	
    	int opcao;
    	System.out.println("#####  Menu Principal Garagem #####");
    	System.out.println("1 - Automóvel");
    	System.out.println("2 - Funcionário");
    	System.out.println("3 - Cliente");
    	System.out.println("4 - Vendas");
    	System.out.println("0 - Sair");
    	
    	Scanner sc = new Scanner(System.in);
    	opcao = sc.nextInt();
    	
    	switch (opcao) {
    		
    		case 1:{
    			int opp = 0;
    			System.out.println("1 - Marca");
    	    	System.out.println("2 - Modelo");
    	    	System.out.println("3 - Veículos");
    	    	Scanner nsc = new Scanner(System.in);
    	    	opp = sc.nextInt();
    	    	
    	    	switch(opp) {
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
    	    	
    	    	case 3:{
    	    		AutomovelView av = new AutomovelView();
        			av.menuAutomovel();
        			this.menuPrincipal();
    	    	}
    	    	
    	    	}
		        
	        }
    	    	
    		
    		case 2:{
    			System.out.print("Olá");
    		}
    	
    		
    		case 0: default:{
    			System.exit(0);
		        break;
	        }
    		
    	}
    }

}
