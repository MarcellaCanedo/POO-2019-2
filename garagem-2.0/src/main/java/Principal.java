import config.SQLConnection;
import view.MarcaView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args){
        Principal p = new Principal();
        p.menuPrincipal();
    }
    
    public void menuPrincipal(){
    	
    	 System.out.println("#Menu Principal");
         System.out.println("01- Funcionário");
         System.out.println("02- Cliente");
         System.out.println("03- Automóvel");
         System.out.println("04- Vendas");
         
         System.out.println("05- Marca");
         System.out.println("06- Modelo");
         
         System.out.println("00- Sair");

         Scanner sc = new Scanner(System.in);
         int op = sc.nextInt();

         switch (op){
             case 1:
                 break;
             case 2:
                 break;
             case 3:
                 break;
             case 4:
                 break;
             case 5:
                 break;    
             case 6:
                 break;
             case 0: default:
                 System.exit(0);
                 break;
         }
    	

        /*MarcaView mv = new MarcaView();
        mv.menuMarca();*/
    }
}