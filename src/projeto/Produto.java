package projeto;

import java.util.ArrayList;
import java.util.List;

public abstract class Produto {
    private final String identificador;
    private final String nome;
    private final double precoUni;
    private final List<Promocao> promocoes;
    private final int stockInicial;

    public Produto(String identificador, String nome, double precoUni, int stockInicial) {
        this.identificador = identificador;
        this.nome = nome;
        this.precoUni = precoUni;
        this.promocoes = new ArrayList();
        this.stockInicial = stockInicial;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUni() {
        return precoUni;
    }
    
    public void addPromocoes(Promocao p){
        promocoes.add(p);
    }
    
    public List<Promocao> getPromocoes(){
        return promocoes;
    }
    
    public double obterPreco(int quantidade, Data d){
        double desconto = 0;
        for (Promocao p: promocoes){
            if(d.compareTo(p.getInicio()) >= 0 && d.compareTo(p.getFim()) <= 0){
                desconto = p.desconto(quantidade, precoUni);
                break;
            }
        }
        return precoUni * quantidade - desconto;
    }

    public boolean igual(Produto p){
        return identificador.equals(p.identificador) && nome.equals(p.nome);
    }
    
    /**
     * Procura um produto numa venda
     * @param v venda
     * @return quantidade desse produto na venda
     */
    private int encontraNaVenda(Venda v){
        for(Item i: v.getCarrinho())
            if(i.getProduto().igual(this))
                return i.getQuantidade();
        return 0;
    }
    
    public int obterStockAtual(Data d, List<Venda> vendas){
        int stockAtual = stockInicial;
        for(Venda v: vendas)
            if(d.compareTo(v.getData()) >= 0)
                stockAtual -= encontraNaVenda(v);
        return stockAtual;
    }

    public abstract double precoDeEnvio();
}
