package controller;

import entity.Venda;
import model.VendaModel;

public class VendaController {

    VendaModel vendaModel;

    public VendaController(){
        this.vendaModel = new VendaModel();
    }

    public boolean cadastrar(Venda venda){
        return vendaModel.cadastrar(venda);
    }

    public boolean alterar(Venda v){

        return true;
    }

    public boolean buscar(String nome){
        return Boolean.parseBoolean(null);
    }

    public boolean excluir(String codigo){

        return true;
    }

}
