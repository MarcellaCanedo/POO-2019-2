package entity;

import entity.Marca;

public class Modelo extends Marca {

    private String nome_modelo;
    private String tipo;

    public String getNome_modelo() { return nome_modelo; }

    public void setNome_modelo(String nome_modelo) { this.nome_modelo = nome_modelo; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }
}