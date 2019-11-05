import config.SQLConnection;
import view.MarcaView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Principal {

	private static void menu(){
		 System.out.println("#Menu Principal");
         System.out.println("01- Funcionário");
         System.out.println("02- Cliente");
         System.out.println("03- Automóvel");
         System.out.println("04- Vendas");
         System.out.println("05- Marca");
         System.out.println("06- Modelo");
         System.out.println("00- Sair");
        System.out.println("Digite uma opção: ");
        
    }

    public static void main(String[] args) throws IOException {
        Scanner op = new Scanner((System.in));
        /*MenuGaragem menu1 = new MenuGaragem();
        MenuVeiculo menu2 = new MenuVeiculo();
        MenuCliente menu3 = new MenuCliente();*/
        MarcaView menu4 = new MarcaView();
        int op1;

        while (true){
            menu();
            op1 = Integer.parseInt(op.next());


            switch (op1) {
                case 1:
                    //menu1.menu();
                    break;
                case 2:
                    //menu2.menu();
                    break;
                case 3:
                    //menu3.menu();
                    break;
                case 4:
                	break;
                case 5:
                	menu4.menuMarca();
                case 7:
                    System.out.println("Saindo do Programa");
                    System.exit(4);
                    break;
                default:
                    System.out.println("Opção invalida!!");
            }
        }

    }

}