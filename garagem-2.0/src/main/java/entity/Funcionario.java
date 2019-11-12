package entity;

public abstract class Funcionario extends Pessoa {
	
	String codigo;
	String usuario;
	String senha;
	float salario;
	
	public abstract float calcularSalario();

	public abstract int getCodigo();

	public abstract String getUsuario();
	
}
