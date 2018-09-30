package caelum;

/**
 * Classe que representa um vetor, ou um conjunto de Objects
 * 
 * @author Rafaela de Amorim Barbosa Silva - Computer Science's Undergraduate at
 *         UFCG
 *
 */
public class Vetor {

	private Object[] objetos;
	private int totalObjetos;

	public Vetor() {
		objetos = new Object[100];
		totalObjetos = 0;
	}

	// Métodos

	/**
	 * Adiciona o novo objeto na primeira posicao disponivel
	 * 
	 * @param al Object novo do array
	 */
	public void adiciona(Aluno aluno) {
		garanteEspaco();
		this.objetos[totalObjetos++] = aluno;
	}

	/**
	 * Adiciona um objeto na posicao desejada, caso a pos seja valida, e reorganiza
	 * o array de modo que o novo objeto nao sobrescreva nenhum outro e fique na
	 * posicao do parametro.
	 * 
	 * @param al  Object a ser adicionado
	 * @param pos Posicao especificada para alocação
	 */
	public void adiciona(int pos, Object al) {
		garanteEspaco();

		if (!posicaoValida(pos))
			throw new IllegalArgumentException("Posição inválida");

		for (int i = totalObjetos - 1; i >= pos; i--) { // i >= pos p/ poder tirar o Object da posicao q eu quero
			objetos[i + 1] = objetos[i]; // totalObjetos = tam do array (ultima posicao vazia)
		}

		objetos[pos] = al;
		totalObjetos++;
	}

	/**
	 * Retorna o Object dada sua posicao no array, caso a posicao seja valida.
	 * 
	 * @param posicao é a posicao do Object
	 * @return Object
	 */
	public Object pega(int posicao) {
		if (!posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		return objetos[posicao];
	}

	/**
	 * Remove um Object do array, dada sua posicao caso seja válida. Após isso, o
	 * array é reorganizado de modo a nao deixar buracos.
	 * 
	 * @param posicao Posicao do Object no array para remocao
	 */
	public void remove(int posicao) {
		if (!posicaoValida(posicao))
			throw new IllegalArgumentException("Posição inválida");

		objetos[posicao] = null;

		for (int i = posicao; i < totalObjetos; i++)
			objetos[i] = objetos[i + 1];

		if (totalObjetos > 0)
			objetos[totalObjetos - 1] = null; // ultimo elemento q havia sido puxado agora deve ser null
		totalObjetos--;
	}

	/**
	 * Dado um Object, percorre-se o array para tentar encontrar o mesmo.
	 * 
	 * @param al Object para busca
	 * @return true caso o Object seja encontrado no array, false caso contrario.
	 */
	public boolean contem(Object al) {
		boolean achou = false;
		int i = 0;

		while (i < totalObjetos && !(achou)) {
			if (al.equals(objetos[i]))
				achou = true;
			i++;
		}

		return achou;
	}

	/**
	 * Operação que limpa todos os elementos do array objetos.
	 */
	public void clear() {
		for (int i = 0; i < totalObjetos; i++)
			objetos[i] = null;
	}

	/**
	 * Retorna o índice da primeira ocorrência de um Object passado com parâmetro,
	 * retorna -1 caso o objeto não esteja presente no vetor.
	 * 
	 * @param objeto Parâmetro para a busca
	 * @return Índice do objeto, caso seja encontrado. -1 caso contrário.
	 */
	public int indexOf(Object objeto) {
		int saida = -1;
		boolean achou = false;
		int i = 0;

		while (i < totalObjetos && !achou) {
			if (objetos[i].equals(objeto)) {
				saida = i;
				achou = true;
			}
			i++;
		}

		return saida;
	}

	/**
	 * Retorna o índice da última ocorrência de um tal objeto passado com parâmetro,
	 * ou -1 se não houver esse elemento no vetor.
	 * 
	 * @param obj Parâmetro para busca
	 * @return Índice da última ocorrência do objeto, -1 se o objeto n estiver no
	 *         vetor.
	 */
	public int lastIndexOf(Object obj) {
		int saida = -1;
		int i = totalObjetos - 1;
		boolean achou = false;

		while (i >= 0 && !achou) {
			if (objetos[i].equals(obj)) {
				saida = i;
				achou = true;
			}
			i--;
		}

		return saida;
	}

	/**
	 * @return Tamanho do array de objetos
	 */
	public int tamanho() {
		return totalObjetos;
	}

	/**
	 * Representação textual de todos os objetos do array
	 */
	@Override
	public String toString() {
		return buildString();
	}

	/**
	 * Método privado que monta a String de representação dos objetos
	 * 
	 * @return String com a lista de objetos
	 */
	private String buildString() {
		String sai = "[";

		if (totalObjetos > 0) {

			for (int i = 0; i < totalObjetos - 1; i++) {
				sai += objetos[i].toString() + ", ";
			}

			sai += objetos[totalObjetos - 1].toString() + "]";
		} else
			sai += "]";

		return sai;
	}

	/**
	 * Método privado para verificação de posição válida no array de objetos
	 * 
	 * @param posicao Posição para verificar
	 * @return boolean, true para valida, false para invalida
	 */
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= totalObjetos;
	}

	/**
	 * Método privado que verifica se o array de objetos está em sua capacidade, se
	 * sim cria um novo array com o dobro de tamanho e substitui objetos pelo novo
	 * array.
	 */
	private void garanteEspaco() {
		if (totalObjetos == objetos.length) {
			Object[] novoArray = new Object[objetos.length * 2];

			for (int i = 0; i < objetos.length; i++)
				novoArray[i] = objetos[i];

			this.objetos = novoArray; // substitui objetos por novoArray
		}
	}
}
