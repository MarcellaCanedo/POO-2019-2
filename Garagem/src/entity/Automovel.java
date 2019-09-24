package entity;

import java.util.Date;

public class Automovel extends Modelo {

    private String cor;
    private String chassi;
    private String placa;
    private float km;
    private float valor;
    private Date ano_fab;
    private Date ano_modelo;

    public String getCor() { return cor; }

    public String getChassi() { return chassi; }

    public void setCor(String cor) { this.cor = cor; }

    public String getPlaca() { return placa; }

    public void setChassi(String chassi) { this.chassi = chassi; }

    public void setPlaca(String placa) { this.placa = placa; }

    public void setKm(float km) { this.km = km; }

    public float getKm() { return km; }

    public float getValor() { return valor; }

    public void setValor(float valor) { this.valor = valor; }

    public Date getAno_fab() { return ano_fab; }

    public void setAno_fab(Date ano_fab) { this.ano_fab = ano_fab; }

    public Date getAno_modelo() { return ano_modelo; }

    public void setAno_modelo(Date ano_modelo) { this.ano_modelo = ano_modelo; }

}