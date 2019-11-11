package entity;
import java.util.*;

public class Automovel {

	 	private int id;
	    private String cor;
	    private String ano_fabricacao;
	    private String ano_modelo;
	    private String chassi;
	    private String placa;
	    private int km;
	    private float valor;
	    
	    
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getCor() {
	        return cor;
	        
	    }

	    public void setCor(String cor) {
	        this.cor = cor;
	    }

		public String getAno_modelo() {
			return ano_modelo;
		}

		public void setAno_modelo(String string) {
			this.ano_modelo = string;
		}

		public String getAno_fabricacao() {
			return ano_fabricacao;
		}

		public void setAno_fabricacao(String string) {
			this.ano_fabricacao = string;
		}

		public String getChassi() {
			return chassi;
		}

		public void setChassi(String chassi) {
			this.chassi = chassi;
		}

		public String getPlaca() {
			return placa;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public int getKm() {
			return km;
		}

		public void setKm(int string) {
			this.km = string;
		}

		public float getValor() {
			return valor;
		}

		public void setValor(float valor) {
			this.valor = valor;
		}
	    
}
