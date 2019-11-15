package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;
import config.SQLConnection;
import entity.Cliente;

public class ClienteModel {
	
	static Connection connection = null;

    public ClienteModel() { ClienteModel.connection = SQLConnection.getConnection(); }

    public Cliente save(Cliente cliente){

        String SQL = "insert into marca values (?, ?, ?, ?, ?, ?, ?)";

        try{

            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "0");
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getEndereco());
            ps.setString(5, cliente.getDt_nascimento());
            ps.setInt(6, cliente.getCodigo());
            ps.setFloat(7, cliente.getSalario());
            ps.executeUpdate();
            int cont = 0;
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
            	cliente.setId(rs.getInt(1));
                cont++;
            }
            if(cont > 0) {
            	return cliente;
            }
            else {
            	return null;
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean update(int id, Cliente c){
    	
    	String sql = "UPDATE cliente SET nome= ? WHERE idcliente = ?";

    	try { 
	    	PreparedStatement ps = connection.prepareStatement(sql);
	    	ps.setString(1, "0");
            ps.setString(2, c.getNome());
            ps.setString(3, c.getCpf());
            ps.setString(4, c.getEndereco());
            ps.setString(5, c.getDt_nascimento());
            ps.setInt(6, c.getCodigo());
            ps.setFloat(7, c.getSalario());
	    	 
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
    	
    	String SQL = "DELETE FROM cliente WHERE id = ?";
    	
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

    public List<Cliente> findAll(){
    	
    	String SQL = "SELECT * FROM cliente ORDER BY idcliente";
    	
    	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    	int cont = 0;
    	
    	try {
    	
	    	java.sql.Statement st = connection.createStatement();
	    	ResultSet rs = st.executeQuery(SQL);
	
	    	while(rs.next())
	    	{
	    		Cliente c = new Cliente();
	    	    
	    	    c.setId(rs.getInt("idcliente"));
	    	    c.setNome(rs.getString("nome"));
	    	    c.setCpf(rs.getString ("cpf"));
	    	    c.setEndereco(rs.getString("endereco"));
	    	    c.setDt_nascimento(rs.getString("dt_nascimento"));
	    	    c.setCodigo(rs.getInt("codigo"));
	    	    c.setSalario(rs.getFloat("salario"));

	    	    c.add(c);
	    	    cont++;
	    	}

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    	if(cont < 1) {
    		return null;
    	}
        return clientes;
    }

    public static Cliente findById(int idcliente){
    	
    	String SQL = "SELECT * FROM cliente WHERE idcliente = ?";
    	
    	try {
    		PreparedStatement ps = connection.prepareStatement(SQL);
	    	ps.setInt(1, idcliente);
	    		    	
	    	ResultSet rs = ps.executeQuery();
	    	
	    	if(rs.next()) {
	    		Cliente c = new Cliente();
	    		c.setId(rs.getInt("idfuncionario"));
	    	    c.setNome(rs.getString("nome"));
	    	    c.setCpf(rs.getString ("cpf"));
	    	    c.setEndereco(rs.getString("endereco"));
	    	    c.setDt_nascimento(rs.getString("dt_nascimento"));
	    	    c.setCodigo(rs.getInt("codigo"));
	    	    c.setSalario(rs.getFloat("salario"));
	    	    
	    	    return c;
	    	}else {
	    		return null;
	    	}
    	    
    	} catch (Exception e){
            System.out.println(e.getMessage());
        }
		return null;
    }
	
}
