public class Funcionario extends Pessoa implements IFuncionario {

    String codigo;
    String usuario;
    String senha;
    float salario;

    Funcionario(){}

    Funcionario(String codigo){
        this.codigo = codigo + this.codigo;
    }

    Funcionario(String cod, String usu){
        codigo= cod;
        usuario = usu;
    }

    public float calcularSalario() {
        return  this.salario * 1.0f;
    }
}
