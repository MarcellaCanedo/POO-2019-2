package view;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.fabric.xmlrpc.base.Data;

import controller.AutomovelController;
import controller.MarcaController;
import entity.Automovel;
import entity.Marca;

public class AutomovelView {

	 	AutomovelController automovelController;
	    
	    ArrayList<Automovel> automoveis = new ArrayList<Automovel>();

		private Automovel bautomovel;

	    public AutomovelView() {
	        this.automovelController = new AutomovelController();
	    }

	    public void menuAutomovel(){
	    	
	    	int op;
	    	System.out.println("Menu Automoveis");
	    	System.out.println("1 - Cadastrar");
	    	System.out.println("2 - Listar");
	    	System.out.println("3 - Buscar");
	    	System.out.println("4 - Alterar");
	    	System.out.println("5 - Excluir");
	    	System.out.println("0 - Voltar");
	    	Scanner sc = new Scanner(System.in);
	    	op = sc.nextInt();
	    	switch (op) {
				
				case 1:{
					System.out.println("Cadastrar Automovel: ");
					Automovel a = new Automovel();
			        Scanner c = new Scanner(System.in);

			        System.out.println("-> Cor: ");
			        a.setCor(c.nextLine());
			        Automovel a2 = this.save(a);
			        
			        System.out.println("-> Ano de Fabri��o: ");
			        /*Date d = new Date(op, op, op);
			        a.setAno_fabricacao(c.nextInt(d));  //Ainda n�o funciona as datas
			        Automovel a3 = this.save(a);*/
			        
			        System.out.println("-> Ano do modelo: ");
			        /*Date d = new Date(op, op, op);
			        a.setAno_modelo(d(c.nextInt());  //Ainda n�o funciona as datas
			        Automovel a3 = this.save(a);*/
			        
			        System.out.println("-> Chassi: ");
			        a.setChassi(c.nextLine());
			        Automovel a3 = this.save(a);
			        
			        System.out.println("-> Placa: ");
			        a.setPlaca(c.nextLine());
			        Automovel a4 = this.save(a);
			        
			        System.out.println("-> Kilometragem: ");
			        a.setKm(c.nextInt());
			        Automovel a5 = this.save(a);
			        
			        System.out.println("Valor do autom�vel: ");
			        a.setKm(c.nextInt());
			        Automovel a6 = this.save(a);
			        
			        if(a == null){
			            System.out.println("\nO Autom�vel n�o foi cadastrado!\n");
			        } else {
			            System.out.println("\n\nAutom�vel cadastrado com sucesso!");
			            if(a.getId() < 10) {
		    				System.out.println("ID - 0"+a.getId());
		    			}else {
		    				System.out.println("ID - "+a.getId());
		    			}
			            System.out.println("COR -> "+a.getPlaca());
			            System.out.println("PLACA -> "+a.getPlaca());
			            System.out.println("VALOR -> "+a.getValor());
			        }
			        
			        menuAutomovel();
			        break;
		        }
				
				case 2:{
					automoveis = (ArrayList <Automovel> ) this.findAll();
			    	System.out.println("####  Listar Marca ####");
			    	if(automoveis != null) {
			    		automoveis.forEach((a) -> {
			    			if(a.getId() < 10) {
			    				System.out.println("ID - 0"+a.getId());
			    			}else {
			    				System.out.println("ID - "+a.getId());
			    			}
			    			System.out.println("COR -> "+a.getPlaca());
				            System.out.println("PLACA -> "+a.getPlaca());
				            System.out.println("VALOR -> "+a.getValor());
				            System.out.println("\n");
				            System.out.println("##############################");
			    		});
			    	}else {
			    		System.out.println("Nenhum ve�culo encontrado!");
			    	}
			    	System.out.println("\n");
					menuAutomovel();
			        break;
		        }
				
				case 3:{
					System.out.println("####  Buscar Autom�vel  ####");
					Scanner c = new Scanner(System.in);
					System.out.println("Informe o c�digo do Autom�vel:");
			        int n = c.nextInt();
			        Automovel bautomovel = new Automovel();
			        bautomovel = findById(bautomovel);
					if(bautomovel != null) {
						if(bautomovel.getId() < 10) {
		    				System.out.println("ID - 0"+bautomovel.getId());
		    			}else {
		    				System.out.println("ID - "+bautomovel.getId());
		    			}
						System.out.println("COR -> "+bautomovel.getPlaca());
			            System.out.println("PLACA -> "+bautomovel.getPlaca());
			            System.out.println("VALOR -> "+bautomovel.getValor());
					}
					else {
						System.out.println("Esta placa ainda n�o existe!!\n");
					}
					System.out.println("\n");
					menuAutomovel();
			        break;
		        }
				
				case 4:{
					System.out.println("####  Alterar Autom�vel  ####");
					Scanner c = new Scanner(System.in);
					System.out.println("Informe a Placa do Autom�vel:");
			        int n = c.nextInt();
			        Automovel automovel = this.findById(bautomovel);
			        if(automovel == null) {
			        	System.out.println("Este c�digo n�o existe!\n");
			        	menuAutomovel();
			        }
			        else {
			        	System.out.println("Id  Automovel");
			        	if(automovel.getId() < 10) {
		    				System.out.println("ID - 0"+automovel.getId());
		    			}else {
		    				System.out.println("ID - "+automovel.getId());
		    			}
			        	System.out.println("COR -> "+automovel.getPlaca());
			            System.out.println("PLACA -> "+automovel.getPlaca());
			            System.out.println("VALOR -> "+automovel.getValor());
			        }
			        
			        System.out.println("Informe os novos dados: ");
			        System.out.println("COR ->");
			        Scanner cor = new Scanner(System.in);
			        automovel.setCor(cor.next());
			        
			        System.out.println("ANO DE FABRICA��O -> ");
			        Scanner ano_fabricacao = new Scanner(System.in);
			        /*a1.setAno_fabricacao(ano_fabricacao.next());*/
			        
			        System.out.println("ANO DO MODELO -> ");
			        Scanner ano_modelo = new Scanner(System.in);
			        /*a1.setAno_fabricacao(ano_fabricacao.next());*/
			        
			        System.out.println("CHASSI -> ");
			        Scanner chassi = new Scanner(System.in);
			        /*a1.setAno_fabricacao(ano_fabricacao.next());*/
			        
			        System.out.println("PLACA -> ");
			        Scanner placa = new Scanner(System.in);
			        /*a1.setAno_fabricacao(ano_fabricacao.next());*/
			        
			        System.out.println("KILOMETRAGEM -> ");
			        Scanner km = new Scanner(System.in);
			        /*a1.setAno_fabricacao(ano_fabricacao.next());*/
			        
			        System.out.println("VALOR -> ");
			        Scanner valor = new Scanner(System.in);
			        /*a1.setAno_fabricacao(ano_fabricacao.next());*/
			      
					boolean resp = this.update(n, automovel);
			        if(resp == true) {
			        	System.out.println("Informa��es do autom�vel alteradas!");
			        }
			        else {
			        	System.out.println("A marca n�o foi alterada ou n�o existe!");
			        }
			        
			        menuAutomovel();
			        break;
		        }
				
				case 5:{
					System.out.println(" Excluir Autom�vel: ");
					Scanner c = new Scanner(System.in);
					System.out.println("Informe a placa do autom�vel:");
			        int n = c.nextInt();
			        boolean resp = this.delete(n);
			        if(resp == true) {
			        	System.out.println("Autom�vel excluido!!!");
			        }
			        else {
			        	System.out.println("Autom�vel n�o encontrado");
			        }
			        
					menuAutomovel();    
			        break;
		        }
				
				case 0:{
					break;
					
				}
	    	}
	    }

		public Automovel save(Automovel a){
	    	return automovelController.save(a);
	    }

	    public boolean update(int n, Automovel aautomovel){
	        return automovelController.update(n, aautomovel);
	    }

	    public boolean delete(int idautomovel){
	    	return automovelController.delete(idautomovel);
	    }

	    public List <Automovel> findAll(){
	    	return automovelController.findAll();
	    }

	    public Automovel findById(Automovel bautomovel){
	    	return automovelController.findById(bautomovel);
	    }
}
