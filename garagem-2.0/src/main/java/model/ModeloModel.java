package model;

import config.SQLConnection;
import entity.Marca;
import entity.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class ModeloModel {

    Connection connection = null;

    public ModeloModel() {
        this.connection = SQLConnection.getConnection();
    }

    public Modelo save(Modelo Modelo){

        String SQL = "INSERT INTO modelo VALUES ( ?, ?, ?, ?)";

        try{

            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "0");
            ps.setString(2, Modelo.getNome());
            ps.setString(3, Modelo.getTipo());
            ps.setInt(4, Modelo.getMarca().getId());

            ps.executeUpdate();

            int cont = 0;
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                Modelo.setId(rs.getInt(1));
                Modelo.setNome(rs.getString(2));
                Modelo.setTipo(rs.getString(3));
                int i = rs.getInt(4);
                Marca marca = new Marca();
                marca = this.selectMarca(i);
                Modelo.setMarca(marca);
                cont++;
            }
            if(cont > 0) {
            	return Modelo;
            }
            else {
            	return null;
            }


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(" AQUI 2");
        return null;
    }

    public boolean update(int id, Modelo m){
    	
    	String sql = "UPDATE modelo SET nome=?, tipo=?, marca=? WHERE id=?";

    	try { 
	    	PreparedStatement ps = connection.prepareStatement(sql);
	    	ps.setString(1, m.getNome());
	    	ps.setString(2, m.getTipo());
	    	ps.setInt(3, m.getMarca().getId());
	    	ps.setInt(4, id);
	    	 
	    	int rowsUpdated = ps.executeUpdate();
	    	if (rowsUpdated > 0) {
	    	    return true;
	    	}
	    	else {
	    		return false;
	    	}
    	} catch (Exception e){
            System.out.println(e.getMessage());
        }
    	return false;
    }

    public boolean delete(int id){
    	
    	String SQL = "DELETE FROM modelo WHERE idmodelo = ?";
    	
    	try {
	    	PreparedStatement ps = connection.prepareStatement(SQL);
	    	ps.setInt(1, id);
	    	 
	    	int rowsDeleted = ps.executeUpdate();
	    	if (rowsDeleted > 0) {
	    	    return true;
	    	}
	    	else {
	    		return false;
	    	}
    	} catch (Exception e){
            System.out.println(e.getMessage());
        }
		return false;
    }

    public List<Modelo> findAll(){
    	
    	String SQL = "SELECT * FROM modelo ORDER BY idmodelo";
    	
    	ArrayList<Modelo> Modelos = new ArrayList<Modelo>();
    	int cont = 0;
    	
    	try {
    	
	    	java.sql.Statement st = connection.createStatement();
	    	ResultSet rs = st.executeQuery(SQL);
	
	    	while(rs.next())
	    	{
	    	    Modelo modelo = new Modelo();
	    	    modelo.setId(rs.getInt("id"));
	    	    modelo.setNome(rs.getString("nome"));
	    	    modelo.setTipo(rs.getString("tipo"));
	    	    int i = rs.getInt("marca");
                Marca marca = new Marca();
                marca = this.selectMarca(i);
                modelo.setMarca(marca);
	    	    
	    	    Modelos.add(modelo);
	    	    cont++;
	    	}

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    	if(cont < 1) {
    		return null;
    	}
        return Modelos;
    }

    public Modelo findById(int id){
    	String SQL = "SELECT * FROM Modelo WHERE idmodelo = ?";
    	
    	try {
    		PreparedStatement ps = connection.prepareStatement(SQL);
	    	ps.setInt(1, id);
	    		    	
	    	ResultSet rs = ps.executeQuery();
	    	
	    	if(rs.next()) {
	    		Modelo modelo = new Modelo();
	    	    modelo.setId(rs.getInt("id"));
	    	    modelo.setNome(rs.getString("nome"));
	    	    modelo.setTipo(rs.getString("tipo"));
	    	    int i = rs.getInt("marca");
                Marca marca = new Marca();
                marca = this.selectMarca(i);
                modelo.setMarca(marca);
	    	    return modelo;
	    	}else {
	    		return null;
	    	}
    	    
    	} catch (Exception e){
            System.out.println(e.getMessage());
        }
		return null;
    }

	public Marca selectMarca(int id) {
		String SQL = "SELECT * FROM marca WHERE idmodelo = ?";
    	
    	try {
    		PreparedStatement ps = connection.prepareStatement(SQL);
	    	ps.setInt(1, id);
	    		    	
	    	ResultSet rs = ps.executeQuery();
	    	
	    	if(rs.next()) {
		    	Marca m = new Marca();
	    	    m.setId(rs.getInt("idmodelo"));
	    	    m.setNome(rs.getString("nome"));
	    	    return m;
	    	}else {
	    		return null;
	    	}
    	    
    	} catch (Exception e){
            System.out.println(e.getMessage());
        }
		return null;
	}
}
