package controller;

import entity.Marca;
import entity.Modelo;
import model.ModeloModel;

import java.util.ArrayList;
import java.util.List;

public class ModeloController {

    ModeloModel modeloModel;

    public ModeloController() {
        this.modeloModel = new ModeloModel();
    }

    public Modelo save(Modelo modelo){
        return this.modeloModel.save(modelo);
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
