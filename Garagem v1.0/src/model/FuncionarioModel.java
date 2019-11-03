package model;

import entity.Funcionario;
import java.util.ArrayList;

public class FuncionarioModel {
    private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

    public boolean cadastrar( Funcionario funcionario){

        this.listaFuncionarios.add(funcionario);
        return  true;
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
