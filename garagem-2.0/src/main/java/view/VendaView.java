package view;

import controller.AutomovelController;
import controller.ClienteController;
import controller.FuncionarioController;
import controller.VendaController;
import entity.Automovel;
import entity.Cliente;
import entity.Funcionario;
import entity.Venda;
import model.VendaModel;

import java.util.Scanner;


	public class VendaView {
	    VendaController vendaController;
	    Scanner sc;

	    public VendaView(){
	        this.vendaController = new VendaController();
	        this.sc = new Scanner(System.in); }

	    public void menuVenda(){
	        System.out.println("\n ### Realizar Venda ### ");
	        System.out.println("1 - Realizar Venda");
	        System.out.println("2 - Cancelar Venda");
	        System.out.println("3 - Listar Vendas");
	        System.out.println("0  - Sair");
	        Scanner sc = new Scanner(System.in);
	        int op = sc.nextInt();

	        switch (op) {
	            case 1:
	                realizarVenda();
	                break;
	            case 2:
	               cancelarVenda();
	                break;
	            case 3:
	               //listarVenda();
	                break;
	            case 0:

	                break;
	            default:
	                System.out.println("Opção Inválida");
	                menuVenda();
	                break;
	        }

	        menuVenda();

	    }

	    public void realizarVenda() {

	        Venda venda = new Venda();
	        AutomovelController automovelController = new AutomovelController();
	        ClienteController clienteController = new ClienteController();
	        FuncionarioController funcionarioController = new FuncionarioController();

	        boolean dadosPrimarios = false;
	        Scanner sc = new Scanner(System.in);
	        System.out.println(" --> Placa do veículo ");
	        String placa = sc.nextLine();
	        System.out.println(" --> Código do cliente ");
	        String codigoCliente = sc.nextLine();
	        System.out.println(" --> Código do funcionário ");
	        String codigoFuncionario = sc.nextLine();

	      if (automovelController.verifica(placa)){
	            venda.setAutomovel(Automovel.enviaObjeto(placa));
	            if (ClienteView.verificaLista(codigoCliente)){
	                venda.setCliente(Cliente.enviaObjeto(codigoCliente));
	                if (Funcionario.verificaLista(codigoFuncionario)){
	                    venda.setFuncionario(Funcionario.enviaObjeto(codigoFuncionario));
	                    dadosPrimarios = true;
	                }
	            }
	        }



	        if (dadosPrimarios){
	            System.out.println("Codigo da venda");
	            venda.setCodigo(sc.nextLine());
	            
	            System.out.println("Data da venda");
	            String dataVenda = sc.nextLine();

	            System.out.println("Valor da venda");
	            venda.setValor_venda(sc.nextFloat());
	            System.out.println("Comissão da venda: ");
	            venda.setComissao_venda(sc.nextFloat());
	            venda.cadastrarVenda();

	            System.out.println("Venda realizada");

	        }else {
	            System.out.println("Dado inexistente");
	        }
	    }

	    private void cancelarVenda(){
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Digite o codigo da venda para excluí-la");
	        String codVenda = sc.nextLine();

	        if (VendaModel.excluirVenda(codVenda)){
	            System.out.println("entity.Venda Exlcuída");
	        }

	    }

	    /*private void listarVenda(){
	        if (VendaModel.verificaListaVazia()){
	            System.out.println("Nenhuma venda realizada");
	        }else {
	            VendaModel.listar()s;
	        }*/

}