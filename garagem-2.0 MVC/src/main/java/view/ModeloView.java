package view;
import controller.ModeloController;
import entity.Marca;
import entity.Modelo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ModeloView {

    ModeloController ModeloController;
    
    ArrayList<Modelo> modelos = new ArrayList<Modelo>();

	private Scanner sc;
	private Scanner c;
	int op;
	
	public ModeloView() {
        this.ModeloController = new ModeloController();
    }

    public void menuModelo(){
    		
    	System.out.println("Menu Modelo: ");
    	System.out.println("1- Cadastrar");
    	System.out.println("2- Listar");
    	System.out.println("3- Buscar");
    	System.out.println("4- Alterar");
    	System.out.println("5- Excluir");
    	System.out.println("00- Voltar");
    	sc = new Scanner(System.in);
    	op = sc.nextInt();
    	
    	switch (op) {
			
			case 1:{
		        Modelo cmodelo = new Modelo();
		        c = new Scanner(System.in);
		        
		        System.out.println("Nome de Modelo: ");
		        cmodelo.setNome(c.nextLine());
		        
		        System.out.println("Tipo de Modelo: ");
		        cmodelo.setTipo(c.nextLine());
		        
		        System.out.println("Código da Marca deste Modelo:"); 
		        Marca marca = new Marca();
		        marca = this.selectMarca(c.nextInt());
		        
		        if(marca == null) {
		        	System.out.println("Marca não registrada na base de dados!");
		        	menuModelo();
		        }
		        else {
		        	System.out.println("Marca: " + marca.getNome());
		        }
		        cmodelo.setMarca(marca);
		        Modelo M = save(cmodelo);

		        if(M == null){
		            System.out.println("\nModelo não foi cadastrado!\n");
		        } else {
		            System.out.println("\n\nModelo cadastrado com sucesso!");
		            if(M.getId() < 500) {
	    				System.out.println("ID --> " + M.getId());
	    			}
		            System.out.println("Nome --> " + M.getNome());
		            System.out.println("Tipo --> " + M.getTipo());
		            System.out.println("Marca --> " + M.getMarca().getNome());
		        }
		        
		        menuModelo();
		        break;
	        }
			
			case 2:{
				modelos = (ArrayList<Modelo>) this.findAll();
		    	System.out.println("####  Listar Modelo  ####");
		    	if(modelos != null) {
		    		modelos.forEach((m) -> {
		    			if(m.getId() < 500) {
		    				System.out.println("ID --> "+m.getId());
		    			}
			            System.out.println("Nome --> " + m.getNome());
			            System.out.println("Tipo --> " + m.getTipo());
			            System.out.println("Marca --> " + m.getMarca().getNome());
			            System.out.println("----------------------------------");
		    		});
		    	}else {
		    		System.out.println("Não há modelos cadastrados!");
		    	}
		    	System.out.println("\n");
		    	
				menuModelo();
		        break;
	        }
			
			case 3:{
				System.out.println("####  Buscar Modelo  ####");
				Scanner c = new Scanner(System.in);
				System.out.println("Informe o código da Modelo: ");
		        int n = c.nextInt();
		        Modelo m = new Modelo();
				m = this.findById(n);
				if(m != null) {
					if(m.getId() < 500) {
	    				System.out.println("ID --> " + m.getId());
	    			}
		            System.out.println("Nome --> " + m.getNome());
		            System.out.println("Tipo --> " + m.getTipo());
		            System.out.println("Marca --> " + m.getMarca().getNome());
				}
				else {
					System.out.println("Este código não existe!\n");
				}
				System.out.println("\n");
				menuModelo();
		        break;
	        }
			
			case 4:{
				System.out.println("####  Alterar Modelo  ####");
				Scanner c = new Scanner(System.in);
				System.out.println("Informe o código do Modelo:");
		        int n = c.nextInt();
		        Modelo m = this.findById(n);
		        if(m == null) {
		        	System.out.println("Este código não existe!\n");
		        	this.menuModelo();
		        }
		        else {
		        	if(m.getId() < 500) {
	    				System.out.println("ID --> " + m.getId());
	    			}
		        	System.out.println("Nome --> " + m.getNome());
		            System.out.println("Tipo --> " + m.getTipo());
		            System.out.println("Marca --> " + m.getMarca().getNome());
		        }
		        
		        System.out.println("\nInforme o novo nome do Modelo:");
		        m.setNome(c.next());
		        
		        System.out.println("Informe o novo tipo do Modelo:");
		        m.setTipo(c.next());
		        
		        System.out.println("Informe o novo código da Marca deste Modelo:");
		        Marca marca = new Marca();
		        marca = selectMarca(c.nextInt());
		        
		        if(marca == null) {
		        	menuModelo();
		        }
		        else {
		        	System.out.println("Marca --> "+marca.getNome());
		        }
		        
		        m.setMarca(marca);

		        boolean r = this.update(n, m);
		        if(r == true) {
		        	System.out.println("Modelo alterado com sucesso!");
		        }
		        else {
		        	System.out.println("O Modelo não foi alterado!");
		        }
		        
		        this.menuModelo();
		        break;
	        }
			
			case 5:{
				System.out.println("Excluir Modelo:");
				Scanner c = new Scanner(System.in);
				System.out.println("Informe o código da Modelo:");
		        int n = c.nextInt();
		        boolean r = this.delete(n);
		        if(r == true) {
		        	System.out.println("Modelo excluído com sucesso!");
		        }
		        else {
		        	System.out.println("A Modelo não foi excluído ou não existe!");
		        }
		        
				menuModelo();
		        break;
	        }
			
			case 0:{
				break;
				
			}
    	}
    }


    public Modelo save(Modelo m){
    	return ModeloController.save(m);
    }

    public boolean update(int id, Modelo m){
        return ModeloController.update(id, m);
    }

    public boolean delete(int id){
    	return ModeloController.delete(id);
    }
    
    public Marca selectMarca(int id) {
    	return ModeloController.selectMarca(id);
    }

    public List<Modelo> findAll(){
    	return ModeloController.findAll();
    }

    public Modelo findById(int id){
    	return ModeloController.findById(id);
    }

}
