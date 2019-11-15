import view.AutomovelView;
import view.FuncionarioView;
import view.MarcaView;
import view.ModeloView;
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
    	    		MarcaView marcav = new MarcaView();
    		        marcav.menuMarca();
    		        menuPrincipal();
    	    	}
    	    	
    	    	case 2:{
    	    		ModeloView modelov = new ModeloView();
    		        modelov.menuModelo();
    		        menuPrincipal();
    	    	}
    	    	
    	    	case 3:{
    	    		AutomovelView av = new AutomovelView();
        			av.menuAutomovel();
        			menuPrincipal();
    	    	}
    	    	
    	    	}
		        
	        }
    	    	
    		case 2:{
    			FuncionarioView funcionariov = new FuncionarioView();
    			funcionariov.menuFuncionario();
    			menuPrincipal();
    		}
    		
    		/*case 3: {
    			ClienteView clientev = new ClienteView();
    			clientev.menuCliente();
    			menuPrincipal();
    		}*/
    	
    		
    		case 0: default:{
    			System.exit(0);
		        break;
	        }
    		
    	}
    }

}
