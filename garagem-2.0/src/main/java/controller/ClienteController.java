package controller;
import java.util.List;

import entity.Cliente;
import model.ClienteModel;

public class ClienteController {

	ClienteModel clienteModel;

    public ClienteController() {
        this.clienteModel = new ClienteModel();
    }

    public Cliente save(Cliente cliente){
        return this.clienteModel.save(cliente);
    }

    public boolean update(int id, Cliente c){
        return clienteModel.update(id, c);
    }

    public boolean delete(int id){
        return clienteModel.delete(id);
    }

    public List<Cliente> findAll(){
    	return clienteModel.findAll();
    }

    public Cliente findById(int id){
        return ClienteModel.findById(id);
    }
	
}
