public class Gerente extends Funcionario implements IFuncionario {

    private String matricula;
    private float salario;

    Gerente(){};

    public Gerente(String matricula, float salario) {
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float calcularSalario() {
        return this.salario * 1.5f;
    }
}
