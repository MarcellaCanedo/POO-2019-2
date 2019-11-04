package controller;
import entity.Funcionario;
import model.FuncionarioModel;
import java.util.List;

public class FuncionarioController {
    FuncionarioModel funcionarioModel;

    public FuncionarioController() { this.funcionarioModel = new FuncionarioModel(); }

    public Funcionario save(Funcionario funcionario){

        return this.funcionarioModel.save(funcionario);

    }

    public boolean cadastrar( Funcionario funcionario){

        return funcionarioModel.cadastrar(funcionario);

    }

    public boolean alterar( Funcionario f){
        return true;
    }

    public Funcionario buscar( String nome){
        return null;
    }

    public boolean excluir(String codigo){
        return true;
    }
}