package projeto;

/**
 * Classe que representa um produto de limpeza.
 * Contém o seu grau de toxicidade,
 * além dos atributos que um produto já possui.
 */
public class Limpeza extends Produto{
    private final int toxicidade;

    /**
     * Construtor da classe Limpeza
     * @param identificador Identificador de um produto
     * @param nome Nome de um produto
     * @param precoUni Preço unitário de um produto
     * @param toxicidade Grau de toxidade de um produto de limpeza
     * @param stockInicial Stock inicial de um produto
     */
    public Limpeza(String identificador, String nome, double precoUni, int toxicidade, int stockInicial) {
        super(identificador, nome, precoUni, stockInicial);
        if(toxicidade < 0 || toxicidade > 10){
            System.out.println("Grau de toxicidade inválida.");
            throw new NumberFormatException();
        }
        this.toxicidade = toxicidade;
    }

    /**
     * Método para devolver o preço de envio de um produto de limpeza
     * @return 0, pois o envio de um produto limpeza não acresce o preço de envio de uma compra
     */
    public double precoDeEnvio(){
        return 0;
    }

    /**
     * Método toString da classe Limpeza
     * @return Nome e identificador de um produto acompanhado pela sua descrição definida pela categoria de produto (Limpeza)
     */
    @Override
    public String toString() {
        return "\t" + nome + "(" + identificador + ")\n\tDescrição do produto:\n\t\tGrau de toxidade: "
                + toxicidade + "\n\t\tPreço Unitário: " + precoUni;
    }
}
