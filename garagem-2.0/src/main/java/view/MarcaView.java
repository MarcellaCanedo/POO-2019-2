package view;

import controller.MarcaController;
import entity.Marca;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MarcaView {

    MarcaController marcaController;

    public MarcaView() {
        this.marcaController = new MarcaController();
        }
        
    public void menuMarca() {
    	
            Scanner sc = new Scanner(System.in);
            int op;


            while (true) {
                System.out.println("Menu Marca");
                System.out.println("01 - Cadastrar Marca");
                System.out.println("02 - Listar Marcas");
                System.out.println("03 - Alterar Marcas");	
                System.out.println("04 - Excluir Marcas");
                System.out.println("05 - Buscar Marcas");
                System.out.println("06 - Sair");
                System.out.println("Escolha uma opção: \n");
                op = Integer.parseInt(sc.next());

                switch (op) {
                    case 1:
                    	this.save();
                        break;
                    case 2:
                        break;
                    case 3:
                    	this.update(null);
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("\n Voltando \n");
                        return;
                    case 7:
                        System.exit(7);
                    default:
                        System.out.println("\n Opção invalida \n");
                }
            }
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
    