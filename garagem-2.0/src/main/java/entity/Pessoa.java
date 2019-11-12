package entity;

public class Pessoa{
	
	protected int id;
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected String dt_nascimento;
    
    public Pessoa(int id, String nome, String endereco, String telefone, String dt_nascimento) {
    	setId(id);
    	setNome(nome);
    	setEndereco(endereco);
    	setTelefone(telefone);
    	setDt_nascimento(dt_nascimento);	
    }
    public Pessoa() {
    }
    
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

	public void setDt_nascimento(String string) {
		this.dt_nascimento = string;
	}
	
}
