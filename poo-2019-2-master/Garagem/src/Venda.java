import java.util.Date;
import java.util.Scanner;

public class Venda {

    private Date dt_venda;
    private int codigo;
    private float comissao_venda;
    private float valor_venda;

    Automovel automovel;
    Funcionario funcionario;
    Cliente cliente;

    public Date getDt_venda() { return dt_venda; }

    public void setDt_venda(Date dt_venda) { this.dt_venda = dt_venda; }

    public int getCodigo() { return codigo; }

    public void setCodigo(int codigo) { this.codigo = codigo; }

    public float getComissao_venda() { return comissao_venda; }

    public void setComissao_venda(float comissao_venda) { this.comissao_venda = comissao_venda; }

    public float getValor_venda() { return valor_venda; }

    public void setValor_venda(float valor_venda) { this.valor_venda = valor_venda; }
}