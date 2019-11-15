package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;
import config.SQLConnection;
import entity.Funcionario;

public class FuncionarioModel {
	
	 static Connection connection = null;

	    public FuncionarioModel() { FuncionarioModel.connection = SQLConnection.getConnection(); }

	    public Funcionario save(Funcionario funcionario){

	        String SQL = "insert into marca values (?, ?, ?, ?, ?, ?, ?, ?)";

	        try{

	            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, "0");
	            ps.setString(2, funcionario.getNome());
	            ps.setString(3, funcionario.getCpf());
	            ps.setString(4, funcionario.getEndereco());
	            ps.setString(5, funcionario.getDt_nascimento());
	            ps.setInt(6, funcionario.getCodigo());
	            ps.setString(7, funcionario.getUsuario());
	            ps.setString(8, funcionario.getSenha());
	            ps.setFloat(9, funcionario.getSalario());
	            ps.executeUpdate();
	            int cont = 0;
	            
	            ResultSet rs = ps.getGeneratedKeys();
	            if(rs.next()){
	                funcionario.setId(rs.getInt(1));
	                cont++;
	            }
	            if(cont > 0) {
	            	return funcionario;
	            }
	            else {
	            	return null;
	            }

	        } catch (Exception e){
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }

	    public boolean update(int id, Funcionario f){
	    	
	    	String sql = "UPDATE funcionario SET nome= ? WHERE idfuncionario = ?";

	    	try { 
		    	PreparedStatement ps = connection.prepareStatement(sql);
		    	ps.setString(1, "0");
	            ps.setString(2, f.getNome());
	            ps.setString(3, f.getCpf());
	            ps.setString(4, f.getEndereco());
	            ps.setString(5, f.getDt_nascimento());
	            ps.setInt(6, f.getCodigo());
	            ps.setString(7, f.getUsuario());
	            ps.setString(8, f.getSenha());
	            ps.setFloat(9, f.getSalario());
		    	 
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
	    	
	    	String SQL = "DELETE FROM funcionario WHERE id = ?";
	    	
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

	    public List<Funcionario> findAll(){
	    	
	    	String SQL = "SELECT * FROM funcionario ORDER BY idfuncionario";
	    	
	    	ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	    	int cont = 0;
	    	
	    	try {
	    	
		    	java.sql.Statement st = connection.createStatement();
		    	ResultSet rs = st.executeQuery(SQL);
		
		    	while(rs.next())
		    	{
		    	    Funcionario func = new Funcionario();
		    	    
		    	    func.setId(rs.getInt("idfuncionario"));
		    	    func.setNome(rs.getString("nome"));
		    	    func.setCpf(rs.getString ("cpf"));
		    	    func.setEndereco(rs.getString("endereco"));
		    	    func.setDt_nascimento(rs.getString("dt_nascimento"));
		    	    func.setCodigo(rs.getInt("codigo"));
		    	    func.setUsuario(rs.getString("usuario"));
		    	    func.setSenha(rs.getString("senha"));
		    	    func.setSalario(rs.getFloat("salario"));

		    	    func.add(func);
		    	    cont++;
		    	}

	        } catch (Exception e){
	            System.out.println(e.getMessage());
	        }
	    	if(cont < 1) {
	    		return null;
	    	}
	        return funcionarios;
	    }

	    public static Funcionario findById(int idfuncionario){
	    	
	    	String SQL = "SELECT * FROM funcionario WHERE idfuncionario = ?";
	    	
	    	try {
	    		PreparedStatement ps = connection.prepareStatement(SQL);
		    	ps.setInt(1, idfuncionario);
		    		    	
		    	ResultSet rs = ps.executeQuery();
		    	
		    	if(rs.next()) {
		    		Funcionario func = new Funcionario();
		    		func.setId(rs.getInt("idfuncionario"));
		    	    func.setNome(rs.getString("nome"));
		    	    func.setCpf(rs.getString ("cpf"));
		    	    func.setEndereco(rs.getString("endereco"));
		    	    func.setDt_nascimento(rs.getString("dt_nascimento"));
		    	    func.setCodigo(rs.getInt("codigo"));
		    	    func.setUsuario(rs.getString("usuario"));
		    	    func.setSenha(rs.getString("senha"));
		    	    func.setSalario(rs.getFloat("salario"));
		    	    
		    	    return func;
		    	}else {
		    		return null;
		    	}
	    	    
	    	} catch (Exception e){
	            System.out.println(e.getMessage());
	        }
			return null;
	    }
}
