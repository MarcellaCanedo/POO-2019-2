package model;
import config.SQLConnection;
import entity.Automovel;

import java.sql.Connection;
import java.sql.Date;
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

        String SQL = "INSERT INTO marca VALUES (? ,? ,?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "0");
            ps.setString(2, automovel.getCor());
            ps.setDate(3,(Date) automovel.getAno_fabricacao());
            ps.setDate(4,(Date) automovel.getAno_modelo());
            ps.setString(5,automovel.getChassi());
            ps.setString(6,automovel.getPlaca());
            ps.setInt(7,automovel.getKm());
            ps.setFloat(3,automovel.getValor());
            ps.executeUpdate();
            int count = 0;
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
            	automovel.setId(rs.getInt(1));
                count++;
            }
            if(count > 0) {
            	return automovel;
            }
            else {
            	return null;
            }


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        /*System.out.println(" AQUI 2");*/
        return null;
    }

    public boolean update(int idautomovel, Automovel a){
    	
    	String sql = "UPDATE automovel SET placa=? WHERE idautomovel=?";

    	try { 
	    	PreparedStatement ps = connection.prepareStatement(sql);
	    	ps.setString(1, a.getPlaca());
	    	ps.setInt(2, idautomovel);
	    	 
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
    	int count = 0;
    	
    	try {
    	
	    	java.sql.Statement st = connection.createStatement();
	    	ResultSet rs = st.executeQuery(SQL);
	
	    	while(rs.next())
	    	{
	    		Automovel a = new Automovel();
	    	    a.setId(rs.getInt("id"));
	    	    a.setPlaca(rs.getString("Placa" ));

	    	    automoveis.add(a);
	    	    count++;
	    	}

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    	if(count < 1) {
    		return null;
    	}
        return automoveis;
    }

    public Automovel findById(float a2){
    	String SQL = "SELECT * FROM automovel WHERE idautomovel = ?";
    	
    	try {
    		PreparedStatement ps = connection.prepareStatement(SQL);
	    	ps.setFloat(1, a2);
	    		    	
	    	ResultSet rs = ps.executeQuery();
	    	
	    	if(rs.next()) {
		    	Automovel a = new Automovel();
	    	    a.setId(rs.getInt("idautomovel"));
	    	    a.setCor(rs.getString("cor"));
	    	    a.setAno_fabricacao(rs.getDate("Ano_Fabricacao"));
	    	    a.setAno_modelo(rs.getDate("Ano_modelo"));
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
