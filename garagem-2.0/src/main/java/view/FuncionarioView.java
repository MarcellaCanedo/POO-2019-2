package view;
import java.util.ArrayList;
import java.util.Scanner;
import controller.FuncionarioController;
import entity.Funcionario;
import entity.Pessoa;

public class FuncionarioView extends Pessoa{
	
	private int codigo;
	private String usuario;
	private String senha;
	private Float salario;
	
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
    	
    }   
}
