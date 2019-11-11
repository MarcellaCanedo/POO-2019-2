package controller;

import java.util.List;
import entity.Automovel;
import entity.Marca;
import model.AutomovelModel;
import model.MarcaModel;

public class AutomovelController {

	AutomovelModel automovelModel;

    public AutomovelController() {
        this.automovelModel = new AutomovelModel();
    }

    public Automovel save(Automovel automovel){
        return this.automovelModel.save(automovel);

    }

    public boolean update(int n, Automovel automovel){
        return automovelModel.update(n, automovel);
    }

    public boolean delete(int idautomovel){
        return automovelModel.delete(idautomovel);
    }

    public List<Automovel> findAll(){
    	return automovelModel.findAll();
    }

    public Automovel findById(int a){
        return automovelModel.findById(a);
    }

	public Automovel findById(Automovel a) {
		return null;
	}

}