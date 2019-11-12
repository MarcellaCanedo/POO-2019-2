package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Statement;
import config.SQLConnection;
import entity.Automovel;
import entity.Funcionario;
import entity.Modelo;

public class FuncionarioModel {
	
	Connection connection = null;

    public FuncionarioModel() {
        connection = SQLConnection.getConnection();
    }

    public Funcionario save(Funcionario funcionario){
    	return null;
    }
}
