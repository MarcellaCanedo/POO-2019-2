package entity;

public class Funcionario {
	
	  	private int id;
	    private String nome;
	    private String cpf;
	    private String endereco;
	    private String telefone;
	    private String dt_nascimento;
	    private int codigo;
	    private String usuario;
	    private String senha;
	    private float salario;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getDt_nascimento() {
			return dt_nascimento;
		}

		public void setDt_nascimento(String dt_nascimento) {
			this.dt_nascimento = dt_nascimento;
		}

		public int getCodigo() {
			return codigo;
		}

		public <Int> Int setCodigo(int codigo) {
			this.codigo = codigo;
			return null;
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public float getSalario() {
			return salario;
		}

		public void setSalario(float salario) {
			this.salario = salario;
		}

		public void add(Funcionario func) {
			
		}
}
