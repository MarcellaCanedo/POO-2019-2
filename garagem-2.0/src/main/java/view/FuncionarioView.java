package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import controller.FuncionarioController;
import controller.MarcaController;
import entity.Funcionario;
import entity.Marca;
import entity.Modelo;

public class FuncionarioView{
	
	FuncionarioController funcionarioController;
    
    ArrayList <Funcionario> funcionarios = new ArrayList<Funcionario>();
	int op;
    
    public FuncionarioView() {  funcionarioController = new FuncionarioController(); }

    public void menuFuncionario(){
    	
    	int opp;
    	System.out.println("####  Menu Funcionário ####");
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
		        
				Funcionario funcionario = new Funcionario();
				Scanner f = new Scanner(System.in);
				
		        System.out.println("\n-->  Digite o nome da Funcionario:");
		        funcionario.setNome(sc.nextLine());

		        System.out.println("\n--> CPF: ");
		        funcionario.setCpf(sc.nextLine());
		        
		        System.out.println("\n-->  Endereço: ");
		        funcionario.setEndereco(sc.nextLine());
		        
		        System.out.println("\n-->  Telefone: ");
		        funcionario.setTelefone(sc.nextLine());

		        System.out.println("\n-->  Data de nascimento: ");
		        funcionario.setDt_nascimento(sc.nextLine());
		        
		        System.out.println("\n-->  Código: ");
		        funcionario.setCodigo(sc.nextInt());
		        
		        System.out.println("\n-->  Usuário: ");
		        funcionario.setUsuario(sc.nextLine());
		        
		        System.out.println("\n-->  Senha: ");
		        funcionario.setSenha(sc.nextLine());
    
		        System.out.println("\n-->  Salário: ");
		        funcionario.setSalario(sc.nextFloat());
		        
		        if(funcionario == null){ 
		            System.out.println("\nFuncionário não cadastrado, campo obrigatório!\n");
		        } else{
		            System.out.println("\nFuncionário cadastrado com sucesso!\n");
		            
		            if(funcionario.getId() <= 500) 
		            {
	    				System.out.println("ID -->  " +funcionario.getId());
	    			}
		            System.out.println("Nome --> " +funcionario.getNome());
		            System.out.println("Codigo --> " +funcionario.getCodigo());
		            System.out.println("CPF --> " +funcionario.getCpf());
		            System.out.println("Salário --> " +funcionario.getSalario());
		        }
		        
		        System.out.println("\n");
		        menuFuncionario();
		        break;
	        }
			
			case 2:{
				funcionarios = (ArrayList<Funcionario>) this.findAll();
				
		    	System.out.println("####  Listar Funcionario  ####");
		    	if(this.funcionarios != null) {
		    		funcionarios.forEach((f) -> {
		    			if(f.getId() <= 500) {
		    				System.out.println("ID --> 0"+f.getId());
		    			}
		    			System.out.println("Nome --> " +f.getNome());
			            System.out.println("Codigo --> " +f.getCodigo());
			            System.out.println("CPF --> " +f.getCpf());
			            System.out.println("Salário --> " +f.getSalario());
			            System.out.println("-----------------------");
		    		});
		    	}else {
		    		System.out.println("Nenhum funcionario registrado na base de dados!");
		    	}
		    	
		    	System.out.println("\n");
				menuFuncionario();
		        break;
	        }
			
			case 3:{
				System.out.println("####  Buscar Funcionário ####");
				Scanner sci = new Scanner(System.in);
				
				System.out.println("-->  Informe o ID do funcionario cadastrada:");
				Funcionario funcionario = new Funcionario();
			
		        int num = sci.nextInt();
				funcionario = this.findById(num);
				if(funcionario != null) {
					if(funcionario.getId() <= 500) {
	    				System.out.println("\nID --> " + funcionario.getId());
	    			}
		            System.out.println("Nome --> "+ funcionario.getNome());
		            System.out.println("Codigo --> " +funcionario.getCodigo());
		            System.out.println("CPF --> " +funcionario.getCpf());
		            System.out.println("Salário --> " +funcionario.getSalario());
		            System.out.println("-----------------------");
		            System.out.println("\n");
				}
				else{
					System.out.println("ID não encontrado na base de dados!\n");
				}
			
				menuFuncionario();
		        break;
	        }
			
			case 4:{
				System.out.println("####  Alterar Funcionário  ####");
				Scanner sci = new Scanner(System.in);
				System.out.println("Insira o ID do funcionário:");
				int num = sci.nextInt();
				
		        Funcionario funcionario = this.findById(num);
		        if(funcionario == null) {
		        	System.out.println("Este código não existe!\n");
		        	this.menuFuncionario();
		        }
		        else {
		        	System.out.println("==== Alteração de Funcionario ====");
		        	if(funcionario.getId() <= 500) {
	    				System.out.println("ID -->  " + funcionario.getId());
	    			}
		            System.out.println("NOME - " + funcionario.getNome());
		        }
		        
		        System.out.println("\nInforme o novo nome da Marca:");
		        Scanner nome = new Scanner(System.in);
		        marca.setNome(nome.next());

		        boolean resp = this.update(num, marca);
		        if(resp == true) {
		        	System.out.println("Marca Alterada com sucesso!");
		        }
		        else {
		        	System.out.println("Marca não existente!!");
		        }
		        
		        menuMarca();
		        break;
	        }
			
			case 5:{
				System.out.println("####  Excluir Marca  ####");
				Scanner c = new Scanner(System.in);
				System.out.println("Informe o ID da marca:");
		        int num = c.nextInt();
		        boolean resp = this.delete(num);
		        if(resp == true) {
		        	System.out.println("Marca excluída!!!");
		        }
		        else {
		        	System.out.println("Marca não existente!");
		        }
		        
				menuMarca();
		        break;
	        }
			
			case 0:{
				break;
				
			}
    	}
    }


    public Funcionario save(Funcionario funcionario1){
    	return funcionarioController.save(funcionario1);
    }

    public boolean update(int id, Marca m){
        return funcionarioController.update(id, m);
    }

    public boolean delete(int id){
    	return funcionarioController.delete(id);
    }

    public List<Funcionario> findAll(){
    	return funcionarioController.findAll();
    }

    public Funcionario findById(int id){
    	return funcionairoController.findById(id);
    }
}
