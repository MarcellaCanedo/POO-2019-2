package executavel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import classes.Automovel;

public class Principal {

	public static void main (String[] args) {
		
		String login = JOptionPane.showInputDialog("Informe o login:");
		String password = JOptionPane.showInputDialog("Informe o password:");
		
		if(login.equalsIgnoreCase("admin") &&
		password.equalsIgnoreCase("admin")){
			
		List<Automovel> automoveis = new ArrayList<Automovel>();
				
		Automovel automovel = new Automovel(); //objeto automovel
		
		}
		
	}
	
}
