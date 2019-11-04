package controller;

import entity.Marca;
import model.MarcaModel;

import java.util.List;

public class MarcaController {

    MarcaModel marcaModel;

    public MarcaController() {
        this.marcaModel = new MarcaModel();
    }

    public Marca save(Marca marca){

        return this.marcaModel.save(marca);

    }

    public Marca update(Marca marca){
        return null;
    }

    public boolean delete(int id){
        return true;
    }

    public List<Marca> findAll(){
        return null;
    }

    public Marca findById(int id){
        return null;
    }

}
