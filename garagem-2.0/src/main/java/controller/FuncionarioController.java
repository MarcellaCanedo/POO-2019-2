package controller;
import java.util.List;
import entity.Funcionario;
import model.FuncionarioModel;

public class FuncionarioController {

	 FuncionarioModel funcionarioModel;

	    public FuncionarioController() {
	        this.funcionarioModel = new FuncionarioModel();
	    }

	    public Funcionario save(Funcionario funcionario){
	        return this.funcionarioModel.save(funcionario);
	    }

	    public boolean update(int id, Funcionario f){
	        return funcionarioModel.update(id, f);
	    }

	    public boolean delete(int id){
	        return funcionarioModel.delete(id);
	    }

	    public List<Funcionario> findAll(){
	    	return funcionarioModel.findAll();
	    }

	    public Funcionario findById(int id){
	        return FuncionarioModel.findById(id);
	    }
}
