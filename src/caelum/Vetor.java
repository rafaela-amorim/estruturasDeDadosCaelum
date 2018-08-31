package caelum;

import java.util.Arrays;

public class Vetor {

	private Aluno[] alunos;
	private final int MAX_ALUNOS = 10000;
	private int totalAlunos;
	
	public Vetor() {
		alunos = new Aluno[MAX_ALUNOS];
		totalAlunos = 0;
	}
	
	// Métodos
	
	public void adiciona(Aluno al) {
		alunos[totalAlunos++] = al;
	}

	public Aluno pega(int posicao) {
		if (posicaoInvalida(posicao)) {
			throw new IllegalArgumentException();
		}
		return alunos[posicao];
	}
	
	// olha isso aqui
	public void remove(int posicao) {
		alunos[posicao] = null;
		totalAlunos--;
	}
	
	public boolean contem(Aluno al) {
		boolean achou = false;
		int i = 0;
		
		while (i < totalAlunos && !(achou)) {
			if (al.equals(alunos[i])) 
				achou = true;
			i++;
		}
		
		return achou;
	}
	
	public int tamanho() {
		return totalAlunos;
	}
	
	@Override
	public String toString() {
		return buildString();
	}
	
	private String buildString() {
		String sai = "[";
		
		for (int i = 0; i < totalAlunos - 1; i++) {
			sai += alunos[i].getNome() + ", ";
		}
		sai += alunos[totalAlunos - 1].getNome() + "]";
		return sai;
	}
	
	private boolean posicaoInvalida(int posicao) {
		return !(posicao >= 0 && posicao < totalAlunos);
	}
	
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao < totalAlunos;
	}
}
