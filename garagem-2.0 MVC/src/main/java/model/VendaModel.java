package model;
import entity.Venda;
import java.util.ArrayList;

	public class VendaModel {

	    private ArrayList<Venda> listaVendas = new ArrayList<Venda>();

	    public boolean cadastrar(Venda venda){
	        this.listaVendas.add(venda);
	        return true;
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

		public static boolean excluirVenda(String codVenda) {
			return false;
		}

		public static boolean verificaListaVazia() {
			return false;
		}

		public static void listar() {
			
		}

	}
