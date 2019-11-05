package model;

import config.SQLConnection;
import entity.Marca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MarcaModel {

    Connection connection;

    public MarcaModel() {
        this.connection = SQLConnection.getConnection();
    }

    public Marca save(Marca marca){

        String SQL = "INSERT INTO marca (nome) VALUES (?)";

        try{

            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, marca.getNome());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                System.out.println(" AQUI 1");
                System.out.println(rs.getInt(1));
                marca.setId(rs.getInt(1));
                return marca;
            }


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(" AQUI 2");
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
