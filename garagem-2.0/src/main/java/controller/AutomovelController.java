package controller;

import java.util.List;
import entity.Automovel;
import entity.Marca;
import model.MarcaModel;

public class AutomovelController {

	AutomovelModel automovelModel;

    public AutomovelController() {
        this.automovelModel = new AutomovelModel();
    }

    public Automovel save(Automovel automovel){

        return this.automovelModel.save(automovel);

    }

    public boolean update(int idautomovel, Automovel a){
        return automovelModel.update(idautomovel, a);
    }

    public boolean delete(int idautomovel){
        return automovelModel.delete(idautomovel);
    }

    public List<Automovel> findAll(){
    	return automovelModel.findAll();
    }

    public Automovel findById(int idautomovel){
        return marcaModel.findById(idautomovel);
    }
	
}