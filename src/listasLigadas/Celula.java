package listasLigadas;

public class Celula {

	// Atributos

	private Celula proxima;
	private Object elemento;
	private Celula anterior;

	// Construtores

	/**
	 * Recebe apenas o elemento referenciado por esta célula, sendo a proxima celula
	 * null, i.e., este é o último elemento da lista.
	 * 
	 * @param elemento Referencia ao objeto
	 */
	public Celula(Object elemento) {
		this.elemento = elemento;
	}

	/**
	 * Cosntrutor que recebe o elemento e a referência para a próxima célula da
	 * lista.
	 * 
	 * @param proxima  Próxima célula
	 * @param elemento Elemento representado por esta célula
	 */
	public Celula(Celula proxima, Object elemento) {
		this(elemento);
		this.proxima = proxima;
	}

	// Métodos

	/**
	 * Muda a referência para o próximo elemento da lista
	 * 
	 * @param proxima próxima célula
	 */
	public void setProxima(Celula proxima) {
		this.proxima = proxima;
	}

	/**
	 * Retorna a referência ao próximo elemento.
	 * 
	 * @return próxima célula
	 */
	public Celula getProxima() {
		return proxima;
	}

	/**
	 * Retorna o próprio elemento referenciado por esta célula.
	 * 
	 * @return Objeto referenciado.
	 */
	public Object getElemento() {
		return elemento;
	}
	
	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}
	
	public Celula getAnterior() {
		return anterior;
	}
	
	@Override
	public String toString() {
		return elemento.toString();
	}
	
}
