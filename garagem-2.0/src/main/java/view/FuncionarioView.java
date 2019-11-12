package view;
import java.util.ArrayList;
import java.util.Scanner;
import controller.FuncionarioController;
import entity.Funcionario;
import entity.Marca;
import entity.Pessoa;

public class FuncionarioView extends Pessoa{
	
	public void Funcionario(int id, String nome, String endereco, String telefone, String dt_nascimento) {
	}

	FuncionarioController funcionarioController;
    
    ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    
    public FuncionarioView(){  funcionarioController = new FuncionarioController(); }

    public void menuFuncionario(){
    	
    	int op;
    	System.out.println("####  Menu Funcionario  ####");
    	System.out.println("1- Cadastrar");
    	System.out.println("2- Listar");
    	System.out.println("3- Buscar");
    	System.out.println("4- Alterar");
    	System.out.println("5- Excluir");
    	System.out.println("00- Voltar");
    	Scanner sc = new Scanner(System.in);	
    	op = sc.nextInt();
    	
    	switch (op) {
		
		case 1:{
			
			Scanner c = new Scanner(System.in);
			Funcionario funcionario = new Funcionario();
			
	        System.out.println("\n-->  Digite o nome do Funcionário:");
			Pessoa.setNome(c.nextLine());
	        Funcionario funcionario = save(funcionario);

	        if(cmarca.getNome() == null || cmarca.getNome().trim().equals("")){ 
	            System.out.println("\nMarca não cadastrada, campo obrigatório!\n");
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
		
    }
    	
    }   
}
