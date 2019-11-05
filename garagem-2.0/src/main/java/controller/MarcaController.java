package controller;
import entity.Marca;
import model.MarcaModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarcaController {
    MarcaModel marcaModel;
    private static Marca marca;
    //static List<Marca> marcaList = new ArrayList<>();
    private Scanner leitura = new Scanner(System.in);
    private int i;
    
   /* public void insereMarca() {
        marca = new Marca();
        System.out.println(" Marca : ");
        .setGaragem(leitura.nextLine());
        if (garagemList.isEmpty()) {
            System.out.println("\n Nenhuma garagem cadastrada \n");
            return;
        } else {
            for (i = 0; i < garagemList.size(); i++) {
                if (garagemList.get(i).getNome().contains(veiculo.getGaragem())) {
                    break;
                }*/
    
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
