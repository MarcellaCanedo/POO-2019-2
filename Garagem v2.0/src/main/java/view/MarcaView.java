package view;

import controller.MarcaController;
import entity.Marca;

import java.util.List;

public class MarcaView {

    MarcaController marcaController;

    public MarcaView() {
        this.marcaController = new MarcaController();
    }

    public void menuMarca(){
        this.save();
    }


    public Marca save(){

        Marca m = new Marca();
        m.setNome("VW");

        Marca m2 = marcaController.save(m);

        if(m2 == null){
            System.out.println("Marca não foi inserida");
        } else {
            System.out.println("Marca");
            System.out.println("ID = " + m2.getId());
            System.out.println("NOME = " + m2.getNome());
        }


        return null;
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
