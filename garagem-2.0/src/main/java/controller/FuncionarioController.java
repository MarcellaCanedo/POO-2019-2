package controller;

import java.util.List;

import entity.Funcionario;
import entity.Marca;
import model.FuncionarioModel;
import model.MarcaModel;

public class FuncionarioController {

	 FuncionarioModel funcionarioModel;

	    public FuncionarioController() {
	        this.funcionarioModel = new FuncionarioModel();
	    }

	    public Funcionario save(Funcionario funcionario){
	        return this.funcionarioModel.save(funcionario);
	    }
}
