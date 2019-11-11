package view;

import controller.MarcaController;
import entity.Automovel;
import entity.Marca;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MarcaView {
    MarcaController marcaController;
    
    ArrayList<Marca> marcas = new ArrayList<Marca>();
    
    public MarcaView() {  marcaController = new MarcaController(); }

    public void menuMarca(){
    	
    	int opp;
    	System.out.println("####  Menu Marcas ####");
    	System.out.println("1- Cadastrar");
    	System.out.println("2- Listar");
    	System.out.println("3- Buscar");
    	System.out.println("4- Alterar");
    	System.out.println("5- Excluir");
    	System.out.println("00- Voltar");
    	Scanner sc = new Scanner(System.in);
    	
    	opp = sc.nextInt();
    	
    	switch (opp) {
			
			case 1:{
				
				Scanner sc1 = new Scanner(System.in);
				Marca marca = new Marca();
				
		        System.out.println("\n-->  Digite o nome da Marca:");
				marca.setNome(sc1.nextLine());
		        Marca cmarca = save(marca);

		        if(cmarca.getNome() == null || cmarca.getNome().trim().equals("")){ 
		            System.out.println("\nMarca n�o cadastrada, campo obrigat�rio!\n");
		        } else{
		            System.out.println("\nMarca cadastrada com sucesso!\n");
		            
		            if(cmarca.getId() <= 500) 
		            {
	    				System.out.println("ID -->  " +cmarca.getId());
	    			}
		            System.out.println("Nome --> " +cmarca.getNome());
		        }
		        
		        System.out.println("\n");
		        menuMarca();
		        break;
	        }
			
			case 2:{
				marcas = (ArrayList<Marca>) this.findAll();
				
		    	System.out.println("####  Listar Marca  ####");
		    	if(this.marcas != null) {
		    		marcas.forEach((m) -> {
		    			if(m.getId() <= 500) {
		    				System.out.println("ID --> 0"+m.getId());
		    			}
			            System.out.println("Nome --> "+m.getNome());
			            System.out.println("-----------------------");
		    		});
		    	}else {
		    		System.out.println("Nenhuma marca encontrada na base de dados!");
		    	}
		    	
		    	System.out.println("\n");
				menuMarca();
		        break;
	        }
			
			case 3:{
				System.out.println("####  Buscar Marca ####");
				Scanner sci = new Scanner(System.in);
				
				System.out.println("-->  Informe o ID da Marca cadastrada:");
				Marca bmarca = new Marca();
			
		        int num = sci.nextInt();
				bmarca = this.findById(num);
				if(bmarca != null) {
					if(bmarca.getId() <= 50) {
	    				System.out.println("ID --> " + bmarca.getId());
	    			}else {
	    				System.out.println("ID --> " + bmarca.getId());
	    			}
		            System.out.println("Nome --> "+ bmarca.getNome());
				}
				else{
					System.out.println("C�digo n�o cadastrado na base de dados!\n");
				}
			
				menuMarca();
		        break;
	        }
			
			case 4:{
				System.out.println("####  Alterar Marca  ####");
				Scanner sci = new Scanner(System.in);
				System.out.println("Insira o c�digo da marca:");
				int n = sci.nextInt();
				
		        Marca marca = this.findById(n);
		        if(marca == null) {
		        	System.out.println("Este c�digo n�o existe!\n");
		        	this.menuMarca();
		        }
		        else {
		        	System.out.println("Id     Marca");
		        	if(marca.getId() < 10) {
	    				System.out.println("ID - 0"+marca.getId());
	    			}else {
	    				System.out.println("ID - "+marca.getId());
	    			}
		            System.out.println("NOME - "+marca.getNome());
		        }
		        
		        
		        System.out.println("\nInforme o novo nome da Marca:");
		        Scanner nome = new Scanner(System.in);
		        marca.setNome(nome.next());

		        boolean r = this.update(n, marca);
		        if(r == true) {
		        	System.out.println("Marca alterada com sucesso!");
		        }
		        else {
		        	System.out.println("A marca n�o foi alterada ou n�o existe!");
		        }
		        
		        this.menuMarca();
		        break;
	        }
			
			case 5:{
				System.out.println("========== Excluir Marca ==========");
				Scanner c = new Scanner(System.in);
				System.out.println("Informe o c�digo da Marca:");
		        int n = c.nextInt();
		        boolean r = this.delete(n);
		        if(r == true) {
		        	System.out.println("Marca exclu�da com sucesso!");
		        }
		        else {
		        	System.out.println("A marca n�o foi exclu�da ou n�o existe!");
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
