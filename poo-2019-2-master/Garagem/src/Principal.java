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
    List<Venda> listaVendas = new ArrayList<>();

    public void calcularSalarioGenerico(Funcionario f) {
        System.out.println(f.calcularSalario());
    }


    public static void main(String args[]) {
        System.out.println("Garagem Tabajara!");

        Funcionario gerente = new Gerente();
        Funcionario badeco = new Badeco();
        Funcionario funcionario = new Funcionario();

        Principal principal = new Principal();

        /*principal.calcularSalarioGenerico(gerente);
        principal.calcularSalarioGenerico(badeco);
        principal.calcularSalarioGenerico(funcionario);*/
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
                alterarFuncionario();
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
        System.out.println("# Escolha o tipo de funcionário: (01 - Gerente,  02 - Funcionario Normal,  03 - Badeco)");
        tipoFuncionario = fsc.nextInt();

        if (tipoFuncionario != 1 && tipoFuncionario != 2 && tipoFuncionario != 3) {
            System.out.println(" Funcionário ainda não existente!!!");
            cadastrarFuncionario();
        } else {
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

            System.out.println("> Informe o codigo: ");
            funcionario.setCodigo(fsc.nextInt());

            System.out.println("> Informe o usuario: ");
            funcionario.setUsuario(sc.nextLine());

            System.out.println("> Informe a senha: ");
            funcionario.setSenha(sc.nextLine());

            if (tipoFuncionario == 1) {
                Gerente gerente = new Gerente();

                gerente.mapFuncionarioToGerente(funcionario);

                System.out.println("> Informe a matricula: ");
                gerente.setMatricula(sc.nextLine());

                System.out.println("> Informe o departamento: ");
                gerente.setDepartamento(sc.nextLine());

                System.out.println("> Informe o salario: ");
                gerente.setSalario(fsc.nextFloat());

                funcionario = gerente;

            } else if (tipoFuncionario == 3) {
                Badeco badeco = new Badeco();
                badeco.mapFuncionarioToBadeco(funcionario);

                System.out.println("> Informe a funcao: ");
                badeco.setFuncao(sc.nextLine());

                System.out.println("> Informe o salario: ");
                badeco.setSalario(fsc.nextFloat());
                funcionario = badeco;

            } else {
                System.out.println("> Informe o salario: ");
                funcionario.setSalario(fsc.nextFloat());
            }

            listaFuncionarios.add(funcionario);
        }
    }

    public void listarFuncionario() {
        System.out.println("#Lista de funcionarios");
        for (Funcionario f : listaFuncionarios) {
            System.out.println("Código: " + f.getCodigo() + " | " + "Nome: " + f.getNome() + " | " + "CPF: " + f.getCpf() +
                    " | " + "Usuário: " + f.getUsuario() + " | " + "Salário com ajuste: " + f.calcularSalario());
        }
    }

    public void alterarFuncionario(){
        Scanner sc = new Scanner(System.in);
        Scanner fsc = new Scanner(System.in);
        int tipoFuncionario = 0;

        System.out.println("# Alterar Funcionário");
        System.out.println("> Informe o código do funcionário: ");
        int codFunc = fsc.nextInt();

        for(Funcionario funcionario: listaFuncionarios){
            if(codFunc == funcionario.getCodigo()) {
                System.out.println("> Informe o nome do funcionario: ");
                funcionario.setNome(sc.nextLine());

                System.out.println("> Informe o CPF: ");
                funcionario.setCpf(sc.nextLine());

                System.out.println("> Informe o endereço: ");
                funcionario.setEndereco(sc.nextLine());

                System.out.println("> Informe o telefone: ");
                funcionario.setTelefone(sc.nextLine());

                try {
                    System.out.println("> Informe a data de nascimento: ");
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

                if (tipoFuncionario == 1) {
                    Gerente gerente = new Gerente();

                    gerente.mapFuncionarioToGerente(funcionario);

                    System.out.println("> Informe a matricula: ");
                    gerente.setMatricula(sc.nextLine());

                    System.out.println("> Informe o departamento: ");
                    gerente.setDepartamento(sc.nextLine());

                    System.out.println("> Informe o salario: ");
                    gerente.setSalario(fsc.nextFloat());

                    funcionario = gerente;

                } else if (tipoFuncionario == 3) {
                    Badeco badeco = new Badeco();
                    badeco.mapFuncionarioToBadeco(funcionario);

                    System.out.println("> Informe a funcao: ");
                    badeco.setFuncao(sc.nextLine());

                    System.out.println("> Informe o salario: ");
                    badeco.setSalario(fsc.nextFloat());
                    funcionario = badeco;

                } else {
                    System.out.println("> Informe o salario: ");
                    funcionario.setSalario(fsc.nextFloat());
                }
            }
        }
        System.out.println("---> Dados do funcionário alterados com sucesso!");
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
                System.out.println("Código: " + f.getCodigo());
                System.out.println("Usuárioo: " + f.getUsuario());
                System.out.println("Senha: " + f.getSenha());
                System.out.println("Salário: " + f.calcularSalario());
            } else {
                System.out.println("> Registro não encontrado!!!");
            }
        }
    }

    public void excluirFuncionario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de funcionario");
        System.out.println("> Informe o código do funcionário");
        int codigoFuncionario = sc.nextInt();

        List<Funcionario> listaParaRemover = new ArrayList<>();

        for (Funcionario f : listaFuncionarios) {
            if (f.getCodigo() == codigoFuncionario) {
                listaParaRemover.add(f);
            } else {
                System.out.println("> Funcionario não encontrado!!!");
            }
        }

        listaFuncionarios.removeAll(listaParaRemover);

        System.out.println("> Exclusão realizada com sucesso!!!");
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
                alterarCliente();
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
        //Scanner fsc = new Scanner (System.in);

        System.out.println("# Cadastro de Cliente ");

        System.out.println("> Informe o nome: ");
        cliente.setNome(sc.nextLine());

        System.out.println("> Informe o cpf: ");
        cliente.setCpf(sc.nextLine());

        System.out.println("> Informe o endereço: ");
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
            System.out.println("Código: " + c.getCodigo() + " | " + "Nome: " + c.getNome() + " | "
                    + "CPF: " + c.getCpf() + " | " + "Telefone: " + c.getTelefone());
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

    public void alterarCliente(){

        Scanner sc = new Scanner (System.in);
        Scanner fsc = new Scanner (System.in);

        System.out.println("## Alterar Cliente: ");
        System.out.println("> Informe o código do cliente: ");
        int codigo_cliente = sc.nextInt();

        for(Cliente cliente: listaClientes){

            if(codigo_cliente == cliente.getCodigo()){
                System.out.println("> Informe o nome: ");
                cliente.setNome(sc.nextLine());

                System.out.println("> Informe o CPF");
                cliente.setCpf(sc.nextLine());

                System.out.println("> Informe o telefone: ");
                cliente.setTelefone(sc.nextLine());

                System.out.println("> Informe o endereço: ");
                cliente.setEndereco(sc.nextLine());

                try {
                    System.out.print("> Informe a data de nascimento: ");
                    String data = sc.nextLine();
                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                    cliente.setDt_nascimento(dt);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("> Código:");
                cliente.setCodigo(sc.nextInt());
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
                alterarAutomovel();
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

        Scanner fsc = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Automovel automovel = new Automovel();

        System.out.println("# Cadastro de Automovel ");

        System.out.println("> Informe o tipo do automóvel (Carro, caminhão, moto, barco): ");
        automovel.setTipo(sc.nextLine());

        System.out.println("> Informe o Modelo: ");
        automovel.setNome_modelo(sc.nextLine());

        System.out.println("> Informe a Marca: ");
        automovel.setNome_Marca(sc.nextLine());

        System.out.println("> Informe a cor: ");
        automovel.setCor(sc.nextLine());

        System.out.println("> Informe o chassi: ");
        automovel.setChassi(fsc.nextLine());

        System.out.println("> Informe a placa: ");
        automovel.setPlaca(fsc.nextLine());

        System.out.println("> Informe o KM: ");
        automovel.setKm(fsc.nextInt());

        System.out.println("> Informe o valor: ");
        automovel.setValor(fsc.nextInt());

        try {
            System.out.print("> Informe o ano de fabricao: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(data);
            automovel.setAno_fab(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("> Informe o ano do modelo: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(data);
            automovel.setAno_modelo(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        listaAutomoveis.add(automovel);
    }

    public void listarAutomovel() {
        System.out.println("#Lista de Automoveis");
        for (Automovel a : listaAutomoveis) {
            System.out.println(a.getTipo() + "|" + a.getNome_modelo() + "|" + a.getNome_Marca() +
                    " | " + a.getCor() + " | " + a.getPlaca() + " | " + a.getChassi() + "|" + a.getValor());
        }
    }

    public void buscarAutomovel() {

        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de Automóvel");
        String busca = sc.nextLine();
        for (Automovel a : listaAutomoveis) {
            if (a.getChassi().equals(busca)) {
                System.out.println("Marca: " + a.getNome_Marca());
                System.out.println("Tipo: " + a.getTipo());
                System.out.println("Placa: " + a.getPlaca());
                System.out.println("Chassi: " + a.getChassi());
                System.out.println("Valor: " + a.getValor());
                System.out.println("Quilometragem: " + a.getKm());
            }
        }
    }

    public void alterarAutomovel(){

        Scanner sc = new Scanner (System.in);
        Scanner fsc = new Scanner (System.in);

        System.out.println("# Alterar Automóvel: ");
        System.out.println("> Informe a placa do automovel: ");
        String placaAutomovel = sc.nextLine();

        for (Automovel automovel: listaAutomoveis){
            if(placaAutomovel.equals (automovel.getPlaca())){

                System.out.println("> Informe o tipo do automóvel: (Carro, caminhão, moto, barco)");
                automovel.setTipo(sc.nextLine());

                System.out.println("> Informe o modelo: ");
                automovel.setNome_modelo(sc.nextLine());

                System.out.println("> Informe a marca: ");
                automovel.setNome_Marca(sc.nextLine());

                System.out.println("> Informe a cor: ");
                automovel.setCor(sc.nextLine());

                System.out.println("> Informe o chassi: ");
                automovel.setChassi(sc.nextLine());

                System.out.println("> Informe a placa: ");
                automovel.setPlaca(sc.nextLine());

                System.out.println("> Informe o KM: ");
                automovel.setKm(fsc.nextFloat());

                System.out.println("> Informe o valor: ");
                automovel.setValor(fsc.nextFloat());

                try {
                    System.out.print("> Informe o ano de fabricao: ");
                    String data = sc.nextLine();
                    Date dt = new SimpleDateFormat("yyyy").parse(data);
                    automovel.setAno_fab(dt);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                try {
                    System.out.print("> Informe o ano do modelo: ");
                    String data = sc.nextLine();
                    Date dt = new SimpleDateFormat("yyyy").parse(data);
                    automovel.setAno_modelo(dt);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

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
            if (a.getChassi().equals(busca)) {
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
        System.out.println("01- Realizar Venda"); //Como se fosse um cadastro de vendas
        System.out.println("02- Cancelar Venda");
        System.out.println("03- Listar Vendas"); //Listagem de todas as vendas realizadas
        System.out.println("00- Voltar");

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
                listarVenda();
            case 4:
                alterarVenda();
            case 0:
                menuVenda();
            default:
                System.exit(0);
                break;
        }
        menuVenda();
    }

    public void realizarVenda() {
        Scanner sc = new Scanner(System.in);
        System.out.println("# Busca de dados para realizar Venda");
        System.out.println("> Informe a placa do Veiculo: ");
        String busca1 = sc.nextLine();

        Venda venda = new Venda();
        boolean procura0 = false;
        boolean procura1 = false;
        boolean procura2 = false;
        int resposta = 0;
        float comissao = 0;

        //Verificar os dados para cadastrar uma venda


        for (Venda v : listaVendas) {
            System.out.println("> Informe o código da venda: " + v.getCodigo());
        }

        for (Automovel a : listaAutomoveis) {
            if (a.getPlaca().equals(busca1)) {
                System.out.println("----> Veículo escolhido ");
                System.out.println("Placa do veículo escolhido: " + a.getPlaca());
                procura0 = true;
            }

            if (procura0 == true) {
                System.out.println("> Informe o Codigo do cliente: ");
                int busca2 = sc.nextInt();

                for (Cliente c : listaClientes) {
                    if (c.getCodigo() == c.getCodigo()) {
                        System.out.println("----> Cliente: ");
                        System.out.println("Codigo: " + c.getCodigo());
                        procura1 = true;
                    }
                    if (procura1 == true) {
                        System.out.println("> Informe o codigo do funcionrio: ");
                        int busca3 = sc.nextInt();

                        for (Funcionario f : listaFuncionarios) {
                            if (f.getCodigo() == f.getCodigo()) {
                                System.out.println("----> Funcionário: ");
                                System.out.println("Codigo: " + f.getCodigo());
                                procura2 = true;
                            }

                            if(procura2 == true){

                                System.out.println("> Informe o código da venda: ");
                                venda.setCodigo(sc.nextInt());

                                try {
                                    System.out.print("> Data da venda: ");
                                    String data = sc.nextLine();
                                    Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                                    venda.setDt_venda(dt);
                                } catch (ParseException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                        }
                        if (procura2 == true){
                            System.out.println("\n O veículo possui valor de desconto? (01- Sim,  00- Não)");
                            resposta = sc.nextInt();
                        }
                        if(resposta == 1){
                            System.out.println("Valor do desconto a ser aplicado sobre o veículo: ");
                            float valorDesconto = sc.nextFloat();

                            venda.setValor_venda(a.getValor() - valorDesconto);
                            System.out.println("----> Valor do veículo: " + a.getValor());
                            System.out.println("----> Valor com desconto: " + venda.getValor_venda());
                            venda.setComissao_venda(venda.getValor_venda()*0.05f);
                            System.out.println("----> Valor da comissão: " + venda.getComissao_venda());
                        }else{
                            System.out.println("----> Valor do veículo vendido: " + a.getValor());
                            venda.setComissao_venda(a.getValor()*0.05f);
                            System.out.println("----> Valor da comissão: " + venda.getComissao_venda());

                        }
                    }
                }
                if(!procura0 || !procura1 || !procura2){
                    System.out.println("Registro não encontrado, tente novamente!");
                    menuVenda();
                }
                listaVendas.add(venda);
            }
        }
    }

    public void listarVenda() {

        System.out.println("#Lista de Vendas");

        for (Venda v : listaVendas) {
            System.out.println("----> Código da venda: " + v.getCodigo());
            for (Automovel a: listaAutomoveis)
            System.out.println("----> Valor automovel: " + a.getValor());
            for (Automovel a : listaAutomoveis) {
                System.out.println("----> Placa: " + a.getPlaca());
            }
            for (Cliente c : listaClientes) {
                System.out.println("----> Codigo Cliente: " + c.getCodigo());
            }
            for (Funcionario f : listaFuncionarios) {
                System.out.println("----> Codigo Funcionário " + f.getCodigo());
            }
        }
    }

    public void alterarVenda(){



    }

    public void cancelarVenda(){
        Scanner sc = new Scanner(System.in);

        System.out.println("> Informe o código da venda:");
        int buscaVenda = sc.nextInt();

        List<Venda> cancelarVenda = new ArrayList<>();

        for(Venda v: listaVendas){
            if(buscaVenda == v.getCodigo())
            {
                cancelarVenda.add(v);
            }
        }
            listaVendas.removeAll(cancelarVenda);
    }
}