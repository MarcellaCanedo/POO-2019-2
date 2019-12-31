package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda  {

    private Date dt_venda;
    private String codigo;
    private float comissao_venda;
    private float valor_venda;

    private Automovel automovel = new Automovel();
    private Funcionario funcionario = new Funcionario();
    private Cliente cliente = new Cliente();

    private List<Venda> listaVenda = new ArrayList<Venda>();

    public Venda(){}



    public boolean verificaListaVazia(){
        boolean verificaListaVazia = false;
        if (listaVenda.isEmpty()){
            verificaListaVazia = true;
        }
        return verificaListaVazia;
    }

    public void cadastrarVenda(){
        listaVenda.add(this);
    }

    public void listarVenda(){
        for (Venda v : listaVenda){
            System.out.println(
                    "Código venda: "+v.getCodigo()+
                            "\n"+"Nome funcionario: "+v.getFuncionario().getNome()+
                            "\n"+"Nome entity.Cliente: "+v.getCliente().getNome()+
                           // "\n"+"Nome entity.Marca: "+v.getAutomovel().getNomeMarca()+
                           // "\n"+"Nome entity.Modelo: "+v.getAutomovel().getNome()+
                          //  "\n"+"Cor: "+v.getAutomovel().getCor()+
                            "\n"+"Valor da entity.Venda: "+v.getValor_venda()+
                            "\n"+"Valor da Comissão: "+v.getComissao_venda()+
                            "\n"+"Data da entity.Venda: "+v.getDt_venda()
            );
        }
    }

    public boolean excluirVenda(String codVenda){
        boolean vendaExcluida = false;
        for (Venda venda : listaVenda){
            if (venda.getCodigo().equals(codVenda)){
                listaVenda.remove(venda);
                vendaExcluida = true;
            }
        }
        return  vendaExcluida;
    }

    public Date getDt_venda() {
        return dt_venda;
    }

    public void setDt_venda(Date dt_venda) {
        this.dt_venda = dt_venda;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getComissao_venda() {
        return comissao_venda;
    }

    public void setComissao_venda(float comissao_venda) {
        this.comissao_venda = comissao_venda;
    }

    public float getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(float valor_venda) {
        this.valor_venda = valor_venda;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
