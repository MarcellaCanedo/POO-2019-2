public class Funcionario extends Pessoa implements IFuncionario{

    private int codigo;
    private String usuario;
    private String senha;
    private String funcao;
    private float salario;

    Funcionario (){}

    public void setFuncao(String funcao){
        this.funcao = funcao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float calcularSalario() {
        return salario * 1.0f;
    }

    public void mapFuncionarioTofuncionario(Funcionario funcionario){
        this.setNome(funcionario.getNome());
        this.setTelefone(funcionario.getTelefone());
        this.setCpf(funcionario.getCpf());
        this.setEndereco(funcionario.getEndereco());
        this.setDt_nascimento(funcionario.getDt_nascimento());
        this.setCodigo(funcionario.getCodigo());
        this.setUsuario(funcionario.getUsuario());
        this.setSenha(funcionario.getSenha());
    }
}