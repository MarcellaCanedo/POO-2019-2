import java.util.Date;

public class Venda {

    private Date dt_venda;
    private String codigo;
    private float comissao_venda;
    private float valor_venda;

    Venda(){};

    Automovel automovel;
    Funcionario funcionario;
    Cliente cliente;

    public float getValor_venda() { return valor_venda; }

    public void setValor_venda (float valor_venda) { this.valor_venda = valor_venda; }

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) { this.codigo = codigo; }

    public float getComissao_venda() { return comissao_venda; }

    public void setComissao_venda(float comissao_venda) { this.comissao_venda = comissao_venda; }


}