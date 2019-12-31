package entity;

	public class Badeco extends Funcionario implements IFuncionario {

	    private String funcao;
	    private Float salario = (float)625.00;

	    public Badeco(){}

	    public Badeco(String funcao) {
	        this.funcao = funcao;
	    }

	    public String getFuncao() {
	        return funcao;
	    }

	    public void setFuncao(String funcao) {
	        this.funcao = funcao;
	    }

	    public float calcularSalario() {
	        return this.salario * 0.8f;
	    }
}
