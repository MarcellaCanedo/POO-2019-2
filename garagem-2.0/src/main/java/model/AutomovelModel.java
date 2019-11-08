package model;
import config.SQLConnection;
import entity.Automovel;

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

        String SQL = "INSERT INTO marca VALUES (?,?)";

        try{

            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "0");
            ps.setString(2, automovel.getNome());
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
    	
    	String sql = "UPDATE automovel SET nome=? WHERE idautomovel=?";

    	try { 
	    	PreparedStatement ps = connection.prepareStatement(sql);
	    	ps.setString(1, a.getNome());
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
	    	ps.setInt(1, idautomovel);
	    	 
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
    	
    	ArrayList<Automovel> marcas = new ArrayList<Automovel>();
    	int count = 0;
    	
    	try {
    	
	    	java.sql.Statement st = connection.createStatement();
	    	ResultSet rs = st.executeQuery(SQL);
	
	    	while(rs.next())
	    	{
	    		Automovel a = new Automovel();
	    	    a.setIdautomovel(rs.getInt("idautomovel"));
	    	    a.setNome(rs.getString("nome" ));

	    	    automoveis.add(m);
	    	    count++;
	    	}

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    	if(count < 1) {
    		return null;
    	}
        return marcas;
    }

    public Marca findById(int idmarca){
    	String SQL = "SELECT * FROM marca WHERE idmarca = ?";
    	
    	try {
    		PreparedStatement ps = connection.prepareStatement(SQL);
	    	ps.setInt(1, idmarca);
	    		    	
	    	ResultSet rs = ps.executeQuery();
	    	
	    	if(rs.next()) {
		    	Marca m = new Marca();
	    	    m.setId(rs.getInt("idmarca"));
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
