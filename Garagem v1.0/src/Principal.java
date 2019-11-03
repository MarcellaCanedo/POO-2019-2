import entity.Funcionario;
import view.ClienteView;
import view.FuncionarioView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String args[]){
        System.out.println("---> Garagem de Automóveis <---");

        Principal principal = new Principal();
        principal.menuPrincipal();
    }

    public void menuPrincipal(){

        System.out.println("#Menu Principal");
        System.out.println("01- Funcionário");
        System.out.println("02- Cliente");
        System.out.println("03- Automóvel");
        System.out.println("04- Vendas");
        System.out.println("00- Sair");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op){
            case 1:
                FuncionarioView funcionarioView = new FuncionarioView();
                funcionarioView.menuFuncionario();
                break;
            case 2:
                /*ClienteView clienteView = new ClienteView();
                clienteView.menuCliente();*/
                break;
            case 3:
                break;
            case 4:
                break;
            case 0: default:
                System.exit(0);
                break;
        }

    }



   /* public void listarFuncionario(){
        System.out.println("#Lista de funcionarios");
        for(Funcionario f:listaFuncionarios){
            System.out.println(f.codigo + " | " + f.getNome() + " | " + f.getCpf() + " " + f.usuario) ;
        }
    }

    public void buscarFuncionario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de funcionario");
        String busca = sc.nextLine();
        for (Funcionario f : listaFuncionarios){
            if(f.getNome().equals(busca)){
                System.out.println("Nome: " + f.getNome());
                System.out.println("CPF: " + f.getCpf());
            }
        }
    }

    public void excluirFuncionario(){
        Scanner sc = new Scanner(System.in);

        System.out.println("# Busca de funcionario");
        String busca = sc.nextLine();

        List<Funcionario> listaParaRemover = new ArrayList<>();

        for (Funcionario f : listaFuncionarios){
            if(f.getNome().equals(busca)){
                listaParaRemover.add(f);
            }
        }

        listaFuncionarios.removeAll(listaParaRemover);

    }*/

}
