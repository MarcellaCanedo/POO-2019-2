package entity;
import java.util.*;

public class Automovel {

	 	private int id;
	    private String cor;
	    private Date ano_fabricacao;
	    private Date ano_modelo;
	    private int chassi;
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

		public Date getAno_modelo() {
			return ano_modelo;
		}

		public void setAno_modelo(Date ano_modelo) {
			this.ano_modelo = ano_modelo;
		}

		public Date getAno_fabricacao() {
			return ano_fabricacao;
		}

		public void setAno_fabricacao(Date ano_fabricacao) {
			this.ano_fabricacao = ano_fabricacao;
		}

		public int getChassi() {
			return chassi;
		}

		public void setChassi(int chassi) {
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

		public void setKm(int km) {
			this.km = km;
		}

		public float getValor() {
			return valor;
		}

		public void setValor(float valor) {
			this.valor = valor;
		}
	    
}
