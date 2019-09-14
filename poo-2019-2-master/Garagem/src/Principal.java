import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

    List<Funcionario> listaFuncionarios = new ArrayList<>();

    public void calcularSalarioGenerico(Funcionario f){
        //System.out.println(f.calcularSalario());
    }

    public static void main(String args[]){
        System.out.println("Garagem Tabajara!");

        Funcionario gerente = new Gerente();
        Funcionario badeco = new Badeco();
        Funcionario funcionario = new Funcionario();

        Principal principal = new Principal();

        principal.calcularSalarioGenerico(gerente);
        principal.calcularSalarioGenerico(badeco);
        principal.calcularSalarioGenerico(funcionario);
        //principal.menuPrincipal();

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
                menuFuncionario();
                break;
            case 2:
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

    public void menuFuncionario() {
        System.out.println("#Menu Funcionario");
        System.out.println("01- Listar");
        System.out.println("02- Cadastrar");
        System.out.println("03- Alterar");
        System.out.println("04- Buscar");
        System.out.println("05- Excluir");
        System.out.println("00- Voltar");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op){
            case 1:
                listarFuncionario();
                break;
            case 2:
                cadastrarFuncionario();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 0: default:
                menuPrincipal();
                break;
        }

        menuFuncionario();

    }

    public void cadastrarFuncionario()  {
        Scanner sc = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();

        System.out.println("# Cadastro de funcionario ");

        System.out.println("> Informe o nome: ");
        funcionario.nome = sc.nextLine();

        System.out.println("> Informe o cpf: ");
        funcionario.cpf = sc.nextLine();

        System.out.println("> Informe o endereço: ");
        funcionario.endereco = sc.nextLine();

        System.out.println("> Informe o telefone: ");
        funcionario.telefone = sc.nextLine();

        try {
            System.out.print("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            funcionario.dt_nascimento = dt;
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo: ");
        funcionario.codigo = sc.nextLine();

        System.out.println("> Informe o usuario: ");
        funcionario.usuario = sc.nextLine();

        System.out.println("> Informe a senha: ");
        funcionario.senha = sc.nextLine();

        listaFuncionarios.add(funcionario);
    }

    public void listarFuncionario(){
        System.out.println("#Lista de funcionarios");
        for(Funcionario f:listaFuncionarios){
            System.out.println(f.codigo + " | " + f.nome + " | " + f.cpf + " " + f.usuario) ;
        }
    }

    public void buscarFuncionario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de funcionario");
        String busca = sc.nextLine();
        for (Funcionario f : listaFuncionarios){
            if(f.nome.equals(busca)){
                System.out.println("Nome: " + f.nome);
                System.out.println("CPF: " + f.cpf);
            }
        }
    }

    public void excluirFuncionario(){
        Scanner sc = new Scanner(System.in);

        System.out.println("# Busca de funcionario");
        String busca = sc.nextLine();

        List<Funcionario> listaParaRemover = new ArrayList<>();

        for (Funcionario f : listaFuncionarios){
            if(f.nome.equals(busca)){
                listaParaRemover.add(f);
            }
        }

        listaFuncionarios.removeAll(listaParaRemover);

    }



}
