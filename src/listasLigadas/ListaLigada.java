package listasLigadas;

public class ListaLigada {
	
	// Atributos
	
	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos;
	
	// Construtores
	
	public ListaLigada() {
		this.primeira = null;
		this.ultima = null;
		totalDeElementos = 0;
	}
	
	// Métodos
	
	public void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(this.primeira, elemento);
		
		if (estaVazia()) 
			this.ultima = nova;
		else 
			this.primeira.setAnterior(nova);
		
		this.primeira = nova;
		totalDeElementos++;
	}
	
	public void adiciona(Object elemento) {
		if (estaVazia())
			adicionaNoComeco(elemento);
		else {
			Celula nova = new Celula(elemento);
			ultima.setProxima(nova);
			nova.setAnterior(ultima);
			ultima = nova;
			
			totalDeElementos++;
		}
	}
	
	public void adiciona(int posicao, Object elemento) {
		if (posicao == 0) 
			adicionaNoComeco(elemento);
		else if (posicao == totalDeElementos) 
			adiciona(elemento);
		else {
			Celula anterior = pegaCelula(posicao - 1);
			Celula proxima = anterior.getProxima();

			Celula nova = new Celula(proxima, elemento);

			nova.setAnterior(anterior);
			anterior.setProxima(nova);
			proxima.setAnterior(nova);
			
			totalDeElementos++;
		}
	}
	
	public Object pega(int posicao) {
		return pegaCelula(posicao).getElemento();
	}
	
	public int tamanho() {
		return totalDeElementos;
	}
	
	public boolean contem(Object elemento) {
		Celula atual = primeira;
		boolean achou = false;
		
		while (atual != null && !achou) {
			if (atual.getElemento().equals(elemento))
				achou = true;
			
			atual = atual.getProxima();
		}
		
		return achou;
	}
	
	public void removeDoComeco() {
		if (!posicaoOcupada(0))
			throw new IllegalArgumentException("Posição não existe");
		
		primeira = primeira.getProxima();
		primeira.setAnterior(null);
		totalDeElementos--;
		
		if (estaVazia())
			ultima = null;
	}
	
	public void remove(int posicao) {
		if (!posicaoOcupada(posicao))
			throw new IllegalArgumentException("Posição Inválida");
		if (posicao == 0)
			removeDoComeco();
		else if (posicao == totalDeElementos - 1)
			removeDoFim();
		else {
			Celula atual = pegaCelula(posicao);
			Celula anterior = atual.getAnterior();
			Celula proxima = atual.getProxima();
			
			anterior.setProxima(proxima);
			proxima.setAnterior(anterior);
			totalDeElementos--;
		}
	}
	
	public void removeDoFim() {
		if (!posicaoOcupada(0))
			throw new IllegalArgumentException("Posição não existe");
		if (totalDeElementos == 1)
			removeDoComeco();
		else {
			Celula penultima = ultima.getAnterior();
			penultima.setProxima(null);
			ultima = penultima;
			totalDeElementos--;
		}
	}
	
	@Override
	public String toString() {
		return buildString();
	}
	
	// Métodos Privados
	
	private String buildString() {
		String saida = "[";
		
		if (totalDeElementos > 0) {
			Celula atual = primeira;
			int i = 0;
			
			while (i < totalDeElementos - 1) {		// percorre até o penúltimo elemento
				saida += atual.toString() + ", ";
				atual = atual.getProxima();
				i++;
			}
			
			saida += atual.toString();
			
		}
		
		saida += "]";
		return saida;
	}
	
	private boolean estaVazia() {
		return totalDeElementos == 0;
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < totalDeElementos;
	}
	
	private Celula pegaCelula(int posicao) {
		if (!posicaoOcupada(posicao))
			throw new IllegalArgumentException("Posição Inválida");
		
		Celula atual = primeira;
		
		for (int i = 0; i < posicao; i++)
			atual = atual.getProxima();
		
		return atual;
	}
	
	// Métodos O(n)
	
	public void removeDoFimLinear() {
		if (!posicaoOcupada(0))
			throw new IllegalArgumentException("Posição não existe");
		
		if (totalDeElementos == 1)
			removeDoComeco();
		else {
			Celula penultima = pegaCelula(totalDeElementos - 2);	
			penultima.setProxima(null);
			ultima = penultima;
			totalDeElementos--;
		}
	}
	
	public void adicionaLinear(int posicao, Object elemento) {
		if (posicao == 0)
			adicionaNoComeco(elemento);
		else if (posicao == totalDeElementos)
			adiciona(elemento);
		else {
			Celula anterior = pegaCelula(posicao - 1);
			Celula nova = new Celula(anterior.getProxima(), elemento);
			anterior.setProxima(nova);
			totalDeElementos++;
		}
	}

}
