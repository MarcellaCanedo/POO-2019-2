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
			        
			        System.out.println("-> Ano de Fabrição: ");
			        /*Date d = new Date(op, op, op);
			        a.setAno_fabricacao(c.nextInt(d));  //Ainda não funciona as datas
			        Automovel a3 = this.save(a);*/
			        
			        System.out.println("-> Ano do modelo: ");
			        /*Date d = new Date(op, op, op);
			        a.setAno_modelo(d(c.nextInt());  //Ainda não funciona as datas
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
			        
			        System.out.println("Valor do automóvel: ");
			        a.setKm(c.nextInt());
			        Automovel a6 = this.save(a);
			        
			        if(a == null){
			            System.out.println("\nO Automóvel não foi cadastrado!\n");
			        } else {
			            System.out.println("\n\nAutomóvel cadastrado com sucesso!");
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
			    		System.out.println("Nenhum veículo encontrado!");
			    	}
			    	System.out.println("\n");
					menuAutomovel();
			        break;
		        }
				
				case 3:{
					System.out.println("####  Buscar Automóvel  ####");
					Scanner c = new Scanner(System.in);
					System.out.println("Informe o código do Automóvel:");
			        int n = c.nextInt();
			        Automovel a = new Automovel();
					a = this.findById(a);
					if(a != null) {
						if(a.getId() < 10) {
		    				System.out.println("ID - 0"+a.getId());
		    			}else {
		    				System.out.println("ID - "+a.getId());
		    			}
						System.out.println("COR -> "+a.getPlaca());
			            System.out.println("PLACA -> "+a.getPlaca());
			            System.out.println("VALOR -> "+a.getValor());
					}
					else {
						System.out.println("Esta placa ainda não existe!!\n");
					}
					System.out.println("\n");
					menuAutomovel();
			        break;
		        }
				
				case 4:{
					System.out.println("####  Alterar Marca  ####");
					Scanner c = new Scanner(System.in);
					System.out.println("Informe a Placa do Automóvel:");
			        int a = c.nextInt();
			        Automovel a1 = this.findById(a1);
			        if(a1 == null) {
			        	System.out.println("Este código não existe!\n");
			        	menuAutomovel();
			        }
			        else {
			        	System.out.println("Id  Automovel");
			        	if(a1.getId() < 10) {
		    				System.out.println("ID - 0"+a1.getId());
		    			}else {
		    				System.out.println("ID - "+a1.getId());
		    			}
			        	System.out.println("COR -> "+a1.getPlaca());
			            System.out.println("PLACA -> "+a1.getPlaca());
			            System.out.println("VALOR -> "+a1.getValor());
			        }
			        
			        System.out.println("Informe os novos dados: ");
			        System.out.println("COR ->");
			        Scanner cor = new Scanner(System.in);
		            a1.setCor(cor.next());
			        
			        /*MODIFICARRRRRRRRRRRRRRRRRR*/
			        System.out.println("ANO DE FABRICAÇÃO -> ");
			        Scanner ano_fabricacao = new Scanner(System.in);
			        a1.setAno_fabricacao(Ano_fabricacao.next());
			        
			        System.out.println("ANO DO MODELO -> ");
			        Scanner ano_modelo = new Scanner(System.in);
			        a1.setAno_fabricacao(Ano_fabricacao.next());
			        
			        System.out.println("CHASSI -> ");
			        Scanner chassi = new Scanner(System.in);
			        a1.setAno_fabricacao(Ano_fabricacao.next());
			        
			        System.out.println("PLACA -> ");
			        Scanner placa = new Scanner(System.in);
			        a1.setAno_fabricacao(Ano_fabricacao.next());
			        
			        System.out.println("KILOMETRAGEM -> ");
			        Scanner km = new Scanner(System.in);
			        a1.setAno_fabricacao(Ano_fabricacao.next());
			        
			        System.out.println("VALOR -> ");
			        Scanner valor = new Scanner(System.in);
			        a1.setAno_fabricacao(Ano_fabricacao.next());
			        
			        
			        
			        System.out.println("\nInforme o novo nome da Marca:");
			        Scanner nome = new Scanner(System.in);
			        m.setNome(nome.next());

			        boolean resp = this.update(n, m);
			        if(resp == true) {
			        	System.out.println("Informações do automóvel alteradas!");
			        }
			        else {
			        	System.out.println("A marca não foi alterada ou não existe!");
			        }
			        
			        menuAutomovel();
			        break;
		        }
				
				case 5:{
					System.out.println(" Excluir Automóvel: ");
					Scanner c = new Scanner(System.in);
					System.out.println("Informe a placa do automóvel:");
			        int n = c.nextInt();
			        boolean resp = this.delete(n);
			        if(resp == true) {
			        	System.out.println("Automóvel excluido!!!");
			        }
			        else {
			        	System.out.println("Automóvel não encontrado");
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

	    public boolean update(int idautomovel, Automovel a){
	        return automovelController.update(idautomovel, a);
	    }

	    public boolean delete(int idautomovel){
	    	return automovelController.delete(idautomovel);
	    }

	    public List <Automovel> findAll(){
	    	return automovelController.findAll();
	    }

	    public Automovel findById(Automovel a){
	    	return automovelController.findById(a);
	    }

	
}
