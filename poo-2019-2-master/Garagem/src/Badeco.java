public class Badeco extends Funcionario implements IFuncionario {

    private String funcao;
    private float salario;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public float getSalario() {
        return salario;
    }

    @Override
    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float calculaSalario() {
        return salario * 0.8f;
    }

    public void mapFuncionarioToBadeco(Funcionario func){
        this.setNome(func.getNome());
        this.setTelefone(func.getTelefone());
        this.setCpf(func.getCpf());
        this.setEndereco(func.getEndereco());
        this.setDt_nascimento(func.getDt_nascimento());
        this.setCodigo(func.getCodigo());
        this.setUsuario(func.getUsuario());
        this.setSenha(func.getSenha());
    }
}