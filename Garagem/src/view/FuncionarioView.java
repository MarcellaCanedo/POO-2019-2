package view;

import controller.FuncionarioController;
import entity.Funcionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FuncionarioView {
    FuncionarioController funcionarioController;
    Scanner sc;
    Scanner fsc;

    public FuncionarioView() {
        this.funcionarioController = funcionarioController;
        this.sc = new Scanner(System.in);
    }

    public void menuFuncionario() {
        System.out.println("#Menu entity.Funcionario");
        System.out.println("01- Listar");
        System.out.println("02- Cadastrar");
        System.out.println("03- Alterar");
        System.out.println("04- Buscar");
        System.out.println("05- Excluir");
        System.out.println("00- Voltar");

        int op = this.sc.nextInt();

        switch (op){
            case 1:
                //listarFuncionario();
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
                return;
        }
        menuFuncionario();
    }

    public void cadastrarFuncionario()  {

        Funcionario funcionario = new Funcionario();

        System.out.println("> Informe o nome: ");
        funcionario.setNome(sc.nextLine());

        System.out.println("> Informe o cpf: ");
        funcionario.setCpf(sc.nextLine());

        System.out.println("> Informe o endereço: ");
        funcionario.setEndereco(sc.nextLine());

        System.out.println("> Informe o telefone: ");
        funcionario.setTelefone(sc.nextLine());

        try {
            System.out.print("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            funcionario.setDt_nascimento(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }


        if(funcionarioController.cadastrar(funcionario)){
            System.out.println("Funcionario cadastrado com sucesso");
        } else {
            System.out.println("ERRO - Não foi possível cadastrar o Funcionário");
        }

    }


}
