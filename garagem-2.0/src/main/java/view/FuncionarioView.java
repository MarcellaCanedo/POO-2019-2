package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.FuncionarioController;
import entity.Funcionario;
import entity.Gerente;
import entity.Badeco;

public class FuncionarioView{
	
	private FuncionarioController funcionarioController;
    private Scanner sc;
	
    ArrayList <Funcionario> funcionarios = new ArrayList<Funcionario>();
	int op;

	private Funcionario funcionario;
    
    public FuncionarioView() {
    	this.funcionarioController = new FuncionarioController(); 
    	this.sc = new Scanner(System.in);
    	this.funcionario = new Funcionario();
    }

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

				System.out.println("1 - Gerente");
		        System.out.println("2 - Funcionario");
		        System.out.println("3 - Badeco");

		        Scanner sc1 = new Scanner(System.in);
		        int op = sc1.nextInt();
		        switch (op){
		            case 1:
		                this.funcionario = new Gerente(null, op);
		                funcionario.setCargo("Gerente");
		                break;
		            case 2:
		                this.funcionario = new Funcionario();
		                funcionario.setCargo("Funcionario");
		                break;
		            case 3:
		                this.funcionario = new Badeco();
		                funcionario.setCargo("Badeco");
		                break;
		        }

		        sc1.nextLine();

		        System.out.println("Nome: ");
		        funcionario.setNome(sc1.nextLine());

		        System.out.println("CPF: ");
		        funcionario.setCpf(sc1.nextLine());

		        System.out.println("Endereço: ");
		        funcionario.setEndereco(sc1.nextLine());

		        System.out.println("Telefone: ");
		        funcionario.setTelefone(sc1.nextLine());

		        System.out.println("Data de nascimento: ");
		        funcionario.setDt_nascimento(sc1.nextLine());

		        System.out.println("Codigo: ");
		        funcionario.setCodigo(sc1.nextInt());

		        System.out.println("Usuario: ");
		        funcionario.setUsuario(sc1.nextLine());

		        System.out.println("Senha: ");
		        funcionario.setSenha(sc1.nextLine());

		       if (funcionarioController.update(op, funcionario)){
		           System.out.println("Sucesso ao cadastrar funcionario");
		       }else{
		           System.out.println("Erro ao cadastrar funcionario, tente novamente");
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
