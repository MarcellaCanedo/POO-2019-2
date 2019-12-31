package controller;
import entity.Marca;
import entity.Modelo;
import java.util.List;
import model.ModeloModel;

public class ModeloController {

    ModeloModel modeloModel;

    public ModeloController() {
        modeloModel = new ModeloModel();
    }

    public Modelo save(Modelo modelo){
        return modeloModel.save(modelo);
    }

    public boolean update(int id, Modelo m){
        return modeloModel.update(id, m);
    }

    public boolean delete(int id){
        return modeloModel.delete(id);
    }

    public List<Modelo> findAll(){
    	return modeloModel.findAll();
    }

    public Modelo findById(int id){
        return modeloModel.findById(id);
    }

	public Marca selectMarca(int id) {
		return modeloModel.selectMarca(id);
	}

}
