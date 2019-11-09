package view;

import controller.MarcaController;
import entity.Automovel;
import entity.Marca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarcaView {

    MarcaController marcaController;
    
    ArrayList<Marca> marcas = new ArrayList<Marca>();

    public MarcaView() {
        this.marcaController = new MarcaController();
    }

    public void menuMarca(){
    	
    	int op;
    	System.out.println("Menu Automóvel");
    	System.out.println("1 - Cadastrar");
    	System.out.println("2 - Listar");
    	System.out.println("3 - Buscar");
    	System.out.println("4 - Alterar");
    	System.out.println("5 - Excluir");
    	System.out.println("0 - Voltar");
    	Scanner sc = new Scanner(System.in);
    	op = sc.nextInt();
    	
    	switch (op) {
			
			case 1:{
				System.out.println("Cadastrar Automovel: ");
				Automovel a = new Automovel();
		        Scanner c = new Scanner(System.in);
		        
		        System.out.println("Informe o nome da Marca:");
		        m.setNome(c.nextLine());
		        Marca m2 = this.save(m);

		        if(m2 == null){
		            System.out.println("\n\nMarca não foi cadastrada!\n\n");
		        } else {
		            System.out.println("\n\nMarca cadastrada com sucesso!");
		            if(m2.getId() < 10) {
	    				System.out.println("ID - 0"+m2.getId());
	    			}else {
	    				System.out.println("ID - "+m2.getId());
	    			}
		            System.out.println("NOME - "+m2.getNome());
		        }
		        
		        this.menuMarca();
		        break;
	        }
			
			case 2:{
				marcas = (ArrayList<Marca>) this.findAll();
		    	System.out.println("========== Listar Marca ==========");
		    	if(marcas != null) {
		    		marcas.forEach((m) -> {
		    			if(m.getId() < 10) {
		    				System.out.println("ID - 0"+m.getId());
		    			}else {
		    				System.out.println("ID - "+m.getId());
		    			}
			            System.out.println("NOME - "+m.getNome());
			            System.out.println("----------------------------------");
		    		});
		    	}else {
		    		System.out.println("Não há marcas cadastradas!");
		    	}
		    	System.out.println("\n");
		    	
				this.menuMarca();
		        break;
	        }
			
			case 3:{
				System.out.println("========== Buscar Marca ==========");
				Scanner c = new Scanner(System.in);
				System.out.println("Informe o código da Marca:");
		        int n = c.nextInt();
		        Marca m = new Marca();
				m = this.findById(n);
				if(m != null) {
					if(m.getId() < 10) {
	    				System.out.println("ID - 0"+m.getId());
	    			}else {
	    				System.out.println("ID - "+m.getId());
	    			}
		            System.out.println("NOME - "+m.getNome());
				}
				else {
					System.out.println("Este código não existe!\n");
				}
				System.out.println("\n");
				this.menuMarca();
		        break;
	        }
			
			case 4:{
				System.out.println("========== Alterar Marca ==========");
				Scanner c = new Scanner(System.in);
				System.out.println("Informe o código da Marca:");
		        int n = c.nextInt();
		        Marca m = this.findById(n);
		        if(m == null) {
		        	System.out.println("Este código não existe!\n");
		        	this.menuMarca();
		        }
		        else {
		        	System.out.println("Id     Marca");
		        	if(m.getId() < 10) {
	    				System.out.println("ID - 0"+m.getId());
	    			}else {
	    				System.out.println("ID - "+m.getId());
	    			}
		            System.out.println("NOME - "+m.getNome());
		        }
		        
		        
		        System.out.println("\nInforme o novo nome da Marca:");
		        Scanner nome = new Scanner(System.in);
		        m.setNome(nome.next());

		        boolean r = this.update(n, m);
		        if(r == true) {
		        	System.out.println("Marca alterada com sucesso!");
		        }
		        else {
		        	System.out.println("A marca não foi alterada ou não existe!");
		        }
		        
		        this.menuMarca();
		        break;
	        }
			
			case 5:{
				System.out.println("========== Excluir Marca ==========");
				Scanner c = new Scanner(System.in);
				System.out.println("Informe o código da Marca:");
		        int n = c.nextInt();
		        boolean r = this.delete(n);
		        if(r == true) {
		        	System.out.println("Marca excluída com sucesso!");
		        }
		        else {
		        	System.out.println("A marca não foi excluída ou não existe!");
		        }
		        
				this.menuMarca();
		        break;
	        }
			
			case 0:{
				break;
				
			}
    	}
    }


    public Marca save(Marca m){
    	return marcaController.save(m);
    }

    public boolean update(int id, Marca m){
        return marcaController.update(id, m);
    }

    public boolean delete(int id){
    	return marcaController.delete(id);
    }

    public List<Marca> findAll(){
    	return marcaController.findAll();
    }

    public Marca findById(int id){
    	return marcaController.findById(id);
    }

}
