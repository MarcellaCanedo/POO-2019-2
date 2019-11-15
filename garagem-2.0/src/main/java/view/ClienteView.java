package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ClienteController;
import entity.Cliente;

public class ClienteView {

	ClienteController clienteController;
    
    ArrayList <Cliente> clientes = new ArrayList<Cliente>();
	int op;
    
    public ClienteView() {  clienteController = new ClienteController(); }

    public void menuCliente(){
    	
    	int opp;
    	System.out.println("####  Menu Cliente ####");
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
		        
				Cliente cliente = new Cliente();
				Scanner f = new Scanner(System.in);
				
				 System.out.println("\n###  Cadastro de Cliente  ###");
				
		        System.out.println("\nNome --> ");
		        cliente.setNome(sc.next());

		        System.out.println("\nCPF --> ");
		        cliente.setCpf(sc.next());
		        
		        System.out.println("\nEndereço --> ");
		        cliente.setEndereco(sc.next());
		        
		        System.out.println("\nTelefone --> ");
		        cliente.setTelefone(sc.next());

		        System.out.println("\nData de nascimento --> ");
		        cliente.setDt_nascimento(sc.next());
		        
		        System.out.println("\nCódigo --> ");
		        cliente.setCodigo(sc.nextInt());
    
		        System.out.println("\nSalário --> ");
		        cliente.setSalario(sc.nextFloat());
		        
		        if(cliente == null){ 
		            System.out.println("\nFuncionário não cadastrado, campo obrigatório!\n");
		        } else{
		            System.out.println("\nFuncionário cadastrado com sucesso!\n");
		            
		            if(cliente.getId() <= 500) 
		            {
	    				System.out.println("ID -->  " +cliente.getId());
	    			}
		            System.out.println("Nome --> " +cliente.getNome());
		            System.out.println("Codigo --> " +cliente.getCodigo());
		            System.out.println("CPF --> " +cliente.getCpf());
		            System.out.println("Salário --> " +cliente.getSalario());
		        }
		        
		        System.out.println("\n");
		        menuCliente();
		        break;
	        }
			
			case 2:{
				clientes = (ArrayList<Cliente>) this.findAll();
				
		    	System.out.println("####  Listar Clientes  ####");
		    	if(this.clientes != null) {
		    		clientes.forEach((f) -> {
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
				menuCliente();
		        break;
	        }
			
			case 3:{
				System.out.println("####  Buscar Cliente ####");
				Scanner sci = new Scanner(System.in);
				
				System.out.println("-->  Informe o ID do cliente cadastrado:");
				Cliente cliente = new Cliente();
			
		        int num = sci.nextInt();
		        cliente= this.findById(num);
				if(cliente!= null) {
					if(cliente.getId() <= 500) {
	    				System.out.println("\nID --> " + cliente.getId());
	    			}
		            System.out.println("Nome --> "+ cliente.getNome());
		            System.out.println("Codigo --> " +cliente.getCodigo());
		            System.out.println("CPF --> " +cliente.getCpf());
		            System.out.println("-----------------------");
		            System.out.println("\n");
				}
				else{
					System.out.println("ID não encontrado na base de dados!\n");
				}
			
				menuCliente();
		        break;
	        }
			
			case 4:{
				System.out.println("####  Alterar Cliente  ####");
				Scanner sci = new Scanner(System.in);
				System.out.println("Insira o ID do funcionário:");
				int num = sci.nextInt();
				
				Cliente cliente = this.findById(num);
		        if(cliente == null) {
		        	System.out.println("Este código não existe!\n");
		        	this.menuCliente();
		        }
		        else {
		        	System.out.println("==== Alteração de Clientes ====");
		        	if(cliente.getId() <= 500) {
	    				System.out.println("ID -->  " + cliente.getId());
	    			}
		            System.out.println("Nome --> " + cliente.getNome());
		            System.out.println("Cpf --> " + cliente.getCpf());
		            System.out.println("Endereço " + cliente.getEndereco());
		            System.out.println("Telefone " + cliente.getTelefone());
		            System.out.println("Codigo --> " +cliente.getCodigo());
		            System.out.println("Data de nascimento --> " +cliente.getDt_nascimento());
		            System.out.println("Salário --> " +cliente.getSalario());
		        }
		        
		        System.out.println("\nInforme os NOVOS dados do Funcionário:");
		        
		        System.out.println("Nome -->");
		        Scanner nome = new Scanner(System.in);
		        cliente.setNome(nome.next());
		        
		        System.out.println("Cpf -->");
		        Scanner cpf = new Scanner(System.in);
		        cliente.setCpf(cpf.next());
		        
		        System.out.println("Endereco -->");
		        Scanner endereco = new Scanner(System.in);
		        cliente.setEndereco(endereco.next());
		        
		        System.out.println("Telefone -->");
		        Scanner telefone = new Scanner(System.in);
		        cliente.setTelefone(telefone.next());
		        
		        System.out.println("Data de nascimento -->");
		        Scanner dt_nascimento = new Scanner(System.in);
		        cliente.setDt_nascimento(dt_nascimento.next());
		        
		        System.out.println("Codigo -->");
		        Scanner codigo = new Scanner(System.in);
		        cliente.setCodigo(codigo.nextInt());
		        
		        System.out.println("Usuario -->");
		        Scanner usuario = new Scanner(System.in);
		        cliente.setCpf(cpf.next());
		        
		        boolean resp = this.update(num, cliente);
		        if(resp == true) {
		        	System.out.println("Funcionario alterado com sucesso!");
		        }
		        else {
		        	System.out.println("Registro de Funcionário não encontrado!!");
		        }
		        
		        menuCliente();
		        break;
	        }
			
			case 5:{
				System.out.println("####  Excluir Cliente  ####");
				Scanner c = new Scanner(System.in);
				System.out.println("Informe o ID do Cliente:");
		        int num = c.nextInt();
		        boolean resp = this.delete(num);
		        if(resp == true) {
		        	System.out.println("Cliente excluído!!!");
		        }
		        else {
		        	System.out.println("Cliente não existente!");
		        }
		        
				menuCliente();
		        break;
	        }
			
			case 0:{
				break;
				
			}
    	}
    }


    public Cliente save(Cliente cliente){
    	return clienteController.save(cliente);
    }

    public boolean update(int id, Cliente cliente){
        return clienteController.update(id, cliente);
    }

    public boolean delete(int id){
    	return clienteController.delete(id);
    }

    public List<Cliente> findAll(){
    	return clienteController.findAll();
    }

    public Cliente findById(int id){
    	ClienteController clienteController = null;
		return clienteController.findById(id);
    }

	public static boolean verificaLista(String codigoCliente) {
		return false;
	}
	
}
