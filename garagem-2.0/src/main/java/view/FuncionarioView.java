package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import controller.FuncionarioController;
import entity.Funcionario;

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
				
				 System.out.println("\n###  Cadastro de Funcionário  ###");
				
		        System.out.println("\nNome --> ");
		        funcionario.setNome(sc.next());

		        System.out.println("\nCPF --> ");
		        funcionario.setCpf(sc.next());
		        
		        System.out.println("\nEndereço --> ");
		        funcionario.setEndereco(sc.next());
		        
		        System.out.println("\nTelefone --> ");
		        funcionario.setTelefone(sc.next());

		        System.out.println("\nData de nascimento --> ");
		        funcionario.setDt_nascimento(sc.next());
		        
		        System.out.println("\nCódigo --> ");
		        funcionario.setCodigo(sc.nextInt());
		        
		        System.out.println("\nUsuário --> ");
		        funcionario.setUsuario(sc.next());
		        
		        System.out.println("\nSenha --> ");
		        funcionario.setSenha(sc.next());
    
		        System.out.println("\nSalário --> ");
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
		            System.out.println("Nome --> " + funcionario.getNome());
		            System.out.println("Cpf --> " + funcionario.getCpf());
		            System.out.println("Endereço " + funcionario.getEndereco());
		            System.out.println("Telefone " + funcionario.getTelefone());
		            System.out.println("Codigo --> " +funcionario.getCodigo());
		            System.out.println("Data de nascimento --> " +funcionario.getDt_nascimento());
		            System.out.println("Código --> " +funcionario.getUsuario());
		            System.out.println("Senha --> " +funcionario.getSenha());
		            System.out.println("Salário --> " +funcionario.getSalario());
		        }
		        
		        System.out.println("\nInforme os NOVOS dados do Funcionário:");
		        
		        System.out.println("Nome -->");
		        Scanner nome = new Scanner(System.in);
		        funcionario.setNome(nome.next());
		        
		        System.out.println("Cpf -->");
		        Scanner cpf = new Scanner(System.in);
		        funcionario.setCpf(cpf.next());
		        
		        System.out.println("Endereco -->");
		        Scanner endereco = new Scanner(System.in);
		        funcionario.setEndereco(endereco.next());
		        
		        System.out.println("Telefone -->");
		        Scanner telefone = new Scanner(System.in);
		        funcionario.setTelefone(telefone.next());
		        
		        System.out.println("Data de nascimento -->");
		        Scanner dt_nascimento = new Scanner(System.in);
		        funcionario.setDt_nascimento(dt_nascimento.next());
		        
		        System.out.println("Codigo -->");
		        Scanner codigo = new Scanner(System.in);
		        funcionario.setCodigo(codigo.nextInt());
		        
		        System.out.println("Usuario -->");
		        Scanner usuario = new Scanner(System.in);
		        funcionario.setCpf(cpf.next());
		        
		        System.out.println("Senha -->");
		        Scanner senha = new Scanner(System.in);
		        funcionario.setSenha(senha.next());

		        System.out.println("Salario -->");
		        Scanner salario = new Scanner(System.in);
		        funcionario.setSalario(salario.nextFloat());
		        
		        boolean resp = this.update(num, funcionario);
		        if(resp == true) {
		        	System.out.println("Funcionario alterado com sucesso!");
		        }
		        else {
		        	System.out.println("Registro de Funcionário não encontrado!!");
		        }
		        
		        menuFuncionario();
		        break;
	        }
			
			case 5:{
				System.out.println("####  Excluir Funcionário  ####");
				Scanner c = new Scanner(System.in);
				System.out.println("Informe o ID do Funcionario:");
		        int num = c.nextInt();
		        boolean resp = this.delete(num);
		        if(resp == true) {
		        	System.out.println("Funcionário excluído!!!");
		        }
		        else {
		        	System.out.println("Funcionário não existente!");
		        }
		        
				menuFuncionario();
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

    public boolean update(int id, Funcionario funcionario){
        return funcionarioController.update(id, funcionario);
    }

    public boolean delete(int id){
    	return funcionarioController.delete(id);
    }

    public List<Funcionario> findAll(){
    	return funcionarioController.findAll();
    }

    public Funcionario findById(int id){
    	FuncionarioController funcionarioController = null;
		return funcionarioController.findById(id);
    }
}
