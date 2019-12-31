package model;
import config.SQLConnection;
import entity.Automovel;
import entity.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;

public class AutomovelModel {

	Connection connection = null;

    public AutomovelModel() {
        this.connection = SQLConnection.getConnection();
    }

    public Automovel save(Automovel automovel){

        String SQL = "INSERT INTO automovel VALUES (? ,? , ?, ?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "0");
            ps.setString(2, automovel.getCor());
            ps.setString(3, automovel.getAno_fabricacao());
            ps.setString(4, automovel.getAno_modelo());
            ps.setString(5,automovel.getChassi());
            ps.setString(6,automovel.getPlaca());
            ps.setInt(7,automovel.getKm());
            ps.setFloat(8,automovel.getValor());
            ps.setInt(9, Modelo.getModelo().getId());
            ps.executeUpdate();
            int cont= 0;
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
            	automovel.setId(rs.getInt(1));
                cont++;
            }
            if(cont > 0) {
            	return automovel;
            }
            else {
            	return null;
            }


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(int a1, Automovel a){
    	
    	String sql = "UPDATE automovel SET placa=? WHERE idautomovel=?";

    	try { 
	    	PreparedStatement ps = connection.prepareStatement(sql);
	    	ps.setInt(1, a.getId());
            ps.setString(2, a.getCor());
            ps.setString(3, a.getAno_fabricacao());
            ps.setString(4, a.getAno_modelo());
            ps.setString(5,a.getChassi());
            ps.setString(6,a.getPlaca());
            ps.setInt(7, a.getKm());
            ps.setFloat(8, a.getValor());
            ps.setInt(9, Modelo.getModelo().getId());
	    	 
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
    	
    	String SQL = "DELETE FROM automovel WHERE idautomovel = ?";
    	
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

    public List<Automovel> findAll(){
    	
    	String SQL = "SELECT * FROM automovel ORDER BY idautomovel";
    	
    	ArrayList<Automovel> automoveis = new ArrayList<Automovel>();
    	int cont = 0;
    	
    	try {
    	
	    	java.sql.Statement st = connection.createStatement();
	    	ResultSet rs = st.executeQuery(SQL);
	
	    	while(rs.next())
	    	{
	    		Automovel a = new Automovel();
	    	    a.setId(rs.getInt("id"));
	    	    a.setPlaca(rs.getString("Placa" ));
	    	    
	    	    a.setId(rs.getInt("id"));
	            a.setCor(rs.getString("cor"));
	            a.setAno_fabricacao(rs.getString("Ano_fabricacao"));
	            a.setAno_modelo(rs.getString("Ano_modelo"));
	            a.setChassi(rs.getString("Chassi"));
	            a.setPlaca(rs.getString("Placa"));
	            a.setKm(rs.getInt("Kilometragem"));
	            a.setValor(rs.getFloat("Valor"));
	            a.setCor(rs.getString("cor"));

	    	    automoveis.add(a);
	    	    cont++;
	    	}

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    	if(cont < 1) {
    		return null;
    	}
        return automoveis;
    }

    public Automovel findById(int a2){
    	String SQL = "SELECT * FROM automovel WHERE idautomovel = ?";
    	
    	try {
    		PreparedStatement ps = connection.prepareStatement(SQL);
	    	ps.setInt(1, a2);
	    		    	
	    	ResultSet rs = ps.executeQuery();
	    	
	    	if(rs.next()) {
		    	Automovel a = new Automovel();
	    	    a.setId(rs.getInt("idautomovel"));
	    	    a.setCor(rs.getString("cor"));
	    	    a.setAno_fabricacao(rs.getString("Ano_Fabricacao"));
	    	    a.setAno_modelo(rs.getString("Ano_modelo"));
	    	    a.setChassi(rs.getString("Chassi"));
	    	    a.setPlaca(rs.getString("Placa"));
	    	    a.setKm(rs.getInt("Km"));
	    	    a.setValor(rs.getFloat("Valor"));
	    	    return a;
	    	}else {
	    		return null;
	    	}
    	    
    	} catch (Exception e){
            System.out.println(e.getMessage());
        }
		return null;
    }
	
}
