import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

    List<Funcionario> listaFuncionarios = new ArrayList<>();
    List<Cliente> listaClientes = new ArrayList<>();
    List<Automovel> listaAutomoveis = new ArrayList<>();

    public void calcularSalarioGenerico(Funcionario f) {
        System.out.println(f.calcularSalario());
    }

    public static void main(String args[]) {
        System.out.println("Garagem Tabajara!");

        Funcionario gerente = new Gerente();
        Funcionario badeco = new Badeco();
        Funcionario funcionario = new Funcionario();

        Principal principal = new Principal();

        // principal.calcularSalarioGenerico(gerente);
        //principal.calcularSalarioGenerico(badeco);
        //principal.calcularSalarioGenerico(funcionario);
        principal.menuPrincipal();

    }

    public void menuPrincipal() {

        System.out.println("#Menu Principal");
        System.out.println("01- Funcionário");
        System.out.println("02- Cliente");
        System.out.println("03- Automóvel");
        System.out.println("04- Vendas");
        System.out.println("00- Sair");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op) {
            case 1:
                menuFuncionario();
                break;
            case 2:
                menuCliente();
                break;
            case 3:
                menuAutomovel();
                break;
            case 4:
                menuVenda();
                break;
            case 0:
            default:
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

        switch (op) {
            case 1:
                listarFuncionario();
                break;
            case 2:
                cadastrarFuncionario();
                break;
            case 3:
                /*Alterar implementação futura*/
                break;
            case 4:
                buscarFuncionario();
                break;
            case 5:
                excluirFuncionario();
                break;
            case 0:
            default:
                menuPrincipal();
                break;
        }

        menuFuncionario();

    }

    public void cadastrarFuncionario() {
        Scanner sc = new Scanner(System.in);
        Scanner fsc = new Scanner(System.in);

        int tipoFuncionario = 0;

        Funcionario funcionario = new Funcionario();

        System.out.println("# Cadastro de funcionario ");
        System.out.println("# Escolha o tipo de funcionÃ¡rio: [01 - Gerente,  02 - Funcionario Normal,  03 - Badeco]");
        tipoFuncionario = fsc.nextInt();

        if(tipoFuncionario != 1 && tipoFuncionario!= 2 && tipoFuncionario != 3){
            System.out.println(" FuncionÃ¡rio ainda nÃ£o existÃªnte!!!");
            cadastrarFuncionario();
        }else{
            System.out.println("> Informe o nome: ");
            funcionario.setNome(sc.nextLine());

            System.out.println("> Informe o cpf: ");
            funcionario.setCpf(sc.nextLine());

            System.out.println("> Informe o endereÃ§o: ");
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

            System.out.println("> Informe o codigo: ");
            funcionario.setCodigo(fsc.nextInt());

            System.out.println("> Informe o usuario: ");
            funcionario.setUsuario(sc.nextLine());

            System.out.println("> Informe a senha: ");
            funcionario.setSenha(sc.nextLine());

            if(tipoFuncionario == 1){
                Gerente gerente = new Gerente();

                gerente.mapFuncionarioToGerente(funcionario);

                System.out.println("> Informe a matricula: ");
                gerente.setMatricula(sc.nextLine());

                System.out.println("> Informe o departamento: ");
                gerente.setDepartamento(sc.nextLine());

                System.out.println("> Informe o salario: ");
                gerente.setSalario(fsc.nextFloat());

                funcionario = gerente;

            }else if(tipoFuncionario == 3)
            {
                Badeco badeco = new Badeco();
                badeco.mapFuncionarioToBadeco(funcionario);

                System.out.println("> Informe a funcao: ");
                badeco.setFuncao(sc.nextLine());

                System.out.println("> Informe o salario: ");
                badeco.setSalario(fsc.nextFloat());

                funcionario = badeco;
            }else{
                System.out.println("> Informe o salario: ");
                funcionario.setSalario(fsc.nextFloat());
            }

            listaFuncionarios.add(funcionario);
        }
    }

    public void listarFuncionario() {
        System.out.println("#Lista de funcionarios");
        for (Funcionario f : listaFuncionarios) {
            System.out.println(f.getCodigo() + " | " + f.getNome() + " | " + f.getCpf() + " | " + f.getUsuario());
        }
    }

    public void buscarFuncionario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de funcionario");
        System.out.println("# Informe o código do Funcionario");
        int codigoFuncao = sc.nextInt();
        for (Funcionario f : listaFuncionarios) {
            if (f.getCodigo() == codigoFuncao) {
                System.out.println("Nome: " + f.getNome());
                System.out.println("CPF: " + f.getCpf());
                System.out.println("Telefone: " + f.getTelefone());
                System.out.println("Data de nascimento: " + f.getDt_nascimento());
                System.out.println("CÃ³digo: " + f.getCodigo());
                System.out.println("UsuÃ¡rio: " + f.getUsuario());
                System.out.println("Senha: " + f.getSenha());
                System.out.println("SalÃ¡rio: " + f.calcularSalario());
            }else{
                System.out.println("> Registro nÃ£o encontrado!!!");
            }
        }
    }

    public void excluirFuncionario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de funcionario");
        System.out.println("> Informe o cÃ³digo do funcionÃ¡rio");
        int codigoFuncionario = sc.nextInt();

        List<Funcionario> listaParaRemover = new ArrayList<>();

        for (Funcionario f : listaFuncionarios) {
            if (f.getCodigo() == codigoFuncionario) {
                listaParaRemover.add(f);
            } else {
                System.out.println("> Funcionario nÃ£o encontrado!!!");
            }
        }

        listaFuncionarios.removeAll(listaParaRemover);

        System.out.println("> ExclusÃ£o realizada com sucesso!!!");
    }

    public void menuCliente() {

        System.out.println("#Menu Cliente");
        System.out.println("01- Listar");
        System.out.println("02- Cadastrar");
        System.out.println("03- Alterar");
        System.out.println("04- Buscar");
        System.out.println("05- Excluir");
        System.out.println("00- Voltar");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op) {
            case 1:
                listarCliente();
                break;
            case 2:
                cadastrarCliente();
                break;
            case 3:
                break;
            case 4:
                buscarCliente();
                break;
            case 5:
                excluirCliente();
                break;
            case 0:
            default:
                menuPrincipal();
                break;
        }

        menuCliente();
    }

    public void cadastrarCliente() {

        Cliente cliente = new Cliente();
        Scanner sc = new Scanner(System.in);
        Scanner fsc = new Scanner (System.in);

        System.out.println("# Cadastro de Cliente ");

        System.out.println("> Informe o nome: ");
        cliente.setNome(sc.nextLine());

        System.out.println("> Informe o cpf: ");
        cliente.setCpf(sc.nextLine());

        System.out.println("> Informe o endereÃ§o: ");
        cliente.setEndereco(sc.nextLine());

        System.out.println("> Informe o telefone: ");
        cliente.setTelefone(sc.nextLine());

        try {
            System.out.print("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            cliente.setDt_nascimento(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo: ");
        cliente.setCodigo(sc.nextInt());
        listaClientes.add(cliente);
    }

    public void listarCliente() {

        System.out.println("#Lista de Clientes");
        for (Cliente c : listaClientes) {
            System.out.println(c.getCodigo() + " | " + c.getNome() + " | " + c.getCpf());
        }

    }

    public void buscarCliente() {

        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de Cliente");
        String busca = sc.nextLine();
        for (Cliente c : listaClientes) {
            if (c.getNome() == (busca)) {
                System.out.println("Nome: " + c.getNome());
                System.out.println("CPF: " + c.getCpf());
                System.out.println("Endereço: " + c.getEndereco());
                System.out.println("Telefone: " + c.getTelefone());
                System.out.println("Codigo: " + c.getCodigo());
            }
        }
    }

    public void excluirCliente() {

        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de Cliente");
        System.out.println("# Informe o nome do Cliente a ser removido: ");
        String busca = sc.nextLine();
        List<Cliente> listaParaRemover = new ArrayList<>();

        for (Cliente c : listaClientes) {
            if (c.getNome().equals(busca)) {
                listaParaRemover.add(c);
            } else {
                System.out.println("> Cliente nao encontrado!!!");
            }
        }
        listaClientes.removeAll(listaParaRemover);
        System.out.println("> Exclusao realizada com sucesso!!!");
    }

    public void menuAutomovel() {

        System.out.println("#Menu Automovel");
        System.out.println("01- Listar");
        System.out.println("02- Cadastrar");
        System.out.println("03- Alterar");
        System.out.println("04- Buscar");
        System.out.println("05- Excluir");
        System.out.println("00- Voltar");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op) {
            case 1:
                listarAutomovel();
                break;
            case 2:
                cadastrarAutomovel();
                break;
            case 3:
                break;
            case 4:
                buscarAutomovel();
                break;
            case 5:
                excluirAutomovel();
                break;
            case 0:
            default:
                menuPrincipal();
                break;
        }
        menuAutomovel();
    }

    public void cadastrarAutomovel() {

        Scanner sc = new Scanner(System.in);
        Automovel automovel = new Automovel();

        System.out.println("# Cadastro de Automovel ");

        System.out.println("> Informe o nome da marca: ");
        automovel.nome = sc.nextLine();

        System.out.println("> Informe o tipo: ");
        automovel.tipo = sc.nextLine();

        System.out.println("> Informe a cor: ");
        automovel.cor = sc.nextLine();

        System.out.println("> Informe o chassi: ");
        automovel.chassi = sc.nextLine();

        System.out.println("> Informe a placa: ");
        automovel.placa = sc.nextLine();

        System.out.println("> Informe o KM: ");
        automovel.km = sc.nextLine();

        System.out.println("> Informe o valor: ");
        automovel.valor = sc.nextLine();

        try {
            System.out.print("> Informe o ano de fabricao: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(data);
            automovel.ano_fab = dt;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("> Informe o ano do modelo: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(data);
            automovel.ano_modelo = dt;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        listaAutomoveis.add(automovel);
    }

    public void listarAutomovel() {

        System.out.println("#Lista de Automoveis");
        for (Automovel a : listaAutomoveis) {
            System.out.println(a.nome + " | " + a.tipo + " | " + a.placa + " | " + a.chassi);
        }

    }

    public void buscarAutomovel() {

        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de AutomÃ³vel");
        String busca = sc.nextLine();
        for (Automovel a : listaAutomoveis) {
            if (a.chassi.equals(busca)) {
                System.out.println("Marca: " + a.nome);
                System.out.println("Tipo: " + a.tipo);
                System.out.println("Placa: " + a.placa);
                System.out.println("Chassi: " + a.chassi);
            }
        }
    }

    public void excluirAutomovel() {

        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de Automovel");
        System.out.println("# Informe o chassi do automovel a ser removido: ");
        String busca = sc.nextLine();
        List<Automovel> listaParaRemover = new ArrayList<>();

        for (Automovel a : listaAutomoveis) {
            if (a.chassi.equals(busca)) {
                listaParaRemover.add(a);
                System.out.println("> Exclusão realizada com sucesso!!!");
            } else {
                System.out.println("> Automóvel não encontrado!!!");
            }
        }
        listaAutomoveis.removeAll(listaParaRemover);
    }

    public void menuVenda() {

        System.out.println("#Menu Vendas");
        System.out.println("01- Realizar Venda");
        System.out.println("02- Cancelar Venda");
        System.out.println("00- Sair");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op) {
            case 1:
                realizarVenda();
                break;
            case 2:
                //cancelarVenda();
                break;
            case 0:
            default:
                System.exit(0);
                break;
        }
    }

    public void realizarVenda() {
        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de dados para realizar Venda");
        System.out.println("> Informe a placa do Veiculo: ");
        String busca1 = sc.nextLine();

        for (Automovel a : listaAutomoveis) {
            if (a.placa.equals(busca1)) {
                System.out.println("Placa: " + a.placa);
            } else {
                System.out.println("> Informaçao Invalida!!!");
            }
            System.out.println("> Informe o Codigo do cliente: ");
            int busca2 = sc.nextInt();

            for (Cliente c : listaClientes) {
                if (c.getCodigo() == busca2) {
                    System.out.println("Codigo: " + c.codigo);
                } else {
                    System.out.println("> Informaçao Invalida!!!");
                }
            }
            int busca3 = sc.nextInt();
            System.out.println("> Informe o codigo do funcioÃ¡rio: ");
            for (Funcionario f : listaFuncionarios) {
                if (f.codigo == busca3) {
                    System.out.println("Codigo: " + f.codigo);
                } else {
                    System.out.println("> Informaçao Invalida!!!");
                }
            }
        }
    }

}