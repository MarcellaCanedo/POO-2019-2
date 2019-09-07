import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

	private String marca;
    List<Funcionario> listaFuncionarios = new ArrayList<>();
    List<Cliente> listaClientes = new ArrayList<>();
    List<Automovel>listaAutomovel = new ArrayList<>();
    List<Marca>excluirMarca = new ArrayList <>();
    
    public static void main (String args[]){
        System.out.println("Garagem Tabajara!");

        Principal principal = new Principal();
        principal.menuPrincipal();
        

    }

    public void menuPrincipal(){

        System.out.println("#Menu Principal");
        System.out.println("01- Funcionário");
        System.out.println("02- Cliente");
        System.out.println("03- Automóvel");
        System.out.println("04- Marca");
        System.out.println("05- Vendas");
        System.out.println("00- Sair");

        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();

        switch (op){
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
            	buscarFuncionario();
                break;
            case 5:
            	excluirFuncionario();
                break;
            case 0: default:
                menuPrincipal();
                break;
        }

        menuFuncionario();

    }

    public void menuAutomovel() {
    	
    	System.out.println("#Menu Automóvel");
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
            case 0: default:
                menuPrincipal();
                break;
        }

        menuAutomovel();
    	
    }
    
    public void menuCliente() 
    {
    	 System.out.println("#Menu Cliente");
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
             case 0: default:
                 menuPrincipal();
                 break;
         }

         menuCliente();
    }
    
    public void menuMarca() {
    	
    	 System.out.println("#Menu Cliente");
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
            	 listarMarca();
                 break;
             case 2:
            	 cadastrarMarca();
                 break;
             case 3:
                 break;
             case 4:
            	 buscarMarca();
                 break;
             case 5:
            	 excluirMarca();
                 break;
             case 0: default:
                 menuPrincipal();
                 break;
         }
    	
    }
    
    public void cadastrarMarca() {
    	Scanner sc = new Scanner(System.in);
        Marca marca = new Marca();
        
        System.out.println("# Cadastro de Marcas: ");
        
        System.out.println("> Informe o nome: ");
        marca.nome = sc.nextLine();
        
        listaMarcas.add(marca);
    }

    public void listarMarca() {
    	
    	System.out.println("#Lista de Marcas");
        for(Marca m: listaMarcas){
            System.out.println(m.nome);
        }
    	
    }

    public void buscarMarca() {
    	 Scanner sc = new Scanner(System.in);
         System.out.println("# Buscar Marcas");
         String busca = sc.nextLine();
         for (Marcas m : listaMarcas){
             if(m.nome.equals(busca)){
                 System.out.println("Nome: " + m.nome);
             }
         }
    }

    public void excluirMarca() {
    	
    	Scanner sc = new Scanner(System.in);

        System.out.println("Exclusão de Marcas: ");
        System.out.println("> Informe o nome da Marca a ser removida: ");
        String busca = sc.nextLine();
        
        List<Marca>excluirMarca = new ArrayList <>();
        
        for (Marca m : listaMarcas){
            if(m.nome.equals(busca)){
                listaMarca.remove(m);
            }
            
            excluirMarca.add(m);
        }
        listaMarcas.removeAll(excluirMarca);
        
        System.out.println("> Exclusão realizada com sucesso!!!");
        
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
            System.out.println(f.codigo + " | " + f.nome + " | " + f.cpf + " | " + f.usuario + " | " + f.telefone + " | " + f.usuario);
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

        System.out.println("Exclusão de Funcionário: ");
        System.out.println("> Informe o nome do Funcionário a ser removido: ");
        String busca = sc.nextLine();
        
        List<Funcionario>excluirFuncionario = new ArrayList <>();
        
        for (Funcionario f : listaFuncionarios){
            if(f.nome.equals(busca)){
                listaFuncionarios.remove(f);
            }
            
            excluirFuncionario.add(f);
        }
        listaFuncionarios.removeAll(excluirFuncionario);
        
        System.out.println("> Exclusão realizada com sucesso!!!");

    }

    public void cadastrarCliente(){
    	Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();

        System.out.println("# Cadastro de Cliente ");

        System.out.println("> Informe o nome: ");
        cliente.nome = sc.nextLine();

        System.out.println("> Informe o cpf: ");
        cliente.cpf = sc.nextLine();

        System.out.println("> Informe o endereço: ");
        cliente.endereco = sc.nextLine();

        System.out.println("> Informe o telefone: ");
        cliente.telefone = sc.nextLine();

        try {
            System.out.print("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            cliente.dt_nascimento = dt;
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo: ");
        cliente.codigo = sc.nextLine();

        listaClientes.add(cliente);
    }
    
    public void listarCliente() {
    	System.out.println("#Lista de Clientes");
        for(Cliente c:listaClientes){
            System.out.println(c.codigo + " | " + c.nome + " | " + c.cpf + " | " + c.telefone);
        }
    }
    
    public void buscarCliente() {
    	  Scanner sc = new Scanner(System.in);
          System.out.println("# Busca de Cliente");
          String busca = sc.nextLine();
          for (Cliente c : listaClientes){
              if(c.nome.equals(busca)){
                  System.out.println("Nome: " + c.nome);
                  System.out.println("CPF: " + c.cpf);
              }
          }
    }
    
    public void excluirCliente() {
    	
    	Scanner sc = new Scanner(System.in);

        System.out.println("Exclusão de Cliente: ");
        System.out.println("> Informe o nome do Cliente a ser removido: ");
        String busca = sc.nextLine();
        
        List<Cliente>excluirCliente = new ArrayList <>();
        
        for (Cliente c : listaClientes){
            if(c.nome.equals(busca)){
                listaClientes.remove(c);
            }
            
            excluirCliente.add(c);
        }
        listaClientes.removeAll(excluirCliente);
        
        System.out.println("> Exclusão realizada com sucesso!!!");
    }
    
    public void cadastrarAutomovel() {
    	
    	Scanner sc = new Scanner(System.in);
        Automovel automovel = new Automovel();

        System.out.println("# Cadastro de Automovel ");

        System.out.println("> Informe a cor: ");
        automovel.cor = sc.nextLine();

        System.out.println("> Informe o chassi : ");
        automovel.chassi = sc.nextLine();
        
        System.out.println("> Marca do automovel: ");
        this.marca = marca;

        System.out.println("> Informe a placa: ");
        automovel.placa = sc.nextLine();

        System.out.println("> Informe a quilometragem: ");
        float km = sc.nextFloat();
        
        System.out.println("> Informe o valor: ");
        float valor = sc.nextFloat();

        try {
            System.out.print("> Informe o ano de fabricação: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(data);
            automovel.ano_fab = dt;
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }
        
        try {
            System.out.print("> Informe o ano do modelo: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(data);
            automovel.ano_modelo = dt;
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }

        listaAutomovel.add(automovel);
    	
    }
    
    public void listarAutomovel() {
    	System.out.println("#Lista de Automóveis");
        for(Automovel a:listaAutomovel){
            System.out.println(a.cor + " | " + a.chassi + " | " + a.placa + " | " + a.km + " | " + a.valor + " | " + a.ano_fab +  " | " + a.ano_modelo);
        }
    	
    }
    
    public void buscarAutomovel() {
    	
    	 Scanner sc = new Scanner(System.in);
         System.out.println("# Busca de Automovel");
         String busca = sc.nextLine();
         for (Automovel a:listaAutomovel){
             if(a.cor.equals(busca)){
                 System.out.println("Cor: " + a.cor);
                 System.out.println("Placa: " + a.placa);
                 System.out.println("Chassi: " +a.chassi);
             }
         }
    }
    
    public void excluirAutomovel() {
    	
    	Scanner sc = new Scanner(System.in);

        System.out.println("Exclusão de Automóvel: ");
        System.out.println("> Informe a placa do Automóvel a ser removido: ");
        String busca = sc.nextLine();
        
        List<Automovel>excluirAutomovel = new ArrayList <>();
        
        for (Automovel a : listaAutomovel){
            if(a.nome.equals(busca)){
                listaAutomovel.remove(a);
            }
            
            excluirAutomovel.add(a);
        }
        
        listaAutomovel.removeAll(excluirAutomovel);
        
        System.out.println("> Exclusão realizada com sucesso!!!");
    }
    
}    