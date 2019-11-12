package entity;

public abstract class Funcionario extends Pessoa {
	
	String codigo;
	String usuario;
	String senha;
	float salario;
	
	public float calcularSalario();
	
}
