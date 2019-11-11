package model;

import config.SQLConnection;
import entity.Marca;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.util.List;
import java.util.ArrayList;

public class MarcaModel {

    static Connection connection = null;

    public MarcaModel() { this.connection = SQLConnection.getConnection(); }

    public Marca save(Marca marca){

        String SQL = "insert into marca values ( ? , ? )";

        try{

            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "0");
            ps.setString(2, marca.getNome());
            ps.executeUpdate();
            int cont = 0;
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                marca.setId(rs.getInt(1));
                cont++;
            }
            if(cont > 0) {
            	return marca;
            }
            else {
            	return null;
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(int id, Marca m){
    	
    	String sql = "UPDATE marca SET nome=? WHERE idmarca=?";

    	try { 
	    	PreparedStatement ps = connection.prepareStatement(sql);
	    	ps.setString(1, m.getNome());
	    	ps.setInt(2, id);
	    	 
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
    	
    	String SQL = "DELETE FROM marca WHERE id = ?";
    	
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

    public List<Marca> findAll(){
    	
    	String SQL = "SELECT * FROM marca ORDER BY idmarca";
    	
    	ArrayList<Marca> marcas = new ArrayList<Marca>();
    	int cont = 0;
    	
    	try {
    	
	    	java.sql.Statement st = connection.createStatement();
	    	ResultSet rs = st.executeQuery(SQL);
	
	    	while(rs.next())
	    	{
	    	    Marca m = new Marca();
	    	    m.setId(rs.getInt("idmarca"));
	    	    m.setNome(rs.getString("nome" ));

	    	    marcas.add(m);
	    	    cont++;
	    	}

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    	if(cont < 1) {
    		return null;
    	}
        return marcas;
    }

    public static Marca findById(int idmarca){
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
